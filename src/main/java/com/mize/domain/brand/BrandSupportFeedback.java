package com.mize.domain.brand;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateSerializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class BrandSupportFeedback extends MizeEntity implements Comparable<BrandSupportFeedback>{

	private static final long serialVersionUID = 7832228152060883799L;
	private Long supportLogId;
	private Long id;
	private Brand brand;
	private Long userId;
	private String userName;
	private String supportType;
	private int rating;
	private String feedback;
	private boolean resolved;	
	private DateTime feedbackDate;
	private String ticketNo;
	private Long brandSupportId;
	private List<PostToSocialMedia> socialMediaPosts;
	private DateTime startDate;

	public BrandSupportFeedback(){
		
	}

	public BrandSupportFeedback(long supportLogId, long id, Brand brand, long brandSupportId, long userId, String userName, String supportType, int rating,
			String feedback, boolean resolved, DateTime feedbackDate, String ticketNo, List<PostToSocialMedia> socialMediaPosts) {
		this.supportLogId = supportLogId;
		this.id = id;
		this.brand = brand;
		this.brandSupportId = brandSupportId;
		this.userId = userId;
		this.userName = userName;
		this.supportType = supportType;
		this.rating = rating;
		this.feedback = feedback;
		this.resolved = resolved;
		this.feedbackDate = feedbackDate;
		this.ticketNo = ticketNo;
		this.socialMediaPosts = socialMediaPosts;
	}
	

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}


	public Long getSupportLogId() {
		return supportLogId;
	}

	public void setSupportLogId(Long supportLogId) {
		this.supportLogId = supportLogId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSupportType() {
		return supportType;
	}

	public void setSupportType(String supportType) {
		this.supportType = supportType;
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

	public List<PostToSocialMedia> getSocialMediaPosts() {
		return socialMediaPosts;
	}

	public void setSocialMediaPosts(List<PostToSocialMedia> socialMediaPosts) {
		this.socialMediaPosts = socialMediaPosts;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("supportLogId = " + supportLogId + ",");
		sb.append("brand = " + brand + ",");
		sb.append("brandSupportId = " + brandSupportId + ",");		
		sb.append("userId = " + userId + ",");
		sb.append("userName = " + userName + ",");
		sb.append("supportType = " + supportType + ",");
		sb.append("rating = " + rating + ",");
		sb.append("feedback = " + feedback + ",");
		sb.append("resolved = " + resolved + ",");
		sb.append("feedbackDate = " + feedbackDate + ",");
		sb.append("ticketNo = " + ticketNo + ",");
		sb.append("socialMediaPosts = " + socialMediaPosts + "} \n");		
		return sb.toString();
	}

	public long getBrandSupportId() {
		return brandSupportId;
	}

	public void setBrandSupportId(long brandSupportId) {
		this.brandSupportId = brandSupportId;
	}
	
	public int compareTo(BrandSupportFeedback entity) {
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
