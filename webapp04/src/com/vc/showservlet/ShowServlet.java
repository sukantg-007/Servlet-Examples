package com.vc.showservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.entity.Emp;
import com.vc.uploadservice.UploadService;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		List<Emp> list=UploadService.getAllEmp();
		String path=getServletContext().getRealPath("/");
		Iterator<Emp> itr=list.iterator();
		PrintWriter out=response.getWriter();		
		out.println("<html><head>");
		out.println("<link rel=\"stylesheet\" href=\"css/style.css\"></head>");
		out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">");		
		out.println("<link rel='stylesheet' href='css/style.css'>");
		out.println("<div class='container-fluid border-dark'>");
		out.println("</head><body><h1 style='text-align: center;'>Employee Details </h1>");		
		out.println("<a class= 'btn btn-success mb-1' style='float:right;' href='index.html'>|Home|</a>");
		out.println("<table class=\"table table-bordered table-hover table-condensed \" border=\"2\">");
		out.println("<thead class=\"thead-dark\">");
		out.println("<tr class=\"bg-warning\">");
		out.println("<th>EID</th>");
		out.println("<th>ENAME</th>");		
		out.println("<th>EADDR</th>");
		out.println("<th>PHOTO</th>");
		out.println("<th>RESUME</th>");		
		out.println("</tr>");
		out.println("</thead><tbody>");
		while(itr.hasNext()) {
			Emp e=itr.next();
			int eid=e.getEid();
			out.println("<tr>");
			out.println("<td>"+eid+"</td>");
			out.println("<td>"+e.getEname()+"</td>");			
			out.println("<td>"+e.getEaddr()+"</td>");
			String imgName=e.getPhoto_path().substring(getServletContext().getRealPath("/resource/").length());
			out.println("<td><img class='img-thumbnail mx-auto d-block' width='60' height='60' src='./resource/"+imgName+"'><a class='m-1 btn btn-success w-100' href='./download?photoid="+eid+"'>Download</a></td>");
			out.println("<td><img class='img-thumbnail mx-auto d-block' width='60' height='60' src='./resource/resume-icon.png'><a class='m-1 btn btn-warning w-100' href='./download?resumeid="+eid+"'>Download</a></td>");	
			out.println("</tr>");			
			System.out.println();
		}
		out.println("</tbody></table></div>");		
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
