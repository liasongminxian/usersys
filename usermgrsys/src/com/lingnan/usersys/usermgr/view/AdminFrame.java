package com.lingnan.usersys.usermgr.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.lingnan.usersys.common.exception.DateException;
import com.lingnan.usersys.common.util.TypeUtils;
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
			System.out.println();
			System.out.println("��ӹ���Ա---------------- 1");
			System.out.println("ɾ���û�------------------ 2");
			System.out.println("��ѯ�û�------------------ 3");
			System.out.println("�޸��û�Ȩ��------------------ 4");		
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
				this.updateShow("ɾ���û�");//����user
				break;
			case 3:
				this.searchShow();
				break;
			case 4:
				this.updateShow("�޸��û�Ȩ��");
				break;
			case 5:
				this.updateShow("�޸ĸ�����Ϣ");
				break;
		
			case 6:
				System.out.println("��л����ʹ�ã��ٻᡣ");
				System.exit(0);
			default:
				System.out.println("���������������ȷ������������");
				
				
			
			}
			
		}
		
	}
	

	
	public void searchShow(){
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
UserController uc=new UserController();
		while(true){
			System.out.println();
			System.out.println("====================");
			System.out.println("��ѯ�����û�------- 1");
			System.out.println("��ID��ѯ ---------- 2");
			System.out.println("���û�����ѯ��ģ����ѯ��------- 3");
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
				try{
					List<UserVo> alluser=new ArrayList<UserVo>();
					
					alluser=uc.doFindAll();
			    	for(UserVo u:alluser){
			    		detailShow(u);

				}
					break;
				} catch(Exception e){
					System.out.println("�������ֻ������1~6������");
					System.out.println("������������");					
				}
				break;
			case 2:
				System.out.println("������Ҫ��ѯ��ID�ţ�");
				
				try{
					int id=-1;
					id=Integer.parseInt(br.readLine());
					
					UserVo getuser=uc.doFindById(id);
					if(getuser!=null){
					detailShow(getuser);
					}
					break;
				} catch(Exception e){
					System.out.println("�������ֻ������1~6������");
					System.out.println("������������");					
				}				
				break;
			case 3:
                System.out.println("������Ҫ��ѯ���û����ؼ��֣�");
				
				try{
					String name=null;
					name=br.readLine();
					List<UserVo> alluser=new ArrayList<UserVo>();
					
					alluser=uc.doFindByName(name);
			    	for(UserVo u:alluser){
			    		detailShow(u);

				} 
				}catch(Exception e){
					System.out.println("�������ֻ������1~6������");
					System.out.println("������������");					
				}	
					break;
			case 4:
				System.out.println("������Ҫÿҳ��ʾ������");
				try {
					int pageSize = Integer.parseInt(br.readLine());
					System.out.println("������Ҫÿҳ��ʾ��ҳ��");
					int pageNo = Integer.parseInt(br.readLine());
	List<UserVo> allpage=new ArrayList<UserVo>();
					
					allpage=uc.doFindByPage(pageNo, pageSize);
			    	for(UserVo u:allpage){
			    		detailShow(u);

				} 
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	
	public void addShow(String type){
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		if(("ע�����Ա").equals(type)){
			System.out.println();
		System.out.println("���ӹ���Ա����");
		System.out.println("====================");
		System.out.println("�������¹���Ա���û�����");
		try{
			UserVo newuser=new UserVo();
			newuser.setName(br.readLine());
			System.out.println("�������¹���Ա�����룺");
			newuser.setPass(br.readLine());
			while(true){
				System.out.println("�������¹���Ա�����䣺");
				String mail=br.readLine();
				if(TypeUtils.mailCheck(mail)){
					newuser.setMail(mail);
					break;				
				} else{
					System.out.println("��������ȷ�������ʽ��ǰ������λ���ǿ��ַ��������@��ĩβ������.com����.cn");
				}
				
				
			}
			
			System.out.println("�������¹���Ա������(yyyy-mm-dd)��");
			String birth=br.readLine();
			java.sql.Date date=TypeUtils.strToDate(birth);
			newuser.setBirth(date);
			newuser.setSuperuser(1);
			UserController uc=new UserController();
			boolean flag=uc.doRegister(newuser);
			if(flag){
				System.out.println("��ӳɹ�������");			
			}else{
				System.out.println("���ʧ����o(�i�n�i)o");
			}
		} catch(Exception e){
			System.out.println("�����¹���Աʱ������"+e.getMessage());
		} 
	
		}
		
	}
	
	
	public void updateShow(String type){
		UserController uc=new UserController();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		if(("�޸��û�Ȩ��").equals(type)){
			System.out.println();


		System.out.println("������Ҫ�޸��û�Ȩ�޵�ID��");
		int id=-1;
		while(true){
			try{
				id=Integer.parseInt(br.readLine());

				boolean flag=uc.doUpdateSuperuser(id);
				if(flag){
					System.out.println("�޸ĳɹ�������");			
				}else{
					System.out.println("�޸�ʧ����o(�i�n�i)o");
				}
				break;
			} catch(Exception e){
				System.out.println("�������ֻ������");
				System.out.println("������������");
				
				
			}
		
		}
		
	}
		if(("ɾ���û�").equals(type)){
			System.out.println();
		System.out.println("ɾ���û�����");
		System.out.println("====================");
		System.out.println("������Ҫɾ�����û�ID��");
		int id=-1;
		while(true){
			try{
				id=Integer.parseInt(br.readLine());

				boolean flag=uc.doDelete(id);
				if(flag){
					System.out.println("ɾ���ɹ�������");			
				}else{
					System.out.println("ɾ��ʧ����o(�i�n�i)o");
				}
				break;
			} catch(Exception e){
				System.out.println("�������ֻ������");
				System.out.println("������������");
				
				
			}
		
		}
		
	}
		if (("�޸ĸ�����Ϣ".equals(type))) {
			
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
		try {
		boolean flag=false;
		System.out.println("�����������룺");
		
			String password=br.readLine();
			
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
		while(true){
			System.out.println("�������������䣺");
			mail=br.readLine();
			if(TypeUtils.mailCheck(mail)){

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
		try {
		boolean flag=false;
		System.out.println("���������û�����");
		
			String name=br.readLine();

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
		try {
		boolean flag=false;
		System.out.println("������������(yyyy-mm-dd)��");
		String birth=br.readLine();
		java.sql.Date date=TypeUtils.strToDate(birth);

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
