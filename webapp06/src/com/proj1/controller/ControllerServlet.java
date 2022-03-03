package com.proj1.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj1.entity.Cake;
import com.proj1.service.CakeServiceImpl;


public class ControllerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ControllerServlet.doPost()");
		String url=request.getRequestURI();
		CakeServiceImpl service=new CakeServiceImpl();
		RequestDispatcher rd=null;
		if(url.endsWith("order")) {
			rd=request.getRequestDispatcher("./order.do");
			rd.forward(request, response);
		}else if(url.endsWith("login.do")) {
			rd=request.getRequestDispatcher("./login.do");
			rd.forward(request, response);
		}else if(url.endsWith("feedback")) {
			rd=request.getRequestDispatcher("./feedback.do");
			rd.forward(request, response);
		}else if(url.endsWith("contactus")) {
			rd=request.getRequestDispatcher("./contactus.do");
			rd.forward(request, response);
		}else if(url.endsWith("add")) {
			rd=request.getRequestDispatcher("./add.do");
			rd.forward(request, response);
		}else if(url.endsWith("signup")) {
			rd=request.getRequestDispatcher("./signup.do");
			rd.forward(request, response);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
