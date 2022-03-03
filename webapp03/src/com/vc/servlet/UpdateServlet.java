package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.entity.Employee;
import com.vc.factory.ServiceFactory;
import com.vc.service.UserService;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		UserService us = ServiceFactory.getUserService();
		int id = Integer.parseInt(request.getParameter("id"));
		Employee e = us.getEmployee(id);
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
		out.println(
				"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");
		out.println("</head><body><div class='container-fluid'><h1>Employee Details </h1>");
		
		out.println("<table class=\"table table-bordered%\" border=\"5\">");
		out.println("<tbody>");
		out.println("<form action=\"./save\" method=\"post\"");
		out.println("<tr>");
		out.println("<td>EID</td><td><input type=\"number\" class=\"text-dark\" name=\"id\" value=\"" + e.getEid() + "\" readonly></input></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ENAME</td><td><input type=\"text\" name=\"name\" value=\"" + e.getEname() + "\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ESAL</td><td><input type=\"number\" name=\"sal\" value=\"" + e.getEsal() + "\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>EADDR</td><td><input type=\"text\" name=\"addr\" value=\"" + e.getEaddr() + "\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>GENDER</td><td><input type=\"text\" name=\"gen\" value=\"" + e.getGender() + "\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>QUALIFICAT</td><td><input type=\"text\" name=\"qual\" value=\"" + e.getQualification() + "\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>DESG</td><td><input type=\"text\" name=\"desg\" value=\""+ e.getDesg() + "\"></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><button type=\"submit\" class=\"btn btn-success\" style=\"float: right;\">Update</button></td>" + 
				"<td><a class=\"btn btn-danger\" href=\"./show\">Cancel</a></td>");
		out.println("</tr>");
		out.println("</form>");
		out.println("</tbody></table></div></body>");
		out.println("</html>");
	}
}
