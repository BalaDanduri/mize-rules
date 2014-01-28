package com.mize.domain.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="user_profile_privacy")
public class UserProfilePrivacy extends MizeEntity implements Comparable<UserProfilePrivacy> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808879417363134780L;
	/*private Long userId;*/
	private String displayBirthYear;
	private Long email;
	private Long friends;
	private Long activity;
	private Long want;
	private Long own;
	private Long birthDate;
	private Long gender;
	private Long cityState;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime createdDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime updatedDate;
	protected int createdBy;
	protected int updatedBy;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return this.id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JsonBackReference(value="userProfilePrivacy_user")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserProfilePrivacy() {
		
	}
	public enum Privacy{
		All(1),Friends(2),Private(3);
		int num;
		Privacy(int num){
			this.num = num;
		}
		public int getNum(){
			return num;
		}
	}
	
	/*public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}*/
	
	@Column(name="display_birthyear", nullable=true)
	public String getDisplayBirthYear() {
		return displayBirthYear;
	}
	public void setDisplayBirthYear(String displayBirthYear) {
		this.displayBirthYear = displayBirthYear;
	}
	
	@Column(name="email", nullable=true)
	public Long getEmail() {
		return email;
	}
	public void setEmail(Long email) {
		this.email = email;
	}
	
	@Column(name="friends", nullable=true)
	public Long getFriends() {
		return friends;
	}
	public void setFriends(Long friends) {
		this.friends = friends;
	}
	
	@Column(name="activity", nullable=true)
	public Long getActivity() {
		return activity;
	}
	public void setActivity(Long activity) {
		this.activity = activity;
	}
	
	@Column(name="want", nullable=true)
	public Long getWant() {
		return want;
	}
	public void setWant(Long want) {
		this.want = want;
	}
	
	@Column(name="own", nullable=true)
	public Long getOwn() {
		return own;
	}
	public void setOwn(Long own) {
		this.own = own;
	}
	
	@Column(name="birthdate", nullable=true)
	public Long getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Long birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name="gender", nullable=true)
	public Long getGender() {
		return gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}
	
	@Column(name="city_state", nullable=true)
	public Long getCityState() {
		return cityState;
	}
	public void setCityState(Long cityState) {
		this.cityState = cityState;
	}

/*	@Column(name="created_by", nullable=true)
	@JsonIgnore
	public Integer getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name="created_date", nullable=true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	/*@Column(name="updated_by", nullable=true)
	@JsonIgnore
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	@Column(name="updated_date", nullable=true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
*/	
	public int compareTo(UserProfilePrivacy privacy) {
		if ( this == privacy ) 
			return EQUAL;
		else if (this.id < privacy.id) 
			return BEFORE;
		else if (privacy.id == this.id) 
			return EQUAL;
		else if (this.id > privacy.id)
			return AFTER;
		return EQUAL;		
	}
	
}
