package com.mt.sx.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.sx.common.base.CommonPage;
import com.mt.sx.common.util.UserUtils;
import com.mt.sx.mapper.SxPermissionMapper;
import com.mt.sx.mapper.SxRolePermissionMapper;
import com.mt.sx.mapper.SxUserRoleMapper;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.pojo.SxRolePermission;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.SxUserRole;
import com.mt.sx.service.SxPermissionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.security.Permission;
import java.util.*;

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

    /**
     * 分页查询所有权限
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public CommonPage listPermission(Integer page, Integer pageSize,String percode) {
        PageHelper.startPage(page,pageSize);
        Example example=new Example(SxPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type","permission");
        if(StringUtils.isNotBlank(percode)){
            criteria.andLike("percode","%"+percode+"%");
        }
        example.orderBy("sort");
        List<SxPermission> permissionList = sxPermissionMapper.selectByExample(example);

        return CommonPage.restPage(permissionList);
    }

    /**
     * 增加权限
     * @param sxPermission
     */
    @Override
    public void insertPermission(SxPermission sxPermission) {
        sxPermission.setType("permission");
        sxPermission.setCreateTime(new Date());
        sxPermissionMapper.insertSelective(sxPermission);
    }

    /**
     * 修改权限
     * @param sxPermission
     */
    @Override
    public void updatePermission(SxPermission sxPermission) {
        sxPermissionMapper.updateByPrimaryKeySelective(sxPermission);
    }

    /**
     * 删除商品权限
     * @param id
     */
    @Override
    public void deletePermission(Integer id) {
        //先删除角色和权限的中间表
        SxRolePermission sxRolePermission=new SxRolePermission();
        sxRolePermission.setPid(id);
        sxRolePermissionMapper.delete(sxRolePermission);
        //再删除权限表
        sxPermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除权限
     * @param ids
     */
    @Override
    public void batchDeletePermisson(List<Integer> ids) {
        //先删除角色和权限的中间表
        for(Integer id:ids){
            SxRolePermission sxRolePermission=new SxRolePermission();
            sxRolePermission.setPid(id);
            sxRolePermissionMapper.delete(sxRolePermission);
        }
        //再删除权限表
        sxPermissionMapper.deleteByIdList(ids);
    }

    /**
     * 分页查询所有菜单
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public CommonPage listMenu(Integer page, Integer pageSize,String title) {
        PageHelper.startPage(page,pageSize);
        Example example=new Example(SxPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type","menu");
        if(StringUtils.isNotBlank(title)){
            criteria.andLike("title","%"+title+"%");
        }
        example.orderBy("sort");
        List<SxPermission> permissionList = sxPermissionMapper.selectByExample(example);

        return CommonPage.restPage(permissionList);
    }

    /**
     * 增加权限菜单
     * @param sxPermission
     */
    @Override
    public void insertMenu(SxPermission sxPermission) {
        sxPermission.setType("menu");
        sxPermission.setCreateTime(new Date());
        sxPermissionMapper.insertSelective(sxPermission);
    }

    /**
     * 修改权限菜单
     * @param sxPermission
     */
    @Override
    public void updateMenu(SxPermission sxPermission) {
        sxPermissionMapper.updateByPrimaryKeySelective(sxPermission);
    }

    /**
     * 删除商品菜单
     * @param id
     */
    @Override
    public void deleteMenu(Integer id) {
        //先删除角色和权限的中间表
        SxRolePermission sxRolePermission=new SxRolePermission();
        sxRolePermission.setPid(id);
        sxRolePermissionMapper.delete(sxRolePermission);
        //再删除菜单信息
        sxPermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除菜单
     * @param ids
     */
    @Override
    public void batchDeleteMenu(List<Integer> ids) {
        //先删除角色和权限的中间表
        for(Integer id:ids){
            SxRolePermission sxRolePermission=new SxRolePermission();
            sxRolePermission.setPid(id);
            sxRolePermissionMapper.delete(sxRolePermission);
        }
        //再删除菜单信息
        sxPermissionMapper.deleteByIdList(ids);
    }

    /**
     * 根据菜单id查询权限
     * @param d
     * @return
     */
    @Override
    public List<SxPermission> findPermissionByPid(Integer id) {
        SxPermission sxPermission=new SxPermission();
        sxPermission.setId(id);
        sxPermission.setType("permission");
        return sxPermissionMapper.select(sxPermission);
    }

    /**
     * 根据菜单id查询子菜单
     * @param id
     * @return
     */
    @Override
    public List<SxPermission> findMenuByPid(Integer id) {
        SxPermission sxPermission=new SxPermission();
        sxPermission.setPid(id);;
        sxPermission.setType("menu");
        return sxPermissionMapper.select(sxPermission);
    }
}
