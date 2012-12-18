package com.mize.domain.user;


import com.mize.domain.common.Entity;

public class UserProfilePrivacy extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808879417363134780L;
	private Long userId;
	private String displayBirthYear;
	private Long email;
	private Long friends;
	private Long activity;
	private Long want;
	private Long own;
	
	public UserProfilePrivacy() {
		
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getDisplayBirthYear() {
		return displayBirthYear;
	}
	public void setDisplayBirthYear(String displayBirthYear) {
		this.displayBirthYear = displayBirthYear;
	}
	public Long getEmail() {
		return email;
	}
	public void setEmail(Long email) {
		this.email = email;
	}
	public Long getFriends() {
		return friends;
	}
	public void setFriends(Long friends) {
		this.friends = friends;
	}
	public Long getActivity() {
		return activity;
	}
	public void setActivity(Long activity) {
		this.activity = activity;
	}
	public Long getWant() {
		return want;
	}
	public void setWant(Long want) {
		this.want = want;
	}
	public Long getOwn() {
		return own;
	}
	public void setOwn(Long own) {
		this.own = own;
	}
	
}
