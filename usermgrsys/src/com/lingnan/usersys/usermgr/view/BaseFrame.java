package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVo;
/**
 * ��ͼ����ӿ�
 * Ϊ��ͼ���ഴ���������
 * @author Administrator
 *
 */

public interface BaseFrame {
	/**
	 * ҳ����ʾ
	 */
	public void show();
	/**
	 * �����û�ҳ����ʾ
	 * @param type �����û���Ϣ������
	 */
	public void addShow(String type);
	/**
	 * ��ѯ�û�ҳ����ʾ
	 */
	public void searchShow();
	/**
	 * �����û�ҳ����ʾ
	 * @param type ������Ϣ������
	 * 
	 */
	public void updateShow(String type);

}
