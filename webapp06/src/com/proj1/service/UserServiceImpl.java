package com.proj1.service;

import com.proj1.dao.CakeDaoImpl;
import com.proj1.dao.ICakeDAO;
import com.proj1.dao.IUserDao;
import com.proj1.dao.UserDaoImpl;
import com.proj1.entity.User;

public class UserServiceImpl implements IUserService {
	IUserDao userDao=null;
	public UserServiceImpl() {
		try{
			userDao=new UserDaoImpl();			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String addUser(User user) {		
		String status=userDao.add(user);
		return status;
	}

	@Override
	public String loginUser(User user) {
		String status=userDao.check(user);
		return status;
	}

}
