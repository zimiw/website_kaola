package com.ssh.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.service.LoginServiceI;
import com.ssh.util.CommonUtil;

@ParentPackage("basePackage")
@Namespace("/")
public class LoginAction {

	@Autowired
	private LoginServiceI loginService;
	
	@Action(value="login", results={@Result(name="success", location="/manager/manager.html"),
			@Result(name="fail",location="/manager/loginFail.html")})
	public String login() throws UnsupportedEncodingException{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		if(loginService.checkUser(URLEncoder.encode(name , "utf-8"), pwd, 0)){
			return "success";
		}
		return "fail";
	}

}
