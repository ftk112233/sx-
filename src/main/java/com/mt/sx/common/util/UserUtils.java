package com.mt.sx.common.util;

import com.mt.sx.common.base.UserActive;
import com.mt.sx.pojo.SxUser;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserUtils {

    /**
     * 获取redis中的user roles permission
     *
     * @return
     */
    public static UserActive getUserActice(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        return (UserActive)SpringContextService.getBean(RedisUtil.class).get(token);
    }

    /**
     * 获取redis中的用户
     * @return
     */
    public  static SxUser getUser(){
        return getUserActice().getUser();
    }


}
