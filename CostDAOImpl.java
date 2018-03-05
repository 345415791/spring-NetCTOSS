package com.wp.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.wp.netctoss.entity.Cost;
/*
 * 持久层实现
 */
@Repository("costDAO")//持久层注解@Repository
public class CostDAOImpl implements CostDAO{
	@Resource (name="ds")//依赖注入连接池,作用相当于BasicDataSource ds=new BasicDataSource();
	//不写name,相当于直接按照DataSource类型注入
	private DataSource ds;
	
	public List<Cost> findAll() {
		Cost cost=null;
		Connection conn=null;
		try {
			conn=ds.getConnection();
			String sql="select * from cost_wp"
					+ " order by cost_id";
			Statement smt=conn.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			//rs里临时存放数据,会随着连接关闭而清空,多以要及时取出!!!
			List<Cost> list=new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
			
		}catch (SQLException e) {
			//记日志(保留现场)
			e.printStackTrace();
			/*
			 * 看异常能否恢复,如果能够恢复,则立即恢复
			 * 若不能恢复,如(发生系统异常,比如数据库停住服务),
			 * 则提示用户稍后再试
			 */
			throw new RuntimeException("查询资费失败",e);
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					throw new RuntimeException (e);
				}
			}
		}
	
	}
	/**
	 * 
	 * ALT+Shift+m提炼方法快捷键
	 *
	 */	
		private Cost createCost(ResultSet rs) throws SQLException {
			Cost c=new Cost();
			c.setCostId(rs.getInt("cost_id"));
			c.setName(rs.getString("name"));
			c.setBaseDuration(rs.getInt("base_duration"));
			c.setBaseCost(rs.getDouble("base_cost"));
			c.setUnitCost(rs.getDouble("unit_cost"));
			c.setDescr(rs.getString("descr"));
			c.setCreatime(rs.getTimestamp("creatime"));
			c.setStartime(rs.getTimestamp("startime"));
			c.setCostType(rs.getString("cost_type"));
			return c;
		}
}
