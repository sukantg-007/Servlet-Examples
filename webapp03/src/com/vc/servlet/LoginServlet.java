package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.factory.ServiceFactory;
import com.vc.service.UserService;

@WebServlet(urlPatterns = "/login",
		loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String uname=request.getParameter("user");
		String pass=request.getParameter("pass");
		UserService us=ServiceFactory.getUserService();
		String status=us.checkLogin(uname, pass);
		PrintWriter out=response.getWriter();
		if(status.equals("success")) {
			out.println("<hr><h1>Login Successfull</h1><hr>");
			out.println("<a href=\"index.html\">Home</a>");
		}else if(status.equals("fail")) {
			out.println("<hr><h1>Login Failed</h1><hr>");
			out.println("<a href=\"index.html\">Home</a>");
		}
	}

}
