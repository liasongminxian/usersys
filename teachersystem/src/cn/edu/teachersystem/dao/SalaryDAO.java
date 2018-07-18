package cn.edu.teachersystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import cn.edu.teachersystem.dto.SalaryDTO;
import cn.edu.teachersystem.util.DataBasedAccess;

public class SalaryDAO {
	public Vector<SalaryDTO> findAllSalaryInfo(){
		Vector<SalaryDTO> v=new Vector<SalaryDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from Salary";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				SalaryDTO s=new SalaryDTO();				
				s.setSalary_id(rs.getString("Salary_id"));				
				s.setTeacher_id(rs.getString("Teacher_id"));			
				s.setSalary_basic(rs.getDouble("Salary_basic"));
				s.setWalfare(rs.getDouble("Walfare"));
				s.setRewardAndPunish_count(rs.getDouble("RewardAndPunish_count"));
				s.setSalary_real(rs.getDouble("Salary_real"));
				s.setIssueDate(rs.getDate("IssueDate"));
				s.seteX(rs.getInt("eX"));
				v.add(s);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
				   rs.close();
				   rs=null;
				}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return v;
	
	}	
	

	public Vector<SalaryDTO> findSalaryByTid(String tid){
		Vector<SalaryDTO> v=new Vector<SalaryDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from Salary where Teacher_id='"+tid+"'";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				SalaryDTO s=new SalaryDTO();				
				s.setSalary_id(rs.getString("Salary_id"));				
				s.setTeacher_id(rs.getString("Teacher_id"));			
				s.setSalary_basic(rs.getDouble("Salary_basic"));
				s.setWalfare(rs.getDouble("Walfare"));
				s.setRewardAndPunish_count(rs.getDouble("RewardAndPunish_count"));
				s.setSalary_real(rs.getDouble("Salary_real"));
				s.setIssueDate(rs.getDate("IssueDate"));
				s.seteX(rs.getInt("eX"));
				v.add(s);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
				   rs.close();
				   rs=null;
				}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return v;
	
	}	



	public Vector<SalaryDTO> findSalaryByDate(Date date){
		Vector<SalaryDTO> v=new Vector<SalaryDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from Salary where IssueDate='"+date+"'";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				SalaryDTO s=new SalaryDTO();				
				s.setSalary_id(rs.getString("Salary_id"));				
				s.setTeacher_id(rs.getString("Teacher_id"));			
				s.setSalary_basic(rs.getDouble("Salary_basic"));
				s.setWalfare(rs.getDouble("Walfare"));
				s.setRewardAndPunish_count(rs.getDouble("RewardAndPunish_count"));
				s.setSalary_real(rs.getDouble("Salary_real"));
				s.setIssueDate(rs.getDate("IssueDate"));
				s.seteX(rs.getInt("eX"));
				v.add(s);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
				   rs.close();
				   rs=null;
				}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return v;
	
	}	

	
	public Vector<SalaryDTO> findSalaryBySid(String sid){
		Vector<SalaryDTO> v=new Vector<SalaryDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from Salary where Salary_id='"+sid+"'";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				SalaryDTO s=new SalaryDTO();				
				s.setSalary_id(rs.getString("Salary_id"));				
				s.setTeacher_id(rs.getString("Teacher_id"));			
				s.setSalary_basic(rs.getDouble("Salary_basic"));
				s.setWalfare(rs.getDouble("Walfare"));
				s.setRewardAndPunish_count(rs.getDouble("RewardAndPunish_count"));
				s.setSalary_real(rs.getDouble("Salary_real"));
				s.setIssueDate(rs.getDate("IssueDate"));
				s.seteX(rs.getInt("eX"));
				v.add(s);
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
				   rs.close();
				   rs=null;
				}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return v;
	
	}	

	public String findTidByTname(String tname){
		
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String tid=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from Teacher where Teacher_id='"+tname+"' and eX=1";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
								
				tid=rs.getString("Teacher_id");				
				
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
				   rs.close();
				   rs=null;
				}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return tid;
	
	}	

	public boolean deleteSalaryBySid(String sid){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		PreparedStatement prep=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("update Salary set eX=? where Salary_id=?");
			prep.setInt(1, 0);
			prep.setString(2, sid);
			prep.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					   rs.close();
					   rs=null;
					}
				if(prep!=null){
					   prep.close();
					   prep=null;
					}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return flag;
	}

	public boolean addNewSalaryInfo(SalaryDTO salary){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		ResultSet rs2=null;
		PreparedStatement prep=null;
		Double real=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("insert into Salary(Salary_id,Teacher_id,Salary_basic,Walfare,IssueDate,ex) values (?,?,?,?,?,?)");
			prep.setString(1,salary.getSalary_id());
			prep.setString(2,salary.getTeacher_id());
			prep.setDouble(3,salary.getSalary_basic());
			prep.setDouble(4,salary.getWalfare());		
			prep.setDate(5,salary.getIssueDate());
			prep.setInt(6,1);
			prep.executeUpdate();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from Salary where Salary_id='"+salary.getSalary_id()+"' and eX=1";
			rs=stat.executeQuery(sql);//处理结果集
			if(rs.next()){
				
            Date IssueDate=rs.getDate("IssueDate");
			String sql2="select sum(Money) as count_num from RewardAndPunish where year(Times)=year('"+IssueDate+"') and month(Times)=month('"+IssueDate+"') and Teacher_id='"+salary.getTeacher_id()+"'and eX=1";
			System.out.println(sql2);
			rs2=stat.executeQuery(sql2);
			if(rs2.next()){
			
			real=rs2.getDouble("count_num");
			prep=conn.prepareStatement("update Salary set RewardAndPunish_count=? where Salary_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setString(2,salary.getSalary_id());
			prep.executeUpdate();
			
			
			
			
//			select year(IssueDate) 年,
//			month(IssueDate) 月,
//			sum(Salary_basic) 销售合计 
//			from Salary 
//			group by year(IssueDate)='1995',
//			month(IssueDate)
			
			
			real=salary.getSalary_basic()+salary.getWalfare()+real;
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setString(2,salary.getSalary_id());
			prep.executeUpdate();
			flag=true;
			}
			}
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					   rs.close();
					   rs=null;
					}
				if(rs2!=null){
					   rs2.close();
					   rs2=null;
					}
				if(prep!=null){
					   prep.close();
					   prep=null;
					}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return flag;
	}

	
	public boolean UpdateWalfareBySid(String sid,Double walfare){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		PreparedStatement prep=null;
		Double price=0.00;
		Double num=0.00;
		Double real=0.00;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("select * from Salary where Salary_id=? and eX=1");
			prep.setString(1,sid);
			rs=prep.executeQuery();
			if(rs.next()){
			
			price=rs.getDouble("Walfare");
			real=rs.getDouble("Salary_real");
			num=walfare-price;
			real=num+real;
			prep=conn.prepareStatement("update Salary set Walfare=? where Salary_id=? and eX=1");
			prep.setDouble(1,walfare);
			prep.setString(2,sid);
			prep.executeUpdate();
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setString(2,sid);
			prep.executeUpdate();
			flag=true;
			}
			
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					   rs.close();
					   rs=null;
					}
				if(prep!=null){
					   prep.close();
					   prep=null;
					}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return flag;
	}

	
	public boolean UpdateS_basicBySid(String sid,Double basic){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		PreparedStatement prep=null;
		Double price=0.00;
		Double num=0.00;
		Double real=0.00;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("select * from Salary where Salary_id=? and eX=1");
			prep.setString(1,sid);
			rs=prep.executeQuery();
			if(rs.next()){
			
			price=rs.getDouble("Salary_basic");
			real=rs.getDouble("Salary_real");
			num=basic-price;
			real=num+real;
			prep=conn.prepareStatement("update Salary set Salary_basic=? where Salary_id=? and eX=1");
			prep.setDouble(1,basic);
			prep.setString(2,sid);
			prep.executeUpdate();
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setString(2,sid);
			prep.executeUpdate();
			flag=true;
			}
		} catch (SQLException e) {
			System.out.println("运行SQL语句时出现错误");
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					   rs.close();
					   rs=null;
					}
				if(prep!=null){
					   prep.close();
					   prep=null;
					}
				if(stat!=null){
				   stat.close();
				   stat=null;
				}
				if(conn!=null){
			       conn.close();
			       conn=null;
				}
			} catch (SQLException e) {
				System.out.println("关闭连接、语句及结果集时出现错误");
				e.printStackTrace();
			}
			
		}
		
         return flag;
	}
	
}


