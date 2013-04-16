package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;


public class ProductRating extends Entity{
	private static final long serialVersionUID = -7410842260731182272L;
	private Long productId;
	private Long userId;
	private ProductRatingSummary mizeRatings = new ProductRatingSummary();
	private ProductRatingSummary friendRatings = new ProductRatingSummary();
	private List<User> friends = new ArrayList<User>();
	
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
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
}
