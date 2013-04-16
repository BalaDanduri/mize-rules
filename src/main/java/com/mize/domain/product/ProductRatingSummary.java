package com.mize.domain.product;

import com.mize.domain.common.Entity;


public class ProductRatingSummary extends Entity{
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
}
