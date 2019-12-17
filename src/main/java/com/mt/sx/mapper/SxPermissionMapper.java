package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxPermissionMapper extends MyMapper<SxPermission>, IdListMapper<SxPermission,Integer> {
}