package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.product.UserProductFeedback;

public class UserActivity extends Entity{

	private static final long serialVersionUID = -1735215114583875295L;
	private Activity activity = new Activity();
	private User user;
	private List<UserProductFeedback> feedbacks;
	private List<UserActivityLog> activityLogs;
	private List<FriendsActivities> friendsActivities;
	public List<Long> activityIds = new ArrayList<Long>();
	private Integer unreadCount;
	private boolean isValid;
	
	public enum ActivityName{
		Send_Friend_Invite(1),Recommend_Product(2),Friend_Invite_Accepted(3),Friend_Request_Pending(4),
		Friend_Input_For_Product(5),Pending_Friend_Input_For_Product(6),Friend_Response_For_Product(7);
		private int value;
		private ActivityName(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}
	
	public static ActivityName getActivityName(long num){
		for(ActivityName a : ActivityName.values()){
			if(num==a.ordinal()+1){
				return a;
			}
		}
		return null;
	}
	
	public enum Like{
		Thumps_Up(1),Thumps_Down(2),Spam(3);
		private int value;
		private Like(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}
	public static Like getLike(int num){
		for(Like li : Like.values()){
			if(num==li.ordinal()+1){
				return li;
			}
		}
		return null;
	}
	public static Action getAction(int num){
		for(Action ac : Action.values()){
			if(num==ac.ordinal()+1){
				return ac;
			}
		}
		return null;
	}
	public enum Action{
		Accept,Ignore,Invite_Accepted,Invite_Accept_Viewed,Product_Response_Viewed;	
	}
	public enum Status{
		Sent,Ignore,Accept,Invite_Accepted,Invite_Accept_Viewed,Friend_Response_For_Product;
	}
	public UserActivity(){
		activityLogs = new ArrayList<UserActivityLog>();
		user = new User();
	}
	public Long getActivityId() {
		return activity.id;
	}
	public void setActivityId(Long activityId) {
		this.activity.id = activityId;
	}
	
	public List<Long> getActivityIds() {
		return activity.activityIds;
	}

	public void setActivityIds(List<Long> activityIds) {
		this.activity.activityIds = activityIds;
	}
	
	public String getActivityName() {
		return activity.activityName;
	}
	public void setActivityName(String activityName) {
		this.activity.activityName = activityName;
	}
	public String getActivityDescription() {
		return activity.activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activity.activityDescription = activityDescription;
	}
	
	@Override
	public String toString() {
		return "UserActivity [activityId=" + activity.id + ", activityName=" + activity.activityName + ", activityDescription=" + activity.activityDescription + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((activity.activityDescription == null) ? 0 : activity.activityDescription
						.hashCode());
		result = prime * result
				+ ((activity.id == null) ? 0 : activity.id.hashCode());
		result = prime * result
				+ ((activity.activityName == null) ? 0 : activity.activityName.hashCode());
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
		if (activity.activityDescription == null) {
			if (other.activity.activityDescription != null)
				return false;
		} else if (!activity.activityDescription.equals(other.activity.activityDescription))
			return false;
		if (activity.id == null) {
			if (other.activity.id != null)
				return false;
		} else if (!activity.id.equals(other.activity.id))
			return false;
		if (activity.activityName == null) {
			if (other.activity.activityName != null)
				return false;
		} else if (!activity.activityName.equals(other.activity.activityName))
			return false;
		return true;
	}
	public List<UserActivityLog> getActivityLogs() {
		return activityLogs;
	}
	public void setActivityLogs(List<UserActivityLog> activityLogs) {
		this.activityLogs = activityLogs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<UserProductFeedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<UserProductFeedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public List<FriendsActivities> getFriendsActivities() {
		return friendsActivities;
	}
	public void setFriendsActivities(List<FriendsActivities> friendsActivities) {
		this.friendsActivities = friendsActivities;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Integer getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(Integer unreadCount) {
		this.unreadCount = unreadCount;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
