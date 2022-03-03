package com.vc.service;

import java.util.List;
import com.vc.entity.Product;

public interface IProductService {
	public String add(Product p);
	public String update(Product p);
	public String delete(Product p);
	public List<Product> showAll();
}
