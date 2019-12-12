package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxCart;
import com.mt.sx.pojo.SxOrder;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.IdsMapper;

public interface SxOrderMapper extends MyMapper<SxOrder> , SelectByIdListMapper<SxCart, Integer> {
}