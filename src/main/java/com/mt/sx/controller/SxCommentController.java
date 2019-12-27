package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxComment;
import com.mt.sx.service.SxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class SxCommentController {
    @Autowired
    SxCommentService sxCommentService;

    /**
     * 分页查询所有评论
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(Integer page, Integer pageSize){
       return CommonResult.success( sxCommentService.list(page,pageSize));
    }

    /**
     * 通过商品id查询
     * @param page
     * @param pageSize
     * @param productId
     * @return
     */
    @GetMapping("/findByProId")
    public CommonResult findByProId(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "productId",required = false,defaultValue = "") Integer productId){
        return CommonResult.success(sxCommentService.findByProductId(page,pageSize,productId));

    }

    /**
     * 添加一条评论
     * @param sxComment
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insert(SxComment sxComment){
        try {
            sxCommentService.insert(sxComment) ;
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }


    }

    /**
     * 删除一条评论
     * @param sxComment
     * @return
     */
    @PostMapping("/delete")
    public CommonResult delete(SxComment sxComment){
        try {
            sxCommentService.insert(sxComment);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }


    }



    /**
     * 批量删除评论
     */
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids){
        try {
            sxCommentService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }
}
