package com.vc.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConFactory {
	
	private static String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String USER="system";
	private static String PASS="Sukantg#007";
	public static Connection getConnection()throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection(URL, USER, PASS);
		return con;
	}
}
