package com.mt.sx.common.util;

import com.mt.sx.pojo.SxBusiness;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WebUtils {
	/**
	 * 模拟用户已经登录并把信息存在session
	 */

	static {
		SxBusiness business=new SxBusiness();
		business.setName("张三");
		business.setPassword("123456");
		WebUtils.getSession().setAttribute("user",business);
	}
	
	
	/**
	 * 得到requset
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) 
				RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;
	}
	
	/**
	 * 得到session
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}

}
