package com.ssh.controller;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.junit.runner.notification.RunListener.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.ssh.entity.User;
import com.ssh.service.UserServiceI;

@ParentPackage("basePackage")
@Namespace("/")
public class TestAction {

	@Autowired
	private UserServiceI userService;
	
	public void test(){
		System.out.println("i am in TestAction");
		userService.test();
	}
	
	@Action(value="first")
	public void saveUser(){
		User user = new User();
		user.setName("xiaoyanzi");
		user.setRole(2);
		System.out.println("i am in first");
		//userService.save(user);
	}
	
	@Action(value="index", results={@Result(name="success", location="/index.html")})
	public String getIndex(){
		return "success";
	}
	
	
}
