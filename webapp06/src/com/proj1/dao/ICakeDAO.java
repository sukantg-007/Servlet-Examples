package com.proj1.dao;

import java.util.List;

import com.proj1.entity.Cake;
import com.proj1.entity.ContactUs;
import com.proj1.entity.Feedback;
import com.proj1.entity.Order;
import com.proj1.entity.User;

public interface ICakeDAO {
	public String add(Order o);
	public String add(Feedback fb);
	public String add(ContactUs cus);
	public String add(User user);
	public String add(Cake cake);
	public String login(User user);
	public Cake get(Integer id);
	public List<Order> getOrder();
	public List<Feedback> getFeedback();
	public List<ContactUs> getContactUs();
	public List<Cake> getCake();
}
