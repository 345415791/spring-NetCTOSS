package com.wp.netctoss.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * jdbc数据库中使用java.sql包下的日期类型:
 * java.sql.Date 年月日
 * java.sql.Time 时分秒
 * java.sql.TimeStamp 年月日时分秒
 * 他们都是java.util.Date的子类
 */
//创建实体类Cost,要满足javaBean规范:
//1.有包 2.实现序列化接口 3.有对应get/set方法 4.有默认构造器Cost(){};
public class Cost implements Serializable {
	//主键ID
	private Integer costId;
	//资费名
	private String name;
	//基本费用
	private double baseCost;
	//基本时长
	private int baseDuration;
	//单位费用
	private double unitCost;
	//状态,0-开通,1-启用
	private String status;
	//描述
	private String descr;
	//创建时间
	private Timestamp creatime;
	//开通时间
	private Timestamp startime;
	//资费类型,1-包月;2-套餐;3-计时;
	private String costType;

	public double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(int i) {
		this.baseDuration = i;
	}
	public double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Timestamp getCreatime() {
		return creatime;
	}
	public void setCreatime(Timestamp creattime) {
		this.creatime = creattime;
	}
	public Timestamp getStartime() {
		return startime;
	}
	public void setStartime(Timestamp startime) {
		this.startime = startime;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	@Override
	public String toString() {
		return "Cost [costId=" + costId + ", name=" + name + ", baseCost=" + baseCost + ", baseDuration=" + baseDuration
				+ ", unitCost=" + unitCost + ", status=" + status + ", descr=" + descr + ", creatime=" + creatime
				+ ", startime=" + startime + ", costType=" + costType + "]";
	}
}
