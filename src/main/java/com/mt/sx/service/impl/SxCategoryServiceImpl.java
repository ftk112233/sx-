package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxCategoryMapper;
import com.mt.sx.pojo.SxCategory;
import com.mt.sx.service.SxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SxCategoryServiceImpl implements SxCategoryService {
    @Autowired
    SxCategoryMapper sxCategoryMapper;

    /**
     * 查询所有分类
     *
     * @return
     */
    @Override
    public List<SxCategory> list() {
        return sxCategoryMapper.selectAll();
    }

    /**
     * 插入分类
     *
     * @param sxCategory
     * @return
     */
    @Override
    public void insertCategory(SxCategory sxCategory) {
        Date date = new Date();
        sxCategory.setCreateTime(date);
        sxCategory.setUpdateTime(date);

        sxCategoryMapper.insertSelective(sxCategory);
    }

    /**
     * 更新分类
     *
     * @param sxCategory
     * @return
     */

    @Override
    public void updateCategory(SxCategory sxCategory) {
        sxCategory.setUpdateTime(new Date());
        sxCategoryMapper.updateByPrimaryKeySelective(sxCategory);
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */

    @Override
    public void deleteCategory(Integer id) {
       sxCategoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    @Override
    public SxCategory findById(Integer id) {
        return sxCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
        sxCategoryMapper.deleteByIdList(ids);
    }
}
