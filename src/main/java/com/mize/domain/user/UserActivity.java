package com.mize.domain.user;

import com.mize.domain.common.Entity;

public class UserActivity extends Entity{

	private static final long serialVersionUID = -1735215114583875295L;
	private Long activityId;
	private String activityName;
	private String activityDescription;
	
	public UserActivity(){
		
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
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
		return "UserActivity [activityId=" + activityId + ", activityName=" + activityName + ", activityDescription=" + activityDescription + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((activityDescription == null) ? 0 : activityDescription
						.hashCode());
		result = prime * result
				+ ((activityId == null) ? 0 : activityId.hashCode());
		result = prime * result
				+ ((activityName == null) ? 0 : activityName.hashCode());
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
		UserActivity other = (UserActivity) obj;
		if (activityDescription == null) {
			if (other.activityDescription != null)
				return false;
		} else if (!activityDescription.equals(other.activityDescription))
			return false;
		if (activityId == null) {
			if (other.activityId != null)
				return false;
		} else if (!activityId.equals(other.activityId))
			return false;
		if (activityName == null) {
			if (other.activityName != null)
				return false;
		} else if (!activityName.equals(other.activityName))
			return false;
		return true;
	}
	
		
}
