package com.mt.sx.service;

import com.mt.sx.pojo.SxSpecsWay;

import java.util.List;

public interface SxSpecsWayService {
    List<SxSpecsWay> list();

    Integer insert(SxSpecsWay sxSpecsWay);

    Integer update(SxSpecsWay sxSpecsWay);

    Integer delete(Integer id);

    SxSpecsWay findById(Integer id);

    void batchDelete(List<Integer> ids);
}
