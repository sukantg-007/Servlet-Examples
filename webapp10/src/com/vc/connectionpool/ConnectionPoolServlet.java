package com.vc.connectionpool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Consumer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.vc.entity.Emp;

@WebServlet("/connection")
public class ConnectionPoolServlet extends HttpServlet {
	private static final String SELECT_EMP_QEUERY="SELECT * FROM EMP";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ArrayList<Emp> list=new ArrayList<Emp>();
		PrintWriter out=response.getWriter();
		Consumer<Emp> show=e->out.println("<tr><td>"+e.getEid()+"</td><td>"+e.getEname()+"</td><td>"+e.getEsal()+"</td><td>"+e.getEaddr()+"</td><td>"+e.getEdoj()+"</td></tr>");		
				try {
		Context initContext=new InitialContext();
		DataSource myds=(DataSource) initContext.lookup("java:/comp/env/oracleDB");
		Connection con=myds.getConnection();
		PreparedStatement pst=con.prepareStatement(SELECT_EMP_QEUERY);
		ResultSet rs=pst.executeQuery();		
		if(rs!=null) {
			while(rs.next()) {
				Emp emp=new Emp();
				emp.setEid(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEsal(rs.getFloat(3));
				emp.setEaddr(rs.getString(4));				
				emp.setEdoj(rs.getDate(5));
				list.add(emp);
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("<html><body><table border='2' align='center'>" +
				"  <tr><th>ID</th><th>NAME</th><th>SALARY</th><th>ADDRESS</th><th>DOJ</th></tr>");
		for(Emp e: list) {
			show.accept(e);
		}
		out.println("</table></body></html>");
				
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
