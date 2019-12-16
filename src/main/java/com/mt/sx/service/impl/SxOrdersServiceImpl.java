package com.mt.sx.service.impl;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.util.RedisUtil;
import com.mt.sx.mapper.*;
import com.mt.sx.pojo.*;
import com.mt.sx.pojo.vo.SxCartVo;
import com.mt.sx.pojo.vo.SxSubOrderVo;
import com.mt.sx.service.SxOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mt.sx.common.util.CommonUtils.removeDuplicateWithOrder;
import static com.mt.sx.common.util.UUIDGenerator.getUUId;

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
    }


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
        // // YsShop user = (YsShop) redis.get("username");
        //////        //sxCart.setShopId(user.getId());
        //////        //以上为正式代码，这里用假数据1进行测试
        sxOrder.setShopId(1);
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
            // // YsShop user = (YsShop) redis.get("username");
            //////        //sxCart.setShopId(user.getId());
            //////        //以上为正式代码，这里用假数据1进行测试
            sxSubOrder.setShopId(1);
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
                    sxOrderInfoMapper.insert(sxOrderInfo);
                }
            }
            sxSubOrderMapper.insert(sxSubOrder);
        }

        return CommonResult.success("创建成功");
    }


    @Override
    public List<SxSubOrderVo> findSubOrders(Integer type) {//根据type状态来查询所有的不同属性订单，如果type为空，查询所有
        // YsShop user = (YsShop) redis.get("username");
        //sxCart.setShopId(user.getId());
        //以上为正式代码，这里用假数据1进行测试
        //先进行数据的查询与归类，用SxSubOrderVo接收数据
        //一定要创建一个vo对象实体去查询 不然查不了
        Example example = new Example(SxOrder.class);
        example.orderBy("createTime").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", 1)
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
                    //
                    //假的用户id
                    //下面是用户id
                    sxSubOrderVo.setShopId(1);
                    sxSubOrderVo.setPrices(subOrder.getPrices());
                    sxSubOrderVo.setBusinessName(sxBusinessMapper.selectByPrimaryKey(sxProduct.getBusinessId()).getName());
                    sxSubOrderVo.setPrice(sxProduct.getPrice());
                    sxSubOrderVo.setSuborderId(subOrder.getSuborderId());
                    sxSubOrderVo.setOrderId(order.getId());
                    SxAddressInfo sxAddressInfo = sxAddressInfoMapper.selectByPrimaryKey(order.getAddressId());
                    sxSubOrderVo.setAddress(sxAddressInfo.getAddress());
                    sxSubOrderVo.setName(sxAddressInfo.getName());
                    sxSubOrderVo.setTelephone(sxAddressInfo.getTelephone());
                    listOrder.add(sxSubOrderVo);
                }
            }
        }
        return listOrder;
    }

    @Override
    public SxOrderInfo findOrdersInfo(Integer id) {
        return sxOrderInfoMapper.selectByPrimaryKey(id);
    }

}
