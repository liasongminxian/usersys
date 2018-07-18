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


public class FindRewardAndPunishServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
	 	         Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
    	         RewardAndPunishDAO r=new RewardAndPunishDAO();
		         String Rid = request.getParameter("Rid");
		         String Teacher_id=request.getParameter("Teacher_id");
		         String Date=request.getParameter("Date");
		         if(Rid!=null&&Rid!=""){
		        	 v=r.findRewardAndPunishByRid(Rid);
		        	 HttpSession session=request.getSession();
		             session.setAttribute("Rid_RewardAndPunish", v);
		             response.sendRedirect("");
		         }
		         if(Teacher_id!=null&&Teacher_id!=""){
		        	 v=r.findRewardAndPunishByTid(Teacher_id);
		        	 HttpSession session=request.getSession();
		             session.setAttribute("Tid_RewardAndPunish", v);
		             response.sendRedirect("");
		         }
		         if(Date!=null&&Date!=""){
		        	
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
			         	java.util.Date date;
						date = sdf.parse(Date);
						java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime());
			        	v=r.findRewardAndPunishByDate(sqlDate); 
			        	HttpSession session=request.getSession();
			             session.setAttribute("Date_RewardAndPunish", v);
			             response.sendRedirect("");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}              // 数据类型的转换：String>java.util.Date>java.sql.Date
		         	
		         }
		        
		    }


}
