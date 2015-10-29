package com.ssh.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.bean.MenuBean;
import com.ssh.service.BusinessServiceI;

@ParentPackage("basePackage")
@Namespace("/")
public class BusinessAction {
	
	@Autowired
	private BusinessServiceI businessService;
	
	@Action(value="getCategorys")
	public void getCategorys(){
		
		ArrayList<String> list = new ArrayList<String>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		System.out.println("i am in getCategory");
		list.add("便当");
		list.add("汉堡");
		list.add("小食");
		list.add("饮料");
		String result =  JSONArray.fromObject(list).toString();
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Action(value="getCategorysAndFirst")
	public void getCategorysAndFirst(){
		
		ArrayList<MenuBean> list = new ArrayList<MenuBean>();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		list = (ArrayList<MenuBean>) businessService.getCategorysAndFirst();
		String result =  JSONArray.fromObject(list).toString();
		try {
			response.getWriter().print(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
