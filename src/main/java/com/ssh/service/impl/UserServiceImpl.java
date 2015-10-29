package com.ssh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.UserDaoI;
import com.ssh.entity.User;
import com.ssh.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserDaoI userDao;
	
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Hello world");
	}

	public Serializable save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
