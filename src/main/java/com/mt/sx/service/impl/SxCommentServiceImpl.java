package com.mt.sx.service.impl;

import com.github.pagehelper.PageHelper;
import com.mt.sx.common.base.CommonPage;
import com.mt.sx.mapper.SxCommentMapper;
import com.mt.sx.pojo.SxComment;
import com.mt.sx.service.SxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SxCommentServiceImpl implements SxCommentService {
    @Autowired
    SxCommentMapper sxCommentMapper;

    /**
     * 查询所有评论
     * 还得改
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public CommonPage list(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<SxComment> sxComments = sxCommentMapper.selectAll();
        return CommonPage.restPage(sxComments);
    }


    /**
     * 插入评论
     * @param sxComment
     * @return
     */
    @Override
    public Integer insert(SxComment sxComment) {
        Date date=new Date();
        sxComment.setCreateTime(date);
        sxComment.setUpdateTime(date);
        return sxCommentMapper.insertSelective(sxComment);
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return sxCommentMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据商品id查询所有评论
     * @param productId
     * @return
     */
    @Override
    public List<SxComment> findByProductId(Integer productId) {
        SxComment sxComment=new SxComment();
        sxComment.setProductId(productId);
        return sxCommentMapper.select(sxComment);
    }
}
