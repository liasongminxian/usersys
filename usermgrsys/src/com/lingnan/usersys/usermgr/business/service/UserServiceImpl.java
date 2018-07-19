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

	@Override
	public boolean delete(int id) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û�ɾ������",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	public boolean updatePassword(int id, String password) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û��޸��������",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
		
	}

	@Override
	public boolean updateMail(int id, String mail) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û��޸��������",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	public List<UserVo> findAll() {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		List<UserVo> alluser=new ArrayList<UserVo>();
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			alluser=userMgrDao.findAll();
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service���ѯ�����û�����",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return alluser;
	}

	@Override
	public boolean updateName(int id, String name) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û��޸��û�������",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	public boolean updateBirth(int id, Date birth) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û��޸����մ���",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

	@Override
	public List<UserVo> findByName(String name) {
		Connection conn=null;
		UserVo user=null;
		List<UserVo> allname=new ArrayList<UserVo>();
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			allname=userMgrDao.findByName(name);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service��findByName�û���ѯ����",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return allname;
	}

	@Override
	public List<UserVo> findByPage(int pageNo, int pageSize) {
		Connection conn=null;
		UserVo user=null;
		List<UserVo> allpage=new ArrayList<UserVo>();
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
			conn=DBUtils.getConnection();
			UserDao userMgrDao=(UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			allpage=userMgrDao.findByPage(pageNo, pageSize);
			
		} catch(DaoException e){
			throw e;
		} catch(Exception e){
			throw new ServiceException("service��findByPage�û���ѯ����",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return allpage;
	}

	@Override
	public boolean updateSuperUser(int id) {
//		�������ݿ����Ӷ������ڱ������ݿ����Ӷ���
		Connection conn=null;
		boolean flag=false;
		try{
//			�������ݿ⹤�����getConnection������ȡ�����ݿ����Ӷ��󣬲���ֵ�����ݿ����Ӷ������
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
			throw new ServiceException("service���û��޸�Ȩ�޴���",e);
		} finally{
			DBUtils.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
		return flag;
	}

}
