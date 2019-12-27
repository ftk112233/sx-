package com.mt.sx.service.impl;

        import com.mt.sx.common.base.CommonResult;
        import com.mt.sx.common.util.RedisUtil;
        import com.mt.sx.mapper.*;
        import com.mt.sx.pojo.*;
        import com.mt.sx.pojo.vo.SxCartVo;
        import com.mt.sx.pojo.vo.SxSubOrderVo;
        import com.mt.sx.service.SxOrdersService;
        import org.apache.commons.lang3.StringUtils;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import tk.mybatis.mapper.entity.Example;

        import javax.annotation.Resource;
        import java.math.BigDecimal;
        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

        import static com.mt.sx.common.util.CommonUtils.removeDuplicateWithOrder;
        import static com.mt.sx.common.util.UUIDGenerator.getUUId;
        import static com.mt.sx.common.util.UserUtils.getUser;

@Service
public class SxOrdersServiceImpl implements SxOrdersService {
    @Resource
    SxAddressInfoMapper sxAddressInfoMapper;
    @Resource
    SxSubOrderMapper sxSubOrderMapper;
    @Resource
    SxProductMapper sxProductMapper;
    @Autowired
    SxOrderMapper sxOrderMapper;
    @Autowired
    SxCartMapper sxCartMapper;
    @Autowired
    SxOrderInfoMapper sxOrderInfoMapper;
    @Autowired
    SxBusinessMapper sxBusinessMapper;
    @Autowired
    RedisUtil redisUtil;

    //生成第一个订单的唯一id
    String fatherId = String.valueOf(getUUId());

    @Override
    public List<SxCartVo> findForCart(List list) {
        List<SxCartVo> listCart = new ArrayList<>();
        List<SxCart> list1 = sxCartMapper.selectByIdList(list);//这个list是购物车提交过来的用户的购物车list
        for (SxCart sxCart : list1) {
            SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(sxCart.getProductId());
            SxCartVo sxCartVo = new SxCartVo();
            sxCartVo.setSpeway(sxProduct.getSpeway());
            sxCartVo.setUnit(sxProduct.getUnit());
            sxCartVo.setProductName(sxProduct.getName());
            sxCartVo.setProductPrice(sxProduct.getPrice());
            sxCartVo.setProductPrePrice(sxProduct.getPrePrice());
            sxCartVo.setPic(sxProduct.getPic());
            sxCartVo.setPrices(sxCart.getPrices());
            sxCartVo.setNumber(sxCart.getNumber());
            listCart.add(sxCartVo);
        }
        return listCart;
    }//提交购物车到订单页面的数据回显

    @Override
    public CommonResult insertOrder(List<Integer> list, Integer addressId, String message, Date hopeTime) {//返回的时购物车的列表,此功能一次创建三张表
        ArrayList<Integer> buslist = new ArrayList<>();
        List<SxCart> list1 = sxCartMapper.selectByIdList(list);
        BigDecimal totalPrices = new BigDecimal("0.00");
        SxOrder sxOrder = new SxOrder();//先创建第一张表
        sxOrder.setId(fatherId);
        int num = 0;
        for (SxCart sxCart : list1) {//遍历每一个提交了的购物车然后计算总价格
            int n = sxCart.getNumber();
            num = n + num;
            BigDecimal prices = sxCart.getPrices();
            totalPrices = totalPrices.add(prices);
        }
        SxUser user = getUser();
        sxOrder.setShopId(user.getRelateId());
        sxOrder.setTotalPrice(totalPrices);
        sxOrder.setCreateTime(new Date());
        sxOrder.setTotalNumber(num);
        sxOrder.setAddressId(addressId);
        sxOrder.setMessage(message);
        sxOrder.setHopeTime(hopeTime);
        sxOrder.setType(0);
        sxOrder.setCreateTime(new Date());
        sxOrderMapper.insert(sxOrder);
        //开始创建第二张表
        for (SxCart sxCart : list1) {
            Integer businessId = sxCart.getBusinessId();//现在得到了每一个businessId，根据每一个这个id查询出所有的商品购物车
            buslist.add(businessId);//现在businessid就在buslist里面
        }
        removeDuplicateWithOrder(buslist);//这是一个去重的工具类
        BigDecimal total = new BigDecimal("0.00");
        for (Integer businessId : buslist) {
            SxSubOrder sxSubOrder = new SxSubOrder();
            sxSubOrder.setOrderId(fatherId);
            for (SxCart sxCart : list1) {//遍历每一个提交了的购物车，找到其中商家id相同的然后计算总价格
                if (sxCart.getBusinessId() == businessId) {
                    BigDecimal prices = sxCart.getPrices();
                    total = total.add(prices);
                }
            }
            String s = String.valueOf(getUUId());
            sxSubOrder.setSuborderId(s);
            sxSubOrder.setPrices(total);
            SxUser sxUser = getUser();
            sxSubOrder.setShopId(sxUser.getRelateId());
            total = new BigDecimal("0.00");
            sxSubOrder.setCreateTime(new Date());
            sxSubOrder.setBusinessId(businessId);
            for (SxCart sxCart : list1) {
                if (sxCart.getBusinessId() == businessId) {
                    SxOrderInfo sxOrderInfo = new SxOrderInfo();
                    sxOrderInfo.setOrderId(fatherId);
                    sxOrderInfo.setSuborderId(s);
                    sxOrderInfo.setProductId(sxCart.getProductId());
                    sxOrderInfo.setNumber(sxCart.getNumber());
                    sxOrderInfo.setCreateTime(new Date());
                    sxOrderInfo.setType(0);
                    sxOrderInfoMapper.insert(sxOrderInfo);
                }
            }
            sxSubOrderMapper.insert(sxSubOrder);
        }
        return CommonResult.success("创建成功");
    }//生成订单

