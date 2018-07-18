package cn.edu.teachersystem.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.teachersystem.dao.RewardAndPunishDAO;
import cn.edu.teachersystem.dto.RewardAndPunishDTO;


public class Admin_UpdateRewardAndPunishServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		         String Rid=request.getParameter("Rid");
		         String Reason=new String(request.getParameter("Reason").getBytes("ISO-8859-1"),"gb2312");
		         String Place=new String(request.getParameter("Place").getBytes("ISO-8859-1"),"gb2312");
		         String Remark=new String(request.getParameter("Remark").getBytes("ISO-8859-1"),"gb2312");
		         String Times=request.getParameter("Times");
		         String Money=request.getParameter("Money");
		         RewardAndPunishDAO r=new RewardAndPunishDAO();
		         boolean flag=false;
		         if(Reason!=null&&Reason!=""){
		         	flag=r.UpdateReasonByRid(Rid,Reason);   //更新薪资信息的福利项
		     		if(flag)
		     		   System.out.println("更新数据成功啦");
		     	    else
		     		   System.out.println("更新数据失败啦");
					Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
	    	        v=r.findAllRewardAndPunishInfo();
			        HttpSession session=request.getSession();
			        session.setAttribute("allrewardAndpunish", v);
			        response.sendRedirect("");
		         
		         }
		         if(Place!=null&&Place!=""){
			         	flag=r.UpdatePlaceByRid(Rid,Place);  
			     		if(flag)
			     		   System.out.println("更新数据成功啦");
			     	    else
			     		   System.out.println("更新数据失败啦");
						Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		    	        v=r.findAllRewardAndPunishInfo();
				        HttpSession session=request.getSession();
				        session.setAttribute("allrewardAndpunish", v);
				        response.sendRedirect("");
			         
			         }
		         if(Remark!=null&&Remark!=""){
			         	flag=r.UpdateRemarkByRid(Rid,Remark);  
			     		if(flag)
			     		   System.out.println("更新数据成功啦");
			     	    else
			     		   System.out.println("更新数据失败啦");
						Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		    	        v=r.findAllRewardAndPunishInfo();
				        HttpSession session=request.getSession();
				        session.setAttribute("allrewardAndpunish", v);
				        response.sendRedirect("");
			         
			         }
		         if(Money!=null&&Money!=""){
		        	 Double money= Double.parseDouble(Money);
			     		flag=r.UpdateMoneyByRid(Rid, money); 
			     		if(flag)
				     		   System.out.println("更新数据成功啦");
				     	    else
				     		   System.out.println("更新数据失败啦");
			     		Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
		    	        v=r.findAllRewardAndPunishInfo();
				        HttpSession session=request.getSession();
				        session.setAttribute("allrewardAndpunish", v);
				        response.sendRedirect("");

			         }
		         
		         if(Times!=null&&Times!=""){
		 			try {
			        	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
				 	     java.util.Date date = sdf.parse(Times);
				 		   	java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime());
				     		flag=r.UpdateTimesByRid(Rid, sqlDate); 
				     		if(flag)
					     		   System.out.println("更新数据成功啦");
					     	    else
					     		   System.out.println("更新数据失败啦");
				     		Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
			    	        v=r.findAllRewardAndPunishInfo();
					        HttpSession session=request.getSession();
					        session.setAttribute("allrewardAndpunish", v);
					        response.sendRedirect("");

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			         }
		         
		        
		    }

}
