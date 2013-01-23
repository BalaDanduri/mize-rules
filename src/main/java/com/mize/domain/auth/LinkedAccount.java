package com.mize.domain.auth;

import com.mize.domain.common.Entity;
import com.mize.domain.auth.User;;

public class LinkedAccount extends Entity {
	/**
	 * Adding these constants to avoid hardcoding in the code.
	 */
	public static final String PROVIDER_FACEBOOK = "facebook";
	public static final String PROVIDER_PASSWORD = "password";
	public static final String PROVIDER_TWITTER= "twitter";
	public static final String PROVIDER_EBAY= "ebay";
	public static final String PROVIDER_LINKEDIN= "linkedin";
	
    private Long id;
    private User user;
    public String providerUserId;
    public String providerKey;
    public String accessToken;
    public String accessTokenSecret;

    public LinkedAccount() {
    	
    }
    
    public LinkedAccount(Long id, User user, String providerUserId, String providerKey, String accessToken) {
		this.id = id;
		this.user = user;
		this.providerUserId = providerUserId;
		this.providerKey = providerKey;
		this.accessToken = accessToken;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getProviderUserId() {
		return providerUserId;
	}
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	public String getProviderKey() {
		return providerKey;
	}
	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
}
