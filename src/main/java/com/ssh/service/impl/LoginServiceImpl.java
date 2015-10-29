package com.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.UserDaoI;
import com.ssh.entity.User;
import com.ssh.service.LoginServiceI;

@Service("loginService")
public class LoginServiceImpl implements LoginServiceI {

	@Autowired
	private UserDaoI userDao;
	
	public Boolean checkUser(String name, String pwd, int role) {
		// TODO Auto-generated method stub
		List<User> users = userDao.getUserByNameAndPwd(name, pwd, role);
		if(users.size() == 0){
			return false;
		}else{
			return true;
		}
	}

}
