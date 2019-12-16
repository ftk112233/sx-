package com.mt.sx.service;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.pojo.SxComment;

import java.util.List;

public interface SxCommentService {
    CommonPage list(Integer page, Integer pageSize);


    Integer insert(SxComment sxComment);

    Integer delete(Integer id);

    List<SxComment> findByProductId(Integer productId);

    void batchDelete(List<Integer> ids);


}
