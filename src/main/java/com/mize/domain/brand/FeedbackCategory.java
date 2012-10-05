package com.mize.domain.brand;

import com.mize.domain.common.Entity;

public class FeedbackCategory extends Entity {
	private int feedbackCategoryId;
	private String feedbackCategory;

	public int getFeedbackCategoryId() {
		return feedbackCategoryId;
	}
	public void setFeedbackCategoryId(int feedbackCategoryId) {
		this.feedbackCategoryId = feedbackCategoryId;
	}
	public String getFeedbackCategory() {
		return feedbackCategory;
	}
	public void setFeedbackCategory(String feedbackCategory) {
		this.feedbackCategory = feedbackCategory;
	}

}
