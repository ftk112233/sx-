package com.mt.sx.service;

import com.mt.sx.pojo.SxSpecsUnit;

import java.util.List;

public interface SxSpecsUnitService {
    List<SxSpecsUnit> list();

    Integer insert(SxSpecsUnit sxSpecsUnit);

    Integer update(SxSpecsUnit sxSpecsUnit);

    Integer delete(Integer id);

    SxSpecsUnit findById(Integer id);

    void batchDelete(List<Integer> ids);
}
