package com.vc.factory;

import com.vc.service.UserService;

public class ServiceFactory {	
	public static UserService getUserService() {
		UserService us=new UserService();
		return us;
	}
}
