package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.Entity;

public class Activity extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1837300834622455157L;
	public Long id;
	public String activityName;
	public String activityDescription;
	public List<Long> activityIds = new ArrayList<Long>();

	public Activity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long activityId) {
		this.id = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityName=" + activityName + ", activityDescription=" + activityDescription
				+ ", activityIds=" + activityIds + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityDescription == null) ? 0 : activityDescription.hashCode());
		result = prime * result + ((activityIds == null) ? 0 : activityIds.hashCode());
		result = prime * result + ((activityName == null) ? 0 : activityName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Activity other = (Activity) obj;
		if (activityDescription == null) {
			if (other.activityDescription != null)
				return false;
		} else if (!activityDescription.equals(other.activityDescription))
			return false;
		if (activityIds == null) {
			if (other.activityIds != null)
				return false;
		} else if (!activityIds.equals(other.activityIds))
			return false;
		if (activityName == null) {
			if (other.activityName != null)
				return false;
		} else if (!activityName.equals(other.activityName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Long> getActivityIds() {
		return activityIds;
	}

	public void setActivityIds(List<Long> activityIds) {
		this.activityIds = activityIds;
	}

	
}