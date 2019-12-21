package com.mt.sx.service;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.pojo.SxRole;

import java.util.List;

public interface SxRoleService {
    CommonPage<SxRole> list(Integer page, Integer pageSize, String name);

    void insert(SxRole sxRole);

    void update(SxRole sxRole);

    void delete(Integer id);

    SxRole findById(Integer id);

    void batchDelete(List<Integer> ids);

    void saveRolePermission(Integer rid,List<Integer> ids);

    List<SxRole> allRolesByBid(Integer id);
}
