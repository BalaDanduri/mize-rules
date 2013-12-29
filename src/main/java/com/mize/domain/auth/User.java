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
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductRegister;
import com.mize.domain.user.Group;
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
	protected String email;
    protected String name;
    protected DateTime lastLogin;
    protected boolean active;
    protected boolean emailValidated;
    protected BusinessEntity be;
    
	protected List<LinkedAccount> linkedAccounts = new ArrayList<LinkedAccount>();
    @Transient
    protected List<UserConnect> userConnects;
    protected UserProfile userProfile;
    protected Long referralId;
    protected UserBE userBe;
    protected UserProfilePrivacy privacy;
    @Transient
	private List<Group> groups = new ArrayList<Group>();
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
	private List<ProductRegister> productRegisters = new ArrayList<ProductRegister>();
	private List<UserBrandMapping> userBrandMapping = new ArrayList<UserBrandMapping>();
    
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
	@JoinColumn(name = "tenant_id")
	//@JsonManagedReference(value="user_be")
	public BusinessEntity getBe() {
		return be;
	}

	public void setBe(BusinessEntity be) {
		this.be = be;
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
	
	@OneToMany(cascade={CascadeType.ALL}, mappedBy="user")
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
	
	@OneToOne(fetch=FetchType.EAGER ,cascade= {CascadeType.ALL} )
	@JoinColumn(name="id")
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
	
	@OneToOne(mappedBy="user", cascade={CascadeType.ALL})
	@JoinColumn(name="user_id")
	
	public UserProfilePrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(UserProfilePrivacy privacy) {
		this.privacy = privacy;
	}

	@OneToOne(mappedBy = "user",cascade={CascadeType.ALL})
	@JoinColumn(name="user_id")
	public UserBE getUserBe() {
		return userBe;
	}

	public void setUserBe(UserBE userBe) {
		this.userBe = userBe;
	}

	@Transient
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JsonManagedReference(value="user_userGroups")
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}
	
	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL,mappedBy="user")
	@Fetch(value=FetchMode.SUBSELECT)
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
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL)
	@JoinColumn(name="prod_regn_id") 
	@JsonManagedReference(value="user_productRegisters")
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
}
