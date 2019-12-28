package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxAddressInfoMapper;
import com.mt.sx.pojo.SxAddressInfo;
import com.mt.sx.service.SxUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.mt.sx.common.util.UserUtils.getUser;

@Service
public class SxUserAddressServiceImpl implements SxUserAddressService {
    @Autowired
    SxAddressInfoMapper sxAddressInfoMapper;

    @Override
    public List<SxAddressInfo> addressList() {

        SxAddressInfo sxAddressInfo  = new SxAddressInfo();
        sxAddressInfo.setShopId(getUser().getRelateId());
        return sxAddressInfoMapper.select(sxAddressInfo);
    }

    @Override
    public Integer insert(SxAddressInfo sxAddressInfo) {
        sxAddressInfo.setShopId(getUser().getRelateId());
        sxAddressInfo.setCreateTime(new Date());
        return sxAddressInfoMapper.insert(sxAddressInfo);
    }

    @Override
    public Integer update(SxAddressInfo sxAddressInfo) {
        sxAddressInfo.setUpdateTime(new Date());
        return sxAddressInfoMapper.updateByPrimaryKeySelective(sxAddressInfo);
    }

    @Override
    public Integer deletedForUser(Integer id) {
        return sxAddressInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SxAddressInfo selectById(Integer id) {
        return sxAddressInfoMapper.selectByPrimaryKey(id);
    }
}
