package com.proj1.service;


import java.util.List;

import com.proj1.dao.ICakeDAO;
import com.proj1.dao.CakeDaoImpl;
import com.proj1.entity.Cake;
import com.proj1.entity.ContactUs;
import com.proj1.entity.Feedback;
import com.proj1.entity.Order;
import com.proj1.entity.User;

public class CakeServiceImpl implements ICakeService {
	ICakeDAO cakeDao=null;
	public CakeServiceImpl() {
		try{
			cakeDao=new CakeDaoImpl();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String addOrder(Order o) {
		String status=cakeDao.add(o);
		return status;
	}

	@Override
	public String addFeedback(Feedback fb) {
		String status=cakeDao.add(fb);
		return status;
	}

	@Override
	public String addContact(ContactUs cus) {
		String status=cakeDao.add(cus);
		return status;
	}

	@Override
	public String addUser(User user) {
		String status=cakeDao.add(user);
		return status;
	}

	@Override
	public String loginUser(User user) {
		String status=cakeDao.login(user);
		return status;
	}

	@Override
	public Cake getCake(Integer cid) {
		Cake c=cakeDao.get(cid);
		return c;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> list=cakeDao.getOrder();
		return list;
	}

	@Override
	public String addCake(Cake cake) {
		String status=cakeDao.add(cake);
		return status;
	}

	@Override
	public List<Feedback> getAllFeedback() {
		List<Feedback> list=cakeDao.getFeedback();
		return list;
	}

	@Override
	public List<ContactUs> getAllContactUs() {
		List<ContactUs> list=cakeDao.getContactUs();
		return list;
	}

	@Override
	public List<Cake> getAllCake() {
		List<Cake> list=cakeDao.getCake();
		return list;
	}

}
