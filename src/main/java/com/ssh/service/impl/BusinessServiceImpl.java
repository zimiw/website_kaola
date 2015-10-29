package com.ssh.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.bean.MenuBean;
import com.ssh.bean.ProductionBean;
import com.ssh.dao.BusinessDaoI;
import com.ssh.entity.Category;
import com.ssh.entity.Production;
import com.ssh.service.BusinessServiceI;

@Service("businessService")
public class BusinessServiceImpl implements BusinessServiceI {

	@Autowired
	private BusinessDaoI businessDao;
	
	public List<MenuBean> getCategorysAndFirst() {
		// TODO Auto-generated method stub
		List result = new ArrayList<MenuBean>();
		List<Category> categorys = businessDao.getCategorys();
		for(Category ca : categorys){
			MenuBean temp = new MenuBean();
			temp.setId(ca.getId());
			temp.setName(ca.getName());
			if(ca.getPriority() == 0){
				temp.setClazz("active");
			}
			for(Production item : ca.getProduction()){
				ProductionBean tempItem = new ProductionBean();
				tempItem.setId(item.getId());
			}
		}
		
		return null;
	}

}
