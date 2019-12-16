package com.mt.sx.service.impl;

import com.mt.sx.mapper.SxSpecsWayMapper;
import com.mt.sx.pojo.SxSpecsWay;
import com.mt.sx.service.SxSpecsWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SxSpecsWayServiceImpl implements SxSpecsWayService {
    @Autowired
    SxSpecsWayMapper sxSpecsWayMapper;

    /**
     * 查询所有规格方式
     * @return
     */
    @Override
    public List<SxSpecsWay> list() {
        return sxSpecsWayMapper.selectAll();
    }

    /**
     * 添加规格方式
     * @param sxSpecsWay
     * @return
     */
    @Override
    public Integer insert(SxSpecsWay sxSpecsWay) {
        Date date=new Date();
        sxSpecsWay.setCreateTime(date);
        sxSpecsWay.setUpdateTime(date);
        return sxSpecsWayMapper.insertSelective(sxSpecsWay);
    }

    /**
     * 更新规格方式
     * @param sxSpecsWay
     * @return
     */
    @Override
    public Integer update(SxSpecsWay sxSpecsWay) {
        sxSpecsWay.setUpdateTime(new Date());
        return sxSpecsWayMapper.updateByPrimaryKeySelective(sxSpecsWay);
    }

    /**
     * 删除规格方式
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return sxSpecsWayMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据售卖方式id查询售卖方式
     * @param id
     * @return
     */
    @Override
    public SxSpecsWay findById(Integer id) {

        return  sxSpecsWayMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除售卖方式
     * @param ids
     */
    @Override
    public void batchDelete(List<Integer> ids) {
       sxSpecsWayMapper.deleteByIdList(ids);
    }
}
