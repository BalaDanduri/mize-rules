package com.mize.domain.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeDomainConstant;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "brand_support")
public class BrandSupport extends MizeEntity implements Comparable<BrandSupport>{

	private static final long serialVersionUID = 8873185292574248278L;
	private Long brandId;
	private String phone;
	private String email;
	private String site;
	private String chatUrl;
	private String tollFreePhone;
	private String hoursOfOp;
	private String qualifier;
	private String type;
	private Boolean validated;
	private Integer validatedBy;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime validatedDate;
	private String twitter;
	private String facebook;
	private String countryCode;
	private Long countryId;
	private Brand brand;
	
	public BrandSupport() {
		
	}
	@Id
	@Column(name = "BRAND_SUPPORT_ID", unique = true, nullable = false, length = 10)
	@GenericGenerator(name="brandsupportId" , strategy="increment")
	@GeneratedValue(generator="brandsupportId")

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public BrandSupport(Long brandId, Long id, String phone, String email,
			String site, String chatUrl, String tollFreePhone,
			String hoursOfOp, String qualifier, String type, Boolean validated,
			Integer validatedBy, DateTime validatedDate, String twitter,String facebook,
			String countryCode, int createdBy, DateTime createdDate,
			int updatedBy, DateTime updatedDate) {
		this.brandId = brandId;
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
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Column(name = "SUPPORT_PHONE",  nullable = true, length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "SUPPORT_EMAIL",  nullable = true, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SUPPORT_SITE",  nullable = true, length = 250)
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@Column(name = "SUPPORT_CHAT",  nullable = true, length = 500)
	public String getChatUrl() {
		return chatUrl;
	}

	public void setChatUrl(String chatUrl) {
		this.chatUrl = chatUrl;
	}

	@Column(name = "SUPPORT_PHONE_TF",  nullable = true, length = 20)
	public String getTollFreePhone() {
		return tollFreePhone;
	}

	public void setTollFreePhone(String tollFreePhone) {
		this.tollFreePhone = tollFreePhone;
	}

	@Column(name = "HOURS_OF_OP",  nullable = true, length = 250)
	public String getHoursOfOp() {
		return hoursOfOp;
	}

	public void setHoursOfOp(String hoursOfOp) {
		this.hoursOfOp = hoursOfOp;
	}

	@Column(name = "SUPPORT_QUALIFIER",  nullable = true, length = 250)
	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	@Column(name = "SUPPORT_TYPE",  nullable = true, length = 11)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "VALIDATED",  nullable = true, length = 1)
	public Boolean isValidated() {
		return validated;
	}

	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	@Column(name = "VALIDATED_BY",  nullable = true, length = 1)
	public Integer getValidatedBy() {
		return validatedBy;
	}

	public void setValidatedBy(Integer validatedBy) {
		this.validatedBy = validatedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@Column(name = "validated_on",  nullable = true)
	public DateTime getValidatedDate() {
		return validatedDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setValidatedDate(DateTime validatedDate) {
		this.validatedDate = validatedDate;
	}

	@Column(name = "support_twitter",  nullable = true)
	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
	@Column(name = "support_facebook",  nullable = true)
	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	@Column(name = "country_id",  nullable = true)
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	@Transient
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_ID", nullable = false)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BrandSupport [brandId=");
		builder.append(brandId);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", site=");
		builder.append(site);
		builder.append(", chatUrl=");
		builder.append(chatUrl);
		builder.append(", tollFreePhone=");
		builder.append(tollFreePhone);
		builder.append(", hoursOfOp=");
		builder.append(hoursOfOp);
		builder.append(", qualifier=");
		builder.append(qualifier);
		builder.append(", type=");
		builder.append(type);
		builder.append(", validated=");
		builder.append(validated);
		builder.append(", validatedBy=");
		builder.append(validatedBy);
		builder.append(", validatedDate=");
		builder.append(validatedDate);
		builder.append(", twitter=");
		builder.append(twitter);
		builder.append(", facebook=");
		builder.append(facebook);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = MizeDomainConstant.PRIME * result + ((brandId == null) ? 0 : brandId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (! super.equals(obj)) {
			return false;
		}
		
		if (!(obj instanceof BrandSupport)) {
			return false;
		}
		
		BrandSupport other = (BrandSupport) obj;
		
		if (!isLongFieldsEquals(this.brandId, other.brandId)) {
			 return false;
		}
		
		return true;
	}

	public int compareTo(BrandSupport that) {
		if ( this == that ) 
			return MizeDomainConstant.EQUAL;
		else if (this.id < that.id) 
			return MizeDomainConstant.BEFORE;
		else if (that.id == this.id) 
			return MizeDomainConstant.EQUAL;
		else if (this.id > that.id)
			return MizeDomainConstant.AFTER;
		return MizeDomainConstant.EQUAL;
	}

}
