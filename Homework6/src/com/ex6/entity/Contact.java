package com.ex6.entity;

public class Contact {
	private String name;
	private String address;
	private String time;

	public Contact(String name, String address, String time) {
		super();
		this.name = name;
		this.address = address;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
