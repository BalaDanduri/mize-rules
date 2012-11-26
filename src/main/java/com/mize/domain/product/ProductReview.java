package com.mize.domain.product;

import com.mize.domain.common.Entity;

public class ProductReview  extends Entity{
	
	protected Long id;
	protected String review;
	protected Integer rating;
	protected Long userId;
	protected Product product;
	protected String commentsBy;
	
	public ProductReview() {
		// TODO Auto-generated constructor stub
	}
	

//	public ProductReview(Long id, String review, Integer rating, Long userId, Product product, String commentsBy) {
//		this.id = id;
//		this.review = review;
//		this.rating = rating;
//		this.userId = userId;
//		this.product = product;
//		this.commentsBy = commentsBy;
//	}
//
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result
				+ ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((commentsBy == null) ? 0 : commentsBy.hashCode());
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
		ProductReview other = (ProductReview) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (review == null) {
			if (other.getReview() != null)
				return false;
		} else if (!review.equals(other.getReview()))
			return false;
		if (rating == null) {
			if (other.getRating()!= null)
				return false;
		} else if (!rating.equals(other.getRating()))
			return false;
		if (userId == null) {
			if (other.getUserId() != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (commentsBy == null) {
			if (other.commentsBy != null)
				return false;
		} else if (!commentsBy.equals(other.commentsBy))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProductReview [id=" + id + ", review=" + review + ", rating="
				+ rating + ", userId=" + userId + ", product=" + product
				+ ", commentsBy=" + commentsBy + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getComentsBy() {
		return commentsBy;
	}


	public void setComeentsBy(String commentsBy) {
		this.commentsBy = commentsBy;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


}
