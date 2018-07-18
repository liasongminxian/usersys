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
	 * �û�service��ʵ��
	 */
	
	private static UserService userService=new UserServiceImpl();
	
	/**
	 * ˽�й��췽��
	 */
	private UserServiceImpl(){
		
	}
	
	/**
	 * ȡ���û�serviceʵ��
	 * @return ʵ������
	 */
	
	public static UserService getInstance(){
		return userService;
	}

	
	/**
	 *�û���¼
	 *@param name �û���
	 *@param password ����
	 *@return �û���Ϣ
	 */
	public UserVo login(String name, String password) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		UserVo user=null;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			user=userMgrDao.login(name, password);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service���û���¼����",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public boolean register(UserVo newuser) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		UserVo user=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û�ע�����",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	public UserVo findById(int id) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		UserVo user=null;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			user=userMgrDao.findById(id);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service��findById�û���ѯ����",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return user;
	}

}
