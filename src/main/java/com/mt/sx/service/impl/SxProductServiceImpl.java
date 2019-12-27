package com.mt.sx.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.sx.common.base.CommonPage;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.common.exception.GlobalException;
import com.mt.sx.common.util.UserUtils;
import com.mt.sx.common.util.WebUtils;
import com.mt.sx.mapper.SxCommentMapper;
import com.mt.sx.mapper.SxProductMapper;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.vo.SxProductVO;
import com.mt.sx.service.SxProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SxProductServiceImpl implements SxProductService {
    @Autowired
    SxProductMapper sxProductMapper;
    @Autowired
    SxCommentMapper sxCommentMapper;

    /**
     * 按条件分页查询属于商户的商品
     *
     * @param
     * @return
     */
    @Override
    public CommonPage list(Integer page, Integer pageSize, String name, String description) {


        PageHelper.startPage(page, pageSize);
        Example example = new Example(SxProduct.class);
        Example.Criteria criteria = example.createCriteria();
        //获取user
        //如果为管理员则查出全部商品否则查出商户的所有商品
        SxUser user = UserUtils.getUser();
        if (user.getType() != 0) {
            criteria.andEqualTo("businessId", user.getRelateId());
        }


        if (StringUtils.isNotBlank(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(description)) {
            criteria.andLike("description", "%" + description + "%");
        }

        List<SxProduct> sxProducts = sxProductMapper.selectByExample(example);
        return CommonPage.restPage(sxProducts);
    }

    /**
     * 增加商品
     *超级管理员无权添加
     * @param sxProduct
     * @return
     */
    @Override
    public void insert(SxProduct sxProduct) {
        //从session中获取用户
        SxUser user = UserUtils.getUser();
        //判断是否为管理员
        if(user.getType()==0){
            throw new GlobalException(ResponseCode.NOUNAUTH);
        }
        sxProduct.setBusinessId(user.getRelateId());

        sxProduct.setCreateBy(user.getUsername());
        sxProduct.setUpdateBy(user.getUsername());

        Date date = new Date();
        sxProduct.setCreateTime(date);
        sxProduct.setUpdateTime(date);
        sxProduct.setSort(0);
        sxProduct.setStatus(1);
        sxProduct.setCount(0);
        sxProductMapper.insertSelective(sxProduct);
    }

    /**
     * 更新商品
     *
     * @param sxProduct
     * @return
     */
    @Override
    public void update(SxProduct sxProduct) {
        sxProduct.setUpdateTime(new Date());
        sxProductMapper.updateByPrimaryKeySelective(sxProduct);
    }

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    @Override
    public void delete(Integer id) {
        sxProductMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询热销商品
     *
     * @return
     */
    @Override
    public CommonPage findSellWell() {
        //自己定义查出热销商品的数量
        PageHelper.startPage(1, 30);
        Example example = new Example(SxProduct.class);
        example.orderBy("count").desc();
        List<SxProduct> sxProducts = sxProductMapper.selectByExample(example);
        return CommonPage.restPage(sxProducts);
    }

    /**
     * 根据小分类id分页查询商品
     *
     * @param spuId
     * @return
     */
    @Override
    public CommonPage findBySpuId(Integer spuId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        SxProduct sxProduct = new SxProduct();
        sxProduct.setSpuId(spuId);
        List<SxProduct> lists = sxProductMapper.select(sxProduct);
        return CommonPage.restPage(lists);
    }

    /**
     * 根据商品名进行分页模糊查询
     *
     * @param name 商品名
     * @return
     */
    @Override
    public CommonPage search(String name, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(SxProduct.class);
        example.createCriteria().andLike("name", "%" + name + "%");
        List<SxProduct> sxProducts = sxProductMapper.selectByExample(example);
        return CommonPage.restPage(sxProducts);
    }

    /**
     * 根据商品id查询商品
     *
     * @param id 商品id
     * @return
     */
    @Override
    public SxProduct findById(Integer id) {
        return sxProductMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
        sxProductMapper.deleteByIdList(ids);
    }

    /**
     * 查询库存紧张的商品
     * @return
     */
    @Override
    public CommonPage findDangerNum(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<SxProduct> sxProductList = sxProductMapper.selectAll();
        List<SxProduct> sxProducts=new ArrayList<>();
        for(SxProduct sxProduct:sxProductList){
            if(sxProduct.getNumber()<=sxProduct.getDangernum()){
                sxProducts.add(sxProduct);
            }
        }
        return CommonPage.restPage(sxProducts);

    }
}
