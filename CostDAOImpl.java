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
 * �־ò�ʵ��
 */
@Repository("costDAO")//�־ò�ע��@Repository
public class CostDAOImpl implements CostDAO{
	@Resource (name="ds")//����ע�����ӳ�,�����൱��BasicDataSource ds=new BasicDataSource();
	//��дname,�൱��ֱ�Ӱ���DataSource����ע��
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
			//rs����ʱ�������,���������ӹرն����,����Ҫ��ʱȡ��!!!
			List<Cost> list=new ArrayList<Cost>();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
			
		}catch (SQLException e) {
			//����־(�����ֳ�)
			e.printStackTrace();
			/*
			 * ���쳣�ܷ�ָ�,����ܹ��ָ�,�������ָ�
			 * �����ָܻ�,��(����ϵͳ�쳣,�������ݿ�ͣס����),
			 * ����ʾ�û��Ժ�����
			 */
			throw new RuntimeException("��ѯ�ʷ�ʧ��",e);
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
	 * ALT+Shift+m����������ݼ�
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
