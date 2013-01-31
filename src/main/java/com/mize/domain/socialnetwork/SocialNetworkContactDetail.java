package com.mize.domain.socialnetwork;

public class SocialNetworkContactDetail {
	
	private String providerUserId;
	private String firstName;
	private String lastName;
	private String pictureURL;
	private String status;
	public String getProviderUserId() {
		return providerUserId;
	}
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SocialNetworkContactDetail [providerUserId=" + providerUserId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", pictureURL=" + pictureURL + ", status=" + status + "]";
	}

	
}
