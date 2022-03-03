package com.proj1.entity;

public class Cake {
	private Integer cid;
	private String cname;
	private String cimgPath;
	private Double prise;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Double getPrise() {
		return prise;
	}
	public void setPrise(Double prise) {
		this.prise = prise;
	}
	public String getCimgPath() {
		return cimgPath;
	}
	public void setCimgPath(String cimgPath) {
		this.cimgPath = cimgPath;
	}
}
