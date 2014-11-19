package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;


public class ProductRating extends MizeSceEntity implements Comparable<ProductRating>{
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
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((friendRatings == null) ? 0 : friendRatings.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result
				+ ((mizeRatings == null) ? 0 : mizeRatings.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ProductRating other = (ProductRating) obj;
		if (friendRatings == null) {
			if (other.friendRatings != null)
				return false;
		} else if (!friendRatings.equals(other.friendRatings))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (mizeRatings == null) {
			if (other.mizeRatings != null)
				return false;
		} else if (!mizeRatings.equals(other.mizeRatings))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ProductRating [productId=" + productId + ", userId=" + userId
				+ ", mizeRatings=" + mizeRatings + ", friendRatings="
				+ friendRatings + ", friends=" + friends + "]";
	}
	@Override
	public int compareTo(ProductRating o) {
		return 0;
	}
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
}
