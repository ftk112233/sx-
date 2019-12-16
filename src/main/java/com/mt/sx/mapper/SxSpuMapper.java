package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxSpu;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxSpuMapper extends MyMapper<SxSpu>, IdListMapper<SxRole,Integer> {
}