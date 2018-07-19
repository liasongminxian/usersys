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
	 * ���ݿ�����
	 */
	private Connection conn;
	/**
	 * ���췽��
	 * @param conn ���ݿ�����
	 */
	public UserDaoImpl(Connection conn){
		
		this.conn=conn;
		
	}
	
	
	/**
	 * �û���¼ʵ����
	 * @param name �û���
	 * @param password ����
	 * @return user ��¼�û�����Ϣ		
	 */
	public UserVo login(String name, String password) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		
		try {
//			�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("select * from I_USER where NAME=? and PASS=? and STATUS=1");
//			����Ԥ��������setXXX�����������Ÿ�ֵ
		    prep.setString(1, name);
		    prep.setString(2, password);
//		       ����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
		    rs=prep.executeQuery();
//		    �����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
		    if(rs.next()){
//		    	����һ�����û����󣬸�ֵ���û��������
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
			throw new ServiceException("��¼sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return user;
	}


	
	public boolean register(UserVo newuser) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
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
		    	
//				�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
				prep=conn.prepareStatement("insert into I_USER(NAME,PASS,MAIL,BIRTH) values (?,?,?,?)");
//				����Ԥ��������setXXX�����������Ÿ�ֵ
			   
			    prep.setString(1, newuser.getName());
			    prep.setString(2, newuser.getPass());
			    prep.setString(3, newuser.getMail());
			    prep.setDate(4, newuser.getBirth());
			    
//			       ����Ԥ��������executeUpdate������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
			    prep.executeUpdate();
				
			}
		    

            flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("ע��sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	
	public UserVo findById(int id) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		
		try {
//			�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("select * from I_USER where ID=? ");
//			����Ԥ��������setXXX�����������Ÿ�ֵ
		    prep.setInt(1,id);
//		       ����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
		    rs=prep.executeQuery();

//		    �����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
		    if(rs.next()){
		    	if (rs.getInt("STATUS")==1) {
//			    	����һ�����û����󣬸�ֵ���û��������
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
		    		
		    		System.out.println(rs.getString("NAME")+"�ѱ�ɾ��");
					
				}

		    	
		    	
		    	
		    }  else{
		    	System.out.println("û�д��û�");
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("findSelf��ѯsql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return user;
		
	}


	@Override
	public boolean delete(int id) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;

		try {
//			�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("select * from I_USER where ID=? ");
//			����Ԥ��������setXXX�����������Ÿ�ֵ
		    prep.setInt(1,id);
//		       ����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
		    rs=prep.executeQuery();
		    if(rs.next()){
		    	if(rs.getInt("SUPERUSER")==1){
		    		System.out.println("���û��ǹ���Ա����û��Ȩ��ɾ����");
		    	} else {
//					�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
					prep=conn.prepareStatement("update I_USER set STATUS=0 where ID=? and SUPERUSER=2");
//					����Ԥ��������setXXX�����������Ÿ�ֵ
				   
				    prep.setInt(1,id);

			
				    prep.executeUpdate();
			
				    

		            flag=true;
					
				}

		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("ɾ��sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	@Override
	public boolean updatePassword(int id,String password) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("�û��ѱ�ɾ��");
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
					System.out.println("û�д��û�");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("�޸�����sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;

	}


	@Override
	public boolean updateMail(int id, String mail) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("�û��ѱ�ɾ��");
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
					System.out.println("û�д��û�");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("�޸�����sql������",e);
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
		
		//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;

        List<UserVo> alluser=new ArrayList<UserVo>();
//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;

//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER");
		    	rs=prep.executeQuery();
		    	while(rs.next()){
		    		user=new UserVo();
			    	user.setId(rs.getInt("ID"));
			    	user.setName(rs.getString("NAME"));
			    	user.setPass("����");
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
			throw new DaoException("��ѯ�����û�sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		

		return alluser;
	}


	@Override
	public boolean updateName(int id, String name) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("�û��ѱ�ɾ��");
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
					System.out.println("û�д��û�");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("�޸��û���sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	@Override
	public boolean updateBirth(int id, Date birth) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("STATUS")==0){
		    			System.out.println("�û��ѱ�ɾ��");
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
					System.out.println("û�д��û�");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("�޸�����sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}


	@Override
	public List<UserVo> findByName(String name) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		List<UserVo> alluser=new ArrayList<UserVo>();

		
		try {
//			�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("SELECT * FROM I_USER WHERE NAME LIKE ?");
//			����Ԥ��������setXXX�����������Ÿ�ֵ
		    prep.setString(1,"%"+name+"%");
//		       ����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
		    rs=prep.executeQuery();
            boolean flag=false;
//		    �����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
		    while(rs.next()){
		    	flag=true;
		    	if (rs.getInt("STATUS")==1) {
//			    	����һ�����û����󣬸�ֵ���û��������
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
		    		
		    		System.out.println(rs.getString("NAME")+"�ѱ�ɾ��");
					
				}

		    	
		    	
		    	
		    }  if(flag==false){
		    	System.out.println("û�к���"+name+"���û�");
		    	
		    }
		    
//	    	for(UserVo u:alluser){
//		    System.out.println(u.getId());
//			System.out.println(u.getName());
//
//		    System.out.println();
//		}
		    
		    
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("findByName��ѯsql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return alluser;
	}


	@Override
	public List<UserVo> findByPage(int pageNo, int pageSize) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		List<UserVo> alluser=new ArrayList<UserVo>();
		boolean flag=false;
		
		try {
			
			prep=conn.prepareStatement("select * from (select t2.*,rownum rn from (select t1.* from I_USER t1 order by id) t2) " +
					"where rn>? and rn<=?");
			//����Ԥ��������setXxx�����������Ÿ�ֵ
			prep.setInt(1,(pageNo-1)*pageSize);
			prep.setInt(2,pageNo*pageSize);

//		       ����Ԥ��������executeQuery������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
		    rs=prep.executeQuery();
            
//		    �����ѯ�����Ϊ�գ���ȡ��������еĸ����ֶΣ���װ���û�����ĸ���������
		    while(rs.next()){
		    	flag=true;
		    	if (rs.getInt("STATUS")==1) {
//			    	����һ�����û����󣬸�ֵ���û��������
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
		    		
		    		System.out.println(rs.getString("NAME")+"�ѱ�ɾ��");
					
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
			throw new DaoException("findByPage��ѯsql������",e);
			
//			e.printStackTrace();
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return alluser;
	}


	@Override
	public boolean updateSuperUser(int id) {
//		���������������������ڱ������ݿ��ѯ���
		ResultSet rs=null;
		boolean flag=false;

//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {

		    
		    
		    	prep=conn.prepareStatement("select * from I_USER where ID=?");
		    	prep.setInt(1, id);
		    	rs=prep.executeQuery();
		    	if(rs.next()){
		    		if(rs.getInt("SUPERUSER")==1){
		    			System.out.println("���û��ǹ���Ա���޷��޸���Ȩ��");
		    		}
		    		else if(rs.getInt("STATUS")==0){
		    			System.out.println("�û��ѱ�ɾ��");
		    		}
		    		else{
		    			prep=conn.prepareStatement("update I_USER set SUPERUSER=1 where ID=?");
		    			prep.setInt(1, id);
		    			prep.executeUpdate();
		    			flag=true;
		    		}
		    		
		    	}
		    	else {
					System.out.println("û�д��û�");
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException("�޸�Ȩ��sql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		return flag;
	}

}
