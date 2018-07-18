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
				this.updateShow("修改个人信息",user);
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

}
