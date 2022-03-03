package com.proj1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj1.entity.User;
import com.proj1.service.CakeServiceImpl;
import com.proj1.service.ICakeService;
import com.proj1.service.IUserService;
import com.proj1.service.UserServiceImpl;

@WebServlet("/signup.do")
public class SignupServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String v_uname=(String)request.getParameter("uname");
		String v_upass=(String)request.getParameter("upass");
		String v_rupass=(String)request.getParameter("rupass");
		System.out.println(v_uname);
		System.out.println(v_upass);
		User user=new User();
		user.setUname(v_uname);
		user.setUpass(v_upass);
		user.setUrole("gen");
		PrintWriter out=response.getWriter();
		IUserService service=new UserServiceImpl();
		String status=service.addUser(user);
		if(status.equals("success")) {
			out.println("Registered...");
		}else {
			out.println("Not Registered...");
		}
		out.close();
	}

}
