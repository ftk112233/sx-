package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxSpecsWay;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxSpecsWayMapper extends MyMapper<SxSpecsWay> , IdListMapper<SxRole,Integer> {
}