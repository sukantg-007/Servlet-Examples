package com.proj1.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.proj1.entity.User;
import com.proj1.service.CakeServiceImpl;
import com.proj1.service.IUserService;
import com.proj1.service.UserServiceImpl;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		IUserService service=new UserServiceImpl();	
		String uname=request.getParameter("name");
		String upass=request.getParameter("pass");
		
		User user=new User();
		user.setUname(uname);
		user.setUpass(upass);
		String status=service.loginUser(user);
		JSONObject obj = new JSONObject();
		if(status.equals("success")) {
			HttpSession session=request.getSession();
			session.setAttribute("name", uname);
			//session.invalidate();
			try {
			obj.put("status", "success");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			try {
				obj.put("status", "fail");
				}catch(Exception e) {
					e.printStackTrace();
				}
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(obj.toString());
	}

}
