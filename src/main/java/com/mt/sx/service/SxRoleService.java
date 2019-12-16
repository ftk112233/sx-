package com.mt.sx.service;

import com.mt.sx.pojo.SxRole;

import java.util.List;

public interface SxRoleService {
    List<SxRole> list(SxRole sxRole);

    void insert(SxRole sxRole);

    void update(SxRole sxRole);

    void delete(Integer id);

    SxRole findById(Integer id);

    void batchDelete(List<Integer> ids);

    void saveRolePermission(Integer rid,List<Integer> ids);

    List<SxRole> allRolesByBid(Integer id);
}
