package com.wp.netctoss.service;

import com.wp.netctoss.entity.Admin;
/**
 * ҵ���ӿ�
 */
public interface LoginService {
	public Admin checkLogin(String adminCode,String pwd);
	//����ֱ����������˺�����,ʵ�ʲ�������ͼ����ύ�û�����
	
	
}
