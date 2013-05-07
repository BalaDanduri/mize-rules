package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.Entity;

public class NotificationDevice extends Entity {
	
	private static final long serialVersionUID = 6457591358862233006L;	
	public static final String HOT_SPOT = "{?}";
	private Long id;
	private String deviceToken;
	private String status;
	private String alert;
	private String sound;
	private String badge;
	private String deviceOS;
	private Long userId;
	List<DeviceUser> deviceUsers = new ArrayList<DeviceUser>();
	
	public enum Status{
		enabled,disabled;
	}
	
	public enum DeviceType{
		IOS("ios"),ANDRIOD("andriod"),BLACKBERRY("blackberry"),WINDOWS("windows");
		private String type;
		private DeviceType(String type) {
			this.type = type;
		}
	}
	public static final DeviceType getDeviceType(String deviceType) {
		for (DeviceType s : DeviceType.values() ){
			if (s.type.equalsIgnoreCase(deviceType)){
				return s;
			}
		}
		return null;
	}
	
	public static Status getStatus(String s){
		for(Status status : Status.values()){
			if(status.toString().equalsIgnoreCase(s)){
				return status;
			}
		}
		return null;
	}
	
	public enum MessageCode{
		FriendInvite("{?} has sent you a Friend Invitation."),
		RequestProductInput("You have received a request to share your opinion on {?}") ,
		ResponseToProductInputRequest("You have received a response to your request for opinion on {?}");
		String message;
		MessageCode(String msg){
			message = msg;
		}
		public String getMessage(){
			return message;
		}
	}
	
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}

	public List<DeviceUser> getDeviceUsers() {
		return deviceUsers;
	}
	public void setDeviceUsers(List<DeviceUser> deviceUsers) {
		this.deviceUsers = deviceUsers;
	}
	
	public String getDeviceOS() {
		return deviceOS;
	}
	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
