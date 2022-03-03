package com.proj1.service;

import java.util.List;

import com.proj1.entity.Cake;
import com.proj1.entity.ContactUs;
import com.proj1.entity.Feedback;
import com.proj1.entity.Order;
import com.proj1.entity.User;

public interface ICakeService {

	public String addOrder(Order o);
	public String addFeedback(Feedback fb);
	public String addContact(ContactUs cus);
	public String addUser(User user);
	public String loginUser(User user);
	public Cake getCake(Integer cid);	
	public String addCake(Cake cake);
	public List<Order> getAllOrder();
	public List<Feedback> getAllFeedback();
	public List<ContactUs> getAllContactUs();
	public List<Cake> getAllCake();
}
