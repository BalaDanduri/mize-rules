package com.mize.domain.product;

import com.mize.domain.common.Entity;


public class ProductRating extends Entity{
	private static final long serialVersionUID = -7410842260731182272L;
	private Long productId;
	private Long userId;
	private ProductRatingSummary mizeRatings = new ProductRatingSummary();
	private ProductRatingSummary friendRatings = new ProductRatingSummary();
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public ProductRatingSummary getMizeRatings() {
		return mizeRatings;
	}
	public void setMizeRatings(ProductRatingSummary mizeRatings) {
		this.mizeRatings = mizeRatings;
	}
	public ProductRatingSummary getFriendRatings() {
		return friendRatings;
	}
	public void setFriendRatings(ProductRatingSummary friendRatings) {
		this.friendRatings = friendRatings;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
