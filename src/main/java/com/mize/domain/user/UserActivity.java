package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;

public class UserActivity extends Entity{

	private static final long serialVersionUID = -1735215114583875295L;
	private Activity activity = new Activity();
	private User user;
	
	private List<UserActivityLog> activityLogs;
	
	public enum ActivityName{
		Send_Friend_Invite(1),Recommend_Product(2),Friend_Invite_Accepted(3);
		private int value;
		private ActivityName(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}
	
	public enum ActivityDesc{
		Desc("Invitation sent to a user to become a friend");
		private String desc;
		ActivityDesc(String desc){
			this.desc = desc;
		}
		public String getDesc(){
			return desc;
		}
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
		Accept,Ignore,Invite_Accepted;	
	}
	public enum Status{
		Sent,Ignore,Accept;
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
		
}
