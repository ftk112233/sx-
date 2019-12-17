package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxRoleMapper;
import com.mt.sx.mapper.SxRolePermissionMapper;
import com.mt.sx.mapper.SxUserRoleMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxRolePermission;
import com.mt.sx.pojo.SxUserRole;
import com.mt.sx.pojo.vo.SxRoleVo;
import com.mt.sx.service.SxRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SxRoleServiceImpl implements SxRoleService {
    @Autowired
    SxRoleMapper sxRoleMapper;
    @Autowired
    SxUserRoleMapper sxUserRoleMapper;
    @Autowired
    SxRolePermissionMapper sxRolePermissionMapper;

    /**
     * 按条件查询所有角色
     * @return
     */
    @Override
    public List<SxRole> list(SxRoleVo sxRoleVo) {
        return sxRoleMapper.selectAll();
    }

    /**
     * 插入角色
     * @param sxRole
     */
    @Override
    public void insert(SxRole sxRole) {
        Date date=new Date();
        sxRole.setCreateTime(date);
        sxRole.setUpdateTime(date);
        sxRoleMapper.insertSelective(sxRole);
    }

    /**
     * 更新角色
     * @param sxRole
     */
    @Override
    public void update(SxRole sxRole) {
        sxRole.setUpdateTime(new Date());
        sxRoleMapper.updateByPrimaryKeySelective(sxRole);
    }

    /**
     * 删除角色
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //先删除两张中间表关联的数据
        SxUserRole sxUserRole=new SxUserRole();
        sxUserRole.setRid(id);
        sxUserRoleMapper.delete(sxUserRole);
        SxRolePermission sxRolePermission=new SxRolePermission();
        sxRolePermission.setRid(id);
        sxRolePermissionMapper.delete(sxRolePermission);
        sxRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更具角色id查询角色
     * @param id
     * @return
     */
    @Override
    public SxRole findById(Integer id) {
       return sxRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除角色
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
       sxRoleMapper.deleteByIdList(ids);
    }

    /**
     * 为角色添加权限
     * @param rid
     * @param ids
     */
    @Override
    public void saveRolePermission(Integer rid, List<Integer> ids) {
        for(Integer pid:ids){
            SxRolePermission sxRolePermission=new SxRolePermission(rid,pid);
            sxRolePermissionMapper.insert(sxRolePermission);
        }
    }

    /**
     * 根据商户id查询其拥有角色
     * @param id
     * @return
     */
    @Override
    public List<SxRole> allRolesByBid(Integer id) {
        //先查询出商户拥有的角色id
        SxUserRole sxUserRole=new SxUserRole();
        sxUserRole.setUid(id);
        List<SxUserRole> sxUserRoleList = sxUserRoleMapper.select(sxUserRole);

        List<SxRole> roleList=new ArrayList();
        for (SxUserRole userRole:sxUserRoleList){
            SxRole sxRole = sxRoleMapper.selectByPrimaryKey(userRole.getRid());
            roleList.add(sxRole);
        }
        return roleList;
    }
}
