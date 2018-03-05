package com.wp.netctoss.service;
//ҵ���
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wp.netctoss.dao.AdminDAO;
import com.wp.netctoss.entity.Admin;
import com.wp.netctoss.service.ApplicationException;
@Service("LoginService")//ҵ���ע��
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="adminDAO")
	private AdminDAO dao;
	
	public Admin checkLogin(String adminCode, String pwd) {//��ʾ���û�������˻�����
		Admin admin=null;
		admin=dao.findByAdminCode(adminCode);
		if(admin==null) {
			//�˺Ų�����
			//�׳�һ��Ӧ���쳣,�û�����������쳣
			throw new ApplicationException("�˺Ų�����");
		}
		if(!admin.getPassword().equals(pwd)) {
			//�������
			throw new ApplicationException("�������");
		}
		//��¼�ɹ�
		return admin;//���ݿ��ѯ�����˺���Ϣ
	}

}
