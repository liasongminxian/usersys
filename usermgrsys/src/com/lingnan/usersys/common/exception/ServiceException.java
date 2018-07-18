package com.lingnan.usersys.common.exception;
/**
 * 将业务层异常包装成自定义异常，进行处理
 * @author Administrator
 *
 */
public class ServiceException extends RuntimeException{
	/**
	 * 默认的构造方法
	 */
	 public ServiceException() {
	       
	    }
	 /**
	  * 构造方法
	  * @param arg0 异常的详细信息
	  */
	 
	 public ServiceException(String arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * 构造方法
	  * @param arg0 产生异常的原因
	  */
	 public ServiceException(Throwable arg0) {
	        super(arg0);
	    }
	 
	 /**
	  * 构造方法
	  * @param arg0 异常的详细信息
	  * @param arg1 产生异常的原因
	  */
	 
	 public ServiceException(String arg0, Throwable arg1) {
	        super(arg0, arg1);
	    }

	

}
