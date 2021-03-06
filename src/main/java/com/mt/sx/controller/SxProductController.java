package com.mt.sx.controller;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.pojo.vo.SxProductVO;
import com.mt.sx.service.SxProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品操作接口")
@RestController
@RequestMapping("/product")
public class SxProductController {
    @Autowired
    SxProductService sxProductService;

    /**
     * 后台按条件分页查询商品
     *
     * @return
     */
    @ApiOperation("商品列表查询")
    @GetMapping("/list")
    public CommonResult list(SxProductVO sxProductVO) {
        return CommonResult.success(sxProductService.list(sxProductVO));
    }

    /**
     * 后台添加商品
     *
     * @param sxProduct
     * @return
     */
    @ApiOperation("插入商品信息")
    @PostMapping("/insert")
    public CommonResult insert(SxProduct sxProduct) {
        if (sxProductService.insert(sxProduct) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    /**
     * 后台更新商品
     *
     * @param sxProduct
     * @return
     */
    @ApiOperation(value = "更新商品接口")
    @PostMapping("/update")
    public CommonResult update(SxProduct sxProduct) {
        if (sxProductService.update(sxProduct) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.UPDATE_FALSE);
    }

    /**
     * 后台删除商品
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除商品信息", notes = "传入商品的id")
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("id") Integer id) {
        if (sxProductService.delete(id) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

    /**
     * 前台查询热销商品
     *
     * @return
     */
    @ApiOperation("查询热销商品")
    @GetMapping("/findSellWell")
    public CommonResult<CommonPage> findSellWell() {
        return CommonResult.success(sxProductService.findSellWell());
    }

    /**
     * 前台根据小分类id查询所有商品
     *
     * @param spuId
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("根据小分类id查询所有商品")
    @GetMapping("/findBySpuId")
    public CommonResult<CommonPage> findBySpuId(@RequestParam("id") Integer spuId,
                                                @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        return CommonResult.success(sxProductService.findBySpuId(spuId, page, pageSize));
    }

    /**
     * 此接口用于前台搜索
     *
     * @param name     商品名
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("前台搜索商品名")
    @GetMapping("/search")
    public CommonResult<CommonPage> search(@RequestParam("name") String name,
                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        return CommonResult.success(sxProductService.search(name, page, pageSize));
    }

    /**
     * 根据id查询商品
     *
     * @param id
     * @return
     */
    @ApiOperation("根据商品id查询商品")
    @GetMapping("/findById")
    public CommonResult<SxProduct> findById(@RequestParam("id") Integer id) {
        return CommonResult.success(sxProductService.findById(id));
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "批量删除商品", notes = "传入List<Integer> ids")
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids) {
        try {
            sxProductService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }

    /**
     * 查询库存紧张的商品
     */
    public CommonResult findDangerNum(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize){
        try {
            CommonPage dangerNum = sxProductService.findDangerNum(page, pageSize);
            return CommonResult.success(dangerNum);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }


    }
}
