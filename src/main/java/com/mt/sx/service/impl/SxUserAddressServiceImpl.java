package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxAddressInfoMapper;
import com.mt.sx.pojo.SxAddressInfo;
import com.mt.sx.service.SxUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SxUserAddressServiceImpl implements SxUserAddressService {
    @Autowired
    SxAddressInfoMapper sxAddressInfoMapper;

    @Override
    public List<SxAddressInfo> addressList(Integer shopId) {
        SxAddressInfo sxAddressInfo  = new SxAddressInfo();
        sxAddressInfo.setShopId(shopId);
        return sxAddressInfoMapper.select(sxAddressInfo);
    }

    @Override
    public Integer insert(SxAddressInfo sxAddressInfo) {
        //测试代码。以后从redis获取用户的id存储
        sxAddressInfo.setShopId(1);
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
}
