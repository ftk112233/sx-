package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxCategory;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxCategoryMapper extends MyMapper<SxCategory>, IdListMapper<SxRole,Integer> {
}