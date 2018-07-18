package cn.edu.teachersystem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.teachersystem.dto.RewardAndPunishDTO;
import cn.edu.teachersystem.dto.SalaryDTO;
import cn.edu.teachersystem.util.DataBasedAccess;

public class RewardAndPunishDAO {
	
	public Vector<RewardAndPunishDTO> findAllRewardAndPunishInfo(){
		Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from RewardAndPunish";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				RewardAndPunishDTO r=new RewardAndPunishDTO();				
				r.setRid(rs.getString("Rid"));				
				r.setTeacher_id(rs.getString("Teacher_id"));			
				r.setMoney(rs.getDouble("Money"));
				r.setReason(rs.getString("Reason"));
				r.setPlace(rs.getString("Place"));				
				r.setTimes(rs.getDate("Times"));
				r.setRemark(rs.getString("Remark"));
				r.seteX(rs.getInt("eX"));
				v.add(r);
				
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

	public Vector<RewardAndPunishDTO> findRewardAndPunishByTid(String tid){
		Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from RewardAndPunish where Teacher_id='"+tid+"'";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				RewardAndPunishDTO r=new RewardAndPunishDTO();				
				r.setRid(rs.getString("Rid"));				
				r.setTeacher_id(rs.getString("Teacher_id"));			
				r.setMoney(rs.getDouble("Money"));
				r.setReason(rs.getString("Reason"));
				r.setPlace(rs.getString("Place"));				
				r.setTimes(rs.getDate("Times"));
				r.setRemark(rs.getString("Remark"));
				r.seteX(rs.getInt("eX"));
				v.add(r);
				
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


	public Vector<RewardAndPunishDTO> findRewardAndPunishByDate(Date date){
		Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from RewardAndPunish where Times='"+date+"'";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				RewardAndPunishDTO r=new RewardAndPunishDTO();				
				r.setRid(rs.getString("Rid"));				
				r.setTeacher_id(rs.getString("Teacher_id"));			
				r.setMoney(rs.getDouble("Money"));
				r.setReason(rs.getString("Reason"));
				r.setPlace(rs.getString("Place"));				
				r.setTimes(rs.getDate("Times"));
				r.setRemark(rs.getString("Remark"));
				r.seteX(rs.getInt("eX"));
				v.add(r);
				
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
	
	public Vector<RewardAndPunishDTO> findRewardAndPunishByRid(String rid){
		Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from RewardAndPunish where Rid='"+rid+"'";
			rs=stat.executeQuery(sql);//处理结果集	
			while(rs.next()&&rs.getInt("eX")!=0){
				RewardAndPunishDTO r=new RewardAndPunishDTO();				
				r.setRid(rs.getString("Rid"));				
				r.setTeacher_id(rs.getString("Teacher_id"));			
				r.setMoney(rs.getDouble("Money"));
				r.setReason(rs.getString("Reason"));
				r.setPlace(rs.getString("Place"));				
				r.setTimes(rs.getDate("Times"));
				r.setRemark(rs.getString("Remark"));
				r.seteX(rs.getInt("eX"));
				v.add(r);
				
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

    public boolean deleteRewardAndPunishByRid(String rid){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		PreparedStatement prep=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		Double real=0.00;
		Double basic=0.00;
		Double total=0.00;
		String sid=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql="select * from RewardAndPunish where Rid='"+rid+"' and eX=1";
			rs=stat.executeQuery(sql);//处理结果集
			if(rs.next()){
			String tid=rs.getString("Teacher_id");
            Date Times=rs.getDate("Times");
            prep=conn.prepareStatement("update RewardAndPunish set eX=? where Rid=?");
			prep.setInt(1, 0);
			prep.setString(2, rid);
			prep.executeUpdate();
			String sql2="select sum(Money) as count_num from RewardAndPunish where year(Times)=year('"+Times+"') and month(Times)=month('"+Times+"') and Teacher_id='"+tid+"'and eX=1";
			System.out.println(sql2);
			rs2=stat.executeQuery(sql2);
			if(rs2.next()){
			real=rs2.getDouble("count_num");
			prep=conn.prepareStatement("update Salary set RewardAndPunish_count=? where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setDate(2,Times);
			prep.setDate(3,Times);
			prep.setString(4,tid);
			prep.executeUpdate();
			prep=conn.prepareStatement("select * from Salary where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");			
			prep.setDate(1,Times);
			prep.setDate(2,Times);
			prep.setString(3,tid);
			rs3=prep.executeQuery();
			if(rs3.next()){
			basic=rs3.getDouble("Salary_basic");
			sid=rs3.getString("Salary_id");
			double walfare = rs3.getDouble("Walfare");
			total=basic+real+walfare;
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,total);
			prep.setString(2,sid);
			prep.executeUpdate();		
			flag=true;
			}
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
				if(rs3!=null){
					   rs3.close();
					   rs3=null;
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

    public boolean UpdateReasonByRid(String rid,String reason){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		PreparedStatement prep=null;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("update RewardAndPunish set Reason=? where Rid=? and eX=1");
			prep.setString(1,reason);
			prep.setString(2,rid);
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

    public boolean UpdatePlaceByRid(String rid,String place){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		PreparedStatement prep=null;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("update RewardAndPunish set Place=? where Rid=? and eX=1");
			prep.setString(1,place);
			prep.setString(2,rid);
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

    
    public boolean UpdateRemarkByRid(String rid,String remark){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		PreparedStatement prep=null;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("update RewardAndPunish set Remark=? where Rid=? and eX=1");
			prep.setString(1,remark);
			prep.setString(2,rid);
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

    public boolean UpdateTimesByRid(String rid,Date times){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		PreparedStatement prep=null;
		String tid=null;
		Date   oldtime;
		Double real=0.00;
		Double real2=0.00;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("select * from RewardAndPunish where Rid=? and eX=1");
			prep.setString(1,rid);
			rs=prep.executeQuery();
			if(rs.next()){
            tid=rs.getString("Teacher_id");
            oldtime=rs.getDate("Times");
			prep=conn.prepareStatement("update RewardAndPunish set Times=? where Rid=? and eX=1");
			prep.setDate(1,times);
			prep.setString(2,rid);
			prep.executeUpdate();
			prep=conn.prepareStatement("select sum(Money) as count_num from RewardAndPunish where year(Times)=year(?) and month(Times)=month(?) and Teacher_id=? and eX=1");
			prep.setDate(1,times);
			prep.setDate(2,times);
			prep.setString(3,tid);
			rs2=prep.executeQuery();
			if(rs2.next()){
			real=rs2.getDouble("count_num");
			prep=conn.prepareStatement("select sum(Money) as count_num from RewardAndPunish where year(Times)=year(?) and month(Times)=month(?) and Teacher_id=? and eX=1");
			prep.setDate(1,oldtime);
			prep.setDate(2,oldtime);
			prep.setString(3,tid);
			rs3=prep.executeQuery();
			if(rs3.next()){
			real2=rs3.getDouble("count_num");
			prep=conn.prepareStatement("update Salary set RewardAndPunish_count=? where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setDate(2,times);
			prep.setDate(3,times);
			prep.setString(4,tid);
			prep.executeUpdate();
			prep=conn.prepareStatement("select * from Salary where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");			
			prep.setDate(1,times);
			prep.setDate(2,times);
			prep.setString(3,tid);
			rs4=prep.executeQuery();
			if(rs4.next()){
			double basic = rs4.getDouble("Salary_basic");
			double walfare = rs4.getDouble("Walfare");
			String sid = rs4.getString("Salary_id");
			double total = basic+real+walfare;
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,total);
			prep.setString(2,sid);
			prep.executeUpdate();	
			prep=conn.prepareStatement("update Salary set RewardAndPunish_count=? where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");
			prep.setDouble(1,real2);
			prep.setDate(2,oldtime);
			prep.setDate(3,oldtime);
			prep.setString(4,tid);
			prep.executeUpdate();
			prep=conn.prepareStatement("select * from Salary where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");			
			prep.setDate(1,oldtime);
			prep.setDate(2,oldtime);
			prep.setString(3,tid);
			rs5=prep.executeQuery();
			if(rs5.next()){
			basic = rs5.getDouble("Salary_basic");
			sid = rs5.getString("Salary_id");
			walfare = rs5.getDouble("Walfare");
			total = basic+real2+walfare;
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,total);
			prep.setString(2,sid);
			prep.executeUpdate();
            
			flag=true;
			}
			}
			}
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
				if(rs3!=null){
					   rs3.close();
					   rs3=null;
					}
				if(rs4!=null){
					   rs4.close();
					   rs4=null;
					}
				if(rs5!=null){
					   rs5.close();
					   rs5=null;
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

    
    public boolean UpdateMoneyByRid(String rid,Double money){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		PreparedStatement prep=null;
		String tid=null;
		Date   time;
		Double real=0.00;
		
		try {
			
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("select * from RewardAndPunish where Rid=? and eX=1");
			prep.setString(1,rid);
			rs=prep.executeQuery();
			if(rs.next()){
            tid=rs.getString("Teacher_id");
            time=rs.getDate("Times");
            prep=conn.prepareStatement("update RewardAndPunish set Money=? where Rid=? and eX=1");
			prep.setDouble(1,money);
			prep.setString(2,rid);
			prep.executeUpdate();
			prep=conn.prepareStatement("select sum(Money) as count_num from RewardAndPunish where year(Times)=year(?) and month(Times)=month(?) and Teacher_id=? and eX=1");
			prep.setDate(1,time);
			prep.setDate(2,time);
			prep.setString(3,tid);
			rs2=prep.executeQuery();
			if(rs2.next()){
			
			real=rs2.getDouble("count_num");
			prep=conn.prepareStatement("update Salary set RewardAndPunish_count=? where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setDate(2,time);
			prep.setDate(3,time);
			prep.setString(4,tid);
			prep.executeUpdate();
			prep=conn.prepareStatement("select * from Salary where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");			
			prep.setDate(1,time);
			prep.setDate(2,time);
			prep.setString(3,tid);
			rs3=prep.executeQuery();
			if(rs3.next()){
			
			double basic = rs3.getDouble("Salary_basic");
			double walfare = rs3.getDouble("Walfare");
			String sid = rs3.getString("Salary_id");
			double total = basic+real+walfare;
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,total);
			prep.setString(2,sid);
			prep.executeUpdate();	
            
			flag=true;
			}}}
			
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
				if(rs3!=null){
					   rs3.close();
					   rs3=null;
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

    public boolean addNewRewardAndPunishInfo(RewardAndPunishDTO rap){
		boolean flag=false;
		Connection conn=null;
		Statement stat=null;	
		ResultSet rs=null;
		ResultSet rs2=null;
		PreparedStatement prep=null;
		Double real=null;
		
		try {
			conn=DataBasedAccess.getConnection();
			prep=conn.prepareStatement("insert into RewardAndPunish values (?,?,?,?,?,?,?,?)");
			prep.setString(1,rap.getRid());
			prep.setString(2,rap.getTeacher_id());
			prep.setDouble(3,rap.getMoney());
			prep.setString(4,rap.getReason());		
			prep.setString(5,rap.getPlace());
			prep.setDate(6,rap.getTimes());
			prep.setString(7,rap.getRemark());
			prep.setInt(8,1);
			prep.executeUpdate();
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//创建SQL语句对象并执行
			String sql2="select sum(Money) as count_num from RewardAndPunish where year(Times)=year('"+rap.getTimes()+"') and month(Times)=month('"+rap.getTimes()+"') and Teacher_id='"+rap.getTeacher_id()+"'and eX=1";
			System.out.println(sql2);
			rs=stat.executeQuery(sql2);
			if(rs.next()){
			real=rs.getDouble("count_num");
			System.out.println(real);
			prep=conn.prepareStatement("update Salary set RewardAndPunish_count=? where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setDate(2,rap.getTimes());
			prep.setDate(3,rap.getTimes());
			prep.setString(4,rap.getTeacher_id());
			prep.executeUpdate();
			prep=conn.prepareStatement("select * from Salary  where year(IssueDate)=year(?) and month(IssueDate)=month(?) and Teacher_id=? and eX=1");
			prep.setDate(1,rap.getTimes());
			prep.setDate(2,rap.getTimes());
			prep.setString(3,rap.getTeacher_id());
			rs2=prep.executeQuery();
			if(rs2.next()){
			
			double basic = rs2.getDouble("Salary_basic");
			double walfare = rs2.getDouble("Walfare");
			String sid = rs2.getString("Salary_id");
			real=basic+walfare+real;
			prep=conn.prepareStatement("update Salary set Salary_real=? where Salary_id=? and eX=1");
			prep.setDouble(1,real);
			prep.setString(2,sid);
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
    


}
