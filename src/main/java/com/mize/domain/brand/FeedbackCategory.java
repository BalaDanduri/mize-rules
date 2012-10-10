package com.mize.domain.brand;

import com.mize.domain.common.Entity;

public class FeedbackCategory extends Entity {
	private int feedbackCategoryId;
	private String feedbackCategory;

	
	public FeedbackCategory() {
		super();
	}

	public FeedbackCategory(int feedbackCategoryId, String feedbackCategory) {
		this.feedbackCategoryId = feedbackCategoryId;
		this.feedbackCategory = feedbackCategory;
	}

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

	@Override
	public String toString() {
		return "FeedbackCategory [feedbackCategoryId=" + feedbackCategoryId
				+ ", feedbackCategory=" + feedbackCategory + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((feedbackCategory == null) ? 0 : feedbackCategory.hashCode());
		result = prime * result + feedbackCategoryId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackCategory other = (FeedbackCategory) obj;
		if (feedbackCategory == null) {
			if (other.feedbackCategory != null)
				return false;
		} else if (!feedbackCategory.equals(other.feedbackCategory))
			return false;
		if (feedbackCategoryId != other.feedbackCategoryId)
			return false;
		return true;
	}
}
