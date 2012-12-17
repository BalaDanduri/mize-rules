package com.mize.domain.user;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserActivityLog extends Entity{
	private static final long serialVersionUID = 1172153514372814503L;
	private Long activityId;
	private User user;
	private User targetUser;
	private Long activityLogId;
	private Long activityKey;
	private String activityAction;
	private String activityStatus;
	private String activityComments;
	public String getActivityComments() {
		return activityComments;
	}

	public void setActivityComments(String activityComments) {
		this.activityComments = activityComments;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime firstActivityTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime lastActivityTime;
	private String userGroupName;
	public UserActivityLog(){
		user = new User();
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public User getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}

	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public Long getActivityLogId() {
		return activityLogId;
	}
	public void setActivityLogId(Long activityLogId) {
		this.activityLogId = activityLogId;
	}
	public Long getActivityKey() {
		return activityKey;
	}
	public void setActivityKey(Long activityKey) {
		this.activityKey = activityKey;
	}
	public String getActivityAction() {
		return activityAction;
	}
	public void setActivityAction(String activityAction) {
		this.activityAction = activityAction;
	}
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	public DateTime getFirstActivityTime() {
		return firstActivityTime;
	}
	public void setFirstActivityTime(DateTime firstActivityTime) {
		this.firstActivityTime = firstActivityTime;
	}
	public DateTime getLastActivityTime() {
		return lastActivityTime;
	}
	public void setLastActivityTime(DateTime lastActivityTime) {
		this.lastActivityTime = lastActivityTime;
	}
	

	@Override
	public String toString() {
		return "UserActivityLog [activityId=" + activityId + ", user=" + user
				+ ", targetUser=" + targetUser + ", activityLogId="
				+ activityLogId + ", activityKey=" + activityKey
				+ ", activityAction=" + activityAction + ", activityStatus="
				+ activityStatus + ", activityComments=" + activityComments
				+ ", firstActivityTime=" + firstActivityTime
				+ ", lastActivityTime=" + lastActivityTime + ", userGroupName="
				+ userGroupName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activityAction == null) ? 0 : activityAction.hashCode());
		result = prime
				* result
				+ ((activityComments == null) ? 0 : activityComments.hashCode());
		result = prime * result
				+ ((activityId == null) ? 0 : activityId.hashCode());
		result = prime * result
				+ ((activityKey == null) ? 0 : activityKey.hashCode());
		result = prime * result
				+ ((activityLogId == null) ? 0 : activityLogId.hashCode());
		result = prime * result
				+ ((activityStatus == null) ? 0 : activityStatus.hashCode());
		result = prime
				* result
				+ ((firstActivityTime == null) ? 0 : firstActivityTime
						.hashCode());
		result = prime
				* result
				+ ((lastActivityTime == null) ? 0 : lastActivityTime.hashCode());
		result = prime * result
				+ ((targetUser == null) ? 0 : targetUser.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((userGroupName == null) ? 0 : userGroupName.hashCode());
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
		UserActivityLog other = (UserActivityLog) obj;
		if (activityAction == null) {
			if (other.activityAction != null)
				return false;
		} else if (!activityAction.equals(other.activityAction))
			return false;
		if (activityComments == null) {
			if (other.activityComments != null)
				return false;
		} else if (!activityComments.equals(other.activityComments))
			return false;
		if (activityId == null) {
			if (other.activityId != null)
				return false;
		} else if (!activityId.equals(other.activityId))
			return false;
		if (activityKey == null) {
			if (other.activityKey != null)
				return false;
		} else if (!activityKey.equals(other.activityKey))
			return false;
		if (activityLogId == null) {
			if (other.activityLogId != null)
				return false;
		} else if (!activityLogId.equals(other.activityLogId))
			return false;
		if (activityStatus == null) {
			if (other.activityStatus != null)
				return false;
		} else if (!activityStatus.equals(other.activityStatus))
			return false;
		if (firstActivityTime == null) {
			if (other.firstActivityTime != null)
				return false;
		} else if (!firstActivityTime.equals(other.firstActivityTime))
			return false;
		if (lastActivityTime == null) {
			if (other.lastActivityTime != null)
				return false;
		} else if (!lastActivityTime.equals(other.lastActivityTime))
			return false;
		if (targetUser == null) {
			if (other.targetUser != null)
				return false;
		} else if (!targetUser.equals(other.targetUser))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userGroupName == null) {
			if (other.userGroupName != null)
				return false;
		} else if (!userGroupName.equals(other.userGroupName))
			return false;
		return true;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}
		
	
}
