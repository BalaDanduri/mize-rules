package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class UserStats extends MizeEntity implements Comparable<UserStats> {
	private static final long serialVersionUID = -3151359495279040285L;

	Long userId;
	Long wantCount;
	Long ownCount;
	Long productRegnCount;
	Long productConsumableCount;
	Long productSchulerCount;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWantCount() {
		return wantCount;
	}

	public void setWantCount(Long wantCount) {
		this.wantCount = wantCount;
	}

	public Long getOwnCount() {
		return ownCount;
	}

	public void setOwnCount(Long ownCount) {
		this.ownCount = ownCount;
	}

	public Long getProductRegnCount() {
		return productRegnCount;
	}

	public void setProductRegnCount(Long productRegnCount) {
		this.productRegnCount = productRegnCount;
	}

	public Long getProductConsumableCount() {
		return productConsumableCount;
	}

	public void setProductConsumableCount(Long productConsumableCount) {
		this.productConsumableCount = productConsumableCount;
	}

	public Long getProductSchulerCount() {
		return productSchulerCount;
	}

	public void setProductSchulerCount(Long productSchulerCount) {
		this.productSchulerCount = productSchulerCount;
	}

	@Override
	public int compareTo(UserStats o) {
		return 0;
	}
	
	@Override
	public String toString() {
		return "UserStats [userId=" + userId + ", wantCount=" + wantCount
				+ ", ownCount=" + ownCount + ", productRegnCount="
				+ productRegnCount + ", productConsumableCount="
				+ productConsumableCount + ", productSchulerCount="
				+ productSchulerCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((ownCount == null) ? 0 : ownCount.hashCode());
		result = prime
				* result
				+ ((productConsumableCount == null) ? 0
						: productConsumableCount.hashCode());
		result = prime
				* result
				+ ((productRegnCount == null) ? 0 : productRegnCount.hashCode());
		result = prime
				* result
				+ ((productSchulerCount == null) ? 0 : productSchulerCount
						.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((wantCount == null) ? 0 : wantCount.hashCode());
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
		UserStats other = (UserStats) obj;
		if (ownCount == null) {
			if (other.ownCount != null)
				return false;
		} else if (!ownCount.equals(other.ownCount))
			return false;
		if (productConsumableCount == null) {
			if (other.productConsumableCount != null)
				return false;
		} else if (!productConsumableCount.equals(other.productConsumableCount))
			return false;
		if (productRegnCount == null) {
			if (other.productRegnCount != null)
				return false;
		} else if (!productRegnCount.equals(other.productRegnCount))
			return false;
		if (productSchulerCount == null) {
			if (other.productSchulerCount != null)
				return false;
		} else if (!productSchulerCount.equals(other.productSchulerCount))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (wantCount == null) {
			if (other.wantCount != null)
				return false;
		} else if (!wantCount.equals(other.wantCount))
			return false;
		return true;
	}

}
