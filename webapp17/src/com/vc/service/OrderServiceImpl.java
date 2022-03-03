package com.vc.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.vc.entity.Order;
import com.vc.factory.ConnectionFactory;

public class OrderServiceImpl implements IOrderService {

	private String INSERT_ORDER_QUERY="INSERT INTO CARTTB VALUES (CARTTB_SEQ.NEXTVAL, ?, ?, ?, ?)";
	private String INSERT_ORDER_REL_QUERY="INSERT INTO ORDER_CART_REL VALUES(?,?)";
	@Override
	public String add(Order order) {
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement(INSERT_ORDER_QUERY);
			pst.setInt(1, order.getCustid());
//			pst.setDouble(2, order.getTotal());
//			pst.setDate(3, new Date(order.getOdate().getTime()));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String update(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
