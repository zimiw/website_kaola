package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssh.dao.BusinessDaoI;
import com.ssh.entity.Category;

@Repository("businessDao")
public class BusinessDaoImpl implements BusinessDaoI {

	@Autowired
	private SessionFactory sf;
	
	public List<Category> getCategorys() {

		String hql = "from category";
		Query query = sf.openSession().createQuery(hql);
		List<Category> list = query.list();
		return list;
	}

}
