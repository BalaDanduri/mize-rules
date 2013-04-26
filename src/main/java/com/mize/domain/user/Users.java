package com.mize.domain.user;

import java.util.List;

import com.mize.domain.auth.User;

public class Users {
	private Integer pageIndex;
	private Integer userCount;
	List<User> userList;
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getUserCount() {
		return userCount;
	}
	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}
	public List<User> getUser() {
		return userList;
	}
	public void setUser(List<User> userList) {
		this.userList = userList;
	}
	

}
