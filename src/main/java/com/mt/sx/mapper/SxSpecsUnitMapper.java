package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxSpecsUnit;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxSpecsUnitMapper extends MyMapper<SxSpecsUnit>, IdListMapper<SxRole,Integer> {
}