    @Override
    public List<SxSubOrderVo> findSubOrders(Integer type) {//根据type状态来查询所有的不同属性订单，如果type为空，查询所有
        checkOrderType();
        SxUser sxUser = getUser();
        //一定要创建一个vo对象实体去查询 不然查不了
        Example example = new Example(SxOrder.class);
        example.orderBy("createTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", sxUser.getRelateId())
                .andEqualTo("status", 0)
                .andEqualTo("deleted", 0);
        if (type != null) {
            criteria.andEqualTo("type", type);
        }
        List<SxOrder> sxOrders = sxOrderMapper.selectByExample(example);
        List<SxSubOrderVo> listOrder = new ArrayList<>();
        List<SxSubOrder> sxSubOrders;
        List<SxOrderInfo> sxOrderInfos;
        for (SxOrder order : sxOrders) {
            Example example1 = new Example(SxSubOrder.class);//一定要创建一个vo对象实体去查询 不然查不了
            example1.orderBy("createTime").desc();
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("orderId", order.getId());
            sxSubOrders = sxSubOrderMapper.selectByExample(example1);
            for (SxSubOrder subOrder : sxSubOrders) {
                Example example2 = new Example(SxOrderInfo.class);//一定要创建一个vo对象实体去查询 不然查不了
                example2.orderBy("createTime").desc();
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("suborderId", subOrder.getSuborderId()).andEqualTo("status", 0).andEqualTo("deleted", 0);
                sxOrderInfos = sxOrderInfoMapper.selectByExample(example2);//当前获取到了所有的商品详情
                for (SxOrderInfo orderInfo : sxOrderInfos) {
                    Integer productId = orderInfo.getProductId();
                    SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(productId);
                    SxSubOrderVo sxSubOrderVo = new SxSubOrderVo();
                    sxSubOrderVo.setDescription(sxProduct.getDescription());
                    sxSubOrderVo.setPic(sxProduct.getPic());
                    sxSubOrderVo.setNum(orderInfo.getNumber());
                    sxSubOrderVo.setType(order.getType());
                    sxSubOrderVo.setBusinessId(sxProduct.getBusinessId());
                    sxSubOrderVo.setShopId(sxUser.getRelateId());
                    sxSubOrderVo.setPrices(subOrder.getPrices());
                    sxSubOrderVo.setBusinessName(sxBusinessMapper.selectByPrimaryKey(sxProduct.getBusinessId()).getName());
                    sxSubOrderVo.setPrice(sxProduct.getPrice());
                    sxSubOrderVo.setSuborderId(subOrder.getSuborderId());
                    sxSubOrderVo.setOrderId(order.getId());
                    SxAddressInfo sxAddressInfo = sxAddressInfoMapper.selectByPrimaryKey(order.getAddressId());
                    sxSubOrderVo.setAddress(sxAddressInfo.getAddress());
                    sxSubOrderVo.setName(sxAddressInfo.getName());
                    sxSubOrderVo.setTelephone(sxAddressInfo.getTelephone());
                    sxSubOrderVo.setProductName(sxProduct.getName());
                    listOrder.add(sxSubOrderVo);
                }
            }
        }
        return listOrder;
    }//客户端自己的订单查询功能，传入类型就行

