package com.wp.netctoss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * ����session��֤��������
 */
public class SessionInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest req, 
			HttpServletResponse res, Object handler)
			throws Exception {
	System.out.println("ִ��SI17preHandle()");
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("admin");
		if(obj==null) {//û�е�¼,�ض��򵽵�½ҳ��
			res.sendRedirect("toLogin.do");
			return false;
		}
		//�Ѿ���½��,���������
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	
}
