package com.proj1.dao;

import com.proj1.entity.User;

public interface IUserDao {
	public String add(User user);
	public String check(User user);	
}
