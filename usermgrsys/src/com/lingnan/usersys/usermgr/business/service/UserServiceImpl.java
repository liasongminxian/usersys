package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.usersys.common.constant.EnumType;
import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.domain.UserVo;

public class UserServiceImpl implements UserService{
	/**
	 * 用户service类实例
	 */
	
	private static UserService userService=new UserServiceImpl();
	
	/**
	 * 私有构造方法
	 */
	private UserServiceImpl(){
		
	}
	
	/**
	 * 取得用户service实例
	 * @return 实例对象
	 */
	
	public static UserService getInstance(){
		return userService;
	}

	
	/**
	 *用户登录
	 *@param name 用户名
	 *@param password 密码
	 *@return 用户信息
	 */
	public UserVo login(String name, String password) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVo user=null;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			user=userMgrDao.login(name, password);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service层用户登录错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	/**
	 * 用户注册
	 * @param newuser 新注册的用户信息
	 * @return 布尔值
	 */
	public boolean register(UserVo newuser) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVo user=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.register(newuser);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户注册错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	/**
	 * 按ID查询I_USER表
	 * @param id 要查询的ID号
	 * @return 查询到的用户信息
	 */
	public UserVo findById(int id) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		UserVo user=null;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			user=userMgrDao.findById(id);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service层findById用户查询错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	/**
	 * 按ID删除用户信息（软删除）
	 * @param id 要删除的ID号
	 * @return 布尔值
	 */
	public boolean delete(int id) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.delete(id);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户删除错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	/**
	 * 按ID更新密码
	 * @param id 要更新密码的ID号
	 * @param password 新密码
	 * @return 布尔值
	 */
	public boolean updatePassword(int id, String password) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.updatePassword(id, password);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户修改密码错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
		
	}

	@Override
	/**
	 * 按ID更新邮箱
	 * @param id 要更新邮箱的ID号
	 * @param mail 新邮箱
	 * @return 布尔值
	 */
	public boolean updateMail(int id, String mail) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.updateMail(id, mail);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户修改邮箱错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	/**
	 * 查询所有信息
	 * @return 所有用户的信息
	 */
	public List<UserVo> findAll() {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		List<UserVo> alluser=new ArrayList<UserVo>();
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			alluser=userMgrDao.findAll();
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service层查询所有用户错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return alluser;
	}

	@Override
	/**
	 * 按ID更新用户名
	 * @param id 要更新用户名的ID号
	 * @param name 新用户名
	 * @return 布尔值
	 */
	public boolean updateName(int id, String name) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.updateName(id, name);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户修改用户名错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	/**
	 * 按ID更新生日日期
	 * @param id 要更新生日日期的ID号
	 * @param birth 新生日日期
	 * @return 布尔值
	 */
	public boolean updateBirth(int id, Date birth) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.updateBirth(id, birth);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户修改生日错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	/**
	 * 按用户名查找（模糊查询）
	 * @param name 要查找的用户名字段
	 * @return 含有相关字段的用户信息
	 */
	public List<UserVo> findByName(String name) {
		Connection conn=null;
		UserVo user=null;
		List<UserVo> allname=new ArrayList<UserVo>();
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			allname=userMgrDao.findByName(name);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service层findByName用户查询错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return allname;
	}

	@Override
	/**
	 * 查询所有信息
	 * @return 所有用户的信息
	 */
	public List<UserVo> findByPage(int pageNo, int pageSize) {
		Connection conn=null;
		UserVo user=null;
		List<UserVo> allpage=new ArrayList<UserVo>();
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			allpage=userMgrDao.findByPage(pageNo, pageSize);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service层findByPage用户查询错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return allpage;
	}

	@Override
	/**
	 * 按ID更新权限
	 * @param id 要更新权限的ID号
	 * @return 布尔值
	 */
	public boolean updateSuperUser(int id) {
//		声明数据库连接对象，用于保存数据库连接对象
		Connection conn=null;
		boolean flag=false;
		try{
//			调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			DBUtils.beginTransaction(conn);
			flag=userMgrDao.updateSuperUser(id);
			DBUtils.commit(conn);
			
		} catch(DaoException e){
			DBUtils.rollback(conn);
			throw e;
		} catch(Exception e){
			DBUtils.rollback(conn);
			throw new ServiceException("service层用户修改权限错误",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

}
