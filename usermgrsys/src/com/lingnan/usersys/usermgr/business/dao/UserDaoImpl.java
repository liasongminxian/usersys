package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


	@Override
	public boolean updatePassword(int id,String password) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("用户已被删除");
		    		}
		    		else{
		    			prep=conn.prepareStatement("update I_USER set PASS=? where ID=?");
		    			prep.setString(1, password);
		    			prep.setInt(2, id);
		    			prep.executeUpdate();
		    			flag=true;
		    		}
		    		
		    	}
		    	else {
					System.out.println("没有此用户");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("修改密码sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;

	}


	@Override
	public boolean updateMail(int id, String mail) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("用户已被删除");
		    		}
		    		else{
		    			prep=conn.prepareStatement("update I_USER set MAIL=? where ID=?");
		    			prep.setString(1, mail);
		    			prep.setInt(2, id);
		    			prep.executeUpdate();
		    			flag=true;
		    		}
		    		
		    	}
		    	else {
					System.out.println("没有此用户");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("修改邮箱sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;

	}


	@Override
	public List<UserVo> findAll() {
//		List<Authority> l = q.list();  
//        
//        List l2 = null;  
//        if (l.size()!=0) {  
//              
//            l2 = new ArrayList();  
//            for(int i=0;i<l.size();i++){  
//                HashMap hm = new HashMap();  
//                hm.put("rid",""+((Authority)l.get(i)).getRid());  
//                hm.put("rname",""+((Authority)l.get(i)).getRname());  
//                l2.add(hm);  
//            }  
//        }  
//return l2; 
		
		//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;

        List<UserVo> alluser=new ArrayList<UserVo>();
//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;

//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER");
		    	rs=prep.executeQuery();
		    	while(rs.next()){
		    		user=new UserVo();
			    	user.setId(rs.getInt("ID"));
			    	user.setName(rs.getString("NAME"));
			    	user.setPass("秘密");
			    	user.setMail(rs.getString("MAIL"));
			    	user.setSuperuser(rs.getInt("SUPERUSER"));
			    	user.setStatus(rs.getInt("STATUS"));
			    	user.setBirth(rs.getDate("BIRTH"));
		    		alluser.add(user);
		    	
		    		
		    	}
		    	
//		    	for(UserVo u:alluser){
//			    System.out.println(u.getId());
//				System.out.println(u.getName());
//
//			    System.out.println();
//			}
		    	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("查询所有用户sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		

		return alluser;
	}


	@Override
	public boolean updateName(int id, String name) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("用户已被删除");
		    		}
		    		else{
		    			prep=conn.prepareStatement("update I_USER set NAME=? where ID=?");
		    			prep.setString(1, name);
		    			prep.setInt(2, id);
		    			prep.executeUpdate();
		    			flag=true;
		    		}
		    		
		    	}
		    	else {
					System.out.println("没有此用户");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("修改用户名sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	@Override
	public boolean updateBirth(int id, Date birth) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("用户已被删除");
		    		}
		    		else{
		    			prep=conn.prepareStatement("update I_USER set BIRTH=? where ID=?");
		    			prep.setDate(1, birth);
		    			prep.setInt(2, id);
		    			prep.executeUpdate();
		    			flag=true;
		    		}
		    		
		    	}
		    	else {
					System.out.println("没有此用户");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("修改生日sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	@Override
	public List<UserVo> findByName(String name) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		List<UserVo> alluser=new ArrayList<UserVo>();

		
		try {
//			调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			prep=conn.prepareStatement("SELECT * FROM I_USER WHERE NAME LIKE ?");
//			调用预编译对象的setXXX方法，给？号赋值
		    prep.setString(1,"%"+name+"%");
//		       调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
		    rs=prep.executeQuery();
            boolean flag=false;
//		    如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
		    while(rs.next()){
		    	flag=true;
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
			    	alluser.add(user);
					
				} 
		    	
		    	if (rs.getInt("STATUS")==0) {
		    		
		    		System.out.println(rs.getString("NAME")+"已被删除");
					
				}

		    	
		    	
		    	
		    }  if(flag==false){
		    	System.out.println("没有含有"+name+"的用户");
		    	
		    }
		    
//	    	for(UserVo u:alluser){
//		    System.out.println(u.getId());
//			System.out.println(u.getName());
//
//		    System.out.println();
//		}
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("findByName查询sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return alluser;
	}


	@Override
	public List<UserVo> findByPage(int pageNo, int pageSize) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		List<UserVo> alluser=new ArrayList<UserVo>();
		boolean flag=false;
		
		try {
			
			prep=conn.prepareStatement("select * from (select t2.*,rownum rn from (select t1.* from I_USER t1 order by id) t2) " +
					"where rn>? and rn<=?");
			//调用预编译对象的setXxx方法，给？号赋值
			prep.setInt(1,(pageNo-1)*pageSize);
			prep.setInt(2,pageNo*pageSize);

//		       调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
		    rs=prep.executeQuery();
            
//		    如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中
		    while(rs.next()){
		    	flag=true;
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
			    	alluser.add(user);
					
				} 
		    	
		    	if (rs.getInt("STATUS")==0) {
		    		
		    		System.out.println(rs.getString("NAME")+"已被删除");
					
				}

		    }	
		    
		    	

//		    
//	    	for(UserVo u:alluser){
//		    System.out.println(u.getId());
//			System.out.println(u.getName());
//
//		    System.out.println();
//		}
//		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("findByPage查询sql语句错误",e);
			
//			e.printStackTrace();
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return alluser;
	}


	@Override
	public boolean updateSuperUser(int id) {
//		声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs=null;
		boolean flag=false;

//		声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement prep=null;
//		声明用户对象变量，用于保存从结果集中提取出来的数据
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("SUPERUSER")==1){
		    			System.out.println("此用户是管理员，无法修改其权限");
		    		}
		    		else if(rs.getInt("STATUS")==0){
		    			System.out.println("用户已被删除");
		    		}
		    		else{
		    			prep=conn.prepareStatement("update I_USER set SUPERUSER=1 where ID=?");
		    			prep.setInt(1, id);
		    			prep.executeUpdate();
		    			flag=true;
		    		}
		    		
		    	}
		    	else {
					System.out.println("没有此用户");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("修改权限sql语句错误",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}

}
