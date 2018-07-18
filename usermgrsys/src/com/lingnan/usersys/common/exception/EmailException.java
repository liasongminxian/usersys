package com.lingnan.usersys.common.exception;
/**
 * 将邮件格式验证时发生的异常包装成自定义异常，进行处理
 * @author Administrator
 *
 */
public class EmailException extends ServiceException{
	/**
	 * 默认的构造方法
	 */
	 public EmailException() {
	       
	    }
	 /**
	  * 构造方法
	  * @param arg0 异常的详细信息
	  */
	 
	 public EmailException(String arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * 构造方法
	  * @param arg0 产生异常的原因
	  */
	 public EmailException(Throwable arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * 构造方法
	  * @param arg0 异常的详细信息
	  * @param arg1 产生异常的原因
	  */
	 
	 public EmailException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	    }

}
