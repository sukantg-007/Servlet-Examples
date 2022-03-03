package com.proj1.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj1.entity.Cake;
import com.proj1.entity.Feedback;
import com.proj1.entity.Order;
import com.proj1.service.CakeServiceImpl;

@WebServlet("/feedback.do")
public class FeedbackServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		CakeServiceImpl service=new CakeServiceImpl();		
		String fname=request.getParameter("fname");
		String fmobile=request.getParameter("fmobile");		
		String fmsg=request.getParameter("fmsg");
		Feedback fb=new Feedback();
		fb.setFname(fname);
		fb.setFmobile(fmobile);
		fb.setFmsg(fmsg);
		String status=service.addFeedback(fb);
		RequestDispatcher rd=null;
		if(status.equals("success")) {
			rd=request.getRequestDispatcher("./feedbacksuccess.html");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("./feedbackfail.html");
			rd.forward(request, response);
		}
		
	}

}
