package com.proj1.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj1.entity.Cake;
import com.proj1.entity.Order;
import com.proj1.service.CakeServiceImpl;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		CakeServiceImpl service=new CakeServiceImpl();		
		String custName=request.getParameter("custName");
		String custMob=request.getParameter("custMob");
		Double qty=(double) Integer.parseInt(request.getParameter("qty"));
		Double weight=Double.parseDouble(request.getParameter("weight"));
		SimpleDateFormat format=new SimpleDateFormat("yyyy-M-d");
		Date odate=null;
		try {
		odate=format.parse(request.getParameter("odate"));
		}catch(Exception e) {e.printStackTrace();}
		String custAddr=request.getParameter("custAddr");
		String custMsg=request.getParameter("custMsg");
		Cake cake=service.getCake(Integer.parseInt(request.getParameter("cakeid")));
		Double totalCost=null;
		if(cake!=null)
			totalCost=2*qty*cake.getPrise()*weight;
		Order o=new Order();
		o.setCustName(custName);
		o.setCustMob(custMob);
		o.setQty(qty);
		o.setWeight(weight);
		o.setOdate(odate);
		o.setCustAddr(custAddr);
		o.setCustMsg(custMsg);
		o.setCake(cake);
		o.setTotalCost(totalCost);
		String status=service.addOrder(o);
		RequestDispatcher rd=null;
		if(status.equals("success")) {
			rd=request.getRequestDispatcher("./ordersuccess.html");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("./orderfail.html");
			rd.forward(request, response);
		}
		
	}

}
