package com.mt.sx.service;

import com.mt.sx.pojo.SxPermission;

import java.security.Permission;
import java.util.List;

public interface SxPermissionService {
    SxPermission findById(Integer id);

    List<SxPermission> allPermissionsByRid(Integer id);

    List<SxPermission> loadLeftMenu();
}
