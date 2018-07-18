package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * ���ݿ⹤����
 * @author Administrator
 *
 */
public class DBUtils {
	
	/**
	 * ��ȡ���ݿ�����
	 * @return Connection conn
	 */
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
//			��������
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="scott";
			String password="123456";
//			��ȡ���ݿ����Ӷ���
			
				conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("oracle���������Ҳ����������Ӧ��jar����û�м���");
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ���ݿ�����ʱ����SQL������");
			e.printStackTrace();
		}
		
		
		
		return conn;
	}
	
	/**
	 * ��������
	 * @param conn
	 */
	
	public static void beginTransaction(Connection conn){
		
		try {
//			��������Զ��ύģʽ��Ϊ��
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("������ʧ��");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �ύ����
	 * @param conn
	 */
	
	public static void commit(Connection conn){
		try {
//			�ύ����
			conn.commit();
//			��������Զ��ύģʽ��Ϊ��
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�����ύʧ��");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �ع�����
	 * @param conn
	 */
	
	
	public static void rollback(Connection conn){
		try {
//			�ع�����
			conn.rollback();
//			��������Զ��ύģʽ��Ϊ��
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ع�ʧ��");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * �ر�����
	 * @param conn
	 */
	
		public static void closeConnection(Connection conn){
			try {
//				����������Ӷ���Ϊ�գ��رոö���
			if(conn!=null){
				
					conn.close();
				} 
			}catch (SQLException e) {
					// TODO Auto-generated catch block
				System.out.println("�ر����Ӷ���ʧ��");
					e.printStackTrace();
				}
			
			
		}
		
		/**
		 * �ر�statement
		 * @param rs
		 * @param stmt
		 */
		
		public static void closeStatement(ResultSet rs,Statement stmt){
			try {
//				�����ѯ���������Ϊ�գ��رոö���
			if(rs!=null){
				
					rs.close();
				} 
//			�����������Ϊ�գ��رոö���
			if(stmt!=null){
				stmt.close();
			}
			
			}catch (SQLException e) {
					// TODO Auto-generated catch block
				System.out.println("�رղ�ѯ���������������ʧ��");
					e.printStackTrace();
				}
			
			
		}
		
		

}
