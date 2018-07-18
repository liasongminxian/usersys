package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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
				this.updateShow("�޸ĸ�����Ϣ",user);
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

}
