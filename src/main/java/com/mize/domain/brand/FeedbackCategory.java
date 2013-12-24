package com.mize.domain.brand;

import com.mize.domain.common.MizeEntity;

public class FeedbackCategory extends MizeEntity implements Comparable<FeedbackCategory>{
	
	private static final long serialVersionUID = -3371001783622958001L;
	private String feedbackCategory;
	
	public FeedbackCategory() {
		super();
	}

	public FeedbackCategory(long feedbackCategoryId, String feedbackCategory) {
		this.id = feedbackCategoryId;
		this.feedbackCategory = feedbackCategory;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Deprecated
	public Long getFeedbackCategoryId() {
		return id;
	}
	
	@Deprecated
	public void setFeedbackCategoryId(Long feedbackCategoryId) {
		this.id = feedbackCategoryId;
	}
	public String getFeedbackCategory() {
		return feedbackCategory;
	}
	public void setFeedbackCategory(String feedbackCategory) {
		this.feedbackCategory = feedbackCategory;
	}

	@Override
	public String toString() {
		return "FeedbackCategory [feedbackCategoryId=" + id
				+ ", feedbackCategory=" + feedbackCategory + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((feedbackCategory == null) ? 0 : feedbackCategory.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeedbackCategory other = (FeedbackCategory) obj;
		if (feedbackCategory == null) {
			if (other.feedbackCategory != null)
				return false;
		} else if (!feedbackCategory.equals(other.feedbackCategory))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public int compareTo(FeedbackCategory entity) {
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
