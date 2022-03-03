package com.vc.pdf;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/pdf")
public class DataServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf");
		try {
		//create Document object
		Document doc=new Document();
		//get writer
		PdfWriter.getInstance(doc, response.getOutputStream());
		//open doc 
		doc.open();
		//writing
		doc.add(new Paragraph("Hello Pdf"));
		
		PdfPTable t=new PdfPTable(3);
		t.addCell("Sr.No");t.addCell("Name");t.addCell("Marks");
		t.addCell("100");t.addCell("AAA");t.addCell("54.65");
		t.addCell("200");t.addCell("BBB");t.addCell("65.23");
		t.addCell("300");t.addCell("CCC");t.addCell("75.25");
		t.addCell("400");t.addCell("DDD");t.addCell("85.52");
		t.addCell("500");t.addCell("EEE");t.addCell("35.36");
		
		doc.add(t);
		
		doc.add(new Paragraph(new Date().toString()));
		//close doc
		doc.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
