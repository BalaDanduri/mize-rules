package com.mize.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonView;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Entity;
import com.mize.domain.common.Gender;
import com.mize.domain.common.PostalAddress;
import com.mize.domain.product.UserProduct;
import com.mize.domain.user.UserProfileViews.UserProfilePrivacyView;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@JsonAutoDetect
public class UserProfile extends Entity {

	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	private Long userId;
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	private UserType userType;
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	private PostalAddress postalAddress;
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private String photoLink;
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private String profileName;
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	private String phoneMobile;
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	private String phoneHome;
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	private String phoneWork;
	
	private String jobTitle;
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private List<UserProduct> want;
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private List<UserProduct> own;
	private Long friendUserId;
	private int friendStatus;
	private String emailOptOut;
	
	
	// Personal Info
	@JsonProperty 
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private String firstName;
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private String lastName;
	
	@DateTimeFormat (pattern="dd-MM-yyyy")
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private DateTime birthdate;
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private Gender gender;
	private String cityState;
	
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	private List<User> friends = new ArrayList<User>();
	private UserProfilePrivacy privacy;
	private int mutualFriendCount;
	private int pageIndex;

	
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
	
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public DateTime getBirthdate() {
		return birthdate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setBirthdate(DateTime birthdate) {
		this.birthdate = birthdate;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@JsonView(UserProfilePrivacyView.class)
	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public String getEmailOptOut() {
		return emailOptOut;
	}
	
	public void setEmailOptOut(String emailOptOut) {
		this.emailOptOut = emailOptOut;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public List<User> getFriends() {
		return friends;
	}

	public void addFriends(List<User> friends) {
		this.friends.addAll(friends);
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public List<UserProduct> getWant() {
		return want;
	}

	public void setWant(List<UserProduct> want) {
		this.want = want;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyView.class)
	public List<UserProduct> getOwn() {
		return own;
	}

	public void setOwn(List<UserProduct> own) {
		this.own = own;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public Long getFriendUserId() {
		return friendUserId;
	}

	public void setFriendUserId(Long friendUserId) {
		this.friendUserId = friendUserId;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public UserProfilePrivacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(UserProfilePrivacy privacy) {
		this.privacy = privacy;
	}
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public int getMutualFriendCount() {
		return mutualFriendCount;
	}

	public void setMutualFriendCount(int mutualFriendCount) {
		this.mutualFriendCount = mutualFriendCount;
	}
	
	@JsonView(UserProfileViews.UserProfilePrivacyHideView.class)
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(int friendStatus) {
		this.friendStatus = friendStatus;
	}
	
	

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((cityState == null) ? 0 : cityState.hashCode());
		result = prime * result + ((emailOptOut == null) ? 0 : emailOptOut.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + friendStatus;
		result = prime * result + ((friendUserId == null) ? 0 : friendUserId.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + mutualFriendCount;
		result = prime * result + ((own == null) ? 0 : own.hashCode());
		result = prime * result + pageIndex;
		result = prime * result + ((phoneHome == null) ? 0 : phoneHome.hashCode());
		result = prime * result + ((phoneMobile == null) ? 0 : phoneMobile.hashCode());
		result = prime * result + ((phoneWork == null) ? 0 : phoneWork.hashCode());
		result = prime * result + ((photoLink == null) ? 0 : photoLink.hashCode());
		result = prime * result + ((postalAddress == null) ? 0 : postalAddress.hashCode());
		result = prime * result + ((privacy == null) ? 0 : privacy.hashCode());
		result = prime * result + ((profileName == null) ? 0 : profileName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		result = prime * result + ((want == null) ? 0 : want.hashCode());
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
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (gender != other.gender)
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
		if (mutualFriendCount != other.mutualFriendCount)
			return false;
		if (own == null) {
			if (other.own != null)
				return false;
		} else if (!own.equals(other.own))
			return false;
		if (pageIndex != other.pageIndex)
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
		if (postalAddress == null) {
			if (other.postalAddress != null)
				return false;
		} else if (!postalAddress.equals(other.postalAddress))
			return false;
		if (privacy == null) {
			if (other.privacy != null)
				return false;
		} else if (!privacy.equals(other.privacy))
			return false;
		if (profileName == null) {
			if (other.profileName != null)
				return false;
		} else if (!profileName.equals(other.profileName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userType != other.userType)
			return false;
		if (want == null) {
			if (other.want != null)
				return false;
		} else if (!want.equals(other.want))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", userType=" + userType + ", postalAddress=" + postalAddress + ", photoLink=" + photoLink + ", profileName=" + profileName + ", phoneMobile=" + phoneMobile + ", phoneHome=" + phoneHome + ", phoneWork=" + phoneWork + ", jobTitle=" + jobTitle + ", want=" + want + ", own=" + own + ", friendUserId=" + friendUserId + ", friendStatus=" + friendStatus + ", emailOptOut=" + emailOptOut + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthdate=" + birthdate + ", gender=" + gender + ", cityState=" + cityState + ", friends=" + friends + ", privacy=" + privacy + ", mutualFriendCount=" + mutualFriendCount + ", pageIndex=" + pageIndex + "]";
	}

	
	
	
	

	
	
	
	
	
}
