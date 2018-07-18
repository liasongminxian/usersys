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

public class Admin_AddRewardAndPunishServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		        
					try {
						 String Rid=request.getParameter("Sid");
				         String Tid=request.getParameter("Tid");
				         String Money=request.getParameter("Money");
				         String Reason=new String(request.getParameter("Reason").getBytes("ISO-8859-1"),"gb2312");
				         String Place=new String(request.getParameter("Place").getBytes("ISO-8859-1"),"gb2312");
				         String Times=request.getParameter("Times");
				         String Remark=new String(request.getParameter("Remark").getBytes("ISO-8859-1"),"gb2312");

				         RewardAndPunishDAO r=new RewardAndPunishDAO();
				         RewardAndPunishDTO rap=new RewardAndPunishDTO();
				         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
				         java.util.Date date= sdf.parse(Times);
						 java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime());
						 Double money= Double.parseDouble(Money);
						 boolean flag=false;
					    	rap.setRid(Rid);
					    	rap.setTeacher_id(Tid);
					    	rap.setMoney(money);
					    	rap.setReason(Reason);
					    	rap.setPlace(Place);
					    	rap.setTimes(sqlDate);
					    	rap.setRemark(Remark);
					
					    	flag=r.addNewRewardAndPunishInfo(rap);
							if(flag)
								System.out.println("插入新数据成功啦");
							else
								System.out.println("插入新数据失败啦");
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
