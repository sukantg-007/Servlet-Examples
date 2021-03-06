package com.vc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.entity.Product;
import com.vc.service.ProductService;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String path = "D:/Student/Sanket/servlet/webapp17/WebContent/images";
		String msg="";
		try {
			UploadBean upb = new UploadBean();
			upb.setFolderstore(path);
			upb.setOverwrite(false);

			MultipartFormDataRequest nreq = new MultipartFormDataRequest(request);
			String pname = nreq.getParameter("pname");
			String catagory = nreq.getParameter("catagory");
			String summary = nreq.getParameter("psummary");
			String price = nreq.getParameter("price");
			String isavailable = nreq.getParameter("isavilable");
			upb.store(nreq);

			Hashtable hs = nreq.getFiles();
			Enumeration e = hs.elements();
			UploadFile f1 = (UploadFile) e.nextElement();
			String pimg_path = f1.getFileName();

			Product p = new Product();
			p.setPname(pname);
			p.setCatagory(catagory);
			p.setSummary(summary);
			p.setPrice(Double.parseDouble(price));
			p.setAvailable(isavailable);
			p.setPimg_path(pimg_path);
			ProductService service = new ProductService();
			msg = service.add(p);
			System.out.println(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}		
		if (msg.equals("success")) {
//			RequestDispatcher dispatcher  = request.getRequestDispatcher("./index.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect("./index.jsp");
		}
	}

}
