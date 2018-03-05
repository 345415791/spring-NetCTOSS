package com.wp.netctoss.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wp.netctoss.dao.CostDAO;
import com.wp.netctoss.entity.Admin;
import com.wp.netctoss.entity.Cost;
import com.wp.netctoss.service.ApplicationException;
import com.wp.netctoss.service.LoginService;
//表示层V+C
@Controller
public class LoginController {
	
	@Resource(name="LoginService")//指定注入依赖关系
	private LoginService service;
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("执行toLogin()");
		return "login";//视图名
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session,Exception ex) {
		System.out.println("lc26,执行login()");
		String adminCode=request.getParameter("adminCode");
		String pwd=request.getParameter("pwd");
		System.out.println(adminCode+","+pwd);
		//调用业务层服务
		//checkLogin()属于业务层,里面注入了持久层AdminDAO,调用了findByCode方法
		Admin admin=service.checkLogin(adminCode, pwd);
		//把admin对象绑定到session对象中,用于session登录验证
		session.setAttribute("admin", admin);
		return "redirect:toIndex.do";
	/*	
	  //调用业务层服务
		try {
			//checkLogin()属于业务层,里面注入了持久层AdminDAO,调用了findByCode方法
			Admin admin=service.checkLogin(adminCode, pwd);
			
			//把admin对象绑定到session对象中,用于session登录验证
			session.setAttribute("admin", admin);
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException) {
				//应用异常,应该明确提示用户,采取正确操作(正确的用户名,密码).
				request.setAttribute("login_failed", e.getMessage());
				return "login";	
			}
			//系统异常,提示用户稍后重试
			return "error";
		}
		return "redirect:toIndex.do";
			*/
	};
	@ExceptionHandler//这是一个复杂异常处理方法,可以自定义一些逻辑,如转发消息,动态加载
	//ex:使其他方法所抛出的异常
	public String exHandle11(Exception ex,
			HttpServletRequest request ) {
		System.out.println("exHandle11()");
		//依据异常类型不同,分别进行相应处理
		if(ex instanceof ApplicationException) {
			//应用异常
			request.setAttribute("login_failed", ex.getMessage());
			System.out.println("LC71用户登录错误");
			return "login";
		}
		else {
			//系统异常,提示用户稍后重试
			System.out.println("LC77系统错误");
			return "error";
		}
	}
	
	public String login() {
		System.out.println("执行login()");
		return "redirect:toIndex.do";//重定向
	}
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		System.out.println("执行toIndex()");
		return "index";
	}
	
	
	@Resource(name="costDAO")//指定注入依赖关系
	private CostDAO costdao;
	
	@RequestMapping("/findCost.do")
	public String finnCost11111(HttpServletRequest request) {
		//HttpServletRequest request = null;不行
		List<Cost> list=costdao.findAll();
		request.setAttribute("costs", list);
		System.out.println("lc70"+list);
		return "find";
		//return "redirect:costList.do";
	}
//	@RequestMapping("/costList.do")
//	public String costList() {
//		System.out.println("lc74执行costList()");
//		return "find";
//	}
}