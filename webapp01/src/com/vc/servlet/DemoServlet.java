package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServlet implements Servlet {
	static {
		System.out.println("DemoServlet.bytecode loading");
	}
    public DemoServlet() {
    	System.out.println("DemoServlet.DemoServlet()--constructor");
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("DemoServlet.init()--method called");
	}
	public void destroy() {
		System.out.println("DemoServlet.destroy()--method called");
	}
	public ServletConfig getServletConfig() {
		return null;
	}
	public String getServletInfo() {
		return null; 
	}
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>This is First Servlet</h1>");
		out.println("<hr><h1>Welcome Servlet</h1>");
	}
}
