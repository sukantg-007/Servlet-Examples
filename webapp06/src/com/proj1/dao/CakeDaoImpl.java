package com.proj1.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proj1.entity.Cake;
import com.proj1.entity.ContactUs;
import com.proj1.entity.Feedback;
import com.proj1.entity.Order;
import com.proj1.entity.User;
import com.proje1.factory.DbConnectionFactory;

public class CakeDaoImpl implements ICakeDAO {

	Connection con=null;
	private static String INSERT_ORDERTB_QUERY="INSERT INTO CAKE_ORDERTB VALUES (CAKE_ORDERTB_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	private static String INSERT_FEEDBACKTB_QUERY="INSERT INTO FEEDBACKTB VALUES (FEEDBACKTB_SEQ.NEXTVAL, ?,?,?)";
	private static String INSERT_CONTACTUSTB_QUERY="INSERT INTO CONTACTUSTB VALUES (CONTACTUSTB_SEQ.NEXTVAL,?,?,?,?)";
	private static String INSERT_CAKETB_QUERY="INSERT INTO CAKETB VALUES(CAKETB_SEQ.NEXTVAL,?,?,?)";
	private static String SELECT_ORDERTB_QUERY="SELECT * FROM CAKE_ORDERTB ORDER BY OID DESC";
	private static String SELECT_USERTB_QUERY="SELECT * FROM USERTB";
	private static String SELECT_FEEDBACKTB_QUERY="SELECT * FROM FEEDBACKTB ORDER BY FID DESC";
	private static String SELECT_CONTACTUSTB_QUERY="SELECT * FROM CONTACTUSTB ORDER BY CUSID DESC";
	private static String SELECT_CAKETB_QUERY="SELECT * FROM CAKETB WHERE CID=?";
	private static String SELECT_CAKETB_ALL_QUERY="SELECT * FROM CAKETB ORDER BY CID DESC";
	public CakeDaoImpl()throws Exception
	{
		con=DbConnectionFactory.getConnection();
	}
	@Override
	public String add(Order o) {
		String status="";
		try(PreparedStatement pst=con.prepareStatement(INSERT_ORDERTB_QUERY)){
			pst.setString(1,o.getCustName());
			pst.setString(2, o.getCustMob());
			pst.setDouble(3, o.getQty());
			pst.setDouble(4, o.getWeight());
			pst.setDate(5, new Date(o.getOdate().getTime()));
			pst.setString(6, o.getCustAddr());
			pst.setString(7, o.getCustMsg());
			pst.setDouble(8, o.getTotalCost());
			pst.setInt(9, o.getCake().getCid());
			status=pst.executeUpdate()>0?"success":"fail";
		}catch(Exception e) {
			status="fail";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String add(Feedback fb) {
		String status="";
		try(PreparedStatement pst=con.prepareStatement(INSERT_FEEDBACKTB_QUERY)){
			pst.setString(1,fb.getFname());
			pst.setString(2,fb.getFmobile());
			pst.setString(3, fb.getFmsg());
			status=pst.executeUpdate()>0?"success":"fail";
		}catch(Exception e) {
			status="fail";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String add(ContactUs cus) {
		String status="";
		try{PreparedStatement pst=con.prepareStatement(INSERT_CONTACTUSTB_QUERY);
			pst.setString(1,cus.getCusname());
			pst.setString(2,cus.getCusemail());
			pst.setString(3,cus.getCusmobile());
			pst.setString(4,cus.getCusmsg());
			status=pst.executeUpdate()>0?"success":"fail";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String login(User user) {
		String status="";		
		try{
			PreparedStatement pst=con.prepareStatement(SELECT_USERTB_QUERY);
			ResultSet rs=pst.executeQuery();
				if(rs.next()) {
				status=user.getUname().equalsIgnoreCase(rs.getString(3))&& user.getUpass().equals(rs.getString(4))?"success":"fail";
				}			
		}catch(Exception e) {
			status="fail";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String add(User user) {
		String status="";
		try(PreparedStatement pst=con.prepareStatement(INSERT_ORDERTB_QUERY)){
			pst.setInt(1, user.getUid());
			pst.setString(2, user.getUrole());
			pst.setString(3, user.getUname());
			pst.setString(4, user.getUpass());
			status=pst.executeUpdate()>0?"success":"fail";
		}catch(Exception e) {
			status="fail";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Cake get(Integer id) {
		Cake c=null;
		try(PreparedStatement pst=con.prepareStatement(SELECT_CAKETB_QUERY)){
			pst.setInt(1, id);
			try(ResultSet rs=pst.executeQuery()){
				if(rs.next()) {
				c=new Cake();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCimgPath(rs.getString(3));
				c.setPrise(rs.getDouble(4));
				}
			}catch(Exception e) {
				c=null;
				e.printStackTrace();
			}
		}catch(Exception e) {
			c=null;
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public List<Order> getOrder() {
		ArrayList<Order> list=new ArrayList<Order>();
		try(PreparedStatement pst=con.prepareStatement(SELECT_ORDERTB_QUERY)){
			try(ResultSet rs=pst.executeQuery()){
				while(rs.next()) {
					Order o=new Order();
					o.setOid(rs.getInt(1));
					o.setCustName(rs.getString(2));
					o.setCustMob(rs.getString(3));
					o.setQty(rs.getDouble(4));
					o.setWeight(rs.getDouble(5));
					o.setOdate(rs.getDate(6));
					o.setCustAddr(rs.getString(7));
					o.setCustMsg(rs.getString(8));
					o.setTotalCost(rs.getDouble(9));
					o.setCake(get(rs.getInt(10)));
					list.add(o);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String add(Cake cake) {
		String status="";
		try(PreparedStatement pst=con.prepareStatement(INSERT_CAKETB_QUERY)){
			pst.setString(1, cake.getCname());
			pst.setString(2, cake.getCimgPath());
			pst.setDouble(3, cake.getPrise());
			status=pst.executeUpdate()>0?"success":"fail";
		}catch(Exception e) {
			status="fail";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public List<Feedback> getFeedback() {
		ArrayList<Feedback> list=new ArrayList<Feedback>();
		try(PreparedStatement pst=con.prepareStatement(SELECT_FEEDBACKTB_QUERY)){
			try(ResultSet rs=pst.executeQuery()){
				while(rs.next()) {
					Feedback fb=new Feedback();
					fb.setFid(rs.getInt(1));
					fb.setFname(rs.getString(2));
					fb.setFmobile(rs.getString(3));
					fb.setFmsg(rs.getString(4));
					list.add(fb);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<ContactUs> getContactUs() {
		ArrayList<ContactUs> list=new ArrayList<ContactUs>();
		try(PreparedStatement pst=con.prepareStatement(SELECT_CONTACTUSTB_QUERY)){
			try(ResultSet rs=pst.executeQuery()){
				while(rs.next()) {
					ContactUs cus=new ContactUs();
					cus.setCusid(rs.getInt(1));
					cus.setCusname(rs.getString(2));
					cus.setCusemail(rs.getString(3));
					cus.setCusmobile(rs.getString(4));
					cus.setCusmsg(rs.getString(5));
					list.add(cus);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Cake> getCake() {
		ArrayList<Cake> list=new ArrayList<Cake>();
		try(PreparedStatement pst=con.prepareStatement(SELECT_CAKETB_ALL_QUERY)){
			try(ResultSet rs=pst.executeQuery()){
				while(rs.next()) {
					Cake cake=new Cake();
					cake.setCid(rs.getInt(1));
					cake.setCname(rs.getString(2));
					cake.setCimgPath(rs.getString(3));
					cake.setPrise(rs.getDouble(4));
					list.add(cake);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
