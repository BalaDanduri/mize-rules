package com.mize.domain.socialnetwork;

import java.util.Map;

public class SocialNetworkContact {

	private String providerName;
	private Long userId;
	private Long countOfConnections;
	private Map<String, SocialNetworkContactDetail> contactDetails;
	public String getProviderName() {
		return providerName;
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
	public Map<String, SocialNetworkContactDetail> getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(Map<String, SocialNetworkContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}
	public Long getCountOfConnections() {
		return countOfConnections;
	}
	public void setCountOfConnections(Long countOfConnections) {
		this.countOfConnections = countOfConnections;
	}
	@Override
	public String toString() {
		return "SocialNetworkContact [providerName=" + providerName + ", userId=" + userId + ", totalNoOfConnections="
				+ countOfConnections + ", contactDetails=" + contactDetails + "]";
	}
	
	
}
