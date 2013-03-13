package com.mize.domain.product;


public class ProductRatingSummary {
	
	protected Long productId;
	protected Double mizeRating;
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
		return "ProductRatingSummary [productId=" + productId + ", mizeRating=" + mizeRating + ", rating1Count="
				+ rating1Count + ", rating2Count=" + rating2Count + ", rating3Count=" + rating3Count
				+ ", rating4Count=" + rating4Count + ", rating5Count=" + rating5Count + ", countOwn=" + countOwn
				+ ", countWant=" + countWant + ", countGift=" + countGift + "]";
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getMizeRating() {
		return mizeRating;
	}

	public void setMizeRating(Double mizeRating) {
		this.mizeRating = mizeRating;
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
}
