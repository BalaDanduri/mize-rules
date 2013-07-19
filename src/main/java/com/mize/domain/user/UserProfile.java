package com.mize.domain.user;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.Gender;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.common.PostalAddress;
import com.mize.domain.product.UserProduct;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@JsonAutoDetect
public class UserProfile extends MizeEntity implements Comparable<UserProfile> {

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
	private String lastName;	
	@DateTimeFormat (pattern="dd-MM-yyyy")
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
	
	private Map<String, URL> photoURLMap = new HashMap<String, URL>();
	
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

	public Long getId() {
		return userId;
	}
	public void setId(Long userId) {
		this.userId = userId;
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
	public int getMutualFriendCount() {
		return mutualFriendCount;
	}

	public void setMutualFriendCount(int mutualFriendCount) {
		this.mutualFriendCount = mutualFriendCount;
	}
	
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
	

	public int getMizeUserCount() {
		return mizeUserCount;
	}

	public void setMizeUserCount(int mizeUserCount) {
		this.mizeUserCount = mizeUserCount;
	}

	public int getWantCount() {
		return wantCount;
	}

	public void setWantCount(int wantCount) {
		this.wantCount = wantCount;
	}

	public int getOwnCount() {
		return ownCount;
	}

	public void setOwnCount(int ownCount) {
		this.ownCount = ownCount;
	}

	
	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public Map<String, URL> getPhotoURLMap() {
		return photoURLMap;
	}

	public void setPhotoURLMap(Map<String, URL> photoURLMap) {
		this.photoURLMap = photoURLMap;
	}

	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	public int getProdFeedbackCount() {
		return prodFeedbackCount;
	}

	public void setProdFeedbackCount(int prodFeedbackCount) {
		this.prodFeedbackCount = prodFeedbackCount;
	}

	public long getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(long friendsCount) {
		this.friendsCount = friendsCount;
	}

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
		int result = super.hashCode();
		result = PRIME * result + ((userId == null) ? 0 : userId.hashCode());
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
	
}
