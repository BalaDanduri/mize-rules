package com.mize.domain.user;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.Gender;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.common.PostalAddress;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.product.UserProduct;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "user_profile")
@JsonAutoDetect
public class UserProfile extends MizeSceEntityAudit implements Serializable, Comparable<UserProfile> {

	private static final long serialVersionUID = 1396029824729565589L;
	private Long userId;
	private UserType userType;
	private PostalAddress postalAddress;
	private String photoLink;
	private String profileName;
	private String phoneMobile;
	private String phoneHome;
	private String phoneWork;	
	private String jobTitle;
	private List<UserProduct> want;
	private List<UserProduct> own;
	private Long friendUserId;
	private int friendStatus;
	private String emailOptOut;
	private String firstName;
	private String middleName;
	private String lastName;	
	private DateTime birthdate;
	private Gender gender;
	private String cityState;
	private List<User> friends = new ArrayList<User>();
	private int mutualFriendCount;
	private int pageIndex;
	private int mizeUserCount;
	private int wantCount;
	private int ownCount;
	private String timezone;
	private UserProfilePrivacy privacy;	
	private boolean isFriend;
	private int prodFeedbackCount;
	private long friendsCount;
	List<String> listNames = new ArrayList<String>();
	List<UserAddress> addresses = new ArrayList<UserAddress>();
	private String promptForAppRating;
	private Map<String, URL> photoURLMap = new HashMap<String, URL>();
	private User user;
	private Locale locale;
	@Transient
	private UserPreference userPreference;
	
	public enum UserProfileResult {
		PROFILE_CREATED, PROFILE_UPDATED
	}
	public enum Timezone {
		EST,CST,AST,MST,PST; 
	}

	public UserProfile() {
		
	}
	
	public UserProfile(Long userId, UserType userType, PostalAddress postalAddress,
			String firstName, String lastName, DateTime birthdate, Gender gender,String photoLink, String jobTitle) {
		
		this.userId = userId;
		this.userType = userType;
		this.postalAddress = postalAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
		this.photoLink=photoLink;
		this.jobTitle=jobTitle;
	}
	
	public UserProfile(Long userId, UserType userType, PostalAddress postalAddress,
			String firstName, String lastName, DateTime birthdate, Gender gender) {
		
		this.userId = userId;
		this.userType = userType;
		this.postalAddress = postalAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
	}	

