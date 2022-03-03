package com.vc.entity;

import java.util.Date;

public class Emp {
	private Integer eid;
	private String ename;
	private Float esal;
	private String eaddr;
	private Date edoj;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Float getEsal() {
		return esal;
	}
	public void setEsal(Float esal) {
		this.esal = esal;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public Date getEdoj() {
		return edoj;
	}
	public void setEdoj(Date edoj) {
		this.edoj = edoj;
	}
}
