package com.mize.domain.brand;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeDomainConstant;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class PostToSocialMedia extends MizeEntity implements Comparable<PostToSocialMedia>{
	
	String postId;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	DateTime postedDate;
	String postData;
	String socialMedia;
	Long feedbackId;
	Long id;
	
	public PostToSocialMedia() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	public DateTime getPostedDate() {
		return postedDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setPostedDate(DateTime postedDate) {
		this.postedDate = postedDate;
	}

	public String getPostData() {
		return postData;
	}

	public void setPostData(String postData) {
		this.postData = postData;
	}

	public String getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setfeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public int compareTo(PostToSocialMedia entity) {
		if ( this == entity ) 
			return MizeDomainConstant.EQUAL;
		else if (this.id < entity.id) 
			return MizeDomainConstant.BEFORE;
		else if (entity.id == this.id) 
			return MizeDomainConstant.EQUAL;
		else if (this.id > entity.id)
			return MizeDomainConstant.AFTER;
		return MizeDomainConstant.EQUAL;
	}


}
