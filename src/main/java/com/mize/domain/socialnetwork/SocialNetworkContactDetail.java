package com.mize.domain.socialnetwork;

public class SocialNetworkContactDetail implements Comparable<SocialNetworkContactDetail>{
	
	public static final int STATUS_NOT_IN_MIZE = 1;
	public static final int STATUS_IN_MIZE = 2;
	public static final int STATUS_MIZE_FRIEND = 3;
	private String providerUserId;
	private String firstName;
	private String lastName;
	private String pictureURL;
	private int status = STATUS_NOT_IN_MIZE;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SocialNetworkContactDetail [providerUserId=" + providerUserId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", pictureURL=" + pictureURL + ", status=" + status + "]";
	}

	public int compareTo(SocialNetworkContactDetail detail) {
		if (firstName == null ) {
			firstName = "";
		}
		
		if (detail.getFirstName() == null) {
			detail.setFirstName("");
		}
		
		if (firstName.equalsIgnoreCase(detail.getFirstName())) {
			if (lastName == null) {
				lastName = "";
			}
			if (detail.getLastName() == null) {
				detail.setLastName("");
			}
			return lastName.toUpperCase().compareTo(detail.getLastName().toUpperCase());

		} else {
			return firstName.toUpperCase().compareTo(detail.getFirstName().toUpperCase());
		}
	}	
	
}
