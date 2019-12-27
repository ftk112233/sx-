package com.mt.sx.service;

import com.mt.sx.pojo.SxCategory;

import java.util.List;

public interface SxCategoryService {
    List<SxCategory> list();

    void insertCategory(SxCategory sxCategory);

    void updateCategory(SxCategory sxCategory);

    void  deleteCategory(Integer id);

    SxCategory findById(Integer id);

    void batchDelete(List<Integer> ids);

}
