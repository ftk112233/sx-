package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxSpu;
import com.mt.sx.service.SxSpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spu")
public class SxSpuController {
    @Autowired
    SxSpuService sxSpuService;

    /**
     * 查询所有小分类
     * @return
     */
    @GetMapping("/list")
    public CommonResult<List<SxSpu>> list(){
        return CommonResult.success(sxSpuService.list());
    }

    /**
     * 添加小分类
     * @param sxSpu
     * @return
     */

    @PostMapping("/insert")
    public CommonResult insert(SxSpu sxSpu){
        if(sxSpuService.insertSpu(sxSpu)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    /**
     * 更新小分类
     * @param sxSpu
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(SxSpu sxSpu){
        if(sxSpuService.updateSxSpu(sxSpu)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.UPDATE_FALSE);
    }

    /**
     * 删除小分类
     * @param id 小分类id
     * @return
     */
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("id") Integer id){
        if(sxSpuService.deleteSxSpu(id)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

    /**
     * 根据大分类id查询小分类
     * @param categoryId  大分类id
     * @return
     */
    @GetMapping("/findByCategoryId")
    public CommonResult<List<SxSpu>> findByCategory(@RequestParam(value ="categoryId") Integer categoryId){
        if (categoryId==null||categoryId==0){
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }
        return CommonResult.success(sxSpuService.findByCategoryId(categoryId));
    }

    /**
     * 根据小分类id查询小分类
     * @param id  小分类id
     * @return
     */
    @GetMapping("/findById")
    public CommonResult<SxSpu> findById(@RequestParam("id") Integer id){
        return CommonResult.success(sxSpuService.findById(id));

    }

    /**
     * 批量删除
     */
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids){
        try {
            sxSpuService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }
}
