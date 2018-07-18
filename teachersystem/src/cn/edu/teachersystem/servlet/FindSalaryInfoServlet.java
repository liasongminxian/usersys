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




import cn.edu.teachersystem.dao.SalaryDAO;
import cn.edu.teachersystem.dto.SalaryDTO;

public class FindSalaryInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
    	         Vector<SalaryDTO> v=new Vector<SalaryDTO>();
    	         SalaryDAO salary=new SalaryDAO();
		         String Salary_id = request.getParameter("Salary_id");
		         String Teacher_id=request.getParameter("Teacher_id");
		         String Date=request.getParameter("Date");
		         if(Salary_id!=null&&Salary_id!=""){
		        	 v=salary.findSalaryBySid(Salary_id);
		        	 HttpSession session=request.getSession();
		             session.setAttribute("Sid_Salary", v);
		             response.sendRedirect("");
		         }
		         if(Teacher_id!=null&&Teacher_id!=""){
		        	 v=salary.findSalaryByTid(Teacher_id);
		        	 HttpSession session=request.getSession();
		             session.setAttribute("Tid_Salary", v);
		             response.sendRedirect("");
		         }
		         if(Date!=null&&Date!=""){
		        	
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
			         	java.util.Date date;
						date = sdf.parse(Date);
						java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime());
			        	v=salary.findSalaryByDate(sqlDate); 
			        	HttpSession session=request.getSession();
			             session.setAttribute("Date_Salary", v);
			             response.sendRedirect("");
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}              // 数据类型的转换：String>java.util.Date>java.sql.Date
		         	
		         }
		        
		    }

}
