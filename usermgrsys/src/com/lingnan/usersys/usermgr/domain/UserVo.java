package com.lingnan.usersys.usermgr.domain;

import java.sql.Date;
/**
 * �û���Ϣ��
 * @author Administrator
 *
 */

public class UserVo {
	
	
	   private int id;          //�������
	   private String name;     //�û���
	   private String pass;     //����
	   private int superuser;   //�û�Ȩ��
	   private String mail;     //����
	   private Date birth;      //��������
	   private int status;      //״̬
	   
	   /**
	    * ȡ���������
	    * @return �������
	    */
	public int getId() {
		return id;
	}
	
	/**
	 * �����������
	 * @param id �������
	 */
	public void setId(int id) {
		this.id = id;
	}
	

	
	/**
	 * ȡ���û���
	 * @return �û���
	 */
	public String getName() {
		return name;
	}
	/**
	 * �����û���
	 * @param name �û���
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ȡ������
	 * @return ����
	 */
	public String getPass() {
		return pass;
	}
	
	/**
	 * ��������
	 * @param pass ����
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * ȡ��Ȩ��
	 * @return Ȩ��
	 */
	public int getSuperuser() {
		return superuser;
	}
	/**
	 * ����Ȩ��
	 * @param superuser Ȩ��
	 */
	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	
	/**
	 * ȡ������
	 * @return ����
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * ��������
	 * @param mail ����
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * ȡ����������
	 * @return ��������
	 */
	public Date getBirth() {
		return birth;
	}
	/**
	 * ������������
	 * @param birth ��������
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	/**
	 * ȡ���û�״̬
	 * @return �û�״̬
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * �����û�״̬
	 * @param status �û�״̬
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	


}
