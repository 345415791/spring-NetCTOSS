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
// * 持久层实现
// */
//@Repository("adminDAO")//持久层注解@Repository
//public class AdminDAOJdbcImpl2 implements AdminDAO{
//	
//	@Resource (name="ds")//依赖注入连接池,作用相当于BasicDataSource ds=new BasicDataSource();
//	//不写name,相当于直接按照DataSource类型注入
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
//			if(rs.next()) {//rs不为空,即有账号
//				admin=new Admin();
//				admin.setAdminId(rs.getInt("admin_id"));
//				admin.setAdminCode(rs.getString("admin_code"));
//				admin.setPassword(rs.getString("password"));
//				admin.setName(rs.getString("name"));
//				admin.setTelephone(rs.getString("telephone"));
//				admin.setEmail(rs.getString("email"));
//				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
//			return admin;//数据库查询出的账号信息
//			}
//		}catch (SQLException e) {
//			//记日志(保留现场)
//			e.printStackTrace();
//			/*
//			 * 看异常能否恢复,如果能够恢复,则立即恢复
//			 * 若不能恢复,如(发生系统异常,比如数据库停住服务),
//			 * 则提示用户稍后再试
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
