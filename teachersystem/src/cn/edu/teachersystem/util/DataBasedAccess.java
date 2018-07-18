package cn.edu.teachersystem.util;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



public class DataBasedAccess {



	    //1433是TCP端口
	    //databaseName是数据库名称
	    //user是sql管理员的登陆名（默认的sa）
	    
	    static String connectionUrl = "jdbc:sqlserver://localhost:1433;" 
	               +"databaseName=TIMS;"
	               + "user=root;"
	               + "password=123321;";
	  //注册驱动程序所需语句
	    private static Connection conn=null;
	    public static Connection getConnection(){
			
			
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//注册驱动程序
				conn=DriverManager.getConnection//获取数据库连接
						(connectionUrl);
				
				
			} catch (ClassNotFoundException e) {
			    System.out.println("mysql驱动程序找不到，请检查对应的jar包有没有加载");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("获取数据库连接时出现SQL语句错误");
				e.printStackTrace();
			} 
			
	         return conn;

		}
	            
	    //主函数
	    public static void main(String[] args) throws Exception{
	        // TODO 自动生成的方法存根

			
			
	    }

	}


