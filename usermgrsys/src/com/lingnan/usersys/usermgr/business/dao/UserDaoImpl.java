package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lingnan.usersys.common.exception.DaoException;
import com.lingnan.usersys.common.exception.ServiceException;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.domain.UserVo;

public class UserDaoImpl implements UserDao{


	/**
	 * 数据库连接
	 */
	private Connection conn;
	/**
	 * 构造方法
	 * @param conn 数据库连接
	 */
	public UserDaoImpl(Connection conn){
		
		this.conn=conn;
		
	}
	
	
	/**
	 * 用户登录实例化
	 * @param name 用户名
	 * @param password 密码
	 * @return user 登录用户的信息		
	 */
	public UserVo login(String name, String password) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		
		try {
//			调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep=conn.prepareStatement("select * from I_USER where NAME=? and PASS=? and STATUS=1");
//			调用预编译对象的setXXX方法，给？号赋值
		    prep.setString(1, name);
		    prep.setString(2, password);
//		       调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
		    rs=prep.executeQuery();
//		    如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
		    if(rs.next()){
//		    	创建一个新用户对象，赋值给用户对象变量
		    	user=new UserVo();
		    	
		    	user.setId(rs.getInt("ID"));
		    	user.setName(rs.getString("NAME"));
		    	user.setPass(rs.getString("PASS"));
		    	user.setMail(rs.getString("MAIL"));
		    	user.setSuperuser(rs.getInt("SUPERUSER"));
		    	user.setStatus(rs.getInt("STATUS"));
		    	user.setBirth(rs.getDate("BIRTH"));
		    	
		    	
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("登录sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return user;
	}


	
	public boolean register(UserVo newuser) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    if(newuser.getSuperuser()==1){
		    	prep=conn.prepareStatement("insert into I_USER(NAME,PASS,MAIL,BIRTH,SUPERUSER) values (?,?,?,?,?)");
		    	prep.setString(1, newuser.getName());
			    prep.setString(2, newuser.getPass());
			    prep.setString(3, newuser.getMail());
			    prep.setDate(4, newuser.getBirth());
			    prep.setInt(5, newuser.getSuperuser());
			    prep.executeUpdate();
		    	
		    } else {
		    	
//				调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
				prep=conn.prepareStatement("insert into I_USER(NAME,PASS,MAIL,BIRTH) values (?,?,?,?)");
//				调用预编译对象的setXXX方法，给？号赋值
			   
			    prep.setString(1, newuser.getName());
			    prep.setString(2, newuser.getPass());
			    prep.setString(3, newuser.getMail());
			    prep.setDate(4, newuser.getBirth());
			    
//			       调用预编译对象的executeUpdate方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			    prep.executeUpdate();
				
			}
		    

            flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("注册sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	
	public UserVo findById(int id) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		
		try {
//			调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep=conn.prepareStatement("select * from I_USER where ID=? ");
//			调用预编译对象的setXXX方法，给？号赋值
		    prep.setInt(1,id);
//		       调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
		    rs=prep.executeQuery();

//		    如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
		    if(rs.next()){
		    	if (rs.getInt("STATUS")==1) {
//			    	创建一个新用户对象，赋值给用户对象变量
			    	user=new UserVo();
			    	
			    	user.setId(rs.getInt("ID"));		    	
			    	user.setName(rs.getString("NAME"));
			    	user.setPass(rs.getString("PASS"));
			    	user.setMail(rs.getString("MAIL"));
			    	user.setSuperuser(rs.getInt("SUPERUSER"));
			    	user.setStatus(rs.getInt("STATUS"));
			    	user.setBirth(rs.getDate("BIRTH"));
					
				} 
		    	
		    	if (rs.getInt("STATUS")==0) {
		    		
		    		System.out.println(rs.getString("NAME")+"已被删除");
					
				}

		    	
		    	
		    	
		    }  else{
		    	System.out.println("没有此用户");
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("findSelf查询sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return user;
		
	}


	@Override
	public boolean delete(int id) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;

		try {
//			调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep=conn.prepareStatement("select * from I_USER where ID=? ");
//			调用预编译对象的setXXX方法，给？号赋值
		    prep.setInt(1,id);
//		       调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
		    rs=prep.executeQuery();
		    if(rs.next()){
		    	if(rs.getInt("SUPERUSER")==1){
		    		System.out.println("该用户是管理员，你没有权限删除。");
		    	} else {
//					调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					prep=conn.prepareStatement("update I_USER set STATUS=0 where ID=? and SUPERUSER=2");
//					调用预编译对象的setXXX方法，给？号赋值
				   
				    prep.setInt(1,id);

			
				    prep.executeUpdate();
			
				    

		            flag=true;
					
				}

		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("删除sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}

}
