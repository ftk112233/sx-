package com.mt.sx.service;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.pojo.SxBusiness;

import java.util.List;

public interface SxBusinessService {

    void insert(SxBusiness sxBusiness);

    void update(SxBusiness sxBusiness);

    void delete(Integer id);

    SxBusiness findById(Integer id);

    CommonPage<SxBusiness> list(Integer page, Integer pageSize, String name);

    void batchDelete(List<Integer> ids);


}
