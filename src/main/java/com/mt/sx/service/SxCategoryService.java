package com.mt.sx.service;

import com.mt.sx.pojo.SxCategory;

import java.util.List;

public interface SxCategoryService {
    List<SxCategory> list();

    Integer insertCategory(SxCategory sxCategory);

    Integer updateCategory(SxCategory sxCategory);

    Integer  deleteCategory(Integer id);

    SxCategory findById(Integer id);

}
