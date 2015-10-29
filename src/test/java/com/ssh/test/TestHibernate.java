package com.ssh.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.entity.User;
import com.ssh.service.UserServiceI;

public class TestHibernate {

	/*private UserServiceI userService;
	
	@Before
	public void before(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
		userService = (UserServiceI) ac.getBean("userService");
	}
	
	@Test
	public void testSaveMethod(){
		User user = new User();
		user.setName("wzm");
		user.setRole(1);
		userService.save(user);
	}*/
	
}
