package com.vc.entity;

public class Product {
	private int pid;
	private String pname;
	private String catagory;
	private String summary;
	private Double price;
	private String isAvailable;
	private String pimg_path;
	private int quantity;	
	
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String isAvailable() {
		return isAvailable;
	}
	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getPimg_path() {
		return pimg_path;
	}
	public void setPimg_path(String pimg_path) {
		this.pimg_path = pimg_path;
	}
}
