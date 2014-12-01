package com.mize.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name="linked_account")
public class LinkedAccount extends MizeSceEntityAudit implements Comparable<LinkedAccount> {
	
	private static final long serialVersionUID = 1947755331862630858L;
	public String providerUserId;
    public String providerKey;
    public String accessToken;
    public String accessTokenSecret;
    public String userName;
    public String firstTime;
    private String password;
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
	@JsonBackReference(value="user_linkedAccount")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="provider_user_id")
	public String getProviderUserId() {
		return providerUserId;
	}
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	
	@Column(name="provider_key")
	public String getProviderKey() {
		return providerKey;
	}
	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}
	
	@Column(name="access_token")
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Column(name="access_token_secret")
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	
	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="first_login")
	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	
	@Transient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LinkedAccount [providerUserId=" + providerUserId + ", providerKey=" + providerKey + ", accessToken=" + accessToken + 
					", accessTokenSecret=" + accessTokenSecret + ", userName=" + userName + ", firstTime=" + firstTime + ", id=" + id + "]";
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
