package cn.edu.teachersystem.test;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.ResultSet;

import cn.edu.teachersystem.dao.SalaryDAO;
import cn.edu.teachersystem.dto.SalaryDTO;
public class SalaryTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//    	Vector<SalaryDTO> v=new Vector<SalaryDTO>();
//    	SalaryDAO salary=new SalaryDAO();
//    	v=salary.findAllSalaryInfo();   //查询所有（管理员）
    	
//    	v=salary.findSalaryByTid("t01"); // 按教师编号查找（管理员查询，教师只能看自己）
    	
//    	v=salary.findSalaryBySid("s01"); //按薪资编号查找薪资信息
    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
    	java.util.Date date = sdf.parse("1996-07-31");              // 数据类型的转换：String>java.util.Date>java.sql.Date
    	java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime()); 
//    	v=salary.findSalaryByDate(sqlDate);  //按发放日期找对应的工资记录
    	
    	
    	
//    	for(SalaryDTO s:v){
//		    System.out.println(s.getSalary_id());
//			System.out.println(s.getTeacher_id());
//		    System.out.println(s.getSalary_basic());	  
//		    System.out.println(s.getWalfare());
//		    System.out.println(s.getRewardAndPunish_count());
//		    System.out.println(s.getSalary_real());
//		    System.out.println(s.getIssueDate());
//		    System.out.println();
//		}
    	
    	SalaryDAO s=new SalaryDAO();                 
    	SalaryDTO salary=new SalaryDTO();
		boolean flag=false;
		salary.setSalary_id("s06");
		salary.setTeacher_id("t01");
		salary.setSalary_basic(1500.00);
		salary.setWalfare(0.00);
		salary.setIssueDate(sqlDate);
		flag=s.addNewSalaryInfo(salary);     //插入新纪录的同时统计奖罚总计和计算实发工资
		if(flag)
			System.out.println("插入新数据成功啦");
		else
			System.out.println("插入新数据失败啦");
    	
    	
//    	flag=s.deleteSalaryBySid("s06");                 // 软删除一条薪资记录
//		if(flag)
//		   System.out.println("删除数据成功啦");
//	    else
//		   System.out.println("删除数据失败啦");
        

//    	flag=s.UpdateWalfareBySid("s06",100.00);   //更新薪资信息的福利项
//		flag=s.UpdateS_basicBySid("s06", 2000.03); //更新薪资信息的基本工资项
//		if(flag)
//		   System.out.println("更新数据成功啦");
//	    else
//		   System.out.println("更新数据失败啦");
	}

}
