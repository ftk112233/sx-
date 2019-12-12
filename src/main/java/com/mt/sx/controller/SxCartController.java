package com.mt.sx.controller;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.service.SxCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cart")
public class SxCartController {
    @Resource
    private SxCartService sxCartService;

    //一次加入一个或者多个进入购物车
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
    @GetMapping("findCartInfo")
    public CommonResult findCartInfoById(Integer id) {
        return CommonResult.success(sxCartService.findCartInfoById(id));
    }

    @PostMapping("delete")
    public CommonResult deletedByCartId(Integer id) {
        return CommonResult.success(sxCartService.deletedByCartId(id));
    }

    @PostMapping("checkNum")
    public CommonResult checkNum(Integer id , Integer num){//商品id和加入的数量，也可以是商品id和购物车提交到订单的数量
        return CommonResult.success(sxCartService.checkNum(id,num));
    }

    @PostMapping("deletedMany")
    public CommonResult deleteMany(@RequestParam List list){
        return CommonResult.success(sxCartService.deletedMany(list));
    }
}
