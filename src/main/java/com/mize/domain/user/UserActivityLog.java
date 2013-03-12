package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserActivityLog extends Entity{
	
	private static final long serialVersionUID = 1172153514372814503L;
	private Long id;
	private List<User> targetUsers;
	private Long activityKey;
	private Integer activityAction;
	private String activityStatus;
	private String activityComments;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime firstActivityTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime lastActivityTime;
	private String userGroupName;
	private String activityName;
	private Integer mutualFriendsCount;
	private String productName;
	private String imageLink;
	private Long productId;
	private Long sourceId;
	private String sourceProductId;
	private String action;
	private String activityViewed;
	private Integer activityLiked;
	private Long parentActivityLogId;	
	private boolean isReqPending;
	private UserActivityLog parentActivityLog;
	
	public UserActivityLog(){
		targetUsers = new ArrayList<User>();
	}
	
	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public boolean isReqPending() {
		return isReqPending;
	}

	public void setReqPending(boolean isReqPending) {
		this.isReqPending = isReqPending;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long activityLogId) {
		this.id = activityLogId;
	}
	public Long getActivityKey() {
		return activityKey;
	}
	public void setActivityKey(Long activityKey) {
		this.activityKey = activityKey;
	}	
	public Integer getActivityAction() {
		return activityAction;
	}
	public void setActivityAction(Integer activityAction) {
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
	public String getActivityComments() {
		return activityComments;
	}

	public void setActivityComments(String activityComments) {
		this.activityComments = activityComments;
	}

	public String getUserGroupName() {
		return userGroupName;
	}

	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}

	public List<User> getTargetUsers() {
		return targetUsers;
	}

	public void setTargetUsers(List<User> targetUsers) {
		this.targetUsers = targetUsers;
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
				+ ((activityKey == null) ? 0 : activityKey.hashCode());
		result = prime * result
				+ ((activityStatus == null) ? 0 : activityStatus.hashCode());
		result = prime
				* result
				+ ((firstActivityTime == null) ? 0 : firstActivityTime
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((lastActivityTime == null) ? 0 : lastActivityTime.hashCode());
		result = prime * result
				+ ((targetUsers == null) ? 0 : targetUsers.hashCode());
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
		if (activityKey == null) {
			if (other.activityKey != null)
				return false;
		} else if (!activityKey.equals(other.activityKey))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastActivityTime == null) {
			if (other.lastActivityTime != null)
				return false;
		} else if (!lastActivityTime.equals(other.lastActivityTime))
			return false;
		if (targetUsers == null) {
			if (other.targetUsers != null)
				return false;
		} else if (!targetUsers.equals(other.targetUsers))
			return false;
		if (userGroupName == null) {
			if (other.userGroupName != null)
				return false;
		} else if (!userGroupName.equals(other.userGroupName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserActivityLog [id=" + id + ", targetUsers=" + targetUsers
				+ ", activityKey=" + activityKey + ", activityAction="
				+ activityAction + ", activityStatus=" + activityStatus
				+ ", activityComments=" + activityComments
				+ ", firstActivityTime=" + firstActivityTime
				+ ", lastActivityTime=" + lastActivityTime + ", userGroupName="
				+ userGroupName + "]";
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Integer getMutualFriendsCount() {
		return mutualFriendsCount;
	}

	public void setMutualFriendsCount(Integer mutualFriendsCount) {
		this.mutualFriendsCount = mutualFriendsCount;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getSourceProductId() {
		return sourceProductId;
	}

	public void setSourceProductId(String sourceProductId) {
		this.sourceProductId = sourceProductId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActivityViewed() {
		return activityViewed;
	}

	public void setActivityViewed(String activityViewed) {
		this.activityViewed = activityViewed;
	}

	public Integer getActivityLiked() {
		return activityLiked;
	}

	public void setActivityLiked(Integer activityLiked) {
		this.activityLiked = activityLiked;
	}

	public Long getParentActivityLogId() {
		return parentActivityLogId;
	}

	public void setParentActivityLogId(Long parentActivityLogId) {
		this.parentActivityLogId = parentActivityLogId;
	}

	public UserActivityLog getParentActivityLog() {
		return parentActivityLog;
	}

	public void setParentActivityLog(UserActivityLog parentActivityLog) {
		this.parentActivityLog = parentActivityLog;
	}	
	
	
		
}
