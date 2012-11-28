package com.mize.domain.product;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserProductFeedback  extends Entity{
	
	protected Long id;
	protected String review;
	protected Integer rating;
	protected User user;
	protected Product product;
	
	public UserProductFeedback() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result
				+ ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());

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
		UserProductFeedback other = (UserProductFeedback) obj;
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
		if (user == null) {
			if (other.getUser() != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProductReview [id=" + id + ", review=" + review + ", rating="
				+ rating + ", userId=" + user + ", product=" + product + "]";
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


}
