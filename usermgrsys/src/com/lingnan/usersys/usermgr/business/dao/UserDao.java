package com.lingnan.usersys.usermgr.business.dao;



import java.sql.Date;
import java.util.List;

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
	
	public boolean delete(int id);
	
	public boolean updatePassword(int id,String password);
	
	public boolean updateMail(int id,String mail);
	
	public boolean updateName(int id,String name);
	
	public boolean updateSuperUser(int id);
	
	public boolean updateBirth(int id,Date birth);
	
	public List<UserVo> findByName(String name);
	
	public List<UserVo> findByPage(int pageNo,int pageSize);
	
	public List<UserVo> findAll();
	
	

}
