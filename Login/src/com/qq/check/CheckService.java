package com.qq.check;

import java.util.ArrayList;

import com.qq.entity.Member;

public class CheckService {
	public boolean check(Member user,ArrayList<Member> list) {
		String username = user.getUsername();
		String password = user.getPassword();
		boolean result = false;
		for(Member m :list) {
			if(m.getUsername().equals(username) && m.getPassword().equals(password)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
}
