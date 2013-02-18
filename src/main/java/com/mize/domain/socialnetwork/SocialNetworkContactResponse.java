package com.mize.domain.socialnetwork;

import java.util.List;

public class SocialNetworkContactResponse {

	private String providerName;
	private Long userId;
	private List<SocialNetworkContactDetail> mizeFriends;
	private List<SocialNetworkContactDetail> mizeContacts;
	private List<SocialNetworkContactDetail> nonmizeContacts;
	public String getProviderName() {
		return providerName;
	}
	public List<SocialNetworkContactDetail> getMizeFriends() {
		return mizeFriends;
	}
	public void setMizeFriends(List<SocialNetworkContactDetail> mizeFriends) {
		this.mizeFriends = mizeFriends;
	}
	public List<SocialNetworkContactDetail> getMizeContacts() {
		return mizeContacts;
	}
	public void setMizeContacts(List<SocialNetworkContactDetail> mizeContacts) {
		this.mizeContacts = mizeContacts;
	}
	public List<SocialNetworkContactDetail> getNonmizeContacts() {
		return nonmizeContacts;
	}
	public void setNonmizeContacts(List<SocialNetworkContactDetail> nonmizeContacts) {
		this.nonmizeContacts = nonmizeContacts;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "SocialNetworkContactResponse [providerName=" + providerName + ", userId=" + userId + ", mizeFriends="
				+ mizeFriends + ", mizeContacts=" + mizeContacts + ", nonmizeContacts=" + nonmizeContacts + "]";
	}
	
}
