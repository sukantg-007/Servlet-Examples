package com.vc.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String USER="system";
	private static String PASS="Sukantg#007";
	private static String CLASS_NAME="oracle.jdbc.OracleDriver";
	
	public static Connection getConnection()throws Exception
	{
		Class.forName(CLASS_NAME);
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
