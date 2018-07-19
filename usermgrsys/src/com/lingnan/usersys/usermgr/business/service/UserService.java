package com.lingnan.usersys.usermgr.business.service;

import java.sql.Date;
import java.util.List;

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
	
	public boolean updatePassword(int id,String password);
	
	public boolean updateMail(int id,String mail);
	
	public boolean updateName(int id,String name);
	
	public boolean updateBirth(int id,Date birth);
	
	public boolean updateSuperUser(int id);
	
	public List<UserVo> findByName(String name);
	
	public List<UserVo> findByPage(int pageNo,int pageSize);
	
	public List<UserVo> findAll();
	
}
