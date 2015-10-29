package com.ssh.service;

public interface LoginServiceI {

	Boolean checkUser(String name, String pwd, int role);
}
