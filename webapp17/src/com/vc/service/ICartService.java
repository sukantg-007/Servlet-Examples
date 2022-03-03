package com.vc.service;

import com.vc.entity.Cart;

public interface ICartService {
	public String add(Cart c);
	public String update(Cart c);
	public String delete(Cart c);	
}
