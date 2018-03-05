package com.wp.netctoss.service;

import com.wp.netctoss.entity.Admin;
/**
 * 业务层接口
 */
public interface LoginService {
	public Admin checkLogin(String adminCode,String pwd);
	//测试直接输入程序账号密码,实际操作由视图层表单提交用户密码
	
	
}
