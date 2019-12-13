package com.mt.sx.service.impl;

import com.mt.sx.mapper.YsShopMapper;
import com.mt.sx.pojo.YsShop;
import com.mt.sx.service.SxUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class SxUserInfoServiceImpl implements SxUserInfoService {
    @Autowired
    YsShopMapper ysShopMapper;
    @Override
    public Object selectUser(Integer id) {
        return ysShopMapper.selectByPrimaryKey(id);
    }
}
