package com.mt.sx.service;

import com.github.pagehelper.PageInfo;
import com.mt.sx.common.base.CommonPage;
import com.mt.sx.pojo.SxPermission;

import java.security.Permission;
import java.util.List;

public interface SxPermissionService {
    SxPermission findById(Integer id);

    List<SxPermission> allPermissionsByRid(Integer id);

    List<SxPermission> loadLeftMenu();

    CommonPage listPermission(Integer page, Integer pageSize,String percode);

    void insertPermission(SxPermission sxPermission);

    void updatePermission(SxPermission sxPermission);

    void deletePermission(Integer id);

    void batchDeletePermisson(List<Integer> ids);

    CommonPage listMenu(Integer page, Integer pageSize, String title);

    void insertMenu(SxPermission sxPermission);

    void updateMenu(SxPermission sxPermission);

    void deleteMenu(Integer id);

    void batchDeleteMenu(List<Integer> ids);

    List<SxPermission> findPermissionByPid(Integer id);

    List<SxPermission> findMenuByPid(Integer id);
}
