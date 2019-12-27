package com.mt.sx.service.impl;

import com.mt.sx.common.util.UserUtils;
import com.mt.sx.mapper.SxPermissionMapper;
import com.mt.sx.mapper.SxRolePermissionMapper;
import com.mt.sx.mapper.SxUserRoleMapper;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.pojo.SxRolePermission;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.SxUserRole;
import com.mt.sx.service.SxPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SxPermissionServiceImpl implements SxPermissionService {
    @Autowired
    SxPermissionMapper sxPermissionMapper;
    @Autowired
    SxRolePermissionMapper sxRolePermissionMapper;
    @Autowired
    SxUserRoleMapper sxUserRoleMapper;
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
     * 根据角色id查询所有权限或菜单
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
            SxPermission permission=new SxPermission();
            permission.setId(rolePermission.getPid());
            permission.setType("permission");
            SxPermission sxPermission = sxPermissionMapper.selectOne(permission);
            permissionList.add(sxPermission);

        }
        return permissionList;
    }

    /**
     * 加载后台管理左边的菜单
     * @return
     */
    @Override
    public List<SxPermission> loadLeftMenu() {
        SxUser user = UserUtils.getUser();
        List<SxPermission> list=null;
        if (user.getType()==0){//如果是管理员则加载全部
            SxPermission permission=new SxPermission();
            permission.setType("menu");
            list=sxPermissionMapper.select(permission);
        }else{
             //先查询角色拥有的角色，再根据角色查询拥有的菜单
             SxUserRole sxUserRole=new SxUserRole();
             sxUserRole.setUid(user.getId());
            List<SxUserRole> userRoles = sxUserRoleMapper.select(sxUserRole);
            Set<Integer> permissionIds=new HashSet<>();
            for(SxUserRole userRole:userRoles){
                SxRolePermission rolePermission=new SxRolePermission();
                rolePermission.setRid(userRole.getRid());
                List<SxRolePermission> rolePermissions = sxRolePermissionMapper.select(rolePermission);
                for(SxRolePermission sxRolePermission :rolePermissions){
                    permissionIds.add(sxRolePermission.getPid());
                }
            }
            List<Integer> ids = new ArrayList<>(permissionIds);
            list=sxPermissionMapper.selectByIdList(ids);
        }
        return list;
    }
}
