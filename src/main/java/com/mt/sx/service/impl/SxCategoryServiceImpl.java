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
    public Integer insertCategory(SxCategory sxCategory) {
        Date date = new Date();
        sxCategory.setCreateTime(date);
        sxCategory.setUpdateTime(date);

        return sxCategoryMapper.insertSelective(sxCategory);
    }

    /**
     * 更新分类
     *
     * @param sxCategory
     * @return
     */

    @Override
    public Integer updateCategory(SxCategory sxCategory) {
        sxCategory.setUpdateTime(new Date());
        return sxCategoryMapper.updateByPrimaryKeySelective(sxCategory);
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */

    @Override
    public Integer deleteCategory(Integer id) {
       return sxCategoryMapper.deleteByPrimaryKey(id);
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
