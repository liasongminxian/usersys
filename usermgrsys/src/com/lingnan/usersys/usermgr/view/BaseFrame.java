package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVo;

public interface BaseFrame {
	/**
	 * ҳ����ʾ
	 */
	public void show();
	/**
	 * �����û�ҳ����ʾ
	 * @param type
	 */
	public void addShow(String type);
	/**
	 * ��ѯ�û�ҳ����ʾ
	 */
	public void searchShow();
	/**
	 * �����û�ҳ����ʾ
	 * @param type
	 * @param user
	 */
	public void updateShow(String type);//����user

}
