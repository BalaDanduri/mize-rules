package com.mize.domain.auth;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductRegister;
import com.mize.domain.user.Group;
import com.mize.domain.user.UserAddress;
import com.mize.domain.user.UserBE;
import com.mize.domain.user.UserBrandMapping;
import com.mize.domain.user.UserGroup;
import com.mize.domain.user.UserProfile;
import com.mize.domain.user.UserProfilePrivacy;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="users")
public class User extends MizeEntity implements Comparable<User> {
	
	private static final long serialVersionUID = 6457591358862233006L;
	private String email;
	private String name;
	private DateTime lastLogin;
	private boolean active;
	private boolean emailValidated;
	private BusinessEntity tenant;
    private String loginId;
    
    private List<LinkedAccount> linkedAccounts = new ArrayList<LinkedAccount>();
    @Transient
    private List<UserConnect> userConnects;
    private UserProfile userProfile;
    private Long referralId;
    private UserBE userBe;
    private UserProfilePrivacy privacy;
	private List<Group> groups = new ArrayList<Group>();
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
    
    @Transient
	private List<ProductRegister> productRegisters = new ArrayList<ProductRegister>();
	private List<UserBrandMapping> userBrandMapping = new ArrayList<UserBrandMapping>();
	private List<UserAddress> addresses = new ArrayList<UserAddress>();
    
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
    
	public User(Long id, String email, String name, DateTime lastLogin,boolean active, boolean emailValidated,List<LinkedAccount> linkedAccounts) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastLogin = lastLogin;
		this.active = active;
		this.emailValidated = emailValidated;
		this.linkedAccounts = linkedAccounts;
	}
	
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
    
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tenant_id" , insertable=false, updatable=false)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column(name="email",nullable=true,length=255)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="name",nullable=true,length=255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Column(name = "last_login",  nullable = false)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getLastLogin() {
		return lastLogin;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)		
	public void setLastLogin(DateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	@Column(name="active",nullable=true)
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Column(name="email_validated", nullable= true)
	public boolean isEmailValidated() {
		return emailValidated;
	}
	public void setEmailValidated(boolean emailValidated) {
		this.emailValidated = emailValidated;
	}
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="user",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="user_linkedAccount")
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
	
	@OneToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL}, mappedBy="user")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public List<UserAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<UserAddress> addresses) {
		this.addresses = addresses;
	}

	@Transient
	public List<UserConnect> getUserConnects() {
		return userConnects;
	}
	
	public void setUserConnects(List<UserConnect> userConnects) {
		this.userConnects = userConnects;
	}
	
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
	
	@OneToOne(fetch=FetchType.EAGER ,cascade= {CascadeType.ALL},mappedBy="user" ,orphanRemoval = true)
	public UserProfile getUserProfile() {
		return userProfile;
	}

	@Column(name="referral_id",nullable=true,length=20)
	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}
	
	@OneToOne(fetch=FetchType.EAGER ,cascade= {CascadeType.ALL},mappedBy="user" ,orphanRemoval = true)
	public UserProfilePrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(UserProfilePrivacy privacy) {
		this.privacy = privacy;
	}

	@OneToOne(fetch=FetchType.EAGER,mappedBy = "user",cascade={CascadeType.ALL},orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public UserBE getUserBe() {
		return userBe;
	}

	public void setUserBe(UserBE userBe) {
		this.userBe = userBe;
	}

	@Transient
	@JsonIgnore(value=false)
	public List<Group> getGroups() {
		return groups;
	}

	@JsonIgnore(false)
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade={CascadeType.ALL},orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="user_userGroups")
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}
	
	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="user",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="user_brandMapping")
    public List<UserBrandMapping> getUserBrandMapping() {
		return userBrandMapping;
	}

	public void setUserBrandMapping(List<UserBrandMapping> userBrandMapping) {
		this.userBrandMapping = userBrandMapping;
	}
	
	@JsonIgnore(false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}
	
	@JsonIgnore(false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@JsonIgnore(false)
	@Column(name = "created_by", updatable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}
	
	@JsonIgnore(false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)
	@JsonIgnore(false)
	@Column(name = "created_date", updatable = false)
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)
	@Column(name = "updated_date")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Transient
	public List<ProductRegister> getProductRegisters() {
		return productRegisters;
	}

	public void setProductRegisters(List<ProductRegister> productRegisters) {
		this.productRegisters = productRegisters;
	}
	
	@JsonIgnore
	@Transient
	public String getUserName(){
		String name = Formatter.EMPTY;
		if(getUserProfile() != null){
			name = WordUtils.capitalize(Formatter.makeNotNullString(getUserProfile().getFirstName()))+" "+WordUtils.capitalize(Formatter.makeNotNullString(getUserProfile().getLastName()));
			name = Formatter.makeNotNullString(name);
		}
		return name;
	}
	
	@JsonIgnore
	@Transient
	public String getFirstName(){
		String name = Formatter.EMPTY;
		if(getUserProfile() != null){
			name = WordUtils.capitalize(Formatter.makeNotNullString(getUserProfile().getFirstName()));
			name = Formatter.makeNotNullString(name);
		}
		return name;
	}

	@Column(name = "login_id")
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Override
	public int compareTo(User arg0) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (emailValidated ? 1231 : 1237);
		result = prime * result
				+ ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((referralId == null) ? 0 : referralId.hashCode());
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
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (referralId == null) {
			if (other.referralId != null)
				return false;
		} else if (!referralId.equals(other.referralId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id ="+id+", email=" + email + ", name=" + name + ", lastLogin="
				+ lastLogin + ", active=" + active + ", emailValidated="
				+ emailValidated + ", loginId=" + loginId + ", referralId="
				+ referralId + "]";
	}
	
	
	
}
