package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxPermissionMapper;
import com.mt.sx.mapper.SxRolePermissionMapper;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.pojo.SxRolePermission;
import com.mt.sx.service.SxPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SxPermissionServiceImpl implements SxPermissionService {
    @Autowired
    SxPermissionMapper sxPermissionMapper;
    @Autowired
    SxRolePermissionMapper sxRolePermissionMapper;
    /**
     * 根据id查询权限
     * @param id
     * @return
     */
    @Override
    public SxPermission findById(Integer id) {
        return sxPermissionMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据角色id查询所有权限
     * @param id 角色id
     * @return
     */
    @Override
    public List<SxPermission> allPermissionsByRid(Integer id) {
        //获取角色关联的权限id
        SxRolePermission sxRolePermission=new SxRolePermission();
        sxRolePermission.setRid(id);
        List<SxRolePermission> rolePermissionList = sxRolePermissionMapper.select(sxRolePermission);
        List<SxPermission> permissionList=new ArrayList<>();
        for (SxRolePermission rolePermission:rolePermissionList){
            //根据权限id查询权限
            SxPermission sxPermission = sxPermissionMapper.selectByPrimaryKey(rolePermission.getPid());
            permissionList.add(sxPermission);

        }
        return permissionList;
    }
}
