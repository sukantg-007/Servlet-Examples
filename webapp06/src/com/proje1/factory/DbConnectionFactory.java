package com.proje1.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionFactory {
	private static Connection con=null;
	private static String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String USER="system";
	private static String PASS="Sukantg#007";
	public static Connection getConnection()throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		return con=DriverManager.getConnection(URL, USER, PASS);
	}
}
