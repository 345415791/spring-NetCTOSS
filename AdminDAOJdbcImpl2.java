//package com.wp.netctoss.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.stereotype.Repository;
//
//import com.wp.netctoss.entity.Admin;
///*
// * �־ò�ʵ��
// */
//@Repository("adminDAO")//�־ò�ע��@Repository
//public class AdminDAOJdbcImpl2 implements AdminDAO{
//	
//	@Resource (name="ds")//����ע�����ӳ�,�����൱��BasicDataSource ds=new BasicDataSource();
//	//��дname,�൱��ֱ�Ӱ���DataSource����ע��
//	private DataSource ds;
//	
//	public Admin findByAdminCode(String adminCode) {
//		Admin admin=null;
//		Connection conn=null;
//		try {
//			conn=ds.getConnection();
//			String sql="select * from Admin_info_wp where admin_code=?";
//			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setString(1, adminCode);
//			ResultSet rs=ps.executeQuery();
//			if(rs.next()) {//rs��Ϊ��,�����˺�
//				admin=new Admin();
//				admin.setAdminId(rs.getInt("admin_id"));
//				admin.setAdminCode(rs.getString("admin_code"));
//				admin.setPassword(rs.getString("password"));
//				admin.setName(rs.getString("name"));
//				admin.setTelephone(rs.getString("telephone"));
//				admin.setEmail(rs.getString("email"));
//				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
//			return admin;//���ݿ��ѯ�����˺���Ϣ
//			}
//		}catch (SQLException e) {
//			//����־(�����ֳ�)
//			e.printStackTrace();
//			/*
//			 * ���쳣�ܷ�ָ�,����ܹ��ָ�,�������ָ�
//			 * �����ָܻ�,��(����ϵͳ�쳣,�������ݿ�ͣס����),
//			 * ����ʾ�û��Ժ�����
//			 */
//			throw new RuntimeException(e);
//		}finally {
//			if(conn!=null) {
//				try {
//					conn.close();
//				}catch(SQLException e){
//					e.printStackTrace();
//					throw new RuntimeException (e);
//				}
//			}
//		}	
//		return admin;
//		
//	}
//}
