package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxOrderInfo;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxOrderInfoMapper extends MyMapper<SxOrderInfo> , IdListMapper<SxRole,Integer> {
}