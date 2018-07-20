package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVo;
/**
 * 视图层类接口
 * 为视图层类创建公共框架
 * @author Administrator
 *
 */

public interface BaseFrame {
	/**
	 * 页面显示
	 */
	public void show();
	/**
	 * 增加用户页面显示
	 * @param type 增加用户信息的类型
	 */
	public void addShow(String type);
	/**
	 * 查询用户页面显示
	 */
	public void searchShow();
	/**
	 * 更新用户页面显示
	 * @param type 更新信息的类型
	 * 
	 */
	public void updateShow(String type);

}
