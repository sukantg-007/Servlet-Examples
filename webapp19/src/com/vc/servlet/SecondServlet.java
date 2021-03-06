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

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// getting request data
		String esal = request.getParameter("esal");
		String eaddr = request.getParameter("eaddr");
		// creating cookie object
		Cookie c3 = new Cookie("esal", esal);
		Cookie c4 = new Cookie("eaddr", eaddr);
		c3.setMaxAge(60);
		c4.setMaxAge(60);
		response.addCookie(c3);
		response.addCookie(c4);
		// forwarding req to other page
		RequestDispatcher dispatcher = request.getRequestDispatcher("./display.html");
		dispatcher.forward(request, response);
	}

}
