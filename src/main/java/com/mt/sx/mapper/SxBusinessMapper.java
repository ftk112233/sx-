package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxPermission;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxBusinessMapper extends MyMapper<SxBusiness>, IdListMapper<SxPermission,Integer> {
}