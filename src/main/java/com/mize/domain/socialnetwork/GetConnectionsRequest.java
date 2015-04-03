package com.mize.domain.socialnetwork;

import com.mize.domain.auth.User;

public class GetConnectionsRequest {

	private User user;
	private String provider;
	private String searchString;
	private int status;
	private int pageIndex;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int index) {
		this.pageIndex = index;
	}
	
	@Override
	public String toString() {
		return "GetConnectionsRequest [ provider=" + provider + ", searchString=" + searchString
				+ ", status=" + status + ", index=" + pageIndex + "]";
	}
	
	
}
