package com.lingnan.usersys.usermgr.controller;

import com.lingnan.usersys.usermgr.business.service.UserService;
import com.lingnan.usersys.usermgr.business.service.UserServiceImpl;
import com.lingnan.usersys.usermgr.domain.UserVo;

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

}
