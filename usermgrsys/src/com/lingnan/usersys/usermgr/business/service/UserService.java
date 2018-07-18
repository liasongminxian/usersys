package com.lingnan.usersys.usermgr.business.service;

import com.lingnan.usersys.usermgr.domain.UserVo;

public interface UserService {

	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录的用户信息
	 */
	public UserVo login(String name,String password);
	
	public boolean register(UserVo newuser);
	
	public UserVo findById(int id);
	
	public boolean delete(int id);
	
}
