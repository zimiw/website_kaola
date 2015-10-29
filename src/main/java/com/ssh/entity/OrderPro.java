package com.ssh.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_pro", schema = "test")
public class OrderPro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1617687250756373228L;
	private String id;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="order_id")
	private Order order;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Production.class)
	@JoinColumn(name="pro_id",nullable=false,updatable=false)
	private Production production;
	
	private int number;
	private String name;
	private float price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Production getProduction() {
		return production;
	}
	public void setProduction(Production production) {
		this.production = production;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
}
