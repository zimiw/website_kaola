package com.ssh.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_user", schema = "test")
public class User implements java.io.Serializable {

	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String name;
	private String phoneNumber;
	private int role;
	private String password;
	private Set<Order> orders;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** minimal constructor */
	public User(String id, String name, String password, int role) {
		this.id = id;
		this.name = name;
		this.setPassword(password);
		this.role = role;
	}

	/** full constructor */
	public User(String id, String name, String password, int role, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.setPassword(password);
		this.role = role;
		this.setPhoneNumber(phoneNumber);
	}

	// Property accessors
	@Column(name = "id", unique = true, nullable = false, length = 18)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name",nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "role", length = 4)
	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Column(name = "phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}