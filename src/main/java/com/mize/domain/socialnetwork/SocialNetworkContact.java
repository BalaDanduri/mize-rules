package com.mize.domain.socialnetwork;

import java.util.List;

public class SocialNetworkContact {

	private String providerName;
	private Long userId;
	private List<SocialNetworkContactDetail> contactDetails;
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
	public List<SocialNetworkContactDetail> getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(List<SocialNetworkContactDetail> contactDetails) {
		this.contactDetails = contactDetails;
	}
	@Override
	public String toString() {
		return "SocialNetworkContact [providerName=" + providerName + ", userId=" + userId + ", contactDetails="
				+ contactDetails + "]";
	}
	
	
}