    @Override
    public SxOrderInfo findOrdersInfo(Integer id) {
        checkOrderType();
        return sxOrderInfoMapper.selectByPrimaryKey(id);
    }//查询订单详情

    @Override
    public List<List<SxSubOrderVo>> findSubOrderByList(List<String> subIdList) {
        checkOrderType();
        List<List<SxSubOrderVo>> subList = new ArrayList<>();
        List<SxSubOrderVo> list = new ArrayList<>();
        List<String> suborderIds = new ArrayList<>();
        for (String suborderId : subIdList) {
            Example example = new Example(SxSubOrder.class);
            Example.Criteria criteria = example.createCriteria();
            if (getUser().getType() == 2) {
                criteria.andEqualTo("shopId", getUser().getRelateId());
            }
            if (getUser().getType() == 1) {
                criteria.andEqualTo("businessId", getUser().getRelateId());
            }
            criteria.andEqualTo("suborderId", suborderId);//先筛选出当前用户可见的subOrderId
            List<SxSubOrder> sxSubOrders = sxSubOrderMapper.selectByExample(example);//现在相应用户权限的subOrder都在这里
            for (SxSubOrder sxSubOrder : sxSubOrders) {
                String suborderId1 = sxSubOrder.getSuborderId();
                suborderIds.add(suborderId1);
            }
            for (String id : suborderIds) {
                Example exampleSub = new Example(SxOrderInfo.class);
                Example.Criteria criteriaSub = exampleSub.createCriteria();
                criteriaSub.andEqualTo("suborderId", id)
                        .andEqualTo("deleted", 0)
                        .andEqualTo("status", 0);
                List<SxOrderInfo> sxOrderInfo = sxOrderInfoMapper.selectByExample(exampleSub);
                for (SxOrderInfo sxSubOrderinfo : sxOrderInfo) {
                    SxSubOrderVo sxSubOrderVo = new SxSubOrderVo();
                    BeanUtils.copyProperties(sxSubOrderinfo, sxSubOrderVo);
                    SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(sxSubOrderinfo.getProductId());
                    sxSubOrderVo.setBusinessId(sxProduct.getBusinessId());
                    SxBusiness sxBusiness = sxBusinessMapper.selectByPrimaryKey(sxProduct.getBusinessId());
                    sxSubOrderVo.setBusinessName(sxBusiness.getName());
                    sxSubOrderVo.setPrice(sxProduct.getPrice());
                    sxSubOrderVo.setDescription(sxProduct.getDescription());
                    sxSubOrderVo.setNum(sxSubOrderinfo.getNumber());
                    sxSubOrderVo.setPic(sxProduct.getPic());
                    SxSubOrder sxSubOrder = new SxSubOrder();
                    sxSubOrder.setSuborderId(sxSubOrderinfo.getSuborderId());
                    SxSubOrder sxSubOrder1 = sxSubOrderMapper.selectOne(sxSubOrder);
                    sxSubOrderVo.setPrices(sxSubOrder1.getPrices());
                    SxOrder sxOrder = new SxOrder();
                    sxOrder.setId(sxSubOrderinfo.getOrderId());
                    SxOrder sxOrder1 = sxOrderMapper.selectOne(sxOrder);
                    sxSubOrderVo.setType(sxSubOrder1.getType());
                    SxAddressInfo sxAddressInfo = sxAddressInfoMapper.selectByPrimaryKey(sxOrder1.getAddressId());
                    sxSubOrderVo.setName(sxAddressInfo.getName());
                    sxSubOrderVo.setAddress(sxAddressInfo.getAddress());
                    sxSubOrderVo.setTelephone(sxAddressInfo.getTelephone());
                    sxSubOrderVo.setProductName(sxProduct.getName());
                    sxSubOrderVo.setShopId(sxAddressInfo.getShopId());
                    list.add(sxSubOrderVo);
                }
                subList.add(list);
            }
        }
        return subList;
    }//按订单id，或者是传入订单的列表查询订单信息

