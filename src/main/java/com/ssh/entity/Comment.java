package com.ssh.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_comment", schema = "test")
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3788802943959003979L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 18)
	private String id;
	
	
	private User user;
	private Order order;
	private Production production;
	
	@Column(name = "tast", length = 3)
	private int tast;
	@Column(name = "speed", length = 3)
	private int speed;
	@Column(name = "attitude", length = 3)
	private int attitude;
	@Column(name = "content", length = 200)
	private String content;
	@Column(name = "comment_time")
	private Timestamp commentTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public int getTast() {
		return tast;
	}
	public void setTast(int tast) {
		this.tast = tast;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getAttitude() {
		return attitude;
	}
	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}
