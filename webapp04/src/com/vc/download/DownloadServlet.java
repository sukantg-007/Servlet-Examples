package com.vc.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.vc.uploadservice.UploadService;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath="";
		
		int eid=0;
		if(request.getParameter("photoid")!=null) {
			eid=Integer.parseInt(request.getParameter("photoid"));
			filePath=UploadService.getRequiredResource("photo", eid);
		}else if(request.getParameter("resumeid")!=null) {
			eid=Integer.parseInt(request.getParameter("resumeid"));
			filePath=UploadService.getRequiredResource("resume", eid);
		}
		if(filePath.isEmpty()) {
			PrintWriter pw=response.getWriter();
			pw.println("<h1>Resource Not found</h1>");
		}else {
			File file=new File(filePath);
			response.setContentLengthLong(file.length());
			ServletContext sc=getServletContext();
			String mimeType=sc.getMimeType(filePath);
			mimeType=mimeType!=null?mimeType:"application/octate-stream";
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
			InputStream is=new FileInputStream(filePath);
			OutputStream os=response.getOutputStream();
			IOUtils.copy(is, os);
			is.close();
			os.close();
		}
	}

}
