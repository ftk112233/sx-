package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxCart;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxCartMapper extends MyMapper<SxCart> , IdListMapper<SxCart,Integer> {
}