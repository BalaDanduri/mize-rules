package com.mize.domain.auth;

import com.mize.domain.common.Entity;

public class UserAuth extends Entity {
	private int userId;
	private String userLogin;
	private String password;
	private int userSourceId;
	private AuthProvider provider;
	private boolean isActive;
	private boolean isValidated;
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
	 * @param isActive
	 * @param isValidated
	 */
	public UserAuth(int userId, String userLogin, String password,
			int userSourceId, AuthProvider provider, boolean isActive,
			boolean isValidated) {
		super();
		this.userId = userId;
		this.userLogin = userLogin;
		this.password = password;
		this.userSourceId = userSourceId;
		this.provider = provider;
		this.isActive = isActive;
		this.isValidated = isValidated;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isValidated() {
		return isValidated;
	}
	
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
}
