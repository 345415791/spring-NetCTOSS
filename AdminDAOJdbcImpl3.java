//package com.wp.netctoss.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.wp.netctoss.entity.Admin;
//
///*
// * �־ò�ʵ��
// */
///**
// * ʹ��spring-jdbc������д	
// */
//@Repository("adminDAO")//�־ò�ע��@Repository
//public class AdminDAOJdbcImpl3 implements AdminDAO{
//	
//	@Resource (name="ds")//����ע�����ӳ�,�����൱��BasicDataSource ds=new BasicDataSource();
//	//��дname,�൱��ֱ�Ӱ���DataSource����ע��
//	private DataSource ds;
//	@Resource(name="jt")
//	private JdbcTemplate template;
////���ַ���,�����������ݿ�,ִ��sql���,�쳣����.����spring��װ����JdbcTemplate
//	public Admin findByAdminCode(String adminCode) {
//		Admin admin=null;
//		String sql="select * from Admin_info_wp where admin_code=?";
//		Object[] params=new Object[] {adminCode};
//		admin=template.queryForObject(sql,params,new EmpRowMapper());
//		return admin;//���ݿ��ѯ�����˺���Ϣ
//	}
//	class EmpRowMapper implements RowMapper<Admin>{
//		//rs:Ҫ����Ľ������ResultSet��
//		//index����ǰ���ڴ���ļ�¼���±꣬��0��ʼ
//		public Admin mapRow(ResultSet rs, int index) throws SQLException {
//			Admin admin=new Admin();
//			admin.setAdminId(rs.getInt("admin_id"));
//			admin.setAdminCode(rs.getString("admin_code"));
//			admin.setPassword(rs.getString("password"));
//			admin.setName(rs.getString("name"));
//			admin.setTelephone(rs.getString("telephone"));
//			admin.setEmail(rs.getString("email"));
//			admin.setEnrolldate(rs.getTimestamp("enrolldate"));
//			return admin;
//			}
//		}
//}