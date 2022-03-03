package com.vc.httpservlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_MYUSER_QUERY="SELECT * FROM MYUSER WHERE USERNAME=? AND PASS=?";
	public Connection getConnection(String path)throws Exception {
		Connection con=null;
		FileInputStream fis=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USER=p.getProperty("user");
		String pass=p.getProperty("pwd");
		con=DriverManager.getConnection(URL, USER, pass);
		return con;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		System.out.println(new File(".").getAbsolutePath());
		try(Connection con=getConnection("./properties/oracledb.properties");
			PreparedStatement pst=con.prepareStatement(SELECT_MYUSER_QUERY);){
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				out.println("<h1>Successfully Logined</h1>");
			}
			else {
				out.println("<h1>Login Failed</h1>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
