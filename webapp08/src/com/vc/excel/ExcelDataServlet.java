package com.vc.excel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@WebServlet("/excel")
public class ExcelDataServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		try {
			//create workbook
			HSSFWorkbook book=new HSSFWorkbook();
			//create sheet in workbook
			HSSFSheet sheet=book.createSheet("Student Data");
			//create rows in sheet
			HSSFRow row0=sheet.createRow(0);
			//create cells and add data
			row0.createCell(0).setCellValue("Sr.No");
			row0.createCell(1).setCellValue("NAME");
			row0.createCell(2).setCellValue("MARKS");
			
			//ROW2
			HSSFRow row1=sheet.createRow(1);
			row1.createCell(0).setCellValue(101);
			row1.createCell(1).setCellValue("Sanket");
			row1.createCell(2).setCellValue(66.36);
			
			HSSFRow row2=sheet.createRow(2);
			row2.createCell(0).setCellValue(102);
			row2.createCell(1).setCellValue("Sanket");
			row2.createCell(2).setCellValue(66.36);
			
			HSSFRow row3=sheet.createRow(3);
			row3.createCell(0).setCellValue(103);
			row3.createCell(1).setCellValue("Sanket");
			row3.createCell(2).setCellValue(66.36);
			
			HSSFRow row4=sheet.createRow(4);
			row4.createCell(0).setCellValue(104);
			row4.createCell(1).setCellValue("Sanket");
			row4.createCell(2).setCellValue(66.36);
			
			//write data to servlet output stream
			book.write(response.getOutputStream());
			//close book
			book.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
