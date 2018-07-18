package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
//		int i=-1;
//		����Ԥ���������������������ڽ������ݿ����������
		PreparedStatement prep=null;
//		�����û�������������ڱ���ӽ��������ȡ����������
		UserVo user=null;
		try {
//			�������Ӷ����prepareStatement�������õ�Ԥ������󣬸�ֵ��Ԥ����������
			prep=conn.prepareStatement("insert into I_USER(NAME,PASS,Mail,Birth) values (?,?,?,?)");
//			����Ԥ��������setXXX�����������Ÿ�ֵ
		   
		    prep.setString(1, newuser.getName());
		    prep.setString(2, newuser.getPass());
		    prep.setString(3, newuser.getMail());
		    prep.setDate(4, newuser.getBirth());
		    
//		       ����Ԥ��������executeUpdate������ִ�в�ѯ���������ز�ѯ�������ֵ��������������
		    prep.executeUpdate();
//		    System.out.println(i);
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
			prep=conn.prepareStatement("select * from I_USER where ID=? and STATUS=1");
//			����Ԥ��������setXXX�����������Ÿ�ֵ
		    prep.setInt(1,id);
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
		    	
		    	
		    	
		    } else if (user.getStatus()==0) {
		    	
		    	System.out.println(user.getName()+"   sorry���ѱ�����Աɾ��o(�i�n�i)o");
				
			} else{
		    	System.out.println("û�д��û�");
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceException("findSelf��ѯsql������",e);
		} finally{
			DBUtils.closeStatement(rs, prep);
			
			
		}
		
		
		// TODO Auto-generated method stub
		return user;
		
	}

}