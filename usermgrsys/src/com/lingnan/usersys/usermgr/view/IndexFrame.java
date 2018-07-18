package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.domain.UserVo;
import com.lingnan.usersys.usermgr.controller.UserController;

public class IndexFrame implements BaseFrame{

	public void show() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			System.out.println("��ӭʹ����浵��û�����ϵͳ");
			System.out.println("=========================");
			System.out.println("�û���¼---------------- 1");
			System.out.println("�û�ע��---------------- 2");
			System.out.println("�˳�����---------------- 3");
			int i=-1;
			while(true){
				try{
					i=Integer.parseInt(br.readLine());
					break;
				} catch(Exception e){
					System.out.println("�������ֻ������1~3������");
					System.out.println("������������");
					
					
				}
			}
			
			switch(i){
			case 1:
				this.loginShow();
				break;
			case 2:
				this.addShow("ע��");
				break;
			case 3:
				System.out.println("��л����ʹ�ã��ٻᡣ");
				System.exit(0);
			default:
				System.out.println("���������������ȷ������������");
				
				
			
			}
			
		}
		
	}

	public void loginShow() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("�û���¼����");
		System.out.println("====================");
		System.out.println("�����������û���");
		try{
			String name=br.readLine();
			System.out.println("��������������");
			String password=br.readLine();
			UserController uc=new UserController();
			UserVo user=uc.doLogin(name, password);
			if(user!=null){
				System.out.println("��¼�ɹ�������");
				System.out.println();
				System.out.println("====================");
				AdminFrame m=new AdminFrame(user);
				m.loginSuccShow();
				System.exit(0);
			}else{
				System.out.println("��¼ʧ����o(�i�n�i)o");
			}
		} catch(Exception e){
			System.out.println("�û���¼ʱ������"+e.getMessage());
		}
		
	}

	@Override
	public void addShow(String type) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		if(("ע��").equals(type)){
		System.out.println("�û�ע�����");
		System.out.println("====================");
		System.out.println("�����������û�����");
		try{
			UserVo newuser=new UserVo();
			newuser.setName(br.readLine());
			System.out.println("�������������룺");
			newuser.setPass(br.readLine());
			while(true){
				System.out.println("�������������䣺");
				String mail=br.readLine();
				if(TypeUtils.mailCheck(mail)){
					newuser.setMail(mail);
					break;				
				} else{
					System.out.println("��������ȷ�������ʽ��ǰ������λ���ǿ��ַ��������@��ĩβ������.com����.cn");
				}
				
				
			}
			
			System.out.println("��������������(yyyy-mm-dd)��");
			String birth=br.readLine();
			java.sql.Date date=TypeUtils.strToDate(birth);
			newuser.setBirth(date);
			UserController uc=new UserController();
			boolean flag=uc.doRegister(newuser);
			if(flag){
				System.out.println("ע��ɹ�������");			
			}else{
				System.out.println("ע��ʧ����o(�i�n�i)o");
			}
		} catch(Exception e){
			System.out.println("�û�ע��ʱ������"+e.getMessage());
		} 
	
		}
		
	}

	@Override
	public void searchShow() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void updateShow(String type) {
		// TODO Auto-generated method stub
		
	}

}
