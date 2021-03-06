package com.vc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vc.entity.Product;
import com.vc.factory.ConnectionFactory;

public class ProductService implements IProductService{

	private final String INSERT_PRODUCT_QUERY="INSERT INTO PRODUCTTB VALUES (PRODUCTTB_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE_PRODUCT_QUERY="UPDATE PRODUCTTB SET PNAME=?, CATAGORY=?, PSUMMARY=?, PRICE=?, AVAILABLE=?, PIMG=? WHERE PID=?";
	private final String DELETE_PRODUC_QUERY="DELETE FROM PRODUCTTB WHERE PID=?";
	private final String SELECT_PRODUCT_QUERY="SELECT * FROM PRODUCTTB";
	@Override
	public String add(Product p) {
		String status="fail";
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement(INSERT_PRODUCT_QUERY);
			pst.setString(1, p.getPname());
			pst.setString(2,p.getCatagory());
			pst.setString(3, p.getSummary());
			pst.setDouble(4, p.getPrice());
			pst.setString(5, p.isAvailable());
			pst.setString(6, p.getPimg_path());
			int count=pst.executeUpdate();
			if(count>0)
				status="success";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String update(Product p) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
		}catch(Exception e) {
			
		}
		return status;
	}

	@Override
	public String delete(Product p) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
		}catch(Exception e) {
			
		}
		return status;
	}

	@Override
	public List<Product> showAll() {
		List<Product> list=new ArrayList<Product>();
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement(SELECT_PRODUCT_QUERY);
			ResultSet rs=pst.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Product p=new Product();
					p.setPid(rs.getInt("pid"));
					p.setPname(rs.getString("pname"));
					p.setCatagory(rs.getString("catagory"));
					p.setSummary(rs.getString("psummary"));
					p.setAvailable(rs.getString("available"));
					p.setPimg_path(rs.getString("pimg"));
					p.setPrice(rs.getDouble("price"));
					list.add(p);
				}
			}
		}catch(Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

}
