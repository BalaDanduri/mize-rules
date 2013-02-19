package com.mize.domain.auth;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonView;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.user.UserProfile;
import com.mize.domain.user.UserProfileViews;
import com.mize.domain.user.UserProfileViews.PublicView;
import com.mize.domain.user.UserProfileViews.UserProfilePrivacyView;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class User extends Entity {
	
	private static final long serialVersionUID = 6457591358862233006L;
	protected Long id;
    protected String email;
    protected String name;
    protected DateTime lastLogin;
    protected boolean active;
    protected boolean emailValidated;
    protected List<LinkedAccount> linkedAccounts;
    protected List<UserConnect> userConnects;
    protected UserProfile userProfile;
    protected Long referralId;
    
    public enum Case {
		SIGNUP, LOGIN , LOGOUT
	}

    public enum SignupResult {
		USER_EXISTS, USER_CREATED_UNVERIFIED, USER_CREATED, USER_EXISTS_UNVERIFIED
	}

    public enum LoginResult {
		USER_UNVERIFIED, USER_LOGGED_IN, NOT_FOUND, WRONG_PASSWORD,USER_FOUND
	}

	
    public User() {
		super();
	}

    public User(Long id) {
		this.id = id;
	}

    
	public User(Long id, String email, String name, DateTime lastLogin,
			boolean active, boolean emailValidated,
			List<LinkedAccount> linkedAccounts) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastLogin = lastLogin;
		this.active = active;
		this.emailValidated = emailValidated;
		this.linkedAccounts = linkedAccounts;
	}
	
	@JsonView(PublicView.class)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@JsonView(UserProfilePrivacyView.class)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public DateTime getLastLogin() {
		return lastLogin;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)		
	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public boolean isEmailValidated() {
		return emailValidated;
	}
	public void setEmailValidated(boolean emailValidated) {
		this.emailValidated = emailValidated;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public List<LinkedAccount> getLinkedAccounts() {
		return linkedAccounts;
	}
	
	public void setLinkedAccounts(List<LinkedAccount> linkedAccounts) {
		this.linkedAccounts = linkedAccounts;
	}

	public void  setLinkedAccount(LinkedAccount linkedAccount) {
		if(linkedAccounts==null) {
			linkedAccounts = new ArrayList<LinkedAccount>();
		}
		linkedAccounts.add(linkedAccount);
	}
	
	public void  addLinkedAccount(LinkedAccount linkedAccount) {
		if(linkedAccounts==null) {
			linkedAccounts = new ArrayList<LinkedAccount>();
		}
		linkedAccounts.add(linkedAccount);
	}
	
	public void addLinkedAccounts(List<LinkedAccount> linkedaccounts) {
		if(this.linkedAccounts==null) {
			this.linkedAccounts = new ArrayList<LinkedAccount>();
		} else {
			this.linkedAccounts.clear();
		}
		for (LinkedAccount linkedAccount : linkedaccounts) {
			this.linkedAccounts.add(linkedAccount);
		}	
	}
	
	public void clearLinkedAccounts() {
		if(this.linkedAccounts!=null) {
			this.linkedAccounts.clear();
		}
	}
	
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public List<UserConnect> getUserConnects() {
		return userConnects;
	}
	
	public void setUserConnects(List<UserConnect> userConnects) {
		this.userConnects = userConnects;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public void  setUserConnect(UserConnect UserConnect) {
		if(userConnects==null) {
			userConnects = new ArrayList<UserConnect>();
		}
		userConnects.add(UserConnect);
	}
	
	public void  addUserConnect(UserConnect UserConnect) {
		if(userConnects==null) {
			userConnects = new ArrayList<UserConnect>();
		}
		userConnects.add(UserConnect);
	}
	
	public void addUserConnects(List<UserConnect> userConnects) {
		if(this.userConnects==null) {
			this.userConnects = new ArrayList<UserConnect>();
		} else {
			this.userConnects.clear();
		}
		for (UserConnect UserConnect : userConnects) {
			this.userConnects.add(UserConnect);
		}	
	}
	
	public void clearUserConnects() {
		if(this.userConnects!=null) {
			this.userConnects.clear();
		}
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", lastLogin=" + lastLogin + ", active="
				+ active + ", emailValidated=" + emailValidated + ", linkedAccounts=" + linkedAccounts
				+ ", userConnects=" + userConnects + ", userProfile=" + userProfile + ", referralId=" + referralId
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (emailValidated ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result
				+ ((linkedAccounts == null) ? 0 : linkedAccounts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((userConnects == null) ? 0 : userConnects.hashCode());
		result = prime * result
				+ ((userProfile == null) ? 0 : userProfile.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (active != other.active)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailValidated != other.emailValidated)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (linkedAccounts == null) {
			if (other.linkedAccounts != null)
				return false;
		} else if (!linkedAccounts.equals(other.linkedAccounts))
			return false;
		if (userConnects == null) {
			if (other.userConnects != null)
				return false;
		} else if (!userConnects.equals(other.userConnects)) {
			return false;
		} 
		if (userProfile == null) {
			if (other.userProfile != null)
				return false;
		} else if (!userProfile.equals(other.userProfile))
		return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
}
