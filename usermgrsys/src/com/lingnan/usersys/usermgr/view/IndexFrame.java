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
			System.out.println("欢迎使用敏娴的用户管理系统");
			System.out.println("=========================");
			System.out.println("用户登录---------------- 1");
			System.out.println("用户注册---------------- 2");
			System.out.println("退出程序---------------- 3");
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
				this.loginShow();
				break;
			case 2:
				this.addShow("注册");
				break;
			case 3:
				System.out.println("感谢您的使用，再会。");
				System.exit(0);
			default:
				System.out.println("您的输入操作不正确，请重新输入");
				
				
			
			}
			
		}
		
	}

	public void loginShow() {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("用户登录界面");
		System.out.println("====================");
		System.out.println("请输入您的用户名");
		try{
			String name=br.readLine();
			System.out.println("请输入您的密码");
			String password=br.readLine();
			UserController uc=new UserController();
			UserVo user=uc.doLogin(name, password);
			if(user!=null){
				System.out.println("登录成功！！！");
				System.out.println();
				System.out.println("====================");
				AdminFrame m=new AdminFrame(user);
				m.loginSuccShow();
				System.exit(0);
			}else{
				System.out.println("登录失败啦o(╥﹏╥)o");
			}
		} catch(Exception e){
			System.out.println("用户登录时出错了"+e.getMessage());
		}
		
	}

	@Override
	public void addShow(String type) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		if(("注册").equals(type)){
		System.out.println("用户注册界面");
		System.out.println("====================");
		System.out.println("请输入您的用户名：");
		try{
			UserVo newuser=new UserVo();
			newuser.setName(br.readLine());
			System.out.println("请输入您的密码：");
			newuser.setPass(br.readLine());
			while(true){
				System.out.println("请输入您的邮箱：");
				String mail=br.readLine();
				if(TypeUtils.mailCheck(mail)){
					newuser.setMail(mail);
					break;				
				} else{
					System.out.println("请输入正确的邮箱格式：前面任意位数非空字符，必须带@，末尾必须有.com或者.cn");
				}
				
				
			}
			
			System.out.println("请输入您的生日(yyyy-mm-dd)：");
			String birth=br.readLine();
			java.sql.Date date=TypeUtils.strToDate(birth);
			newuser.setBirth(date);
			UserController uc=new UserController();
			boolean flag=uc.doRegister(newuser);
			if(flag){
				System.out.println("注册成功！！！");			
			}else{
				System.out.println("注册失败啦o(╥﹏╥)o");
			}
		} catch(Exception e){
			System.out.println("用户注册时出错了"+e.getMessage());
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
