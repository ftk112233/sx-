package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxPassbyMapper;
import com.mt.sx.pojo.SxPassby;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.service.SxpassbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static com.mt.sx.common.util.UserUtils.getUser;

@Service
public class SxpassbyServiceImpl implements SxpassbyService {
    @Autowired
    SxPassbyMapper sxPassbyMapper;

    @Override
    public List<SxPassby> findByBusId() {
        SxUser user = getUser();
        Integer businessid = user.getRelateId();
        if (businessid != null) {
            Example example = new Example(SxPassby.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("businessId", businessid)
                    .andEqualTo("status", 0)
                    .andEqualTo("deleted", 0);
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

}
