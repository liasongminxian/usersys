package com.lingnan.usersys.usermgr.business.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.Connection;


import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.domain.UserVo;

public class UserDaoImplTest {
@Test

//	public void testLogin() {
//		Connection conn=null;
//		UserVo user=null;
//		conn=DBUtils.getConnection();
//		UserDaoImpl userconn=new UserDaoImpl(conn);
//		user=userconn.login("a", "aaa");
//		System.out.println(user.getId());
//		
//	}
	
//	public void testDelete() {
//	Connection conn=null;
//	boolean flag=false;
//	conn=DBUtils.getConnection();
//	UserDaoImpl userconn=new UserDaoImpl(conn);
//	flag=userconn.delete(8);
//	System.out.println(flag);
//	
//}
	
//	public void testUpdatePassword() {
//	Connection conn=null;
//	boolean flag=false;
//	conn=DBUtils.getConnection();
//	UserDaoImpl userconn=new UserDaoImpl(conn);
//	flag=userconn.updatePassword(2, "bbb");
//	System.out.println(flag);
//	
//}
	
//	public void testUpdateMail() {
//	Connection conn=null;
//	boolean flag=false;
//	conn=DBUtils.getConnection();
//	UserDaoImpl userconn=new UserDaoImpl(conn);
//	flag=userconn.updateMail(2, "bb@qq.com");
//	System.out.println(flag);
//	
//}
	
//	public void testFindAll() {
//	Connection conn=null;
//
//	conn=DBUtils.getConnection();
//	UserDaoImpl userconn=new UserDaoImpl(conn);
//	userconn.findAll();
//
//	
//}
	
//	public void testFindById() {
//		Connection conn=null;
//		UserVo user=null;
//		conn=DBUtils.getConnection();
//		UserDaoImpl userconn=new UserDaoImpl(conn);
//		user=userconn.findById(5);
//		System.out.println(user.getName());
//		
//	}

//public void testFindById() {
//Connection conn=null;
//UserVo user=null;
//conn=DBUtils.getConnection();
//UserDaoImpl userconn=new UserDaoImpl(conn);
//userconn.findByName("a");
//
//
//}

public void testFindByPage() {
Connection conn=null;
UserVo user=null;
conn=DBUtils.getConnection();
UserDaoImpl userconn=new UserDaoImpl(conn);
userconn.findByPage(3, 3);


}


	
//	public void testRegister() {
//		Connection conn=null;
//		UserVo newuser=new UserVo();
//		boolean flag=false;
//		conn=DBUtils.getConnection();
//		java.sql.Date date=TypeUtils.strToDate("1997-06-29");
//		newuser.setName("e");
//		newuser.setPass("eee");
//		newuser.setMail("e@163.com");
//		newuser.setBirth(date);
//		UserDaoImpl userconn=new UserDaoImpl(conn);
//		flag=userconn.register(newuser);
//		System.out.println(flag);
//		
//		
//	}

}
