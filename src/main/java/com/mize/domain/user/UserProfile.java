package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.common.Gender;
import com.mize.domain.common.PostalAddress;
import com.mize.domain.product.UserProduct;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@JsonAutoDetect
public class UserProfile extends Entity {
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
	
	private String emailOptOut;
	private String pageIndex;
	
	// Personal Info
	@JsonProperty 
	private String firstName;
	private String lastName;
	
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime birthdate;
	private Gender gender;
	
	private List<User> friends = new ArrayList<User>();
	private UserProfilePrivacy privacy;
	
	public enum UserProfileResult {
		PROFILE_CREATED, PROFILE_UPDATED
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
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class)
	public DateTime getBirthdate() {
		return birthdate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}
	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public String getEmailOptOut() {
		return emailOptOut;
	}
	
	public void setEmailOptOut(String emailOptOut) {
		this.emailOptOut = emailOptOut;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void addFriends(List<User> friends) {
		this.friends.addAll(friends);
	}
	public List<UserProduct> getWant() {
		return want;
	}

	public void setWant(List<UserProduct> want) {
		this.want = want;
	}

	public List<UserProduct> getOwn() {
		return own;
	}

	public void setOwn(List<UserProduct> own) {
		this.own = own;
	}

	public Long getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(Long friendUserId) {
		this.friendUserId = friendUserId;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public UserProfilePrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(UserProfilePrivacy privacy) {
		this.privacy = privacy;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
}
