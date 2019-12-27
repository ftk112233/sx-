package com.mt.sx.controller;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.service.SxCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "用户购物车操作接口")
@RestController
@RequestMapping("cart")
public class SxCartController {
    @Resource
    private SxCartService sxCartService;

    //一次加入一个或者多个进入购物车
    @ApiOperation(value = "加入购物车", notes = "可以一次加入多个或者一个")
    @PostMapping("insert")
    public CommonResult insert(Integer id, Integer num) {
        if (StringUtils.isEmpty(id)) {
            return CommonResult.fail(-1, "请重新选择商品");
        } else {
            if (sxCartService.selectByProductId(id) != null) {
                return CommonResult.success(sxCartService.update(id, num));
            }
            return CommonResult.success(sxCartService.insert(id, num));
        }
    }

    //根据用户的id查询购物车的列表
    @ApiOperation(value = "查询购物车", notes = "会自动从redis中获取用户的id")
    @GetMapping("findCartInfo")
    public CommonResult findCartInfoById() {
        return CommonResult.success(sxCartService.findCartInfoById());
    }

    @ApiOperation(value = "删除购物车", notes = "传入购物车id")
    @PostMapping("delete")
    public CommonResult deletedByCartId(Integer id) {
        return CommonResult.success(sxCartService.deletedByCartId(id));
    }

    @ApiOperation(value = "批量删除购物车", notes = "传入购物车的id的集合")
    @PostMapping("deletedMany")
    public CommonResult deleteMany(@RequestParam List list) {
        return CommonResult.success(sxCartService.deletedMany(list));
    }

    @ApiOperation(value = "库存检测", notes = "检测库存，传入商品id和数量，库存不足请停止后续操作")
    @PostMapping("checkNum")
    public CommonResult checkNum(Integer id, Integer num) {//商品id和加入的数量，也可以是商品id和购物车提交到订单的数量
        return CommonResult.success(sxCartService.checkNum(id, num));
    }


}
