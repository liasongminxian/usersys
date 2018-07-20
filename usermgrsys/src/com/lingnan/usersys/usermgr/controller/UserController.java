package com.lingnan.usersys.usermgr.controller;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVo;
/**
 * ���Ʋ���
 * ��UserService���н�һ����װ��ʵ�����ݿ��java�����ӵ�����
 * @author Administrator
 *
 */
public class UserController {
//	�����û�service�ӿڶ��󣬽���ҵ����
	UserService userMgrService =UserServiceImpl.getInstance();
	/**
	 * �û���¼
	 * @param name �û���
	 * @param password �û�����
	 * @return �û���Ϣ
	 */
	public UserVo doLogin(String name,String password){
		UserVo user=null;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.login(name, password);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û���¼ʱ��������"+e.getMessage());
		} 
		
		return user;
		
		
	}
	
	
	/**
	 * �û�ע��
	 * @param newuser ��ע����û���Ϣ
	 * @return ����ֵ
	 */
	public boolean doRegister(UserVo newuser){
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.register(newuser);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û�ע��ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
		
	}
	
	/**
	 * ��ID��ѯI_USER��
	 * @param id Ҫ��ѯ��ID��
	 * @return ��ѯ�����û���Ϣ
	 */
	public UserVo doFindById(int id){
		UserVo user=null;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			user=userMgrService.findById(id);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û���ѯʱ��������"+e.getMessage());
		} 
		
		return user;
		
		
	}
	
	/**
	 * ��IDɾ���û���Ϣ����ɾ����
	 * @param id Ҫɾ����ID��
	 * @return ����ֵ
	 */
	public boolean doDelete(int id){
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.delete(id);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û�ɾ��ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
		
	}
	
	/**
	 * ��ID��������
	 * @param id Ҫ���������ID��
	 * @param mail ������
	 * @return ����ֵ
	 */
	public boolean doUpdatePassword(int id, String password){
		
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.updatePassword(id, password);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û��޸�����ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * ��ID�����û���
	 * @param id Ҫ�����û�����ID��
	 * @param name ���û���
	 * @return ����ֵ
	 */
	public boolean doUpdateMail(int id, String mail){
		
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.updateMail(id, mail);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û��޸�����ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * ��ID�����û���
	 * @param id Ҫ�����û�����ID��
	 * @param name ���û���
	 * @return ����ֵ
	 */
	public boolean doUpdateName(int id, String name){
		
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.updateName(id, name);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û��޸��û���ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	
	/**
	 * ��ID������������
	 * @param id Ҫ�����������ڵ�ID��
	 * @param birth ����������
	 * @return ����ֵ
	 */
	public boolean doUpdateBirth(int id, Date birth){
		
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.updateBirth(id, birth);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û��޸�����ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * ��ID����Ȩ��
	 * @param id Ҫ����Ȩ�޵�ID��
	 * @return ����ֵ
	 */
	public boolean doUpdateSuperuser(int id){
		
		boolean flag=false;
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			flag=userMgrService.updateSuperUser(id);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û��޸�Ȩ��ʱ��������"+e.getMessage());
		} 
		
		return flag;
		
	}
	
	/**
	 * ��ѯ������Ϣ
	 * @return �����û�����Ϣ
	 */
	public List<UserVo> doFindAll(){
		List<UserVo> alluser=new ArrayList<UserVo>();
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			alluser=userMgrService.findAll();
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���ѯ�����û�ʱ��������"+e.getMessage());
		} 
		
		return alluser;
		
		
	}
	
	/**
	 * ���û������ң�ģ����ѯ��
	 * @param name Ҫ���ҵ��û����ֶ�
	 * @return ��������ֶε��û���Ϣ
	 */
	public List<UserVo> doFindByName(String name){
		List<UserVo> allname=new ArrayList<UserVo>();
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			allname=userMgrService.findByName(name);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���û�����ѯʱ��������"+e.getMessage());
		} 
		
		return allname;
		
		
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo Ҫ��ѯ��ҳ��
	 * @param pageSize ÿҳ�ж��ٸ���¼
	 * @return ָ��ҳ����û���Ϣ
	 */
	public List<UserVo> doFindByPage(int pageNo, int pageSize){
		List<UserVo> allpage=new ArrayList<UserVo>();
		
		try{
//			�����û�service�ӿ��е�login�����������û���¼����
			allpage=userMgrService.findByPage(pageNo, pageSize);
		
		} catch(Exception e){
//			��ʾ�쳣��Ϣ
			System.out.println("controller���ҳ��ѯʱ��������"+e.getMessage());
		} 
		
		return allpage;
		
		
	}

}
