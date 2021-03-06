package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.base.UserActive;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.common.util.JwtUtils;
import com.mt.sx.common.util.RedisUtil;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.service.SxBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户登陆管理接口")
@RestController
public class LoginController {
    @Autowired
    SxBusinessService sxBusinessService;
    @Autowired
    RedisUtil redisUtil;

    private final Long VALID_TIME = 20 * 60 * 1000L;

    @ApiOperation("用户登陆功能")
    @PostMapping("/login")
    public CommonResult login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        //创建用户名,密码身份验证 Token
        UsernamePasswordToken info = new UsernamePasswordToken(username, password);
        try {
            //登录， 即身份验证
            subject.login(info);
            UserActive userActive = (UserActive) subject.getPrincipal();
            SxUser user = userActive.getUser();
            String token = JwtUtils.createToken(user);
            redisUtil.set(token, userActive, VALID_TIME);
            return CommonResult.success("登录成功", token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //身份认证失败 
            return CommonResult.fail(ResponseCode.VALIDATE_FALSE);
        } catch (Exception e) {
            return CommonResult.fail(ResponseCode.FAILED);
        }

    }
    @ApiOperation("用户退出")
    @GetMapping("/logout")
    public CommonResult logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        redisUtil.del(token);
        return CommonResult.success(ResponseCode.LOGOUT);
    }


}
