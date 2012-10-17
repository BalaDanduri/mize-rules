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
	private String facebook;
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
			int validatedBy, DateTime validatedDate, String twitter,String facebook,
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
		this.facebook= facebook;
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
	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
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


	@Override
	public String toString() {
		return "BrandSupport [brand=" + brand + ", id=" + id + ", phone="
				+ phone + ", email=" + email + ", site=" + site + ", chatUrl="
				+ chatUrl + ", tollFreePhone=" + tollFreePhone + ", hoursOfOp="
				+ hoursOfOp + ", qualifier=" + qualifier + ", type=" + type
				+ ", validated=" + validated + ", validatedBy=" + validatedBy
				+ ", validatedDate=" + validatedDate + ", twitter=" + twitter
				+ ", facebook=" + facebook + ", countryCode=" + countryCode
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate  
				+ ", getBrand()=" + getBrand() + ", getId()=" + getId()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail()
				+ ", getSite()=" + getSite() + ", getChatUrl()=" + getChatUrl()
				+ ", getTollFreePhone()=" + getTollFreePhone()
				+ ", getHoursOfOp()=" + getHoursOfOp() + ", getQualifier()="
				+ getQualifier() + ", getType()=" + getType()
				+ ", isValidated()=" + isValidated() + ", getValidatedBy()="
				+ getValidatedBy() + ", getValidatedDate()="
				+ getValidatedDate() + ", getTwitter()=" + getTwitter()
				+ ", getFacebook()=" + getFacebook() + ", getCountryCode()="
				+ getCountryCode() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getCreatedDate()=" + getCreatedDate()
				+ ", getModifiedBy()=" + getModifiedBy()
				+ ", getModifiedDate()=" + getModifiedDate()
				+ ", getMessage()=" + getMessage()
				+ ", getApplicationMessages()=" + getApplicationMessages()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((chatUrl == null) ? 0 : chatUrl.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + createdBy;
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result
				+ ((hoursOfOp == null) ? 0 : hoursOfOp.hashCode());
		result = prime * result + id;
		result = prime * result + modifiedBy;
		result = prime * result
				+ ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((qualifier == null) ? 0 : qualifier.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result
				+ ((tollFreePhone == null) ? 0 : tollFreePhone.hashCode());
		result = prime * result + ((twitter == null) ? 0 : twitter.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (validated ? 1231 : 1237);
		result = prime * result + validatedBy;
		result = prime * result
				+ ((validatedDate == null) ? 0 : validatedDate.hashCode());
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
		BrandSupport other = (BrandSupport) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (chatUrl == null) {
			if (other.chatUrl != null)
				return false;
		} else if (!chatUrl.equals(other.chatUrl))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (hoursOfOp == null) {
			if (other.hoursOfOp != null)
				return false;
		} else if (!hoursOfOp.equals(other.hoursOfOp))
			return false;
		if (id != other.id)
			return false;
		if (modifiedBy != other.modifiedBy)
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (qualifier == null) {
			if (other.qualifier != null)
				return false;
		} else if (!qualifier.equals(other.qualifier))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (tollFreePhone == null) {
			if (other.tollFreePhone != null)
				return false;
		} else if (!tollFreePhone.equals(other.tollFreePhone))
			return false;
		if (twitter == null) {
			if (other.twitter != null)
				return false;
		} else if (!twitter.equals(other.twitter))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (validated != other.validated)
			return false;
		if (validatedBy != other.validatedBy)
			return false;
		if (validatedDate == null) {
			if (other.validatedDate != null)
				return false;
		} else if (!validatedDate.equals(other.validatedDate))
			return false;
		return true;
	}
}
