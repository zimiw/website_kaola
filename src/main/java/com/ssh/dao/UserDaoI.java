package com.ssh.dao;

import java.io.Serializable;
import java.util.List;

import com.ssh.entity.User;

public interface UserDaoI {

	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	Serializable save(User user); 
	User getUserById(String id);
	List<User> getUserByName(String name);
	List<User> getUserByNameAndPwd(String name,String pwd);
	List<User> getUserByNameAndPwd(String name,String pwd, int role);
}