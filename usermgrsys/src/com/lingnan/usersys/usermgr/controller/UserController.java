package com.lingnan.usersys.usermgr.controller;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVo;

public class UserController {
//	声明用户service接口对象，进行业务处理
	UserService userMgrService =UserServiceImpl.getInstance();
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 用户密码
	 * @return 用户信息
	 */
	public UserVo doLogin(String name,String password){
		UserVo user=null;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.login(name, password);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户登录时发生错误"+e.getMessage());
		} 
		
		return user;
		
		
	}
	
	public boolean doRegister(UserVo newuser){
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.register(newuser);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户注册时发生错误"+e.getMessage());
		} 
		
		return flag;
		
		
	}
	
	public UserVo doFindById(int id){
		UserVo user=null;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			user=userMgrService.findById(id);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户查询时发生错误"+e.getMessage());
		} 
		
		return user;
		
		
	}
	
	public boolean doDelete(int id){
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.delete(id);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户删除时发生错误"+e.getMessage());
		} 
		
		return flag;
		
		
	}

}
