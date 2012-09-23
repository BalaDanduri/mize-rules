package com.mize.domain.user;

import com.mize.domain.common.Entity;

public class UserAuth extends Entity {
	private int userId;
	private String userLogin;
	private String password;
	private int userSourceId;
	private AuthProvider provider;
	
	public enum Case {
		SIGNUP, LOGIN
	}

	public enum SignupResult {
		USER_EXISTS, USER_CREATED_UNVERIFIED, USER_CREATED, USER_EXISTS_UNVERIFIED
	}

	public enum LoginResult {
		USER_UNVERIFIED, USER_LOGGED_IN, NOT_FOUND, WRONG_PASSWORD
	}
	
	/**
	 * 
	 */
	public UserAuth() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param userId
	 * @param userLogin
	 * @param password
	 * @param userSourceId
	 * @param provider
	 */
	public UserAuth(int userId, String userLogin, String password,
			int userSourceId, AuthProvider provider) {
		super();
		this.userId = userId;
		this.userLogin = userLogin;
		this.password = password;
		this.userSourceId = userSourceId;
		this.provider = provider;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserSourceId() {
		return userSourceId;
	}
	public void setUserSourceId(int userSourceId) {
		this.userSourceId = userSourceId;
	}
	public AuthProvider getProvider() {
		return provider;
	}
	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}
}
