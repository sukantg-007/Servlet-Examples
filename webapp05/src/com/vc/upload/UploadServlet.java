package com.vc.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.uploadservice.UploadService;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//String path=getServletContext().getRealPath("/WebContent/uploadedImg");
		//File fileSaveDir=new File(path);
		String path="D:\\Student\\Sanket\\servlet\\webapp05\\WebContent\\image";
		System.out.println(path);
		/*
		 * if(!fileSaveDir.exists()){ fileSaveDir.mkdir(); }
		 */		
		try {
			UploadBean upb=new UploadBean();			
			upb.setFolderstore(path);
			upb.setOverwrite(false);
			
			MultipartFormDataRequest nreq=new MultipartFormDataRequest(request);
			String name=nreq.getParameter("name");
			String addr=nreq.getParameter("addr");
			upb.store(nreq);
			out.println("<h2>Photo and Resume Uploaded...Name : "+name+"</h2>");
			
			Hashtable hs=nreq.getFiles();			
			Enumeration e=hs.elements();
			ArrayList<String> list=new ArrayList<String>();
			while(e.hasMoreElements()) {
				UploadFile f1=(UploadFile) e.nextElement();				
				list.add(path+File.separator+f1.getFileName());
			}
			String status=UploadService.empRegister(name, addr, list);
			if(status.equals("success"))
				out.println("<h2>Successfully Stored</h2>");
			else
				out.println("<h2>Fail to Stored</h2>");
			
			RequestDispatcher rd=request.getRequestDispatcher("./index.html");
			rd.include(request, response);
			
		} catch (Exception e) {
			out.println(e);
			e.printStackTrace();
		}
	}

}
