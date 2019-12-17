package com.mt.sx.common.shiro;

import cn.hutool.core.util.StrUtil;

import com.alibaba.fastjson.JSON;
import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.common.util.RedisUtil;
import com.mt.sx.common.util.SpringContextService;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 自定义shiro过滤器
 */

public class MyFilter extends BasicHttpAuthenticationFilter {

    public RedisUtil getRedisUtil() {
        return SpringContextService.getBean(RedisUtil.class);
    }


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        // 获取token
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String token = httpServletRequest.getHeader("token");
        if(StrUtil.isBlank(token)) {
            responseError(response,"请先登陆");
            return false;
        }

        // 判断缓存中是否有token
        RedisUtil redisUtil = getRedisUtil();
        boolean isLogin = redisUtil.hasKey(token);
        if(!isLogin) {
            responseError(response, "登陆过期，请重新登陆");
            return false;
        }

        // 刷新过期时间
        redisUtil.expire("token:" + token, 3600);
        return true;
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    private void responseError(ServletResponse response, String msg) {
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=UTF-8");
            writer = response.getWriter();
            writer.print(JSON.toJSONString(CommonResult.fail(ResponseCode.UNLOGIN.getCode(), ResponseCode.UNLOGIN.getMsg())));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
