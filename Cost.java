package com.wp.netctoss.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * jdbc���ݿ���ʹ��java.sql���µ���������:
 * java.sql.Date ������
 * java.sql.Time ʱ����
 * java.sql.TimeStamp ������ʱ����
 * ���Ƕ���java.util.Date������
 */
//����ʵ����Cost,Ҫ����javaBean�淶:
//1.�а� 2.ʵ�����л��ӿ� 3.�ж�Ӧget/set���� 4.��Ĭ�Ϲ�����Cost(){};
public class Cost implements Serializable {
	//����ID
	private Integer costId;
	//�ʷ���
	private String name;
	//��������
	private double baseCost;
	//����ʱ��
	private int baseDuration;
	//��λ����
	private double unitCost;
	//״̬,0-��ͨ,1-����
	private String status;
	//����
	private String descr;
	//����ʱ��
	private Timestamp creatime;
	//��ͨʱ��
	private Timestamp startime;
	//�ʷ�����,1-����;2-�ײ�;3-��ʱ;
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
