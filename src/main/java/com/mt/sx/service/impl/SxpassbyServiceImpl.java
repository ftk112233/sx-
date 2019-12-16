package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxPassbyMapper;
import com.mt.sx.pojo.SxPassby;
import com.mt.sx.service.SxpassbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SxpassbyServiceImpl implements SxpassbyService {
    @Autowired
    SxPassbyMapper sxPassbyMapper;

    @Override
    public List<SxPassby> findByBusId(Integer businessid) {

        if (businessid != null) {
            Example example = new Example(SxPassby.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("businessId", businessid);
            return sxPassbyMapper.selectByExample(example);
        } else {
            return sxPassbyMapper.selectAll();
        }
    }

    @Override
    public Integer insert(SxPassby sxPassby) {
        return sxPassbyMapper.insert(sxPassby);
    }

    @Override
    public Integer update(SxPassby sxPassby) {
        Example example = new Example(SxPassby.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", sxPassby.getId());
        return sxPassbyMapper.updateByExampleSelective(sxPassby, example);
    }

    @Override
    public Integer deleted(Integer passId) {
        return sxPassbyMapper.deleteByPrimaryKey(passId);
    }

}
