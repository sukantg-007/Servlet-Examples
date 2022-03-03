package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.entity.Employee;
import com.vc.factory.ServiceFactory;
import com.vc.service.UserService;

@WebServlet(urlPatterns = "/register",
loadOnStartup = 2)
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name").toLowerCase();
		String gen=request.getParameter("gen").toLowerCase();
		float sal=Float.parseFloat(request.getParameter("sal"));
		String qual=request.getParameter("qual").toLowerCase();
		String desg=request.getParameter("desg").toLowerCase();
		String addr=request.getParameter("addr").toLowerCase();
		
		Employee e=new Employee();
		e.setEid(id);
		e.setEname(name);
		e.setGender(gen);
		e.setEsal(sal);
		e.setQualification(qual);
		e.setDesg(desg);
		e.setEaddr(addr);
		
		UserService us=ServiceFactory.getUserService();
		String status=us.register(e);
		PrintWriter out=response.getWriter();
		if(status.equals("success")) {
			out.println("<hr><h1>Registration Successfull</h1><hr>");
			out.println("<a href=\"index.html\">Home</a>");
		}else if(status.equals("fail")) {
			out.println("<hr><h1>Registration Failed</h1><hr>");
			out.println("<a href=\"index.html\">Home</a>");
		}
	}

}
