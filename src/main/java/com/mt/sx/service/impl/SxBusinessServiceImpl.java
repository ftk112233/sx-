package com.mt.sx.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mt.sx.mapper.SxBusinessMapper;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.service.SxBusinessService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class SxBusinessServiceImpl implements SxBusinessService {
    @Autowired
    SxBusinessMapper sxBusinessMapper;



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
