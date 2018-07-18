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
			superuser="管理员";
		} else if(user.getSuperuser()==2){
			superuser="普通用户";
		}
		System.out.println("欢迎登录主窗体");
		System.out.println(user.getName()+"您好~"+"        您的权限是："+superuser);
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
			
			System.out.println("添加管理员---------------- 1");
			System.out.println("删除用户------------------ 2");
			System.out.println("查询用户------------------ 3");
			System.out.println("修改用户------------------ 4");		
			System.out.println("修改个人信息-------------- 5");
			
			System.out.println("退出程序------------------ 6");
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
				this.addShow("注册管理员");
				break;
			case 2:
				this.updateShow("删除用户",user);//考虑user
				break;
			case 3:
				this.searchShow();
				break;
			case 4:
				this.updateShow("修改用户",user);
				break;
			case 5:
				this.updateShow("修改个人信息",user);
				break;
		
			case 6:
				System.out.println("感谢您的使用，再会。");
				System.exit(0);
			default:
				System.out.println("您的输入操作不正确，请重新输入");
				
				
			
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
			System.out.println("查询所有用户------- 1");
			System.out.println("按ID查询 ---------- 2");
			System.out.println("按用户名查询------- 3");
			System.out.println("分页查询----------- 4");		
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
				this.addShow("注册管理员");
				break;
			case 2:
				System.out.println("请输入要查询的ID号：");
				int id=-1;
				try{
					id=Integer.parseInt(br.readLine());
					UserController uc=new UserController();
					UserVo getuser=uc.doFindById(id);
					detailShow(getuser);
					break;
				} catch(Exception e){
					System.out.println("输入错误，只能输入1~6的数字");
					System.out.println("请您重新输入");					
				}				
				break;
			case 3:

				this.searchShow();
				break;
			case 4:
				this.updateShow("修改用户",user);
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
	
	public void detailShow(UserVo getuser) {
		
		System.out.println();
		System.out.println("信息查询界面");
		System.out.println("====================");
		System.out.println("ID:      "+getuser.getId());
		System.out.println("用户名:  "+getuser.getName());
		System.out.println("生日:    "+getuser.getBirth());
		System.out.println("邮箱:    "+getuser.getMail());
		
		String superuser=null;
		if (getuser.getSuperuser()==1) {
			
			superuser="管理员";
			
		} else {
			
			superuser="普通用户";
		}
		
		System.out.println("权限:    "+superuser);
		System.out.println("====================");
		
		
		
	}

}
