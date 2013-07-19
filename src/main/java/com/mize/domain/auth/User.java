package com.mize.domain.auth;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonView;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.user.Group;
import com.mize.domain.user.UserBE;
import com.mize.domain.user.UserProfile;
import com.mize.domain.user.UserProfilePrivacy;
import com.mize.domain.user.UserProfileViews;
import com.mize.domain.user.UserProfileViews.PublicView;
import com.mize.domain.user.UserProfileViews.UserProfilePrivacyView;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class User extends MizeEntity implements Comparable<User> {
	
	private static final long serialVersionUID = 6457591358862233006L;
	protected Long id;
    protected String email;
    protected String name;
    protected DateTime lastLogin;
    protected boolean active;
    protected boolean emailValidated;
    protected List<LinkedAccount> linkedAccounts = new ArrayList<LinkedAccount>();
    protected List<UserConnect> userConnects;
    protected UserProfile userProfile;
    protected Long referralId;
    protected UserBE userBe;
    protected UserProfilePrivacy privacy;
	private List<Group> groups = new ArrayList<Group>();
    
    public enum Case {
		SIGNUP, LOGIN , LOGOUT
	}

    public enum SignupResult {
		USER_EXISTS, USER_CREATED_UNVERIFIED, USER_CREATED, USER_EXISTS_UNVERIFIED
	}

    public enum LoginResult {
		USER_UNVERIFIED, USER_LOGGED_IN, NOT_FOUND, WRONG_PASSWORD,USER_FOUND
	}
    
    public User(){
    	userProfile = new UserProfile();
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
	
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}
	
	public UserProfilePrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(UserProfilePrivacy privacy) {
		this.privacy = privacy;
	}

	public UserBE getUserBe() {
		return userBe;
	}

	public void setUserBe(UserBE userBe) {
		this.userBe = userBe;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", lastLogin=" + lastLogin + ", active="
				+ active + ", emailValidated=" + emailValidated + ", linkedAccounts=" + linkedAccounts
				+ ", userConnects=" + userConnects + ", userProfile=" + userProfile + ", referralId=" + referralId
				+ ", userBe=" + userBe + ", privacy=" + privacy + ", groups=" + groups + "]";
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailValidated != other.emailValidated)
			return false;
		return true;
	}
	
	public int compareTo(User user) {
		if ( this == user ) 
			return EQUAL;
		else if (this.id < user.id) 
			return BEFORE;
		else if (user.id == this.id) 
			return EQUAL;
		else if (this.id > user.id)
			return AFTER;
		return EQUAL;		
	}

	
}
