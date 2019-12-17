package com.mt.sx.service.impl;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.util.RedisUtil;
import com.mt.sx.mapper.SxBusinessMapper;
import com.mt.sx.mapper.SxCartMapper;
import com.mt.sx.mapper.SxProductMapper;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxCart;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.vo.SxCartVo;
import com.mt.sx.service.SxCartService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

import static com.mt.sx.common.util.CommonUtils.removeDuplicateWithOrder;
import static com.mt.sx.common.util.UserUtils.getUser;

@Service
public class SxCartServiceImpl implements SxCartService {
    @Resource
    SxCartMapper sxCartMapper;
    @Resource
    SxProductMapper sxProductMapper;
    @Resource
    SxBusinessMapper sxBusinessMapper;
    @Resource
    RedisUtil redis;

    @Override
    public Integer insert(Integer id, Integer num) {//插入商品到购物车
        SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(id);
        SxCartVo sxCartVo = new SxCartVo();
        sxCartVo.setProductId(sxProduct.getId());
        SxUser sxUser = getUser();
        sxCartVo.setShopId(sxUser.getRelateId());
        sxCartVo.setNumber(num);
        sxCartVo.setBusinessId(sxProduct.getBusinessId());
        sxCartVo.setPrices(sxProduct.getPrice().multiply(new BigDecimal(Integer.toString(num))));
        sxCartVo.setCreateTime(new Date());
        return sxCartMapper.insert(sxCartVo);
    }

    @Override
    public SxCart selectByProductId(Integer id) {//查询购物车中是否有这个商品
        SxCart sxCart = new SxCart();
        sxCart.setProductId(id);
        return sxCartMapper.selectOne(sxCart);
    }

    @Override
    public Integer update(Integer id, Integer num) {
        SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(id);//查询商品
        SxCart sxCart = new SxCart();
        sxCart.setUpdateTime(new Date());
        int a = selectByProductId(id).getNumber();
        sxCart.setNumber(a + num);
        sxCart.setPrices(sxProduct.getPrice().multiply(new BigDecimal(Integer.toString(a + num))));
        Example example = new Example(SxCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", id);
        return sxCartMapper.updateByExampleSelective(sxCart, example);
    }


    @Override
    public CommonResult<ArrayList<List<SxCartVo>>> findCartInfoById() {//这个id是用户的id,shopId
        SxUser sxUser = getUser();
        Example example = new Example(SxCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopId", sxUser.getRelateId());
        example.orderBy("updateTime").desc();
        List<SxCart> sxCarts = sxCartMapper.selectByExample(example);//shopid就是用户的id，现在要根据用户的id查出店铺的id
        ArrayList<Integer> buslist = new ArrayList<>();
        ArrayList<List<SxCartVo>> list = new ArrayList();
        for (SxCart sxCart : sxCarts) {
            Integer businessId = sxCart.getBusinessId();//现在得到了每一个businessId，根据每一个这个id查询出所有的商品购物车
            buslist.add(businessId);//现在businessid就在buslist里面
        }
        removeDuplicateWithOrder(buslist);
        for (int buid : buslist) {
            SxCart sxCart1 = new SxCart();//为购物车设置实体以便查询
            sxCart1.setBusinessId(buid);
            List<SxCart> selectCartS = sxCartMapper.select(sxCart1); //根据商家id查询出了该商家所有的购物车
            ArrayList<SxCartVo> list1 = new ArrayList<>();
            for (SxCart selectCart : selectCartS) {
                SxCartVo sxCartVo = new SxCartVo();
                sxCartVo.setNumber(sxCartMapper.selectByPrimaryKey(selectCart.getId()).getNumber());//购物车中添加的数量
                sxCartVo.setId(selectCart.getId());//购物车id
                sxCartVo.setPrices(selectCart.getPrices());//当前购物车总价格
                sxCartVo.setShopId(sxUser.getRelateId());//买家id
                sxCartVo.setBusinessId(selectCart.getBusinessId());//卖家id
                sxCartVo.setProductId(selectCart.getProductId());//产品id
                sxCartVo.setBusinessShopName(sxBusinessMapper.selectByPrimaryKey(selectCart.getBusinessId()).getName());//卖家店铺名称
                SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(selectCart.getProductId());
                sxCartVo.setSpeway(sxProduct.getSpeway());//产品类别和单位
                sxCartVo.setUnit(sxProduct.getUnit());//产品类别和单位
                sxCartVo.setProductPrice(sxProduct.getPrice());//产品单价
                sxCartVo.setProductNumber(sxProduct.getNumber());//产品的库存
                sxCartVo.setPic(sxProduct.getPic());//图片
                sxCartVo.setProductName(sxProduct.getName());//得到产品名字
                sxCartVo.setProductDescription(sxProduct.getDescription());//得到产品的描述信息
                sxCartVo.setUpdateTime(selectCart.getUpdateTime());
                sxCartVo.setCreateTime(selectCart.getCreateTime());
                list1.add(sxCartVo);
            }
            list.add(list1);
        }
        return CommonResult.success(list);
    }

    @Override//删除单个的购物车
    public Integer deletedByCartId(Integer id) {
        return sxCartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Boolean checkNum(Integer id, Integer num) {//根据产品id查询是否可以添加到购物车或者提交到订单
        SxProduct sxProduct = sxProductMapper.selectByPrimaryKey(id);
        if (sxProduct.getNumber() >= num) {
            return true;//true则可以加入到购物车或者提交到订单
        }
        return false;
    }

    @Override
    public CommonResult deletedMany(List list) {
        sxCartMapper.deleteByIdList(list);
            return CommonResult.success("删除成功", 200);

    }
}
