package com.ssh.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_order", schema = "test")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -317088309681559803L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private Timestamp orderTime;
	private String orderNote;
	private Timestamp expectTime;
	private Timestamp actualTime;
	private User operator;
	private User delivor;
	private String phoneNumber;
	private String phoneBackup;
	private int payWay;
	private float sum;
	private User user;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<OrderPro> items;

	public Order(){}
	
	@Column(name = "id", unique = true, nullable = false, length = 18)
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderNote() {
		return orderNote;
	}
	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}
	public Timestamp getExpectTime() {
		return expectTime;
	}
	public void setExpectTime(Timestamp expectTime) {
		this.expectTime = expectTime;
	}
	public Timestamp getActualTime() {
		return actualTime;
	}
	public void setActualTime(Timestamp actualTime) {
		this.actualTime = actualTime;
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="oprator_id")
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="delivor_id")
	public User getDelivor() {
		return delivor;
	}
	public void setDelivor(User delivor) {
		this.delivor = delivor;
	}
	public String getPhoneBackup() {
		return phoneBackup;
	}
	public void setPhoneBackup(String phoneBackup) {
		this.phoneBackup = phoneBackup;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderPro> getItems() {
		return items;
	}

	public void setItems(Set<OrderPro> items) {
		this.items = items;
	}
}
