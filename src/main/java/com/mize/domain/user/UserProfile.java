package com.mize.domain.user;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.common.Gender;
import com.mize.domain.common.PostalAddress;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@JsonAutoDetect
public class UserProfile extends Entity {
	private int userId;
	private UserType userType;
	private PostalAddress postalAddress;
	private String photoLink;
	
	private String profileName;
	private String phoneMobile;
	private String phoneHome;
	private String phoneWork;
	private String jobTitle;
	
	
	// Personal Info
	@JsonProperty 
	private String firstName;
	private String lastName;
	
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime birthdate;
	private Gender gender;
	
	public enum UserProfileResult {
		PROFILE_CREATED, PROFILE_UPDATED
	}

	public UserProfile() {
		
	}
	
	public UserProfile(int userId, UserType userType, PostalAddress postalAddress,
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
	
	public UserProfile(int userId, UserType userType, PostalAddress postalAddress,
			String firstName, String lastName, DateTime birthdate, Gender gender) {
		
		this.userId = userId;
		this.userType = userType;
		this.postalAddress = postalAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.gender = gender;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
}
