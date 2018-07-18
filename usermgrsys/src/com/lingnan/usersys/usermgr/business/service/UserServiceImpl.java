package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;

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

}
