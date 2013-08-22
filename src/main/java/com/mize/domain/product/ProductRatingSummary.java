package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;


public class ProductRatingSummary extends MizeEntity implements Comparable<ProductRatingSummary> {
	private static final long serialVersionUID = -7710842260731182272L;
	protected Long productId;
	protected Double rating;
	protected Integer rating1Count;
	protected Integer rating2Count;
	protected Integer rating3Count;
	protected Integer rating4Count;
	protected Integer rating5Count;
	protected Integer countOwn;
	protected Integer countWant;
	protected Integer countGift;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getRating1Count() {
		if(rating1Count == null){
			rating1Count = Integer.valueOf(0);
		}
		return rating1Count;
	}

	public void setRating1Count(Integer rating1Count) {
		this.rating1Count = rating1Count;
	}

	public Integer getRating2Count() {
		if(rating2Count == null){
			rating2Count = Integer.valueOf(0);
		}
		return rating2Count;
	}

	public void setRating2Count(Integer rating2Count) {
		this.rating2Count = rating2Count;
	}

	public Integer getRating3Count() {
		if(rating3Count == null){
			rating3Count = Integer.valueOf(0);
		}
		return rating3Count;
	}

	public void setRating3Count(Integer rating3Count) {
		this.rating3Count = rating3Count;
	}

	public Integer getRating4Count() {
		if(rating4Count == null){
			rating4Count = Integer.valueOf(0);
		}
		return rating4Count;
	}

	public void setRating4Count(Integer rating4Count) {
		this.rating4Count = rating4Count;
	}

	public Integer getRating5Count() {
		if(rating5Count == null){
			rating5Count = Integer.valueOf(0);
		}
		return rating5Count;
	}

	public void setRating5Count(Integer rating5Count) {
		this.rating5Count = rating5Count;
	}

	public Integer getCountOwn() {
		return countOwn;
	}

	public void setCountOwn(Integer countOwn) {
		this.countOwn = countOwn;
	}

	public Integer getCountWant() {
		return countWant;
	}

	public void setCountWant(Integer countWant) {
		this.countWant = countWant;
	}

	public Integer getCountGift() {
		return countGift;
	}

	public void setCountGift(Integer countGift) {
		this.countGift = countGift;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(ProductRatingSummary arg0) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((countGift == null) ? 0 : countGift.hashCode());
		result = prime * result
				+ ((countOwn == null) ? 0 : countOwn.hashCode());
		result = prime * result
				+ ((countWant == null) ? 0 : countWant.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		if (!super.equals(obj))
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
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
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

	@Override
	public String toString() {
		return "ProductRatingSummary [productId=" + productId + ", rating="
				+ rating + ", rating1Count=" + rating1Count + ", rating2Count="
				+ rating2Count + ", rating3Count=" + rating3Count
				+ ", rating4Count=" + rating4Count + ", rating5Count="
				+ rating5Count + ", countOwn=" + countOwn + ", countWant="
				+ countWant + ", countGift=" + countGift + "]";
	}	
	
}
