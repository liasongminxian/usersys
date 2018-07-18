package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVo;

public class AdminFrame extends NormalFrame{
	
	public AdminFrame(UserVo user){
		super(user);
		
	}
	
	public void loginSuccShow(){
		String superuser=null;
		if(user.getSuperuser()==1){
			superuser="����Ա";
		} else if(user.getSuperuser()==2){
			superuser="��ͨ�û�";
		}
		System.out.println("��ӭ��¼������");
		System.out.println(user.getName()+"����~"+"        ����Ȩ���ǣ�"+superuser);
		System.out.println("====================");
		if(user.getSuperuser()==1){
			this.show();
			
		} else{
			new NormalFrame(user).show();
		}
		
		
	}
	
	public void show() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			
			System.out.println("��ӹ���Ա---------------- 1");
			System.out.println("ɾ���û�------------------ 2");
			System.out.println("��ѯ�û�------------------ 3");
			System.out.println("�޸��û�------------------ 4");		
			System.out.println("�޸ĸ�����Ϣ-------------- 5");
			
			System.out.println("�˳�����------------------ 6");
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
				this.addShow("ע�����Ա");
				break;
			case 2:
				this.updateShow("ɾ���û�",user);//����user
				break;
			case 3:
				this.searchShow();
				break;
			case 4:
				this.updateShow("�޸��û�",user);
				break;
			case 5:
				this.updateShow("�޸ĸ�����Ϣ",user);
				break;
		
			case 6:
				System.out.println("��л����ʹ�ã��ٻᡣ");
				System.exit(0);
			default:
				System.out.println("���������������ȷ������������");
				
				
			
			}
			
		}
		
	}
	
	public void updateShow(String type,UserVo user){
	
	}
	
	public void searchShow(){
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			System.out.println();
			System.out.println("====================");
			System.out.println("��ѯ�����û�------- 1");
			System.out.println("��ID��ѯ ---------- 2");
			System.out.println("���û�����ѯ------- 3");
			System.out.println("��ҳ��ѯ----------- 4");		
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
				this.addShow("ע�����Ա");
				break;
			case 2:
				System.out.println("������Ҫ��ѯ��ID�ţ�");
				int id=-1;
				try{
					id=Integer.parseInt(br.readLine());
					UserController uc=new UserController();
					UserVo getuser=uc.doFindById(id);
					detailShow(getuser);
					break;
				} catch(Exception e){
					System.out.println("�������ֻ������1~6������");
					System.out.println("������������");					
				}				
				break;
			case 3:

				this.searchShow();
				break;
			case 4:
				this.updateShow("�޸��û�",user);
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
	
	public void detailShow(UserVo getuser) {
		
		System.out.println();
		System.out.println("��Ϣ��ѯ����");
		System.out.println("====================");
		System.out.println("ID:      "+getuser.getId());
		System.out.println("�û���:  "+getuser.getName());
		System.out.println("����:    "+getuser.getBirth());
		System.out.println("����:    "+getuser.getMail());
		
		String superuser=null;
		if (getuser.getSuperuser()==1) {
			
			superuser="����Ա";
			
		} else {
			
			superuser="��ͨ�û�";
		}
		
		System.out.println("Ȩ��:    "+superuser);
		System.out.println("====================");
		
		
		
	}

}
