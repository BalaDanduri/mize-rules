package com.mize.domain.product;


public class ProductRatingSummary  {
	
	protected Long productRatingId;
	protected Long productSourceId;
	protected Long productId;
	protected Double productRating;
	protected Long rating1Count;
	protected Long rating2Count;
	protected Long rating3Count;
	protected Long rating4Count;
	protected Long rating5Count;
	
	@Override
	public String toString() {
		return "ProductRatingSummary [productRatingId=" + productRatingId
				+ ", productSourceId=" + productSourceId + ", productId="
				+ productId + ", productRating=" + productRating
				+ ", rating1Count=" + rating1Count + ", rating2Count="
				+ rating2Count + ", rating3Count=" + rating3Count
				+ ", rating4Count=" + rating4Count + ", rating5Count="
				+ rating5Count + "]";
	}

	public Long getProductRatingId() {
		return productRatingId;
	}

	public void setProductRatingId(Long productRatingId) {
		this.productRatingId = productRatingId;
	}

	public Long getProductSourceId() {
		return productSourceId;
	}

	public void setProductSourceId(Long productSourceId) {
		this.productSourceId = productSourceId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getProductRating() {
		return productRating;
	}

	public void setProductRating(Double productRating) {
		this.productRating = productRating;
	}

	public Long getRating1Count() {
		return rating1Count;
	}

	public void setRating1Count(Long rating1Count) {
		this.rating1Count = rating1Count;
	}

	public Long getRating2Count() {
		return rating2Count;
	}

	public void setRating2Count(Long rating2Count) {
		this.rating2Count = rating2Count;
	}

	public Long getRating3Count() {
		return rating3Count;
	}

	public void setRating3Count(Long rating3Count) {
		this.rating3Count = rating3Count;
	}

	public Long getRating4Count() {
		return rating4Count;
	}

	public void setRating4Count(Long rating4Count) {
		this.rating4Count = rating4Count;
	}

	public Long getRating5Count() {
		return rating5Count;
	}

	public void setRating5Count(Long rating5Count) {
		this.rating5Count = rating5Count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result
				+ ((productRating == null) ? 0 : productRating.hashCode());
		result = prime * result
				+ ((productRatingId == null) ? 0 : productRatingId.hashCode());
		result = prime * result
				+ ((productSourceId == null) ? 0 : productSourceId.hashCode());
		result = prime * result
				+ ((rating1Count == null) ? 0 : rating1Count.hashCode());
		result = prime * result
				+ ((rating2Count == null) ? 0 : rating2Count.hashCode());
		result = prime * result
				+ ((rating3Count == null) ? 0 : rating3Count.hashCode());
		result = prime * result
				+ ((rating4Count == null) ? 0 : rating4Count.hashCode());
		result = prime * result
				+ ((rating5Count == null) ? 0 : rating5Count.hashCode());
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
		ProductRatingSummary other = (ProductRatingSummary) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productRating == null) {
			if (other.productRating != null)
				return false;
		} else if (!productRating.equals(other.productRating))
			return false;
		if (productRatingId == null) {
			if (other.productRatingId != null)
				return false;
		} else if (!productRatingId.equals(other.productRatingId))
			return false;
		if (productSourceId == null) {
			if (other.productSourceId != null)
				return false;
		} else if (!productSourceId.equals(other.productSourceId))
			return false;
		if (rating1Count == null) {
			if (other.rating1Count != null)
				return false;
		} else if (!rating1Count.equals(other.rating1Count))
			return false;
		if (rating2Count == null) {
			if (other.rating2Count != null)
				return false;
		} else if (!rating2Count.equals(other.rating2Count))
			return false;
		if (rating3Count == null) {
			if (other.rating3Count != null)
				return false;
		} else if (!rating3Count.equals(other.rating3Count))
			return false;
		if (rating4Count == null) {
			if (other.rating4Count != null)
				return false;
		} else if (!rating4Count.equals(other.rating4Count))
			return false;
		if (rating5Count == null) {
			if (other.rating5Count != null)
				return false;
		} else if (!rating5Count.equals(other.rating5Count))
			return false;
		return true;
	}

	public ProductRatingSummary() {
	}
	
}
