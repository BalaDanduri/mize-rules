package com.mize.domain.brand;

import com.mize.domain.common.MizeEntity;

public class BrandFeedback extends MizeEntity implements Comparable<BrandFeedback>{
	
	private static final long serialVersionUID = 1957219755183415343L;
	private Long id;
	private Brand brand;
	private int userId;
	private FeedbackCategory category;
	private String subject;
	private String description;
	
	
	public Long getId() {
		return id;
	}
		
	public void setId(Long brandFeedbackId) {
		this.id = brandFeedbackId;
	}
	
	@Deprecated
	public Long getBrandFeedbackId() {
		return id;
	}
	
	@Deprecated
	public void setBrandFeedbackId(Long brandFeedbackId) {
		this.id = brandFeedbackId;
	}

	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public FeedbackCategory getCategory() {
		return category;
	}
	public void setCategory(FeedbackCategory category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int compareTo(BrandFeedback entity) {
		if ( this == entity ) 
			return EQUAL;
		else if (this.id < entity.id) 
			return BEFORE;
		else if (entity.id == this.id) 
			return EQUAL;
		else if (this.id > entity.id)
			return AFTER;
		return EQUAL;		
	}	


}