    @Override
    public CommonResult addPassBy(String suborderId, Integer passById) {//suborderId是唯一的
        checkOrderType();
        Integer type = getUser().getType();
        if (type!=1){
            return CommonResult.fail(-1,"没有操作权限");
        }
        SxSubOrder sxSubOrders = new SxSubOrder();
        sxSubOrders.setSuborderId(suborderId);
        SxSubOrder sxSubOrder = sxSubOrderMapper.selectOne(sxSubOrders);
        if (sxSubOrder.getType() == 0) {
            return CommonResult.fail(-1, "商品未支付成功，无法发货！");
        }
        if (sxSubOrder.getType() == 2) {
            return CommonResult.fail(-1, "商品已发货！请勿重复提交");
        }
        if (sxSubOrder.getType() == 3) {
            Example example = new Example(SxSubOrder.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("suborderId", suborderId);
            SxSubOrder sxSubOrders1 = new SxSubOrder();
            sxSubOrders1.setPassbyId(passById);
            sxSubOrders1.setType(2);
            return CommonResult.success(sxSubOrderMapper.updateByExampleSelective(sxSubOrders1, example));
        } else {
            return CommonResult.fail(-1, "系统异常");
        }

    }//卖家发货，添加配送员

    @Override
    public CommonResult cancelOrder(String suborderId) {
        checkOrderType();
        Integer type = getUser().getType();
        if (type!=0||type!=2){
            return CommonResult.fail(-1,"没有操作权限");
        }
        SxSubOrder sxSubOrders = new SxSubOrder();
        sxSubOrders.setSuborderId(suborderId);
        SxSubOrder sxSubOrder = sxSubOrderMapper.selectOne(sxSubOrders);
        if (sxSubOrder.getType() == 0) {
            return CommonResult.success(sxSubOrderMapper.deleteByExample(sxSubOrder));
        } else {
            return CommonResult.fail(-1, "支付完成的订单请联系卖家处理");
        }
    }//用户取消订单操作

    @Override
    public CommonResult cancelOrderForTable(String suborderId) {
        checkOrderType();
        Integer type = getUser().getType();
        if (type!=1){
            return CommonResult.fail(-1,"没有操作权限");
        }
        SxSubOrder sxSubOrders = new SxSubOrder();
        sxSubOrders.setSuborderId(suborderId);
        SxSubOrder sxSubOrder = sxSubOrderMapper.selectOne(sxSubOrders);
        if (sxSubOrder.getType() == 1) {
            return CommonResult.success(sxSubOrderMapper.deleteByExample(sxSubOrder));
        }
        if (sxSubOrder.getType() == 0) {
            return CommonResult.fail(-1, "未付款的订单商家不可取消，请联系客户操作");
        } else {
            return CommonResult.fail(-1, "已发货的订单不可取消，请联系平台处理");
        }
    }//卖家取消已支付但是未发货的订单

    @Override
    public List<SxSubOrderVo> findSubOrdersForTable(Integer type) {
        checkOrderType();
        SxUser sxUser = getUser();
        SxSubOrder sxSubOrder = new SxSubOrder();
        Example example = new Example(SxOrder.class);
        example.orderBy("createTime").desc();
        Example.Criteria criteria = example.createCriteria();
        if (sxUser.getType() == 2) {
            criteria.andEqualTo("shopId", sxUser.getRelateId()).andEqualTo("status", 0);
        }
        if (sxUser.getType() == 1) {
            sxSubOrder.setShopId(sxUser.getRelateId());
            criteria.andEqualTo("businessId", sxUser.getRelateId());
        }
        criteria.andEqualTo("deleted", 0);
        if (type != null) {
            criteria.andEqualTo("type", type);
        }
        List<SxOrder> sxOrders = sxOrderMapper.selectByExample(example);
        List<SxSubOrderVo> listOrder = new ArrayList<>();
        List<SxSubOrder> sxSubOrders;
        List<SxOrderInfo> sxOrderInfos;
        for (SxOrder order : sxOrders) {
            Example example1 = new Example(SxSubOrder.class);//一定要创建一个vo对象实体去查询 不然查不了
            example1.orderBy("createTime").desc();
            Example.Criteria criteria1 = example1.createCriteria();
            criteria1.andEqualTo("orderId", order.getId());
            sxSubOrders = sxSubOrderMapper.selectByExample(example1);
            for (SxSubOrder subOrder : sxSubOrders) {
                Example example2 = new Example(SxOrderInfo.class);//一定要创建一个vo对象实体去查询 不然查不了
                example2.orderBy("createTime").desc();
                Example.Criteria criteria2 = example2.createCriteria();
                criteria2.andEqualTo("suborderId", subOrder.getSuborderId()).andEqualTo("status", 0).andEqualTo("deleted", 0);
                sxOrderInfos = sxOrderInfoMapper.selectByExample(example2);//当前获取到了所有的商品详情
                for (SxOrderInfo orderInfo : sxOrderInfos) {
                    Integer productId = orderInfo.getProductId();
                    SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(productId);
                    SxSubOrderVo sxSubOrderVo = new SxSubOrderVo();
                    sxSubOrderVo.setDescription(sxProduct.getDescription());
                    sxSubOrderVo.setPic(sxProduct.getPic());
                    sxSubOrderVo.setNum(orderInfo.getNumber());
                    sxSubOrderVo.setType(order.getType());
                    sxSubOrderVo.setBusinessId(sxProduct.getBusinessId());
                    sxSubOrderVo.setShopId(subOrder.getShopId());//获得用户的id
                    sxSubOrderVo.setPrices(subOrder.getPrices());
                    sxSubOrderVo.setBusinessName(sxBusinessMapper.selectByPrimaryKey(sxProduct.getBusinessId()).getName());
                    sxSubOrderVo.setPrice(sxProduct.getPrice());
                    sxSubOrderVo.setSuborderId(subOrder.getSuborderId());
                    sxSubOrderVo.setOrderId(order.getId());
                    SxAddressInfo sxAddressInfo = sxAddressInfoMapper.selectByPrimaryKey(order.getAddressId());
                    sxSubOrderVo.setAddress(sxAddressInfo.getAddress());
                    sxSubOrderVo.setName(sxAddressInfo.getName());
                    sxSubOrderVo.setTelephone(sxAddressInfo.getTelephone());
                    sxSubOrderVo.setProductName(sxProduct.getName());
                    listOrder.add(sxSubOrderVo);
                }
            }
        }
        return listOrder;
    }//查看所有关于当前用户的订单列表

    @Override
    public CommonResult totalConsume() {
        checkOrderType();
        BigDecimal total = new BigDecimal("0.00");
        SxUser sxUser = getUser();
        SxSubOrder sxSubOrder = new SxSubOrder();
        if (sxUser.getType() == 2) {
            sxSubOrder.setShopId(sxUser.getRelateId());
        }
        if (sxUser.getType() == 1) {
            sxSubOrder.setBusinessId(sxUser.getRelateId());
        }
        sxSubOrder.setType(3);
        List<SxSubOrder> select = sxSubOrderMapper.select(sxSubOrder);
        for (SxSubOrder subOrder : select) {
            BigDecimal prices = subOrder.getPrices();
            total = total.add(prices);
        }
        return CommonResult.success(total);
    }//统计当前登陆用户所有已完成订单消费金额（会自动判断当前用户）

    @Override
    public CommonResult findSubOrderByName(String name, String subOrderId) {
        checkOrderType();
        List<String> suborderIdList = new ArrayList<>();
        Example exampleT = new Example(SxProduct.class);
        Example.Criteria criteriaT = exampleT.createCriteria();
        if ((name != null && subOrderId == null)) {
            criteriaT.andLike("name", "%" + name + "%");
        }
        List<SxProduct> select = sxProductMapper.selectByExample(exampleT);
        if (subOrderId != null && name == null) {
            suborderIdList.add(subOrderId);
        }
        for (SxProduct product : select) {
            SxOrderInfo sxOrderInfo = new SxOrderInfo();
            sxOrderInfo.setProductId(product.getId());
            sxOrderInfo.setStatus(0);
            sxOrderInfo.setDeleted(0);
            List<SxOrderInfo> selectSxOrderInfo = sxOrderInfoMapper.select(sxOrderInfo);//查询出了所有有关该商品名的有用的订单
            for (SxOrderInfo orderInfo : selectSxOrderInfo) {
                String suborderId = orderInfo.getSuborderId();
                suborderIdList.add(suborderId);//此时所有的跟商品有关的子订单都在这里
            }
        }
        removeDuplicateWithOrder(suborderIdList);//去除重复的subOrderId
        //再调用订单查询的方法就可以了
        if ((name != null && subOrderId != null) || (name == null && subOrderId == null)) {
            return CommonResult.fail(-1, "请输入正确的查询信息");
        }
        return CommonResult.success(suborderIdList);
    }//模糊查询出相关联的子订单单号，再根据这些订单单号去查询出正确的信息做列表去返回

    public void checkOrderType() {
        SxSubOrder sxSubOrder = new SxSubOrder();
        sxSubOrder.setType(0);
        List<SxSubOrder> orderList = sxSubOrderMapper.select(sxSubOrder);
        for (SxSubOrder subOrder : orderList) {
            Date createTime = subOrder.getCreateTime();
            Date d1 = createTime;
            Date d2 = new Date();
            Long diff = d2.getTime() - d1.getTime();//这样得到的差值是毫秒级别
            if (diff > 3600000) {
                sxSubOrderMapper.delete(subOrder);
            }
            System.out.println("当前的间隔时间为:" + diff);
        }
    }//大于一个小时的订单将在下一次任意人员的查询时自动删除

}

