package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.product.Product;

public class UserActivityLog extends Entity{
	
	private static final long serialVersionUID = 1172153514372814503L;
	private Long id;
	private List<User> targetUsers;
	private Long activityKey;
	private Integer activityAction;
	private String activityStatus;
	private String activityComments;
	protected DateTime firstActivityTime;
	protected DateTime lastActivityTime;
	private String userGroupName;
	private String activityName;
	private Integer mutualFriendsCount;
	private Product product;
	private String action;
	private String activityViewed;
	private Integer activityLiked;
	private Long parentActivityLogId;
	private UserActivityLog parentActivityLog;
	
	public UserActivityLog(){
		targetUsers = new ArrayList<User>();
		product = new Product();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
