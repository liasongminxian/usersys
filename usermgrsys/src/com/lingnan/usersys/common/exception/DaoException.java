package com.lingnan.usersys.common.exception;
/**
 * �����ݿ���쳣��װ���Զ����쳣�����д���
 * @author Administrator
 *
 */
public class DaoException extends RuntimeException{
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	 public DaoException() {
	       
	    }
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  */
	 
	 public DaoException(String arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �����쳣��ԭ��
	  */
	 public DaoException(Throwable arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  * @param arg1 �����쳣��ԭ��
	  */
	 
	 public DaoException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	    }

}
