package com.lingnan.usersys.usermgr.business.dao;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVo;

public interface UserDao extends BaseDao{
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录的用户信息
	 */
	public UserVo login(String name,String password);
	
	public boolean register(UserVo newuser);
	
	public UserVo findById(int id);

}
