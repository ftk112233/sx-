package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxSpuMapper;
import com.mt.sx.pojo.SxSpu;
import com.mt.sx.service.SxSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SxSpuServiceImpl implements SxSpuService {
    @Autowired
    SxSpuMapper sxSpuMapper;

    /**
     * 查询所有小分类
     * @return
     */
    @Override
    public List<SxSpu> list() {
        return sxSpuMapper.selectAll();
    }

    /**
     * 插入小分类
     * @param sxSpu
     * @return
     */
    @Override
    public Integer insertSpu(SxSpu sxSpu) {
        Date date=new Date();
        sxSpu.setCreateTime(date);
        sxSpu.setUpdateTime(date);
        sxSpu.setSort(0);
        sxSpu.setStatus(1);
        return sxSpuMapper.insertSelective(sxSpu);
    }

    /**
     * 更新小分类
     * @param sxSpu
     * @return
     */
    @Override
    public Integer updateSxSpu(SxSpu sxSpu) {
        sxSpu.setUpdateTime(new Date());
        return sxSpuMapper.updateByPrimaryKeySelective(sxSpu);
    }

    /**
     * 删除小分类
     * @param id
     * @return
     */
    @Override
    public Integer deleteSxSpu(Integer id) {
        return sxSpuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据大分类id查询小分类
     * @param categoryId 分类id
     * @return
     */
    @Override
    public List<SxSpu> findByCategoryId(Integer categoryId) {
        SxSpu sxSpu=new SxSpu();
        sxSpu.setCategoryId(categoryId);
        return sxSpuMapper.select(sxSpu);
    }

    /**
     * 根据小分类id查询
     * @param id
     * @return
     */
    @Override
    public SxSpu findById(Integer id) {
        return sxSpuMapper.selectByPrimaryKey(id);
    }
}
