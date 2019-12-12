package com.mt.sx.service;

import com.mt.sx.pojo.SxSpu;

import java.util.List;

public interface SxSpuService {
    List<SxSpu> list();

    Integer insertSpu(SxSpu sxSpu);

    Integer uopdateSxSpu(SxSpu sxSpu);

    Integer deleteSxSpu(Integer id);

    List<SxSpu> findByCategoryId(Integer categoryId);
}
