package com.wp.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wp.netctoss.entity.Admin;

/*
 * 持久层实现
 */
/**
 * 使用mybatis-spring 进行重写	
 */
@Repository("adminDAO")//持久层注解@Repository
public class AdminDAOJdbcImpl implements AdminDAO{
	private ApplicationContext ac;
	private AdminDAO dao;
//	@Resource (name="ds")//依赖注入连接池,作用相当于BasicDataSource ds=new BasicDataSource();
//	//不写name,相当于直接按照DataSource类型注入
//	private DataSource ds;
	
	public Admin findByAdminCode(String adminCode) {
		
		//启动spring容器
		ac=new ClassPathXmlApplicationContext("springmvc.xml");
//			 ds=ac.getBean("ds",DataSource.class);
			dao=ac.getBean("aDAO",AdminDAO.class);
			
		Admin	admin=dao.findByAdminCode(adminCode);
			System.out.println(admin);
			return admin;

	}

//	@Resource (name="ds")//依赖注入连接池,作用相当于BasicDataSource ds=new BasicDataSource();
//	//不写name,相当于直接按照DataSource类型注入
//	private DataSource ds;
//	@Resource(name="jt")
//	private JdbcTemplate template;
////这种方法,少了连接数据库,执行sql语句,异常处理.都被spring封装好了JdbcTemplate
//	public Admin findByAdminCode(String adminCode) {
//		Admin admin=null;
//		System.out.println("ADImpl57执行的findBy");
//		String sql="select * from Admin_info_wp where admin_code=?";
//		Object[] params=new Object[] {adminCode};
//		admin=template.queryForObject(sql,params,new EmpRowMapper());
//		return admin;//数据库查询出的账号信息
//	}
//	class EmpRowMapper implements RowMapper<Admin>{
//		//rs:要处理的结果集（ResultSet）
//		//index：当前正在处理的记录的下标，从0开始
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
	public Admin findByAdminCode1(String AdminCode) {
		// TODO Auto-generated method stub
		return null;
	}
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	

}