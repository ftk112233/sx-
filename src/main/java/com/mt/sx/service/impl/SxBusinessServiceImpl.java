package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxBusinessMapper;
import com.mt.sx.mapper.SxBusinessRoleMapper;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxBusinessRole;
import com.mt.sx.service.SxBusinessService;
import io.netty.handler.ssl.IdentityCipherSuiteFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class SxBusinessServiceImpl implements SxBusinessService {
    @Autowired
    SxBusinessMapper sxBusinessMapper;
    @Autowired
    SxBusinessRoleMapper sxBusinessRoleMapper;

    /**
     * 根据商户名查询商户
     * @param username
     * @return
     */
    @Override
    public SxBusiness findByName(String username) {
        SxBusiness sxBusiness=new SxBusiness();
        sxBusiness.setName(username);
        return sxBusinessMapper.selectOne(sxBusiness);
    }

    /**
     * 按条件查询商户
     * @param sxBusiness
     * @return
     */
    @Override
    public List<SxBusiness> list(SxBusiness sxBusiness) {
        Example example =new Example(SxBusiness.class);
        if(StringUtils.isNotBlank(sxBusiness.getName())){
            example.createCriteria().andLike("name",sxBusiness.getName());
        }
        return sxBusinessMapper.selectByExample(example);
    }

    /**
     * 增加商户
     * @param sxBusiness
     * @return
     */
    @Override
    public void insert(SxBusiness sxBusiness) {
        Date date =new Date();
        sxBusiness.setCreateTime(date);
        sxBusiness.setUpdateTime(date);

        sxBusinessMapper.insertSelective(sxBusiness);
    }
    /**
     * 更新商户
     */
    @Override
    public void update(SxBusiness sxBusiness) {
        sxBusiness.setUpdateTime(new Date());
        sxBusinessMapper.updateByPrimaryKeySelective(sxBusiness);
    }

    /**
     * 删除商户
     * @param id
     * @return
     */
    @Override
    public void delete(Integer id) {
        //先删除商户和角色中间表的数据
        SxBusinessRole sxBusinessRole=new SxBusinessRole();
        sxBusinessRole.setBid(id);
        sxBusinessRoleMapper.delete(sxBusinessRole);
        //上除商户表数据
       sxBusinessMapper.deleteByPrimaryKey(id);

    }

    /**
     * 根据id查询商户
     * @param id
     * @return
     */
    @Override
    public SxBusiness findById(Integer id) {
        return sxBusinessMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
        sxBusinessMapper.deleteByIdList(ids);
    }
}
