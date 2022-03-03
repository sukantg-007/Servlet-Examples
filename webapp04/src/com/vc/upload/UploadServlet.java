package com.vc.upload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.uploadservice.UploadService;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String status="";
		try {
			MultipartFormDataRequest nreq=new MultipartFormDataRequest(request);
			String name=nreq.getParameter("name");
			String addr=nreq.getParameter("addr");
			UploadBean upb=new UploadBean();
			upb.setFolderstore(getServletContext().getRealPath("/resource"));
			upb.setOverwrite(false);
			upb.setFilesizelimit(150*1024);
			upb.store(nreq);
			//pw.println("<h1>File Uploaded Successfully</h1>");
			Vector<UploadParameters> vector=upb.getHistory();
			ArrayList<String> fileList=new ArrayList<String>();
			vector.forEach(up->{
				fileList.add(getServletContext().getRealPath("/resource/")+up.getFilename());				
			});			
			System.out.println(fileList);
			status=UploadService.empRegister(name, addr,fileList);
			RequestDispatcher rd=request.getRequestDispatcher("./index.html");
			rd.include(request, response);
			if(status.equals("success")) {
				pw.println("<div class='container'><h1 style='color:green'>Employee Registered Successfully</h1></div>");
			}else {
				pw.println("<div class='container'><h1 style='color:red'>Employee Registered Failed</h1></div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
