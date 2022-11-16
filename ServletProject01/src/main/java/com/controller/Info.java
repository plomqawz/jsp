package com.controller;

public class Info {
	private String name;
	private String id;
	private String pwd;
	private String phone;
	private String address;
	
	// »ý¼ºÀÚ
	public Info(String name, String id, String pwd, String phone, String address) {
		super();
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.address = address;
	}
	
	//getter, setter
	public String getName() {
		return name == null ? "" : name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id == null ? "" : id.trim();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd == null ? "" : pwd.trim();
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone == null ? "" : phone.trim();
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address == null ? "" : address.trim();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
