package com.lingnan.usersys.common.exception;
/**
 * ���ʼ���ʽ��֤ʱ�������쳣��װ���Զ����쳣�����д���
 * @author Administrator
 *
 */
public class EmailException extends ServiceException{
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	 public EmailException() {
	       
	    }
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  */
	 
	 public EmailException(String arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �����쳣��ԭ��
	  */
	 public EmailException(Throwable arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  * @param arg1 �����쳣��ԭ��
	  */
	 
	 public EmailException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	    }

}
