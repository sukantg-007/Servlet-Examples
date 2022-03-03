package com.vc.factory;

import com.vc.service.IProductService;
import com.vc.service.ProductService;

public class ProductServiceFactory {
	static IProductService productService=null;
	public static IProductService getProductService()
	{
		productService=new ProductService();
		return productService;
	}
}
