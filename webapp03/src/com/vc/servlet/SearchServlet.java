package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.entity.Employee;
import com.vc.factory.ServiceFactory;
import com.vc.service.UserService;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String colName = request.getParameter("colname");
		String searchKey = request.getParameter("searchkey").trim().toLowerCase();
		UserService us = ServiceFactory.getUserService();
		List<Employee> elist = us.getSpecificEmp(colName, searchKey);
		
		if (elist == null) {
			out.println("Record Not Available");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("./SearchEmp.html");
			rd.include(request, response);
			Iterator<Employee> itr = elist.iterator();
			out.println("<div class='container-fluid'>");
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
			while (itr.hasNext()) {
				Employee e = itr.next();
				int eid = e.getEid();
				out.println("<tr>");
				out.println("<td>" + eid + "</td>");
				out.println("<td>" + e.getEname() + "</td>");
				out.println("<td>" + e.getEsal() + "</td>");
				out.println("<td>" + e.getEaddr() + "</td>");
				out.println("<td>" + e.getGender() + "</td>");
				out.println("<td>" + e.getQualification() + "</td>");
				out.println("<td>" + e.getDesg() + "</td>");
				out.println("<td><a class=\"btn btn-success\" href=\"./update?id=" + eid + "\">Update</a></td>");
				out.println("<td><a class=\"btn btn-danger\" href=\"./delete?id=" + eid + "\">Delete</a></td>");
				out.println("</tr>");
			}			
			out.println("</tbody></table></div></body>");
			out.println("</html>");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
