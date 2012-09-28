package com.mize.domain.brand;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateSerializer;
import com.mize.domain.util.JsonDateTimeSerializer;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

public class BrandSupport extends Entity {

	private Brand brand;
	private int id;
	private String phone;
	private String email;
	private String site;
	private String chatUrl;
	private String tollFreePhone;
	private String hoursOfOp;
	private String qualifier;
	private String type;
	private boolean validated;
	private int validatedBy;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime validatedDate;
	private String twitter;
	private String countryCode;
	private int createdBy;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime createdDate;
	private int modifiedBy;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime modifiedDate;
	
	public BrandSupport() {
		
	}

	
	public BrandSupport(Brand brand, int id, String phone, String email,
			String site, String chatUrl, String tollFreePhone,
			String hoursOfOp, String qualifier, String type, boolean validated,
			int validatedBy, DateTime validatedDate, String twitter,
			String countryCode, int createdBy, DateTime createdDate,
			int modifiedBy, DateTime modifiedDate) {
		this.brand = brand;
		this.id = id;
		this.phone = phone;
		this.email = email;
		this.site = site;
		this.chatUrl = chatUrl;
		this.tollFreePhone = tollFreePhone;
		this.hoursOfOp = hoursOfOp;
		this.qualifier = qualifier;
		this.type = type;
		this.validated = validated;
		this.validatedBy = validatedBy;
		this.validatedDate = validatedDate;
		this.twitter = twitter;
		this.countryCode = countryCode;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}


	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getChatUrl() {
		return chatUrl;
	}

	public void setChatUrl(String chatUrl) {
		this.chatUrl = chatUrl;
	}

	public String getTollFreePhone() {
		return tollFreePhone;
	}

	public void setTollFreePhone(String tollFreePhone) {
		this.tollFreePhone = tollFreePhone;
	}

	public String getHoursOfOp() {
		return hoursOfOp;
	}

	public void setHoursOfOp(String hoursOfOp) {
		this.hoursOfOp = hoursOfOp;
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public int getValidatedBy() {
		return validatedBy;
	}

	public void setValidatedBy(int validatedBy) {
		this.validatedBy = validatedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getValidatedDate() {
		return validatedDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setValidatedDate(DateTime validatedDate) {
		this.validatedDate = validatedDate;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getModifiedDate() {
		return modifiedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
