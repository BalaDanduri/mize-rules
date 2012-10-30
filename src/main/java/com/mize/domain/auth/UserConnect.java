package com.mize.domain.auth;

import com.mize.domain.common.Entity;

public class UserConnect extends Entity {
	/**
	 * Adding these constants to avoid hardcoding in the code.
	 */
    private Long linkedAccountId;
    private Long userId;
    public String email;
    public String provider;

    public UserConnect() {
    	
    }
    
    public UserConnect(Long linkedAccountId, Long userId, String email,
			String provider) {
		this.linkedAccountId = linkedAccountId;
		this.userId = userId;
		this.email = email;
		this.provider = provider;
	}

	public Long getLinkedAccountId() {
		return linkedAccountId;
	}
	public void setLinkedAccountId(Long linkedAccountId) {
		this.linkedAccountId = linkedAccountId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
}
