package com.ssh.bean;

public class ProductionBean {

	private String id;
	private String name;
	private float price;
	private String imgUrl;
	private int monthCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getMonthCount() {
		return monthCount;
	}
	public void setMonthCount(int monthCount) {
		this.monthCount = monthCount;
	}
}
