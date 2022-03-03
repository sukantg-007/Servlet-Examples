package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.entity.Employee;
import com.vc.factory.ServiceFactory;
import com.vc.service.UserService;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		UserService us=ServiceFactory.getUserService();
		int count=us.getEmployeeCount();
		ArrayList<Employee> list=us.getAllEmployee(count);
		Iterator<Employee> itr=list.iterator();
		PrintWriter out=response.getWriter();		
		out.println("<html><head>");
		out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");		
		out.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
		out.println("<div class='container-fluid m-3 border-dark'>");
		out.println("</head><body><h1 style='text-align: center;'>Employee Details </h1>");
		out.println("<h2 style='float:left;'>Employee Count :"+count+"</h2>");
		out.println("<a class= 'btn btn-success mr-2' style='float:right;' href='index.html'>|Home|</a>");
		out.println("<table class=\"table table-bordered table-hover table-condensed \" border=\"2\">");
		out.println("<thead class=\"thead-dark\">");
		out.println("<tr class=\"bg-warning\">");
		out.println("<th>EID</th>");
		out.println("<th>ENAME</th>");
		out.println("<th>ESAL</th>");
		out.println("<th>EADDR</th>");
		out.println("<th>GENDER</th>");
		out.println("<th>QUALIFICAT</th>");
		out.println("<th>DESG</th>");
		out.println("<th>Action</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead><tbody>");
		while(itr.hasNext()) {
			Employee e=itr.next();
			int eid=e.getEid();
			out.println("<tr>");
			out.println("<td>"+eid+"</td>");
			out.println("<td>"+e.getEname()+"</td>");
			out.println("<td>"+e.getEsal()+"</td>");
			out.println("<td>"+e.getEaddr()+"</td>");
			out.println("<td>"+e.getGender()+"</td>");
			out.println("<td>"+e.getQualification()+"</td>");
			out.println("<td>"+e.getDesg()+"</td>");
			out.println("<td><a class=\"btn btn-success\" href=\"./update?id="+eid+"\">Update</a></td>");
			out.println("<td><a class=\"btn btn-danger\" href=\"./delete?id="+eid+"\">Delete</a></td>");
			out.println("</tr>");
		}
		out.println("</tbody></table></div></body>");
		out.println("</html>");		
	}

}
