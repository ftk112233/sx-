package com.mt.sx.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mt.sx.mapper.SxUserMapper;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.service.SxUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SxUserServiceImpl implements SxUserService {
    @Autowired
    SxUserMapper sxUserMapper;

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @Override
    public SxUser findByName(String username) {
        SxUser sxUser=new SxUser();
        sxUser.setUsername(username);
        return sxUserMapper.selectOne(sxUser);
    }

    /**
     * 增加用户
     * @param sxUser
     */
    @Override
    public void insert(SxUser sxUser) {
        sxUser.setCreateTime(new Date());
        String salt= IdUtil.simpleUUID().toUpperCase();
        sxUser.setSalt(salt);//设置盐
        sxUser.setPassword(new Md5Hash(sxUser.getPassword(), salt, 2).toString());
        sxUserMapper.insertSelective(sxUser);

    }
}
