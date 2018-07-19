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
			
			System.out.println("修改自己的信息---------------- 1");
			System.out.println("查询自己的信息---------------- 2");
			System.out.println("退出程序---------------------- 3");
			int i=-1;
			while(true){
				try{
					i=Integer.parseInt(br.readLine());
					break;
				} catch(Exception e){
					System.out.println("输入错误，只能输入1~3的数字");
					System.out.println("请您重新输入");
					
					
				}
			}
			
			switch(i){
			
			
			case 1:
				this.updateShow("修改个人信息");
				break;
			case 2:
				this.searchShow();
				break;
		
			case 3:
				System.out.println("感谢您的使用，再会。");
				System.exit(0);
			default:
				System.out.println("您的输入操作不正确，请重新输入");
				
				
			
			}
			
		}
		
	}
	
	public void searchShow(){
		System.out.println();
		System.out.println("信息查询界面");
		System.out.println("====================");
		System.out.println("ID:     "+user.getId());
		System.out.println("用户名:  "+user.getName());
		System.out.println("生日:    "+user.getBirth());
		System.out.println("邮箱:    "+user.getMail());
		
		String superuser=null;
		if (user.getSuperuser()==1) {
			
			superuser="管理员";
			
		} else {
			
			superuser="普通用户";
		}
		
		System.out.println("权限:    "+superuser);
		System.out.println("====================");
		
	}
	

	public void updateShow(String type) {
		if (("修改个人信息".equals(type))) {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.println();
				System.out.println("====================");
				System.out.println("修改用户名------- 1");
				System.out.println("修改密码---------- 2");
				System.out.println("修改邮箱------- 3");
				System.out.println("修改生日----------- 4");		
				System.out.println("返回上一页面 ------- 5");			
				System.out.println("退出程序 ----------- 6");
				int i=-1;
				while(true){
					try{
						i=Integer.parseInt(br.readLine());
						
						break;
					} catch(Exception e){
						System.out.println("输入错误，只能输入1~6的数字");
						System.out.println("请您重新输入");
						
						
					}
				}
				
				switch(i){
				case 1:
					this.updateShow("修改用户名");
					break;
				case 2:
					this.updateShow("修改密码");				
					break;
				case 3:

					this.updateShow("修改邮箱");	
					break;
				case 4:
					this.updateShow("修改生日");
					break;
				case 5:
					this.show();
					break;		
				case 6:
					System.out.println("感谢您的使用，再会。");
					System.exit(0);
				default:
					System.out.println("您的输入操作不正确，请重新输入");
					
					
				
				}
				
			}

		}
			

	
	if("修改密码".equals(type)){
		try {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		System.out.println("请输入新密码：");
		
			String password=br.readLine();
			UserController uc=new UserController();
			flag=uc.doUpdatePassword(user.getId(), password);
			if (flag) {
				System.out.println("修改密码成功");
			} else{
				System.out.println("修改密码失败");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	if("修改邮箱".equals(type)){
		try {
			boolean flag=false;
			String mail;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("请输入您的邮箱：");
			mail=br.readLine();
			if(TypeUtils.mailCheck(mail)){
				UserController uc=new UserController();
				flag=uc.doUpdateMail(user.getId(), mail);
				break;				
			} else{
				System.out.println("请输入正确的邮箱格式：前面任意位数非空字符，必须带@，末尾必须有.com或者.cn");
			}
			
			
		}

			if (flag) {
				user.setMail(mail);
				System.out.println("修改邮箱成功");
			} else{
				System.out.println("修改邮箱失败");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	if("修改用户名".equals(type)){
		try {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		System.out.println("请输入新用户名：");
		
			String name=br.readLine();
			UserController uc=new UserController();
			flag=uc.doUpdateName(user.getId(), name);
			if (flag) {
				user.setName(name);
				System.out.println("修改用户名成功");
			} else{
				System.out.println("修改用户名失败");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	if("修改生日".equals(type)){
		try {BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean flag=false;
		System.out.println("请输入新日期(yyyy-mm-dd)：");
		String birth=br.readLine();
		java.sql.Date date=TypeUtils.strToDate(birth);

			UserController uc=new UserController();
			flag=uc.doUpdateBirth(user.getId(), date);
			if (flag) {
				user.setBirth(date);
				System.out.println("修改生日成功");
			} else{
				System.out.println("修改生日失败");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateException e) {
			throw new DateException("邮箱", e);
		}
	}
	
	}
}
