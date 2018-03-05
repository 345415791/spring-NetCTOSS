package com.wp.netctoss.dao;

import org.springframework.stereotype.Repository;

import com.wp.netctoss.annotations.MyBatisRepository;
import com.wp.netctoss.entity.Admin;


/**
 * ³Ö¾Ã²ã½Ó¿Ú
 */

@MyBatisRepository

@Repository("adDAO")
public interface AdminDAO {
	
	public Admin findByAdminCode(String AdminCode);
	public void delete(int id);
}
