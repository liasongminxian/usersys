package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVo;

public class NormalFrame extends IndexFrame{

	UserVo user=null;

	public NormalFrame(UserVo user) {
		this.user=user;
		// TODO Auto-generated constructor stub
	}
	
	public void show() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			
			System.out.println("�޸��Լ�����Ϣ---------------- 1");
			System.out.println("��ѯ�Լ�����Ϣ---------------- 2");
			System.out.println("�˳�����---------------------- 3");
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
				this.updateShow("�޸ĸ�����Ϣ");
				break;
			case 2:
				this.searchShow();
				break;
		
			case 3:
				System.out.println("��л����ʹ�ã��ٻᡣ");
				System.exit(0);
			default:
				System.out.println("���������������ȷ������������");
				
				
			
			}
			
		}
		
	}
	
	public void searchShow(){
		System.out.println();
		System.out.println("��Ϣ��ѯ����");
		System.out.println("====================");
		System.out.println("ID:     "+user.getId());
		System.out.println("�û���:  "+user.getName());
		System.out.println("����:    "+user.getBirth());
		System.out.println("����:    "+user.getMail());
		
		String superuser=null;
		if (user.getSuperuser()==1) {
			
			superuser="����Ա";
			
		} else {
			
			superuser="��ͨ�û�";
		}
		
		System.out.println("Ȩ��:    "+superuser);
		System.out.println("====================");
		
	}
	

	public void updateShow(String type) {
		if (("�޸ĸ�����Ϣ".equals(type))) {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println();
				System.out.println("====================");
				System.out.println("�޸��û���------- 1");
				System.out.println("�޸�����---------- 2");
				System.out.println("�޸�����------- 3");
				System.out.println("�޸�����----------- 4");		
				System.out.println("������һҳ�� ------- 5");			
				System.out.println("�˳����� ----------- 6");
				int i=-1;
				while(true){
					try{
						i=Integer.parseInt(br.readLine());
						
						break;
					} catch(Exception e){
						System.out.println("�������ֻ������1~6������");
						System.out.println("������������");
						
						
					}
				}
				
				switch(i){
				case 1:
					this.updateShow("�޸��û���");
					break;
				case 2:
					this.updateShow("�޸�����");				
					break;
				case 3:

					this.updateShow("�޸�����");	
					break;
				case 4:
					this.updateShow("�޸�����");
					break;
				case 5:
					this.show();
					break;		
				case 6:
					System.out.println("��л����ʹ�ã��ٻᡣ");
					System.exit(0);
				default:
					System.out.println("���������������ȷ������������");
					
					
				
				}
				
			}

		}
			

	
	if("�޸�����".equals(type)){
		try {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		System.out.println("�����������룺");
		
			String password=br.readLine();
			UserController uc=new UserController();
			flag=uc.doUpdatePassword(user.getId(), password);
			if (flag) {
				System.out.println("�޸�����ɹ�");
			} else{
				System.out.println("�޸�����ʧ��");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if("�޸�����".equals(type)){
		try {
			boolean flag=false;
			String mail;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("�������������䣺");
			mail=br.readLine();
			if(TypeUtils.mailCheck(mail)){
				UserController uc=new UserController();
				flag=uc.doUpdateMail(user.getId(), mail);
				break;				
			} else{
				System.out.println("��������ȷ�������ʽ��ǰ������λ���ǿ��ַ��������@��ĩβ������.com����.cn");
			}
			
			
		}

			if (flag) {
				user.setMail(mail);
				System.out.println("�޸�����ɹ�");
			} else{
				System.out.println("�޸�����ʧ��");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	if("�޸��û���".equals(type)){
		try {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		System.out.println("���������û�����");
		
			String name=br.readLine();
			UserController uc=new UserController();
			flag=uc.doUpdateName(user.getId(), name);
			if (flag) {
				user.setName(name);
				System.out.println("�޸��û����ɹ�");
			} else{
				System.out.println("�޸��û���ʧ��");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	if("�޸�����".equals(type)){
		try {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		System.out.println("������������(yyyy-mm-dd)��");
		String birth=br.readLine();
		java.sql.Date date=TypeUtils.strToDate(birth);

			UserController uc=new UserController();
			flag=uc.doUpdateBirth(user.getId(), date);
			if (flag) {
				user.setBirth(date);
				System.out.println("�޸����ճɹ�");
			} else{
				System.out.println("�޸�����ʧ��");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateException e) {
			throw new DateException("����", e);
		}
	}
	
	}
}
