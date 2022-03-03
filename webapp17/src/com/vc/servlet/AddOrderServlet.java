package com.vc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vc.entity.Order;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		String result = request.getParameter("json");
		System.out.println(result);		
		request.setAttribute("result", result);
		response.sendRedirect("./checkout.jsp");
		ObjectMapper om=new ObjectMapper();
		Order o=om.readValue(result, Order.class);
		
	}

}
