package com.lingnan.usersys.usermgr.domain;

import java.sql.Date;
/**
 * 用户信息类
 * @author Administrator
 *
 */

public class UserVo {
	
	
	   private int id;          //主键编号
	   private String name;     //用户名
	   private String pass;     //密码
	   private int superuser;   //用户权限
	   private String mail;     //邮箱
	   private Date birth;      //生日日期
	   private int status;      //状态
	   
	   /**
	    * 取得主键编号
	    * @return 主键编号
	    */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置主键编号
	 * @param id 主键编号
	 */
	public void setId(int id) {
		this.id = id;
	}
	

	
	/**
	 * 取得用户名
	 * @return 用户名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置用户名
	 * @param name 用户名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 取得密码
	 * @return 密码
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * 设置密码
	 * @param pass 密码
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * 取得权限
	 * @return 权限
	 */
	public int getSuperuser() {
		return superuser;
	}
	/**
	 * 设置权限
	 * @param superuser 权限
	 */
	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	
	/**
	 * 取得邮箱
	 * @return 邮箱
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * 设置邮箱
	 * @param mail 邮箱
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * 取得生日日期
	 * @return 生日日期
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * 设置生日日期
	 * @param birth 生日日期
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * 取得用户状态
	 * @return 用户状态
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * 设置用户状态
	 * @param status 用户状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	


}
