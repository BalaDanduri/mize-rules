package com.mize.domain.auth;

import com.mize.domain.common.MizeEntity;

public class UserConnect extends MizeEntity implements Comparable<UserConnect> {
	
	private static final long serialVersionUID = 678341089266523579L;
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

	public Long getId() {
		return linkedAccountId;
	}
	public void setId(Long linkedAccountId) {
		this.linkedAccountId = linkedAccountId;
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
	
	public int compareTo(UserConnect entity) {
		if ( this == entity ) 
			return EQUAL;
		else if (this.id < entity.id) 
			return BEFORE;
		else if (entity.id == this.id) 
			return EQUAL;
		else if (this.id > entity.id)
			return AFTER;
		return EQUAL;		
	}
	
	@Override
	public String toString() {
		return "UserConnect [linkedAccountId=" + linkedAccountId + ", email=" + email + ", userId="+userId +", provider=" + provider +"]";
	}

}
