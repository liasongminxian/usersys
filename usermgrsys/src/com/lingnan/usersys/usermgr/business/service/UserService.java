package com.lingnan.usersys.usermgr.business.service;

import java.sql.Date;
import java.util.List;

import com.lingnan.usersys.usermgr.domain.UserVo;

/**
 * UserService接口
 * 项目中所有的实现UserService层方法都继承该接口
 * 对UseDao的方法进行封住，进行事务管理和数据库连接
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录的用户信息
	 */
	public UserVo login(String name,String password);
	/**
	 * 用户注册
	 * @param newuser 新注册的用户信息
	 * @return 布尔值
	 */
	public boolean register(UserVo newuser);
	/**
	 * 按ID查询I_USER表
	 * @param id 要查询的ID号
	 * @return 查询到的用户信息
	 */
	public UserVo findById(int id);
	/**
	 * 按ID删除用户信息（软删除）
	 * @param id 要删除的ID号
	 * @return 布尔值
	 */
	public boolean delete(int id);
	/**
	 * 按ID更新密码
	 * @param id 要更新密码的ID号
	 * @param password 新密码
	 * @return 布尔值
	 */
	public boolean updatePassword(int id,String password);
	/**
	 * 按ID更新邮箱
	 * @param id 要更新邮箱的ID号
	 * @param mail 新邮箱
	 * @return 布尔值
	 */
	public boolean updateMail(int id,String mail);
	/**
	 * 按ID更新用户名
	 * @param id 要更新用户名的ID号
	 * @param name 新用户名
	 * @return 布尔值
	 */
	public boolean updateName(int id,String name);
	/**
	 * 按ID更新权限
	 * @param id 要更新权限的ID号
	 * @return 布尔值
	 */
	public boolean updateSuperUser(int id);
	/**
	 * 按ID更新生日日期
	 * @param id 要更新生日日期的ID号
	 * @param birth 新生日日期
	 * @return 布尔值
	 */
	public boolean updateBirth(int id,Date birth);
	/**
	 * 按用户名查找（模糊查询）
	 * @param name 要查找的用户名字段
	 * @return 含有相关字段的用户信息
	 */
	public List<UserVo> findByName(String name);
	/**
	 * 分页查询
	 * @param pageNo 要查询的页码
	 * @param pageSize 每页有多少个记录
	 * @return 指定页码的用户信息
	 */
	public List<UserVo> findByPage(int pageNo,int pageSize);
	/**
	 * 查询所有信息
	 * @return 所有用户的信息
	 */
	public List<UserVo> findAll();
	
	
	
}
