package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxSku;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxSkuMapper extends MyMapper<SxSku> , IdListMapper<SxRole,Integer> {
}