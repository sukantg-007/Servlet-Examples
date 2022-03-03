package com.vc.entity;


import java.util.List;

public class Order {	
	private Integer custid;
	private Double totalp;	
	private List<Product> allproduct;
	private Integer totalq;	
	
	public Integer getTotalq() {
		return totalq;
	}
	public void setTotalq(Integer totalq) {
		this.totalq = totalq;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public Double getTotalp() {
		return totalp;
	}
	public void setTotalp(Double totalp) {
		this.totalp = totalp;
	}
	public List<Product> getAllproduct() {
		return allproduct;
	}
	public void setAllproduct(List<Product> allproduct) {
		this.allproduct = allproduct;
	}
	
}	

