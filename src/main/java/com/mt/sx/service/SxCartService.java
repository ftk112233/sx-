package com.mt.sx.service;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxCart;
import com.mt.sx.pojo.vo.SxCartVo;

import java.util.ArrayList;
import java.util.List;

public interface SxCartService {

    Integer insert(Integer id, Integer num);

    SxCart selectByProductId(Integer id);

    Integer update(Integer id, Integer num);

    CommonResult<ArrayList<List<SxCartVo>>> findCartInfoById(Integer id);

    Integer deletedByCartId(Integer id);

    Boolean checkNum(Integer id, Integer num);

    CommonResult deletedMany(List list);
}
