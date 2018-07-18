package com.lingnan.usersys.usermgr.business.service;

import com.lingnan.usersys.usermgr.domain.UserVo;

public interface UserService {

	/**
	 * �û���¼
	 * @param name �û���
	 * @param password ����
	 * @return ��¼���û���Ϣ
	 */
	public UserVo login(String name,String password);
	
	public boolean register(UserVo newuser);
	
	public UserVo findById(int id);
	
	public boolean delete(int id);
	
}
