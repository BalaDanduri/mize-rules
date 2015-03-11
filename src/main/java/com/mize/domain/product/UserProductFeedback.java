package com.mize.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

public class UserProductFeedback  extends MizeSceEntity implements Comparable<UserProdFeedback>{
	
	private static final long serialVersionUID = 1784400215647825886L;
	protected Long id;
	protected String feedbackTitle;
	protected String review;
	protected Integer rating;
	protected User user;
	protected Product product;
	protected String reviewedBy;
	protected int pageIndex;

	public String getReviewedBy() {
		return reviewedBy;
	}


	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFeedbackTitle() {
		return feedbackTitle;
	}


	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}

	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore(false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


	@Override
	public String toString() {
		return "UserProductFeedback [id=" + id + ", feedbackTitle=" + feedbackTitle + ", review=" + review + ", rating=" + rating + ", user=" + user
				+ ", product=" + product + ", reviewedBy=" + reviewedBy + ", pageIndex=" + pageIndex + "]";
	}

	@Override
	public int compareTo(UserProdFeedback o) {
		return 0;
	}
	
}
