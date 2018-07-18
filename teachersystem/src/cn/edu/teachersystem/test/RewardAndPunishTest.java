package cn.edu.teachersystem.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import cn.edu.teachersystem.dao.RewardAndPunishDAO;
import cn.edu.teachersystem.dto.RewardAndPunishDTO;

public class RewardAndPunishTest {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
   
		try {
//		 	Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
	    	RewardAndPunishDAO r=new RewardAndPunishDAO();
//	    	v=r.findAllRewardAndPunishInfo();
//	    	v=r.findRewardAndPunishByRid("r04");
//	    	v=r.findRewardAndPunishByTid("t01");
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
	    	java.util.Date date;                                         // 数据类型的转换：String>java.util.Date>java.sql.Date
			date = sdf.parse("2018-03-07");
		   	java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime());
//	    	v=r.findRewardAndPunishByDate(sqlDate);
//	    	for(RewardAndPunishDTO rap:v){
//		    System.out.println(rap.getRid());
//			System.out.println(rap.getTeacher_id());
//		    System.out.println(rap.getMoney());	  
//		    System.out.println(rap.getReason());
//		    System.out.println(rap.getPlace());
//		    System.out.println(rap.getTimes());
//		    System.out.println(rap.getRemark());
//		    System.out.println();
//		}
//	    	RewardAndPunishDTO rap=new RewardAndPunishDTO();
//	    	rap.setRid("r07");
//	    	rap.setTeacher_id("t01");
//	    	rap.setMoney(-200.00);
//	    	rap.setReason("吐痰");
//	    	rap.setPlace("厕所");
//	    	rap.setTimes(sqlDate);
//	    	rap.setRemark("一般违规");
		   	boolean flag=false;
			flag=r.UpdateTimesByRid("r07", sqlDate);
//			flag=r.UpdateMoneyByRid("r02", -100.00);
//
			if(flag)
			   System.out.println("更新数据成功啦");
		    else
			   System.out.println("更新数据失败啦");
		   	
//			flag=r.addNewRewardAndPunishInfo(rap);
//			if(flag)
//				System.out.println("插入新数据成功啦");
//			else
//				System.out.println("插入新数据失败啦");
//		   	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	    	
	    	
//	    	boolean flag=false;
//	    	flag=r.deleteRewardAndPunishByRid("r07");
//			if(flag)
//			   System.out.println("删除数据成功啦");
//		    else
//			   System.out.println("删除数据失败啦");
	    	
			
	    	
 
	}

}
