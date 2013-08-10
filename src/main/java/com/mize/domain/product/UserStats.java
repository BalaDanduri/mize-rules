package com.mize.domain.product;

import com.mize.domain.common.MizeEntity;

public class UserStats extends MizeEntity implements Comparable<UserStats> {
	private static final long serialVersionUID = -3151359495279040285L;

	Long userId;
	Integer wantCount;
	Integer ownCount;
	Integer productRegnCount;
	Integer productConsumableCount;
	Integer serviceScheduleCount;
	
	public enum Stats{
		want,own,product_regn,product_consumable,service_schedule;
	}
	
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

	public Integer getWantCount() {
		return wantCount;
	}

	public void setWantCount(Integer wantCount) {
		this.wantCount = wantCount;
	}

	public Integer getOwnCount() {
		return ownCount;
	}

	public void setOwnCount(Integer ownCount) {
		this.ownCount = ownCount;
	}

	public Integer getProductRegnCount() {
		return productRegnCount;
	}

	public void setProductRegnCount(Integer productRegnCount) {
		this.productRegnCount = productRegnCount;
	}

	public Integer getProductConsumableCount() {
		return productConsumableCount;
	}

	public void setProductConsumableCount(Integer productConsumableCount) {
		this.productConsumableCount = productConsumableCount;
	}

	public Integer getServiceScheduleCount() {
		return serviceScheduleCount;
	}

	public void setServiceScheduleCount(Integer serviceScheduleCount) {
		this.serviceScheduleCount = serviceScheduleCount;
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
				+ productConsumableCount + ", serviceScheduleCount="+ serviceScheduleCount+ "]";
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
				+ ((serviceScheduleCount == null) ? 0 : serviceScheduleCount
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
		if (serviceScheduleCount == null) {
			if (other.serviceScheduleCount != null)
				return false;
		} else if (!serviceScheduleCount.equals(other.serviceScheduleCount))
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
