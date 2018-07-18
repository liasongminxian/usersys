package cn.edu.teachersystem.dto;
import java.sql.Date;
public class SalaryDTO {
	private String salary_id;
	private String teacher_id;
	private Double salary_basic;//[Salary_basic] [decimal](10, 2) NULL,
	private Double walfare;//[Walfare] [decimal](10, 2) NULL,
	private Double rewardAndPunish_count;//[RewardAndPunish_count] [decimal](10, 2) NULL,
	private Double salary_real;//[Salary_real] [decimal](10, 2) NULL,
	private Date issueDate;
	private int eX;
	public int geteX() {
		return eX;
	}
	public void seteX(int eX) {
		this.eX = eX;
	}
	public String getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(String salary_id) {
		this.salary_id = salary_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	
	
	public Double getSalary_basic() {
		return salary_basic;
	}
	public void setSalary_basic(Double salary_basic) {
		this.salary_basic = salary_basic;
	}
	public Double getWalfare() {
		return walfare;
	}
	public void setWalfare(Double walfare) {
		this.walfare = walfare;
	}
	public Double getRewardAndPunish_count() {
		return rewardAndPunish_count;
	}
	public void setRewardAndPunish_count(Double rewardAndPunish_count) {
		this.rewardAndPunish_count = rewardAndPunish_count;
	}
	public Double getSalary_real() {
		return salary_real;
	}
	public void setSalary_real(Double salary_real) {
		this.salary_real = salary_real;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


}
