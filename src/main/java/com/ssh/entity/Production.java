package com.ssh.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_production", schema = "test")
public class Production implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6879396328796804443L;
	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String name;
	private Category category;
	private float price;
	private String note;
	private String imgUrl;
	private Timestamp setupTime;
	private Timestamp updateTime;
	private Timestamp onlineTime;
	private Timestamp offlineTime;
	private String proCharacter;
	private int status;
	private String instruction;
	private Set<Image> images;
	//private Set<Production> parents;
	private Set<Production> children;

	// Constructors

	/** default constructor */
	public Production() {
		
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

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id") 
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "note", length = 50)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "imgUrl", length = 100)
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "setupTime")
	public Timestamp getSetupTime() {
		return setupTime;
	}

	public void setSetupTime(Timestamp setupTime) {
		this.setupTime = setupTime;
	}

	@Column(name = "updateTime")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "onlineTime")
	public Timestamp getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Timestamp onlineTime) {
		this.onlineTime = onlineTime;
	}

	@Column(name = "offlineTime")
	public Timestamp getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(Timestamp offlineTime) {
		this.offlineTime = offlineTime;
	}

	@Column(name = "proCharacter", length = 50)
	public String getProCharacter() {
		return proCharacter;
	}

	public void setProCharacter(String proCharacter) {
		this.proCharacter = proCharacter;
	}

	@Column(name = "status", length = 3)
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "instruction", length = 50)
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	    @JoinTable(
	            name="t_pro_children",
	            joinColumns=@JoinColumn(name="parent_id"),
	            inverseJoinColumns=@JoinColumn(name="child_id")
	    )
	public Set<Production> getChildren() {
		return children;
	}

	public void setChildren(Set<Production> children) {
		this.children = children;
	}

	@OneToMany(mappedBy="production",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}
}
