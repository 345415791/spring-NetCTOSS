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
//��ʾ��V+C
@Controller
public class LoginController {
	
	@Resource(name="LoginService")//ָ��ע��������ϵ
	private LoginService service;
	
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		System.out.println("ִ��toLogin()");
		return "login";//��ͼ��
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session,Exception ex) {
		System.out.println("lc26,ִ��login()");
		String adminCode=request.getParameter("adminCode");
		String pwd=request.getParameter("pwd");
		System.out.println(adminCode+","+pwd);
		//����ҵ������
		//checkLogin()����ҵ���,����ע���˳־ò�AdminDAO,������findByCode����
		Admin admin=service.checkLogin(adminCode, pwd);
		//��admin����󶨵�session������,����session��¼��֤
		session.setAttribute("admin", admin);
		return "redirect:toIndex.do";
	/*	
	  //����ҵ������
		try {
			//checkLogin()����ҵ���,����ע���˳־ò�AdminDAO,������findByCode����
			Admin admin=service.checkLogin(adminCode, pwd);
			
			//��admin����󶨵�session������,����session��¼��֤
			session.setAttribute("admin", admin);
		}catch (Exception e) {
			e.printStackTrace();
			if(e instanceof ApplicationException) {
				//Ӧ���쳣,Ӧ����ȷ��ʾ�û�,��ȡ��ȷ����(��ȷ���û���,����).
				request.setAttribute("login_failed", e.getMessage());
				return "login";	
			}
			//ϵͳ�쳣,��ʾ�û��Ժ�����
			return "error";
		}
		return "redirect:toIndex.do";
			*/
	};
	@ExceptionHandler//����һ�������쳣������,�����Զ���һЩ�߼�,��ת����Ϣ,��̬����
	//ex:ʹ�����������׳����쳣
	public String exHandle11(Exception ex,
			HttpServletRequest request ) {
		System.out.println("exHandle11()");
		//�����쳣���Ͳ�ͬ,�ֱ������Ӧ����
		if(ex instanceof ApplicationException) {
			//Ӧ���쳣
			request.setAttribute("login_failed", ex.getMessage());
			System.out.println("LC71�û���¼����");
			return "login";
		}
		else {
			//ϵͳ�쳣,��ʾ�û��Ժ�����
			System.out.println("LC77ϵͳ����");
			return "error";
		}
	}
	
	public String login() {
		System.out.println("ִ��login()");
		return "redirect:toIndex.do";//�ض���
	}
	@RequestMapping("/toIndex.do")
	public String toIndex() {
		System.out.println("ִ��toIndex()");
		return "index";
	}
	
	
	@Resource(name="costDAO")//ָ��ע��������ϵ
	private CostDAO costdao;
	
	@RequestMapping("/findCost.do")
	public String finnCost11111(HttpServletRequest request) {
		//HttpServletRequest request = null;����
		List<Cost> list=costdao.findAll();
		request.setAttribute("costs", list);
		System.out.println("lc70"+list);
		return "find";
		//return "redirect:costList.do";
	}
//	@RequestMapping("/costList.do")
//	public String costList() {
//		System.out.println("lc74ִ��costList()");
//		return "find";
//	}
}