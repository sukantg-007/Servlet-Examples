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
		// creating HttpSession obje
		HttpSession session=request.getSession(false);
		session.setAttribute("esal", esal);
		session.setAttribute("eaddr", eaddr);		
		// forwarding req to other page
		RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("./display.html"));
		dispatcher.forward(request, response);
	}

}
