package com.lingnan.usersys.common.dao;

import java.sql.Connection;

import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;
/**
 * dao����Ĺ���������
 * @author Administrator
 *
 */
public class DaoFactory {
	
	/**
	 * ����û�dao����Ĺ�������
	 * @param conn ���ݿ����Ӷ���
	 * @param type dao����
	 * @return dao �ӿ�
	 */
	public static BaseDao getDao(Connection conn,String type){
//		��������dao�������û�user����ʵ�����û�daoʵ����
		if("user".equals(type)){
//			����ʵ������dao����
          return new UserDaoImpl(conn);
		}
		
//		���û�к�����ָ������ƥ���ֵ������ʾ������Ϣ
		else{
			throw new ServiceException("dao������������");
		}
	}

}
