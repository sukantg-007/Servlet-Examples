package com.vc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//getting request data
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		//creating cookie object
		Cookie c1=new Cookie("eid", eid);
		Cookie c2=new Cookie("ename",ename);
		response.addCookie(c1);
		response.addCookie(c2);
		//forwarding req to other page
		RequestDispatcher dispatcher=request.getRequestDispatcher("./form2.html");
		dispatcher.forward(request, response);
	}

}
