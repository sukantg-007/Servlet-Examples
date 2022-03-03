package com.proj1.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj1.entity.ContactUs;
import com.proj1.entity.Feedback;
import com.proj1.service.CakeServiceImpl;

@WebServlet("/contactus.do")
public class ContactusServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		CakeServiceImpl service=new CakeServiceImpl();		
		String cusname=request.getParameter("cusname");
		String cusemail=request.getParameter("cusemail");
		String cusmobile=request.getParameter("cusmobile");		
		String cusmsg=request.getParameter("cusmsg");
		ContactUs cus=new ContactUs();
		cus.setCusname(cusname);
		cus.setCusemail(cusemail);
		cus.setCusmobile(cusmobile);
		cus.setCusmsg(cusmsg);
		String status=service.addContact(cus);
		RequestDispatcher rd=null;
		if(status.equals("success")) {
			rd=request.getRequestDispatcher("./contactussuccess.html");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("./contactusfail.html");
			rd.forward(request, response);
		}
	}

}
