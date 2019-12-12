package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxCart;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.IdsMapper;

public interface SxCartMapper extends MyMapper<SxCart>, SelectByIdListMapper<SxCart, Integer>, DeleteByIdListMapper<SxCart,Integer> {
}