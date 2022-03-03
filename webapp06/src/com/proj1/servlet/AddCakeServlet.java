package com.proj1.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.proj1.entity.Cake;
import com.proj1.service.CakeServiceImpl;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/add.do")
public class AddCakeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String path="D:\\Student\\Sanket\\servlet\\webapp06\\WebContent\\cakeimage";
		CakeServiceImpl service=new CakeServiceImpl();
		RequestDispatcher rd=null;
		try {
			UploadBean upb=new UploadBean();			
			upb.setFolderstore(path);
			upb.setOverwrite(false);
			
			MultipartFormDataRequest nreq=new MultipartFormDataRequest(request);
			String cname=nreq.getParameter("cname");				
			Double prise=Double.parseDouble(nreq.getParameter("prise"));
			upb.store(nreq);
			String cimg_path="";
			Hashtable hs=nreq.getFiles();			
			Enumeration e=hs.elements();			
			if(e.hasMoreElements()) {
				UploadFile f1=(UploadFile) e.nextElement();				
				cimg_path=path+File.separator+f1.getFileName();
			}

			Cake cake=new Cake();
			cake.setCname(cname);
			cake.setCimgPath(cimg_path);
			cake.setPrise(prise);
			String status=service.addCake(cake);
			
			if(status.equals("success")) {
				rd=request.getRequestDispatcher("./addCakesuccess.html");
				rd.forward(request, response);
			}else {
				
			}	
		} catch (Exception e) {	
			rd=request.getRequestDispatcher("./addCakefail.html");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
	}

}
