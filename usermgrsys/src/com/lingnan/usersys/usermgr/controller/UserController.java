package com.lingnan.usersys.usermgr.controller;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVo;
/**
 * 控制层类
 * 对UserService进行进一步封装，实现数据库和java的连接的整合
 * @author Administrator
 *
 */
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
	
	
	/**
	 * 用户注册
	 * @param newuser 新注册的用户信息
	 * @return 布尔值
	 */
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
	
	/**
	 * 按ID查询I_USER表
	 * @param id 要查询的ID号
	 * @return 查询到的用户信息
	 */
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
	
	/**
	 * 按ID删除用户信息（软删除）
	 * @param id 要删除的ID号
	 * @return 布尔值
	 */
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
	
	/**
	 * 按ID更新邮箱
	 * @param id 要更新邮箱的ID号
	 * @param mail 新邮箱
	 * @return 布尔值
	 */
	public boolean doUpdatePassword(int id, String password){
		
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.updatePassword(id, password);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户修改密码时发生错误"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * 按ID更新用户名
	 * @param id 要更新用户名的ID号
	 * @param name 新用户名
	 * @return 布尔值
	 */
	public boolean doUpdateMail(int id, String mail){
		
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.updateMail(id, mail);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户修改邮箱时发生错误"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * 按ID更新用户名
	 * @param id 要更新用户名的ID号
	 * @param name 新用户名
	 * @return 布尔值
	 */
	public boolean doUpdateName(int id, String name){
		
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.updateName(id, name);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户修改用户名时发生错误"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	
	/**
	 * 按ID更新生日日期
	 * @param id 要更新生日日期的ID号
	 * @param birth 新生日日期
	 * @return 布尔值
	 */
	public boolean doUpdateBirth(int id, Date birth){
		
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.updateBirth(id, birth);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户修改生日时发生错误"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * 按ID更新权限
	 * @param id 要更新权限的ID号
	 * @return 布尔值
	 */
	public boolean doUpdateSuperuser(int id){
		
		boolean flag=false;
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			flag=userMgrService.updateSuperUser(id);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户修改权限时发生错误"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * 查询所有信息
	 * @return 所有用户的信息
	 */
	public List<UserVo> doFindAll(){
		List<UserVo> alluser=new ArrayList<UserVo>();
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			alluser=userMgrService.findAll();
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层查询所有用户时发生错误"+e.getMessage());
		} 
		
		return alluser;
		
		
	}
	
	/**
	 * 按用户名查找（模糊查询）
	 * @param name 要查找的用户名字段
	 * @return 含有相关字段的用户信息
	 */
	public List<UserVo> doFindByName(String name){
		List<UserVo> allname=new ArrayList<UserVo>();
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			allname=userMgrService.findByName(name);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层用户名查询时发生错误"+e.getMessage());
		} 
		
		return allname;
		
		
	}
	
	/**
	 * 分页查询
	 * @param pageNo 要查询的页码
	 * @param pageSize 每页有多少个记录
	 * @return 指定页码的用户信息
	 */
	public List<UserVo> doFindByPage(int pageNo, int pageSize){
		List<UserVo> allpage=new ArrayList<UserVo>();
		
		try{
//			调用用户service接口中的login方法，进行用户登录操作
			allpage=userMgrService.findByPage(pageNo, pageSize);
		
		} catch(Exception e){
//			显示异常信息
			System.out.println("controller层分页查询时发生错误"+e.getMessage());
		} 
		
		return allpage;
		
		
	}

}
