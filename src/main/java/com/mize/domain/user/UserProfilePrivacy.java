package com.mize.domain.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name="user_profile_privacy")
public class UserProfilePrivacy extends MizeSceEntityAudit implements Comparable<UserProfilePrivacy> {
	
	private static final long serialVersionUID = 6808879417363134780L;
	private String displayBirthYear;
	private Long email;
	private Long friends;
	private Long activity;
	private Long want;
	private Long own;
	private Long birthDate;
	private Long gender;
	private Long cityState;
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
	
	@Column(name="display_birthyear")
	public String getDisplayBirthYear() {
		return displayBirthYear;
	}
	public void setDisplayBirthYear(String displayBirthYear) {
		this.displayBirthYear = displayBirthYear;
	}
	
	@Column(name="email")
	public Long getEmail() {
		return email;
	}
	public void setEmail(Long email) {
		this.email = email;
	}
	
	@Column(name="friends")
	public Long getFriends() {
		return friends;
	}
	public void setFriends(Long friends) {
		this.friends = friends;
	}
	
	@Column(name="activity")
	public Long getActivity() {
		return activity;
	}
	public void setActivity(Long activity) {
		this.activity = activity;
	}
	
	@Column(name="want")
	public Long getWant() {
		return want;
	}
	public void setWant(Long want) {
		this.want = want;
	}
	
	@Column(name="own")
	public Long getOwn() {
		return own;
	}
	public void setOwn(Long own) {
		this.own = own;
	}
	
	@Column(name="birthdate")
	public Long getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Long birthDate) {
		this.birthDate = birthDate;
	}
	
	@Column(name="gender")
	public Long getGender() {
		return gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}
	
	@Column(name="city_state")
	public Long getCityState() {
		return cityState;
	}
	public void setCityState(Long cityState) {
		this.cityState = cityState;
	}

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
