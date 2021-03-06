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
		//creating session object
		HttpSession session=request.getSession();
		session.setAttribute("eid", eid);
		session.setAttribute("ename",ename);		
		//forwarding req to other page
		RequestDispatcher dispatcher=request.getRequestDispatcher(response.encodeURL("./form2.html"));
		dispatcher.forward(request, response);
	}

}