	@Id
	@GenericGenerator(name="id",strategy="increment")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch=FetchType.LAZY,targetEntity=User.class)
	@JoinColumn(name="user_id")
	@JsonBackReference(value="userprofile_user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Transient
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	@Transient
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "birth_day",updatable = false)
	public DateTime getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}
	
	@org.hibernate.annotations.Type(type="com.mize.domain.util.GenderJPA")	
	@Column(name = "gender")
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Column(name = "photo_link")
	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}
	
	@Column(name = "profile_name")
	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	
	@Column(name = "phone_mobile")
	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	
	@Column(name = "phone_home")
	public String getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	
	@Column(name = "phone_work")
	public String getPhoneWork() {
		return phoneWork;
	}
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	
	@Transient
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Column(name = "email_opt_out")
	public String getEmailOptOut() {
		return emailOptOut;
	}
	
	public void setEmailOptOut(String emailOptOut) {
		this.emailOptOut = emailOptOut;
	}
	
	@Transient
	public List<User> getFriends() {
		return friends;
	}

	public void addFriends(List<User> friends) {
		this.friends.addAll(friends);
	}
	
	@Transient
	public List<UserProduct> getWant() {
		return want;
	}

	public void setWant(List<UserProduct> want) {
		this.want = want;
	}
	
	@Transient
	public List<UserProduct> getOwn() {
		return own;
	}

	public void setOwn(List<UserProduct> own) {
		this.own = own;
	}
	
	@Transient
	public Long getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(Long friendUserId) {
		this.friendUserId = friendUserId;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	@Transient
	public UserProfilePrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(UserProfilePrivacy privacy) {
		this.privacy = privacy;
	}
	
	@Transient
	public int getMutualFriendCount() {
		return mutualFriendCount;
	}

	public void setMutualFriendCount(int mutualFriendCount) {
		this.mutualFriendCount = mutualFriendCount;
	}
	
	@Transient
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Transient
	public int getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(int friendStatus) {
		this.friendStatus = friendStatus;
	}
	
	@Transient
	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	
	@Transient
	public int getMizeUserCount() {
		return mizeUserCount;
	}

	public void setMizeUserCount(int mizeUserCount) {
		this.mizeUserCount = mizeUserCount;
	}

	@Transient
	public int getWantCount() {
		return wantCount;
	}

	public void setWantCount(int wantCount) {
		this.wantCount = wantCount;
	}

	@Transient
	public int getOwnCount() {
		return ownCount;
	}

	public void setOwnCount(int ownCount) {
		this.ownCount = ownCount;
	}
	
	@Column(name = "timezone")
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Transient
	public Map<String, URL> getPhotoURLMap() {
		return photoURLMap;
	}

	public void setPhotoURLMap(Map<String, URL> photoURLMap) {
		this.photoURLMap = photoURLMap;
	}

	@Transient
	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	@Transient
	public int getProdFeedbackCount() {
		return prodFeedbackCount;
	}

	public void setProdFeedbackCount(int prodFeedbackCount) {
		this.prodFeedbackCount = prodFeedbackCount;
	}

	@Transient
	public long getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}

	@Transient
	public List<String> getListNames() {
		return listNames;
	}

	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}
	
		@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", photoLink=" + photoLink + ", profileName=" + profileName + ", phoneMobile=" +
				phoneMobile + ", phoneHome=" + phoneHome + ", phoneWork=" + phoneWork + ", jobTitle=" + jobTitle + ", emailOptOut=" + 
				emailOptOut + ", firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate + ", gender=" 
				+ gender + ", cityState=" + cityState + ", timezone=" + timezone + ", privacy=" + privacy + ", photoURLMap=" + photoURLMap + ", id=" + id
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result
				+ ((cityState == null) ? 0 : cityState.hashCode());
		result = prime * result
				+ ((emailOptOut == null) ? 0 : emailOptOut.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + friendStatus;
		result = prime * result
				+ ((friendUserId == null) ? 0 : friendUserId.hashCode());
		result = prime * result + (int) (friendsCount ^ (friendsCount >>> 32));
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isFriend ? 1231 : 1237);
		result = prime * result
				+ ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((listNames == null) ? 0 : listNames.hashCode());
		result = prime * result
				+ ((phoneHome == null) ? 0 : phoneHome.hashCode());
		result = prime * result
				+ ((phoneMobile == null) ? 0 : phoneMobile.hashCode());
		result = prime * result
				+ ((phoneWork == null) ? 0 : phoneWork.hashCode());
		result = prime * result
				+ ((photoLink == null) ? 0 : photoLink.hashCode());
		result = prime * result
				+ ((profileName == null) ? 0 : profileName.hashCode());
		result = prime * result
				+ ((timezone == null) ? 0 : timezone.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + wantCount;
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
		UserProfile other = (UserProfile) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (cityState == null) {
			if (other.cityState != null)
				return false;
		} else if (!cityState.equals(other.cityState))
			return false;
		if (emailOptOut == null) {
			if (other.emailOptOut != null)
				return false;
		} else if (!emailOptOut.equals(other.emailOptOut))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friendStatus != other.friendStatus)
			return false;
		if (friendUserId == null) {
			if (other.friendUserId != null)
				return false;
		} else if (!friendUserId.equals(other.friendUserId))
			return false;
		if (friendsCount != other.friendsCount)
			return false;
		if (gender != other.gender)
			return false;
		if (isFriend != other.isFriend)
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (listNames == null) {
			if (other.listNames != null)
				return false;
		} else if (!listNames.equals(other.listNames))
			return false;
		if (phoneHome == null) {
			if (other.phoneHome != null)
				return false;
		} else if (!phoneHome.equals(other.phoneHome))
			return false;
		if (phoneMobile == null) {
			if (other.phoneMobile != null)
				return false;
		} else if (!phoneMobile.equals(other.phoneMobile))
			return false;
		if (phoneWork == null) {
			if (other.phoneWork != null)
				return false;
		} else if (!phoneWork.equals(other.phoneWork))
			return false;
		if (photoLink == null) {
			if (other.photoLink != null)
				return false;
		} else if (!photoLink.equals(other.photoLink))
			return false;
		if (profileName == null) {
			if (other.profileName != null)
				return false;
		} else if (!profileName.equals(other.profileName))
			return false;
		if (timezone == null) {
			if (other.timezone != null)
				return false;
		} else if (!timezone.equals(other.timezone))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	public int compareTo(UserProfile profile) {
		if ( this == profile ) 
			return EQUAL;
		else if (this.id < profile.id) 
			return BEFORE;
		else if (profile.id == this.id) 
			return EQUAL;
		else if (this.id > profile.id)
			return AFTER;
		return EQUAL;		
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "user")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<UserAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<UserAddress> addresses) {
		this.addresses = addresses;
	}

	@Column(name = "prompt_app_rating")
	public String getPromptForAppRating() {
		return promptForAppRating;
	}

	public void setPromptForAppRating(String promptForAppRating) {
		this.promptForAppRating = promptForAppRating;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Transient
	public UserPreference getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}
	

	
}
