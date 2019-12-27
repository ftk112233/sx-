package com.mt.sx.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.sx.mapper.SxUserMapper;
import com.mt.sx.mapper.SxUserRoleMapper;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.SxUserRole;
import com.mt.sx.pojo.vo.SxUserVo;
import com.mt.sx.service.SxUserService;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class SxUserServiceImpl implements SxUserService {
    @Autowired
    SxUserMapper sxUserMapper;
    @Autowired
    SxUserRoleMapper sxUserRoleMapper;

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
//        sxUser.setOpenId();  先不加，等以后用户授权之后一并传入进来
        sxUserMapper.insertSelective(sxUser);

    }

    /**
     * 修改用户
     * @param sxUser
     */
    @Override
    public void updateUser(SxUser sxUser) {
        sxUserMapper.updateByPrimaryKeySelective(sxUser);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //先删除用户和角色关联的中间表
        SxUserRole sxUserRole=new SxUserRole();
        sxUserRole.setUid(id);
        sxUserRoleMapper.delete(sxUserRole);
        //再删除用户表数据
        sxUserMapper.deleteByPrimaryKey(id);

    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
       for (Integer id:ids){
           //先删除用户和角色关联的中间表
           SxUserRole sxUserRole=new SxUserRole();
           sxUserRole.setUid(id);
           sxUserRoleMapper.delete(sxUserRole);
       }
       sxUserMapper.deleteByIdList(ids);
    }

    /**
     * 修改密码
     * @param id
     * @param password
     */
    @Override
    public void updatePwd(Integer id, String password) {
        SxUser sxUser=new SxUser();
        String salt= IdUtil.simpleUUID().toUpperCase();
        sxUser.setSalt(salt);//设置盐
        sxUser.setPassword(new Md5Hash(sxUser.getPassword(), salt, 2).toString());
        sxUserMapper.updateByPrimaryKeySelective(sxUser);
    }

    /**
     * 按条件分页查询
     * @param page
     * @param pageSize
     * @param username
     * @return
     */
    @Override
    public PageInfo<SxUser> list(Integer page,Integer pageSize,String username) {
        PageHelper.startPage(page,pageSize);
        Example example=new Example(SxUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(username)){
            criteria.andEqualTo("username",username);
        }
        List<SxUser> sxUsers = sxUserMapper.selectByExample(example);
        PageInfo<SxUser> pageInfo=new PageInfo<>(sxUsers);
        return pageInfo;
    }
}
