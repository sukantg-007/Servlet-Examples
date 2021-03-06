package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//getting request data
		String edesg=request.getParameter("edesg");
		String eloc=request.getParameter("eloc");
		//obtaining all cookies
		Cookie[] cookies=request.getCookies();
		
		PrintWriter out=response.getWriter();		
		out.println("<html><head>");
		out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");		
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<div class='container-fluid border-dark'>");
		out.println("</head><body><h1 style='text-align: center;'>Employee Details </h1>");		
		out.println("<a class= 'btn btn-success mb-1' style='float:right;' href='index.html'>|Home|</a>");
		out.println("<table class=\"table table-bordered table-hover table-condensed \" border=\"2\">");
		out.println("<thead class=\"thead-dark\">");
		out.println("<tr class=\"bg-warning\">");		
		out.println("<th>EID</th>");		
		out.println("<th>ENAME</th>");
		out.println("<th>ESAL</th>");
		out.println("<th>EADDR</th>");
		out.println("<th>EDESG</th>");
		out.println("<th>ELOCATION</th>");		
		out.println("</tr>");
		out.println("</thead><tbody>");		
			out.println("<tr>");
		for (int i = 0; i < cookies.length; i++) {
			out.println("<td>"+cookies[i].getValue()+"</td>");
		}			
			out.println("<td>"+edesg+"</td>");
			out.println("<td>"+eloc+"</td>");
			out.println("</tr>");
		out.println("</tbody></table></div>");		
		out.println("</html>");	
	}

}

