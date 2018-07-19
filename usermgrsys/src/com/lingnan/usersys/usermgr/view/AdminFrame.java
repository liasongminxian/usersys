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
			System.out.println();
			System.out.println("添加管理员---------------- 1");
			System.out.println("删除用户------------------ 2");
			System.out.println("查询用户------------------ 3");
			System.out.println("修改用户权限------------------ 4");		
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
				this.updateShow("删除用户");//考虑user
				break;
			case 3:
				this.searchShow();
				break;
			case 4:
				this.updateShow("修改用户权限");
				break;
			case 5:
				this.updateShow("修改个人信息");
				break;
		
			case 6:
				System.out.println("感谢您的使用，再会。");
				System.exit(0);
			default:
				System.out.println("您的输入操作不正确，请重新输入");
				
				
			
			}
			
		}
		
	}
	

	
	public void searchShow(){
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
UserController uc=new UserController();
		while(true){
			System.out.println();
			System.out.println("====================");
			System.out.println("查询所有用户------- 1");
			System.out.println("按ID查询 ---------- 2");
			System.out.println("按用户名查询（模糊查询）------- 3");
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
				try{
					List<UserVo> alluser=new ArrayList<UserVo>();
					
					alluser=uc.doFindAll();
			    	for(UserVo u:alluser){
			    		detailShow(u);

				}
					break;
				} catch(Exception e){
					System.out.println("输入错误，只能输入1~6的数字");
					System.out.println("请您重新输入");					
				}
				break;
			case 2:
				System.out.println("请输入要查询的ID号：");
				
				try{
					int id=-1;
					id=Integer.parseInt(br.readLine());
					
					UserVo getuser=uc.doFindById(id);
					if(getuser!=null){
					detailShow(getuser);
					}
					break;
				} catch(Exception e){
					System.out.println("输入错误，只能输入1~6的数字");
					System.out.println("请您重新输入");					
				}				
				break;
			case 3:
                System.out.println("请输入要查询的用户名关键字：");
				
				try{
					String name=null;
					name=br.readLine();
					List<UserVo> alluser=new ArrayList<UserVo>();
					
					alluser=uc.doFindByName(name);
			    	for(UserVo u:alluser){
			    		detailShow(u);

				} 
				}catch(Exception e){
					System.out.println("输入错误，只能输入1~6的数字");
					System.out.println("请您重新输入");					
				}	
					break;
			case 4:
				System.out.println("请输入要每页显示的条数");
				try {
					int pageSize = Integer.parseInt(br.readLine());
					System.out.println("请输入要每页显示的页码");
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
	
	public void addShow(String type){
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		if(("注册管理员").equals(type)){
			System.out.println();
		System.out.println("增加管理员界面");
		System.out.println("====================");
		System.out.println("请输入新管理员的用户名：");
		try{
			UserVo newuser=new UserVo();
			newuser.setName(br.readLine());
			System.out.println("请输入新管理员的密码：");
			newuser.setPass(br.readLine());
			while(true){
				System.out.println("请输入新管理员的邮箱：");
				String mail=br.readLine();
				if(TypeUtils.mailCheck(mail)){
					newuser.setMail(mail);
					break;				
				} else{
					System.out.println("请输入正确的邮箱格式：前面任意位数非空字符，必须带@，末尾必须有.com或者.cn");
				}
				
				
			}
			
			System.out.println("请输入新管理员的生日(yyyy-mm-dd)：");
			String birth=br.readLine();
			java.sql.Date date=TypeUtils.strToDate(birth);
			newuser.setBirth(date);
			newuser.setSuperuser(1);
			UserController uc=new UserController();
			boolean flag=uc.doRegister(newuser);
			if(flag){
				System.out.println("添加成功！！！");			
			}else{
				System.out.println("添加失败啦o(╥﹏╥)o");
			}
		} catch(Exception e){
			System.out.println("增加新管理员时出错了"+e.getMessage());
		} 
	
		}
		
	}
	
	
	public void updateShow(String type){
		UserController uc=new UserController();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		if(("修改用户权限").equals(type)){
			System.out.println();


		System.out.println("请输入要修改用户权限的ID：");
		int id=-1;
		while(true){
			try{
				id=Integer.parseInt(br.readLine());

				boolean flag=uc.doUpdateSuperuser(id);
				if(flag){
					System.out.println("修改成功！！！");			
				}else{
					System.out.println("修改失败啦o(╥﹏╥)o");
				}
				break;
			} catch(Exception e){
				System.out.println("输入错误，只能数字");
				System.out.println("请您重新输入");
				
				
			}
		
		}
		
	}
		if(("删除用户").equals(type)){
			System.out.println();
		System.out.println("删除用户界面");
		System.out.println("====================");
		System.out.println("请输入要删除的用户ID：");
		int id=-1;
		while(true){
			try{
				id=Integer.parseInt(br.readLine());

				boolean flag=uc.doDelete(id);
				if(flag){
					System.out.println("删除成功！！！");			
				}else{
					System.out.println("删除失败啦o(╥﹏╥)o");
				}
				break;
			} catch(Exception e){
				System.out.println("输入错误，只能数字");
				System.out.println("请您重新输入");
				
				
			}
		
		}
		
	}
		if (("修改个人信息".equals(type))) {
			
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
		try {
		boolean flag=false;
		System.out.println("请输入新密码：");
		
			String password=br.readLine();
			
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
		while(true){
			System.out.println("请输入您的邮箱：");
			mail=br.readLine();
			if(TypeUtils.mailCheck(mail)){

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
		try {
		boolean flag=false;
		System.out.println("请输入新用户名：");
		
			String name=br.readLine();

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
		try {
		boolean flag=false;
		System.out.println("请输入新日期(yyyy-mm-dd)：");
		String birth=br.readLine();
		java.sql.Date date=TypeUtils.strToDate(birth);

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
