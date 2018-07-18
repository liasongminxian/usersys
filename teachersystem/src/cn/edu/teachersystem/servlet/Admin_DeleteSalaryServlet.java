package cn.edu.teachersystem.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.teachersystem.dao.SalaryDAO;
import cn.edu.teachersystem.dto.SalaryDTO;

public class Admin_DeleteSalaryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		
		       
		       String Sid=request.getParameter("Sid");
		       System.out.println(Sid);
		       SalaryDAO s=new SalaryDAO();  
				boolean flag=false;
				flag=s.deleteSalaryBySid(Sid);
				if(flag)
				    System.out.println("É¾³ý³É¹¦À²");
			    else
				    System.out.println("É¾³ýÊ§°ÜÀ²");
				Vector<SalaryDTO> v=new Vector<SalaryDTO>();
    	        v=s.findAllSalaryInfo();
		        HttpSession session=request.getSession();
		        session.setAttribute("allsalary", v);
		        response.sendRedirect("");
		        
		    }


}
