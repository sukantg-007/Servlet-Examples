package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");		
		String sfno=request.getParameter("fno");
		String ssno=request.getParameter("sno");
		PrintWriter out=response.getWriter();
		int fno=Integer.parseInt(sfno);
		int sno=Integer.parseInt(ssno);
		out.println("Division : "+(fno/sno));		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
