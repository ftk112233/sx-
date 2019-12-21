package com.mt.sx.common.exception;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@RestControllerAdvice
public class MyExceptionHandler {
    /**
     * 捕获没有权限的异常
     * @param request
     * @param response
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = AuthorizationException.class)//指定拦截的异常
    public CommonResult errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        System.out.println(request.getRequestURL()+"此接口你无权访问");
        e.printStackTrace();
       return CommonResult.fail(403,"你无权访问");
    }

    @ExceptionHandler(value = GlobalException.class)//指定拦截的异常
    public CommonResult GrobleHandler(GlobalException e) throws Exception {

        return CommonResult.fail(e.getCode(),e.getMessage());
    }
}
