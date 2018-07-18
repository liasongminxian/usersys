package cn.edu.teachersystem.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.teachersystem.dao.RewardAndPunishDAO;
import cn.edu.teachersystem.dto.RewardAndPunishDTO;


public class Admin_FindAllRewardAndPunishServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
           	 	Vector<RewardAndPunishDTO> v=new Vector<RewardAndPunishDTO>();
            	RewardAndPunishDAO r=new RewardAndPunishDAO();
    	        v=r.findAllRewardAndPunishInfo();
		        HttpSession session=request.getSession();
		        session.setAttribute("allrewardAndpunish", v);
		        response.sendRedirect("");
		        
		    }

}
