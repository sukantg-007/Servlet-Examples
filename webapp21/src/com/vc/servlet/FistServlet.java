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
		
		PrintWriter out=response.getWriter();
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n" + 
				"        integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\r\n" + 
				"    <!-- JavaScript Bundle with Popper -->\r\n" + 
				"    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\r\n" + 
				"        integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\" crossorigin=\"anonymous\">\r\n" + 
				"    </script>");
		out.println("<div class=\"container mt-4\">\r\n" + 
				"        <h1>Employee Registration</h1>");
		out.println("<div class=\"container mt-4\">\r\n" + 
				"        <h1>Employee Registration</h1>\r\n" + 
				"        <form action=\"./second\" method=\"post\">\r\n" + 
				"            \r\n" + 
				"                <div class=\"form-group d-flex\">                    \r\n" + 
				"                    <label class=\"w-25\" for=\"exampleInputEmail1\">ESAL</label>\r\n" + 
				"                    <input type=\"number\" name=\"esal\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\"\r\n" + 
				"                        placeholder=\"Enter ESAL\">      \r\n" + 
				"                    \r\n" + 
				"                </div>\r\n" + 
				"                <div class=\"form-group d-flex\">\r\n" + 
				"                    <label class=\"w-25\" for=\"exampleInputPassword1\">EADDR</label>\r\n" + 
				"                    <textarea class=\"form-control\" name=\"eaddr\" id=\"\" rows=\"3\"></textarea>\r\n" + 
				"                </div>                \r\n" +
				"<input type='hidden' name='eid' value='"+eid+"'/>"+
				"<input type='hidden' name='ename' value='"+ename+"'/>"+
				"                <button type=\"submit\" class=\"btn btn-primary\">Next</button>\r\n" + 
				"            \r\n" + 
				"        </form>\r\n" + 
				"\r\n" + 
				"    </div>");
	}

}
