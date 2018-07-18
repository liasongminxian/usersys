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



public class Admin_FindAllSarlaryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
    	        Vector<SalaryDTO> v=new Vector<SalaryDTO>();
    	        SalaryDAO salary=new SalaryDAO();
    	        v=salary.findAllSalaryInfo();
		        HttpSession session=request.getSession();
		        session.setAttribute("allsalary", v);
		        response.sendRedirect("");
		        
		    }

}
