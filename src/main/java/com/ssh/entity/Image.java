package com.ssh.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_image", schema = "test")
public class Image implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2900206234265041830L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String path;
	private String instruction;
	private Production production;
	private Timestamp uploadTime;
	
	public Image(){}
	
	@Column(name = "id", unique = true, nullable = false, length = 18)
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "path", length = 200)
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Column(name = "instruction", length = 50)
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	
	@Column(name = "uploadTime")
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="pro_id") 
	public Production getProduction() {
		return production;
	}
	public void setProduction(Production production) {
		this.production = production;
	}
}
