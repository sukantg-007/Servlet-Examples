package com.vc.entity;


import java.util.List;

public class Cart {
	private int custid;
	private Double totalp;
	private Double totalq;
	private List<Product> allproduct;
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public Double getTotalp() {
		return totalp;
	}
	public void setTotalp(Double totalp) {
		this.totalp = totalp;
	}
	public Double getTotalq() {
		return totalq;
	}
	public void setTotalq(Double totalq) {
		this.totalq = totalq;
	}
	public List<Product> getAllproduct() {
		return allproduct;
	}
	public void setAllproduct(List<Product> allproduct) {
		this.allproduct = allproduct;
	}
}
