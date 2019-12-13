package com.mt.sx.service;

import com.mt.sx.pojo.SxBusiness;

import java.util.List;

public interface SxBusinessService {
    SxBusiness findByName(String username);

    void insert(SxBusiness sxBusiness);

    void update(SxBusiness sxBusiness);

    void delete(Integer id);

    SxBusiness findById(Integer id);

    List<SxBusiness> list(SxBusiness sxBusiness);


}
