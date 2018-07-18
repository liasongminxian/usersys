package cn.edu.teachersystem.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class RewardAndPunishDTO {
	private String rid;
	private String teacher_id;
	private Double money;//[Money] [decimal](10, 2) NULL,
	private String reason;
	private String place;
	private Date times;	
	private String remark;
	private int eX;
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public int geteX() {
		return eX;
	}
	public void seteX(int eX) {
		this.eX = eX;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
