package com.vc.uploadservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vc.entity.Emp;

public class UploadService {
	static Connection con;
	private static final String INSERT_NEW_EMP_QUERY = "INSERT INTO NEW_EMP VALUES(NEW_EMP_SEQUENCE.NEXTVAL,?,?,?,?)";
	private static final String SELECT_NEW_EMP_QUERY = "SELECT * FROM NEW_EMP ORDER BY EID";
	private static final String SELECT_NEW_EMP_PHOTO_QUERY = "SELECT PHOTO_PATH FROM NEW_EMP WHERE EID=?";
	private static final String SELECT_NEW_EMP_RESUME_QUERY = "SELECT RESUME_PATH FROM NEW_EMP WHERE EID=?";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "system";
	private static final String PASS = "Sukantg#007";

	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String empRegister(String name, String addr, ArrayList<String> fileList) {
		String status = "";
		try (PreparedStatement pst = con.prepareStatement(INSERT_NEW_EMP_QUERY)) {
			pst.setString(1, name);
			pst.setString(2, addr);
			pst.setString(3, fileList.get(0));
			pst.setString(4, fileList.get(1));
			int count = pst.executeUpdate();
			status = count > 0 ? "success" : "fail";
		} catch (Exception e) {
			status = "fail";
			e.printStackTrace();
		}
		return status;
	}

	public static ArrayList<Emp> getAllEmp() {
		ArrayList<Emp> list = new ArrayList<>();
		try (PreparedStatement pst = con.prepareStatement(SELECT_NEW_EMP_QUERY)) {
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Emp e = new Emp();
					e.setEid(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setEaddr(rs.getString(3));
					e.setPhoto_path(rs.getString(4));
					e.setResume_path(rs.getString(5));
					list.add(e);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}
	
	public static String getRequiredResource(String path, int pathId) {
		String resourcePath="";
		String 	QUERY="";
		if(path.equals("photo"))
			QUERY=SELECT_NEW_EMP_PHOTO_QUERY;
		else if(path.equals("resume"))
			QUERY=SELECT_NEW_EMP_RESUME_QUERY;
		try (PreparedStatement pst = con.prepareStatement(QUERY)) {
			pst.setInt(1, pathId);
			try (ResultSet rs = pst.executeQuery()) {
				if(rs.next()) {										
					resourcePath=rs.getString(1);
				}
			} catch (Exception e) {
				resourcePath="";
				e.printStackTrace();
			}
		} catch (Exception e1) {
			resourcePath="";
			e1.printStackTrace();
		}
		return resourcePath;
	}
}
