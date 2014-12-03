package com.mize.domain.brand;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public class PostToSocialMedia extends MizeSceEntity implements Comparable<PostToSocialMedia>{
	
	private static final long serialVersionUID = 4674350998777147719L;
	String postId;
	MizeDateTime postedDate;
	String postData;
	String socialMedia;
	Long feedbackId;
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

	public MizeDateTime getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(MizeDateTime postedDate) {
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
