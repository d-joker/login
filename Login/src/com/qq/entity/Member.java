package com.qq.entity;

public class Member {
	private String username;
	private String password;

	
	public Member() {
		super();
	}

	
	@Override
	public String toString() {
		return "Member [username=" + username + ", password=" + password + "]";
	}


	public Member(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
