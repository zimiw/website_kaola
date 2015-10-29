package com.ssh.entity;

import java.io.Serializable;
import java.util.HashSet;
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
@Table(name = "t_category", schema = "test")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1643241305105289857L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private int priority;
	private Set<Production> production = new HashSet<Production>();
	
	public Category(){}

	@Column(name = "id", unique = true, nullable = false, length = 3)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name",nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "priority", length = 3)
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="category",fetch=FetchType.LAZY)
	public Set<Production> getProduction() {
		return production;
	}

	public void setProduction(Set<Production> production) {
		this.production = production;
	};
}
