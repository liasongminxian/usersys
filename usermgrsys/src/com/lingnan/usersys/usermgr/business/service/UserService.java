package com.lingnan.usersys.usermgr.business.service;

import java.sql.Date;
import java.util.List;

import com.lingnan.usersys.usermgr.domain.UserVo;

/**
 * UserService�ӿ�
 * ��Ŀ�����е�ʵ��UserService�㷽�����̳иýӿ�
 * ��UseDao�ķ������з�ס�����������������ݿ�����
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * �û���¼
	 * @param name �û���
	 * @param password ����
	 * @return ��¼���û���Ϣ
	 */
	public UserVo login(String name,String password);
	/**
	 * �û�ע��
	 * @param newuser ��ע����û���Ϣ
	 * @return ����ֵ
	 */
	public boolean register(UserVo newuser);
	/**
	 * ��ID��ѯI_USER��
	 * @param id Ҫ��ѯ��ID��
	 * @return ��ѯ�����û���Ϣ
	 */
	public UserVo findById(int id);
	/**
	 * ��IDɾ���û���Ϣ����ɾ����
	 * @param id Ҫɾ����ID��
	 * @return ����ֵ
	 */
	public boolean delete(int id);
	/**
	 * ��ID��������
	 * @param id Ҫ���������ID��
	 * @param password ������
	 * @return ����ֵ
	 */
	public boolean updatePassword(int id,String password);
	/**
	 * ��ID��������
	 * @param id Ҫ���������ID��
	 * @param mail ������
	 * @return ����ֵ
	 */
	public boolean updateMail(int id,String mail);
	/**
	 * ��ID�����û���
	 * @param id Ҫ�����û�����ID��
	 * @param name ���û���
	 * @return ����ֵ
	 */
	public boolean updateName(int id,String name);
	/**
	 * ��ID����Ȩ��
	 * @param id Ҫ����Ȩ�޵�ID��
	 * @return ����ֵ
	 */
	public boolean updateSuperUser(int id);
	/**
	 * ��ID������������
	 * @param id Ҫ�����������ڵ�ID��
	 * @param birth ����������
	 * @return ����ֵ
	 */
	public boolean updateBirth(int id,Date birth);
	/**
	 * ���û������ң�ģ����ѯ��
	 * @param name Ҫ���ҵ��û����ֶ�
	 * @return ��������ֶε��û���Ϣ
	 */
	public List<UserVo> findByName(String name);
	/**
	 * ��ҳ��ѯ
	 * @param pageNo Ҫ��ѯ��ҳ��
	 * @param pageSize ÿҳ�ж��ٸ���¼
	 * @return ָ��ҳ����û���Ϣ
	 */
	public List<UserVo> findByPage(int pageNo,int pageSize);
	/**
	 * ��ѯ������Ϣ
	 * @return �����û�����Ϣ
	 */
	public List<UserVo> findAll();
	
	
	
}
