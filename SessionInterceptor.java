package com.wp.netctoss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 用于session验证的拦截器
 */
public class SessionInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest req, 
			HttpServletResponse res, Object handler)
			throws Exception {
	System.out.println("执行SI17preHandle()");
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("admin");
		if(obj==null) {//没有登录,重定向到登陆页面
			res.sendRedirect("toLogin.do");
			return false;
		}
		//已经登陆过,则允许访问
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
