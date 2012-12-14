package com.mize.domain.product;

import com.mize.domain.common.BaseEntity;


public class ProductRatingSummary extends BaseEntity {
	
	protected Long productRatingId;
	protected Long productSourceId;
	protected Long productId;
	protected Double productRating;
	protected Long rating1Count;
	protected Long rating2Count;
	protected Long rating3Count;
	protected Long rating4Count;
	protected Long rating5Count;
	protected Long countOwn;
	protected Long countWant;
	protected Long countGift;
	
	@Override
	public String toString() {
		return "ProductRatingSummary [productRatingId=" + productRatingId
				+ ", productSourceId=" + productSourceId + ", productId="
				+ productId + ", productRating=" + productRating
				+ ", rating1Count=" + rating1Count + ", rating2Count="
				+ rating2Count + ", rating3Count=" + rating3Count
				+ ", rating4Count=" + rating4Count + ", rating5Count="
				+ rating5Count + ", countOwn=" + countOwn + ", countWant="
				+ countWant + ", countGift=" + countGift + "]";
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
		if (rating1Count == null) {
			rating1Count = new Long(0);
		}
		return rating1Count;
	}

	public void setRating1Count(Long rating1Count) {
		this.rating1Count = rating1Count;
	}

	public Long getRating2Count() {
		if (rating2Count == null) {
			rating2Count = new Long(0);
		}
		return rating2Count;
	}

	public void setRating2Count(Long rating2Count) {
		this.rating2Count = rating2Count;
	}

	public Long getRating3Count() {
		if (rating3Count == null) {
			rating3Count = new Long(0);
		}
		return rating3Count;
	}

	public void setRating3Count(Long rating3Count) {
		this.rating3Count = rating3Count;
	}

	public Long getRating4Count() {
		if (rating4Count == null) {
			rating4Count = new Long(0);
		}
		return rating4Count;
	}

	public void setRating4Count(Long rating4Count) {
		this.rating4Count = rating4Count;
	}

	public Long getRating5Count() {
		if (rating5Count == null) {
			rating5Count = new Long(0);
		}
		return rating5Count;
	}

	public void setRating5Count(Long rating5Count) {
		this.rating5Count = rating5Count;
	}

	public Long getCountOwn() {
		return countOwn;
	}

	public void setCountOwn(Long countOwn) {
		this.countOwn = countOwn;
	}

	public Long getCountWant() {
		return countWant;
	}

	public void setCountWant(Long countWant) {
		this.countWant = countWant;
	}

	public Long getCountGift() {
		return countGift;
	}

	public void setCountGift(Long countGift) {
		this.countGift = countGift;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countGift == null) ? 0 : countGift.hashCode());
		result = prime * result
				+ ((countOwn == null) ? 0 : countOwn.hashCode());
		result = prime * result
				+ ((countWant == null) ? 0 : countWant.hashCode());
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
		if (countGift == null) {
			if (other.countGift != null)
				return false;
		} else if (!countGift.equals(other.countGift))
			return false;
		if (countOwn == null) {
			if (other.countOwn != null)
				return false;
		} else if (!countOwn.equals(other.countOwn))
			return false;
		if (countWant == null) {
			if (other.countWant != null)
				return false;
		} else if (!countWant.equals(other.countWant))
			return false;
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
