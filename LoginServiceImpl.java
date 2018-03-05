package com.wp.netctoss.service;
//业务层
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wp.netctoss.dao.AdminDAO;
import com.wp.netctoss.entity.Admin;
import com.wp.netctoss.service.ApplicationException;
@Service("LoginService")//业务层注解
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO dao;
	
	public Admin checkLogin(String adminCode, String pwd) {//表示层用户输入的账户密码
		Admin admin=null;
		admin=dao.findByAdminCode(adminCode);
		if(admin==null) {
			//账号不存在
			//抛出一个应用异常,用户操作引起的异常
			throw new ApplicationException("账号不存在");
		}
		if(!admin.getPassword().equals(pwd)) {
			//密码错误
			throw new ApplicationException("密码错误");
		}
		//登录成功
		return admin;//数据库查询出的账号信息
	}

}
