package com.lingnan.usersys.common.exception;
/**
 * ��ҵ����쳣��װ���Զ����쳣�����д���
 * @author Administrator
 *
 */
public class ServiceException extends RuntimeException{
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	 public ServiceException() {
	       
	    }
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  */
	 
	 public ServiceException(String arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �����쳣��ԭ��
	  */
	 public ServiceException(Throwable arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  * @param arg1 �����쳣��ԭ��
	  */
	 
	 public ServiceException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	    }

	

}
