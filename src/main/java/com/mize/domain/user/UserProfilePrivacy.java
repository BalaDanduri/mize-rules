package com.mize.domain.user;


import com.mize.domain.common.Entity;

public class UserProfilePrivacy extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808879417363134780L;
	private Long userId;
	private int contact;
	private int personal;
	private String displayBirthYear;
	private int email;
	private int friends;
	private int activity;
	private int want;
	private int own;
	
	public UserProfilePrivacy() {
		
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public int getPersonal() {
		if (personal == 0 ) {
			personal = 2;
		}
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}

	public int getContact() {
		if (contact == 0 ) {
			contact = 2;
		}
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getDisplayBirthYear() {
		if (displayBirthYear == null) {
			displayBirthYear = "Y";
		}
		return displayBirthYear;
	}
	public void setDisplayBirthYear(String displayBirthYear) {
		this.displayBirthYear = displayBirthYear;
	}
	public int getEmail() {
		if (email == 0 ) {
			email = 2;
		}
		return email;
	}
	public void setEmail(int email) {
		this.email = email;
	}
	public int getFriends() {
		if (friends == 0 ) {
			friends = 2;
		}
		return friends;
	}
	public void setFriends(int friends) {
		this.friends = friends;
	}
	public int getActivity() {
		if (activity == 0 ) {
			activity = 2;
		}
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public int getWant() {
		if (want == 0 ) {
			want = 2;
		}
		return want;
	}
	public void setWant(int want) {
		this.want = want;
	}
	public int getOwn() {
		if (own == 0 ) {
			own = 2;
		}
		return own;
	}
	public void setOwn(int own) {
		this.own = own;
	}
	
}
