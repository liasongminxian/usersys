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

public class Admin_AddSalaryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		        
					try {
						 String Sid=request.getParameter("Sid");
				         String Tid=request.getParameter("Tid");
				         String Walfare=request.getParameter("Walfare");
				         String Salary_basic=request.getParameter("Salary_basic");
				         String Date=request.getParameter("IssueDate");
				         SalaryDAO s=new SalaryDAO(); 
				         SalaryDTO salary=new SalaryDTO();
				         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 按发放日期查找 
				         java.util.Date date= sdf.parse(Date);
						 java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime());
						 Double walfare= Double.parseDouble(Walfare);
						 Double salary_basic= Double.parseDouble(Salary_basic);
						 boolean flag=false;
						 salary.setSalary_id(Sid);
						 salary.setTeacher_id(Tid);
						 salary.setSalary_basic(salary_basic);
						 salary.setWalfare(walfare);
						 salary.setIssueDate(sqlDate);
						 flag=s.addNewSalaryInfo(salary);
							if(flag)
								System.out.println("插入新数据成功啦");
							else
								System.out.println("插入新数据失败啦");
						  Vector<SalaryDTO> v=new Vector<SalaryDTO>();
			    	      v=s.findAllSalaryInfo();
					      HttpSession session=request.getSession();
					      session.setAttribute("allsalary", v);
					      response.sendRedirect("");

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		     
					
		         
		        
		    

		        
		    }

}
