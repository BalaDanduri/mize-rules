package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.Entity;

public class NotificationDevice extends Entity {
	
	private static final long serialVersionUID = 6457591358862233006L;	
	private Long id;
	private String deviceToken;
	private String status;
	private String alert;
	private String sound;
	private String badge;
	private String OS;
	private Long userId;
	List<DeviceUser> deviceUsers = new ArrayList<DeviceUser>();
	
	public enum Status{
		enabled,disabled;
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
		FriendInvite,RecommendProduct,AskQuestion;
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
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
