package com.lingnan.usersys.common.exception;
/**
 * ������ת��ʱ�������쳣��װ���Զ����쳣�����д���
 * @author Administrator
 *
 */
public class DateException extends ServiceException{
	/**
	 * Ĭ�ϵĹ��췽��
	 */
	 public DateException() {
	       
	    }
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  */
	 
	 public DateException(String arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �����쳣��ԭ��
	  */
	 public DateException(Throwable arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * ���췽��
	  * @param arg0 �쳣����ϸ��Ϣ
	  * @param arg1 �����쳣��ԭ��
	  */
	 
	 public DateException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	    }

}
