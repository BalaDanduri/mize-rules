package com.mize.domain.brand;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.common.MizeDomainConstant;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class BrandUserSupportLog extends MizeEntity implements Comparable<BrandUserSupportLog>{

	private Long brandId;
	private Long id;
	private Long userId;
	private String supportType;
	private String countryCode;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endTime;
	private long brandSupportId;
	
	public BrandUserSupportLog(){
		
	}
	
	public BrandUserSupportLog(long brandId, long id,
			long userId, String supportType, String countryCode, DateTime startTime,
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

	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
		int result = super.hashCode();
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + (int) (brandSupportId ^ (brandSupportId >>> 32));
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((supportType == null) ? 0 : supportType.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		BrandUserSupportLog other = (BrandUserSupportLog) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (brandSupportId != other.brandSupportId)
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
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
	
	public int compareTo(BrandUserSupportLog entity) {
		if ( this == entity ) 
			return MizeDomainConstant.EQUAL;
		else if (this.id < entity.id) 
			return MizeDomainConstant.BEFORE;
		else if (entity.id == this.id) 
			return MizeDomainConstant.EQUAL;
		else if (this.id > entity.id)
			return MizeDomainConstant.AFTER;
		return MizeDomainConstant.EQUAL;
	}

}
