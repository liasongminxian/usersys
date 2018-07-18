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

public class Admin_UpdateSalaryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException
		    {
		         String Sid=request.getParameter("Sid");
		         String Walfare=request.getParameter("Walfare");
		         String Salary_basic=request.getParameter("Salary_basic");
		         SalaryDAO s=new SalaryDAO(); 
		         boolean flag=false;
		         if(Walfare!=null&&Walfare!=""){
		             Double walfare= Double.parseDouble(Walfare);
		         	flag=s.UpdateWalfareBySid(Sid,walfare);   //更新薪资信息的福利项
		     		if(flag)
		     		   System.out.println("更新数据成功啦");
		     	    else
		     		   System.out.println("更新数据失败啦");
					Vector<SalaryDTO> v=new Vector<SalaryDTO>();
	    	        v=s.findAllSalaryInfo();
			        HttpSession session=request.getSession();
			        session.setAttribute("allsalary", v);
			        response.sendRedirect("");
		         
		         }
		         if(Walfare!=null&&Walfare!=""){
		        	 Double salary_basic= Double.parseDouble(Salary_basic);
			     		flag=s.UpdateS_basicBySid(Sid, salary_basic); //更新薪资信息的基本工资项
			     		if(flag)
				     		   System.out.println("更新数据成功啦");
				     	    else
				     		   System.out.println("更新数据失败啦");
						Vector<SalaryDTO> v=new Vector<SalaryDTO>();
		    	        v=s.findAllSalaryInfo();
				        HttpSession session=request.getSession();
				        session.setAttribute("allsalary", v);
				        response.sendRedirect("");

			         }
		         
		        
		    }

}
