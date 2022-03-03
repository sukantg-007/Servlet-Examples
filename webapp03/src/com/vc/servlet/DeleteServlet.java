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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserService us = ServiceFactory.getUserService();
		int id = Integer.parseInt(request.getParameter("id"));
		String status=us.deleteEmp(id);
		PrintWriter out=response.getWriter();
		if(status.equals("success")) {
			response.sendRedirect("./show");
		}else if(status.equals("fail")) {
			out.println("<hr><h1>Updation Failed</h1><hr>");
			out.println("<a href=\"index.html\">Home</a>");
		}
	}

}
