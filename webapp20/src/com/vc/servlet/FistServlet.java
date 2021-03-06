package com.vc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//getting request data
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String esal = request.getParameter("esal");
		String eaddr = request.getParameter("eaddr");
		//creating session object
		HttpSession session=request.getSession();
		session.setAttribute("eid", eid);
		session.setAttribute("ename",ename);	
		session.setAttribute("esal", esal);
		session.setAttribute("eaddr", eaddr);
		//forwarding req to other page
		//response.sendRedirect(response.encodeURL("./display.html"));
//		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(response.encodeURL("/form2.html"));
//		dispatcher.forward(request, response);
		PrintWriter out=response.getWriter();
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n" + 
				"        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n" + 
				"    <!-- JavaScript Bundle with Popper -->\r\n" + 
				"    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\r\n" + 
				"        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\">\r\n" + 
				"    </script>");
		out.println("<div class=\"container mt-4\">\r\n" + 
				"        <h1>Employee Registration</h1>");
		out.println("<form action='./display;JSESSIONID="+session.getId()+"' method='post'>\r\n" +
				"            \r\n" + 
				"                <div class=\"form-group d-flex\">                    \r\n" + 
				"                    <label class=\"w-25\" for=\"exampleInputEmail1\">EDESG</label>\r\n" + 
				"                    <input type=\"text\" name=\"edesg\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\"\r\n" + 
				"                        placeholder=\"Enter EID\">      \r\n" + 
				"                    \r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-group d-flex\">\r\n" + 
				"                    <label class=\"w-25\" for=\"exampleInputPassword1\">ELOCATION</label>\r\n" + 
				"                    <input type=\"text\" name=\"eloc\" class=\"form-control\" id=\"exampleInputPassword1\" placeholder=\"Enter Ename\">\r\n" + 
				"                </div>                \r\n" + 
				"                <button type=\"submit\" class=\"btn btn-primary\">Display</button>\r\n" + 
				"            \r\n" + 
				"        </form>");
	}

}
