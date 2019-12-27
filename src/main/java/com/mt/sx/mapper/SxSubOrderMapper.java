package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxSubOrder;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxSubOrderMapper extends MyMapper<SxSubOrder>, IdListMapper<SxRole,Integer> {
}