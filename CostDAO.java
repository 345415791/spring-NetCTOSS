package com.wp.netctoss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wp.netctoss.entity.Cost;
/*
 * �־ò�ʵ��
 */

public interface CostDAO {
	List<Cost> findAll() ;
	
}
