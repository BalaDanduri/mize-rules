package com.mize.domain.brand;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class BrandSupportFeedback extends Entity {

	private int supportLogId;
	private int id;
	private int rating;
	private String feedback;
	private boolean resolved;	
	private DateTime feedbackDate;
	private String ticketNo;
	private Brand brand;
	private int userId;
	private int userName;
	private String supportType;
	
	public BrandSupportFeedback(){
		
	}

	public BrandSupportFeedback(int supportLogId, int id, int rating,
			String feedback, boolean resolved, DateTime feedbackDate,
			String ticketNo, Brand brand, int userId, int userName,
			String supportType) {
		this.supportLogId = supportLogId;
		this.id = id;
		this.rating = rating;
		this.feedback = feedback;
		this.resolved = resolved;
		this.feedbackDate = feedbackDate;
		this.ticketNo = ticketNo;
		this.brand = brand;
		this.userId = userId;
		this.userName = userName;
		this.supportType = supportType;
	}

	public int getSupportLogId() {
		return supportLogId;
	}

	public void setSupportLogId(int supportLogId) {
		this.supportLogId = supportLogId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)		
	public DateTime getFeedbackDate() {
		return feedbackDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setFeedbackDate(DateTime feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
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

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}

	public String getSupportType() {
		return supportType;
	}

	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}
}
