package com.ssh.service;

import java.io.Serializable;

import com.ssh.entity.User;

public interface UserServiceI {

	public void test();
	
	Serializable save(User user);
}
