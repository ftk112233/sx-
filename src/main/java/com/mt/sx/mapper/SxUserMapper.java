package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxUser;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxUserMapper extends MyMapper<SxUser> , IdListMapper<SxUser,Integer> {
}