package com.ssh.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;


public class FirstFilter extends StrutsPrepareAndExecuteFilter {

	public void init(FilterConfig filterConfig)
			throws ServletException{
		super.init(filterConfig);
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException{
		System.out.println("i am in do");
		
		super.doFilter(req, res, chain);
	}
}
