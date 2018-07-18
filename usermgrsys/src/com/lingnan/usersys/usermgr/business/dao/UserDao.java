package com.lingnan.usersys.usermgr.business.dao;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVo;

public interface UserDao extends BaseDao{
	/**
	 * �û���¼
	 * @param name �û���
	 * @param password ����
	 * @return ��¼���û���Ϣ
	 */
	public UserVo login(String name,String password);
	
	public boolean register(UserVo newuser);
	
	public UserVo findById(int id);

}
