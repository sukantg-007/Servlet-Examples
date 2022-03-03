package com.proj1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.proj1.entity.User;
import com.proje1.factory.DbConnectionFactory;

public class UserDaoImpl implements IUserDao {

	//queries
	private final String SELECT_USER_QUERY="SELECT * FROM USERTB WHERE USERNAME=? AND USERPASS=?";
	private final String INSERT_USER_QUERY="INSERT INTO USERTB VALUES(USERTB_SEQ.NEXTVAL,?,?,?)";
	@Override
	public String add(User user) {
		String status="fail";
		try {
			Connection con=DbConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement(INSERT_USER_QUERY);
			pst.setString(1, user.getUrole());
			pst.setString(2, user.getUname());
			pst.setString(3, user.getUpass());
			int count=pst.executeUpdate();
			if(count>0)
				status="success";			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public String check(User user) {		
		String status="fail";
		try {
			Connection con=DbConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement(SELECT_USER_QUERY);
			pst.setString(1, user.getUname().toLowerCase());
			pst.setString(2, user.getUpass());			
			ResultSet rs=pst.executeQuery();
			if(rs.next())			
				status="success";			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
