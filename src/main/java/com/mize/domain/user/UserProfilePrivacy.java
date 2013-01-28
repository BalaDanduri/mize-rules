package com.mize.domain.user;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class UserProfilePrivacy extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6808879417363134780L;
	private Long userId;
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
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getDisplayBirthYear() {
		return displayBirthYear;
	}
	public void setDisplayBirthYear(String displayBirthYear) {
		this.displayBirthYear = displayBirthYear;
	}
	public Long getEmail() {
		return email;
	}
	public void setEmail(Long email) {
		this.email = email;
	}
	public Long getFriends() {
		return friends;
	}
	public void setFriends(Long friends) {
		this.friends = friends;
	}
	public Long getActivity() {
		return activity;
	}
	public void setActivity(Long activity) {
		this.activity = activity;
	}
	public Long getWant() {
		return want;
	}
	public void setWant(Long want) {
		this.want = want;
	}
	public Long getOwn() {
		return own;
	}
	public void setOwn(Long own) {
		this.own = own;
	}
	public Long getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Long birthDate) {
		this.birthDate = birthDate;
	}
	public Long getGender() {
		return gender;
	}
	public void setGender(Long gender) {
		this.gender = gender;
	}
	public Long getCityState() {
		return cityState;
	}
	public void setCityState(Long cityState) {
		this.cityState = cityState;
	}

	@JsonIgnore
	public int getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

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

	@JsonIgnore
	public int getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

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
	
}
