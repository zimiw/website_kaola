package com.ssh.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.dao.UserDaoI;
import com.ssh.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDaoI {

	@Autowired
	private SessionFactory sf;

	public Serializable save(User user) {
		return sf.openSession().save(user);
	}

	public User getUserById(String id) {
		return null;
	}

	public List<User> getUserByName(String name) {

		String hql = "from t_user where name = ?";
		Query query = sf.openSession().createQuery(hql);
		query.setString(0, name);
		List<User> list = query.list();
		return list;
	}

	public List<User> getUserByNameAndPwd(String name, String pwd) {

		String hql = "from t_user where name = ? and password = ?";
		Query query = sf.openSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		List<User> list = query.list();
		return list;
	}

	public List<User> getUserByNameAndPwd(String name, String pwd, int role) {

		String hql = "from User where name = ? and password = ? and role= ?";
		Query query = sf.openSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		query.setInteger(2, role);
		List<User> list = query.list();
		return list;
	}
}
