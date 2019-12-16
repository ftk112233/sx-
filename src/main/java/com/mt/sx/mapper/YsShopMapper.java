package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.YsShop;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface YsShopMapper extends MyMapper<YsShop>, IdListMapper<SxRole,Integer> {
}