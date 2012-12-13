package com.mize.domain.brand;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class PostToSocialMedia extends Entity {
	
	String postId;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	DateTime postedDate;
	String postData;
	String socialMedia;
	int feedbackId;
	
	public PostToSocialMedia() {
		
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

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setfeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

}
