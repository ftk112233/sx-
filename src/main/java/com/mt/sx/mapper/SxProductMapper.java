package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxProductMapper extends MyMapper<SxProduct>, IdListMapper<SxRole,Integer> {
}