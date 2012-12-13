package com.mize.domain.brand;

import com.mize.domain.common.Entity;

public class BrandFeedback extends Entity {
	
	private int brandFeedbackId;
	private Brand brand;
	private int userId;
	private FeedbackCategory category;
	private String subject;
	private String description;
	
	public int getBrandFeedbackId() {
		return brandFeedbackId;
	}
	public void setBrandFeedbackId(int brandFeedbackId) {
		this.brandFeedbackId = brandFeedbackId;
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
	

}
