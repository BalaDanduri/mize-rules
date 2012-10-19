package com.mize.domain.brand;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class BrandUserSupportLog extends Entity {

	private int brandId;
	private int id;
	private int userId;
	private String supportType;
	private String countryCode;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endTime;
	private long brandSupportId;
	
	public BrandUserSupportLog(){
		
	}
	
	public BrandUserSupportLog(int brandId, int id,
			int userId, String supportType, String countryCode, DateTime startTime,
			DateTime endTime, long brandSupportId) {
		this.brandId = brandId;
		this.id = id;
		this.userId = userId;
		this.supportType = supportType;
		this.countryCode = countryCode;
		this.startTime = startTime;
		this.endTime = endTime;
		this.brandSupportId = brandSupportId;
	}

	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSupportType() {
		return supportType;
	}
	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	public DateTime getStartTime() {
		return startTime;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	public DateTime getEndTime() {
		return endTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)		
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brandId;
		result = prime * result + id;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((supportType == null) ? 0 : supportType.hashCode());
		result = prime * result + userId;
		
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
		BrandUserSupportLog other = (BrandUserSupportLog) obj;
		if (brandId != other.brandId)
			return false;
		if (brandSupportId != other.brandSupportId)
			return false;
		if (id != other.id)
			return false;
		if (countryCode != other.countryCode)
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (supportType == null) {
			if (other.supportType != null)
				return false;
		} else if (!supportType.equals(other.supportType))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BrandUserSupportLog [brandId=" + brandId
				+ ", brandSupportId=" + brandSupportId
				+ ", brandUserSupportLogId=" + id
				+ ", userId=" + userId + ", supportType=" + supportType
				+ ", countryId=" + countryCode + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	public long getBrandSupportId() {
		return brandSupportId;
	}

	public void setBrandSupportId(long brandSupportId) {
		this.brandSupportId = brandSupportId;
	}
}
