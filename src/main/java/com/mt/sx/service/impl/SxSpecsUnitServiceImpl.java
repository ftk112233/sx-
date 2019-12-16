package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxSpecsUnitMapper;
import com.mt.sx.pojo.SxSpecsUnit;
import com.mt.sx.service.SxSpecsUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SxSpecsUnitServiceImpl implements SxSpecsUnitService {
    @Autowired
    SxSpecsUnitMapper sxSpecsUnitMapper;

    /**
     * 查询所有单位规格
     * @return
     */
    @Override
    public List<SxSpecsUnit> list() {
        return sxSpecsUnitMapper.selectAll();
    }

    /**
     * 插入单位规格
     * @param sxSpecsUnit
     * @return
     */
    @Override
    public Integer insert(SxSpecsUnit sxSpecsUnit) {
        Date date=new Date();
        sxSpecsUnit.setCreateTime(date);
        sxSpecsUnit.setUpdateTime(date);
        return sxSpecsUnitMapper.insertSelective(sxSpecsUnit);
    }

    /**
     * 更新单位规格
     * @param sxSpecsUnit
     * @return
     */

    @Override
    public Integer update(SxSpecsUnit sxSpecsUnit) {
        sxSpecsUnit.setUpdateTime(new Date());
        return sxSpecsUnitMapper.updateByPrimaryKeySelective(sxSpecsUnit);
    }

    /**
     * 删除单位规格
     * @param id 单位规格id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return sxSpecsUnitMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据单位规格id查询单位规格
     * @param id
     * @return
     */
    @Override
    public SxSpecsUnit findById(Integer id) {
        return sxSpecsUnitMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
        sxSpecsUnitMapper.deleteByIdList(ids);
    }
}
