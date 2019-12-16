package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxPassby;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxPassbyMapper extends MyMapper<SxPassby> , IdListMapper<SxRole,Integer> {
}