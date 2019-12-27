package com.mt.sx.controller;

        import com.mt.sx.common.base.CommonResult;
        import com.mt.sx.pojo.SxBusiness;
        import com.mt.sx.pojo.SxPassby;
        import com.mt.sx.service.SxpassbyService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passBy")
public class SxpassByController {
    @Autowired
SxpassbyService sxpassbyService;

    @GetMapping("/findByBusId")//根据店家id或者管理员不需要传参数直接查询
    public CommonResult findByBusId(){
        return  CommonResult.success(sxpassbyService.findByBusId());
    }
    @PostMapping("/insert")
    public CommonResult insert(SxPassby sxPassby){
        return CommonResult.success(sxpassbyService.insert(sxPassby));
    }

    @PostMapping("/update")
    public CommonResult update(SxPassby sxPassby){
        return CommonResult.success(sxpassbyService.update(sxPassby));
    }

    @PostMapping("/deleted")
    public CommonResult deleted(SxPassby sxPassby){
        return CommonResult.success(sxpassbyService.update(sxPassby));
    }

}
