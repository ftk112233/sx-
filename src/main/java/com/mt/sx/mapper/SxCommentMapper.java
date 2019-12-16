package com.mt.sx.mapper;

import com.mt.sx.common.config.MyMapper;
import com.mt.sx.pojo.SxComment;
import com.mt.sx.pojo.SxRole;
import tk.mybatis.mapper.additional.idlist.IdListMapper;

public interface SxCommentMapper extends MyMapper<SxComment>, IdListMapper<SxRole,Integer> {
}