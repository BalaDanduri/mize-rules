package com.mize.domain.auth;

import com.mize.domain.common.MizeEntity;

public class LinkedAccount extends MizeEntity implements Comparable<LinkedAccount> {
	
	private static final long serialVersionUID = 1947755331862630858L;
	public String providerUserId;
    public String providerKey;
    public String accessToken;
    public String accessTokenSecret;
    public String userName;
    public String firstTime;
    private User user;
    
	/**
	 * Adding these constants to avoid hardcoding in the code.
	 */
	public static final String PROVIDER_FACEBOOK = "facebook";
	public static final String PROVIDER_PASSWORD = "password";
	public static final String PROVIDER_TWITTER= "twitter";
	public static final String PROVIDER_EBAY= "ebay";
	public static final String PROVIDER_LINKEDIN= "linkedin";

    
    public LinkedAccount() {    	
    }
    
    public enum Provider{
    	PROVIDER_FACEBOOK("facebook"),PROVIDER_PASSWORD("password"),PROVIDER_TWITTER("twitter"),PROVIDER_LINKEDIN("linkedin");
    	private String val;
    	Provider(String v){
    		val = v;
    	}
    	public String getValue(){
    		return val;
    	}
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
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	@Override
	public String toString() {
		return "LinkedAccount [providerUserId=" + providerUserId + ", providerKey=" + providerKey + ", accessToken=" + accessToken + ", accessTokenSecret=" + accessTokenSecret + ", userName=" + userName + ", firstTime=" + firstTime + ", user=" + user + ", id=" + id + "]";
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((providerKey == null) ? 0 : providerKey.hashCode());
		result = PRIME * result + ((providerUserId == null) ? 0 : providerUserId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkedAccount other = (LinkedAccount) obj;		
		if (providerKey == null) {
			if (other.providerKey != null)
				return false;
		} else if (!providerKey.equals(other.providerKey))
			return false;
		if (providerUserId == null) {
			if (other.providerUserId != null)
				return false;
		} else if (!providerUserId.equals(other.providerUserId))
			return false;
		return true;
	}
	
	public int compareTo(LinkedAccount account) {
		if ( this == account ) 
			return EQUAL;
		else if (this.id < account.id) 
			return BEFORE;
		else if (account.id == this.id) 
			return EQUAL;
		else if (this.id > account.id)
			return AFTER;
		return EQUAL;		
	}

}
