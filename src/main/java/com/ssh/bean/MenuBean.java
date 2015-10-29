package com.ssh.bean;

import java.util.List;
import java.util.Set;

public class MenuBean {

	private int id;
	private String name;
	private String clazz;
	
	private Set<ProductionBean> content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public Set<ProductionBean> getContent() {
		return content;
	}
	public void setContent(Set<ProductionBean> content) {
		this.content = content;
	}
}
