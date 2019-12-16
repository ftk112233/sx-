package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxOrder;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxOrderMapper extends MyMapper<SxOrder>, IdListMapper<SxRole,Integer> {
}