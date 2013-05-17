package com.mize.domain.socialnetwork;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;

public class FriendInvite {

	private String provider;
	private List<String> providerIds;
	private String searchString;
	private User user;
	private List<String> inviteUserList = new ArrayList<String>();
	private List<Long> friendInviteUserList = new ArrayList<Long>();
	private String subject;
	private String inviteMessage;
	private String twitterInviteMessage;
	
	public String getTwitterInviteMessage() {
		return twitterInviteMessage;
	}
	public void setTwitterInviteMessage(String twitterInviteMessage) {
		this.twitterInviteMessage = twitterInviteMessage;
	}
	@Override
	public String toString() {
		return "FriendInvite [provider=" + provider + ", providerIds=" + providerIds + ", searchString=" + searchString
				+ ", user=" + user + ", inviteUserList=" + inviteUserList + ", friendInviteUserList="
				+ friendInviteUserList + ", subject=" + subject + ", inviteMessage=" + inviteMessage
				+ ", twitterInviteMessage=" + twitterInviteMessage + "]";
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getInviteMessage() {
		return inviteMessage;
	}
	public void setInviteMessage(String inviteMessage) {
		this.inviteMessage = inviteMessage;
	}
	public FriendInvite() {
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public List<String> getProviderIds() {
		return providerIds;
	}
	public void setProviderIds(List<String> providerIds) {
		this.providerIds = providerIds;
	}
	
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<String> getInviteUserList() {
		return inviteUserList;
	}
	public void setInviteUserList(List<String> inviteUserList) {
		this.inviteUserList = inviteUserList;
	}
	public List<Long> getFriendInviteUserList() {
		return friendInviteUserList;
	}
	public void setFriendInviteUserList(List<Long> friendInviteUserList) {
		this.friendInviteUserList = friendInviteUserList;
	}

}
