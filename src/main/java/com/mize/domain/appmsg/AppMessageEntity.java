package com.mize.domain.appmsg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class AppMessageEntity extends MizeEntity implements Serializable {

	private static final long serialVersionUID = 16153638967617947L;
	private String code;
	private String msgType;
	private Integer severity;
	private boolean isExists;
	private String isActive;
	private String shortDesc;
	private String languageCode;
    private String countryCode;
	private List<AppMessage> appMessages;
	private BusinessEntity tenant;

	public AppMessageEntity() {
		super();
		appMessages = new ArrayList<AppMessage>();
	}

	public AppMessageEntity(boolean isExists) {
		super();
		this.isExists = isExists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public boolean isExists() {
		return isExists;
	}

	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}

	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public List<AppMessage> getAppMessages() {
		return appMessages;
	}

	public void setAppMessages(List<AppMessage> appMessages) {
		this.appMessages = appMessages;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	@JsonIgnore(false)
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + (isExists ? 1231 : 1237);
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result + ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		AppMessageEntity other = (AppMessageEntity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isExists != other.isExists)
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (msgType == null) {
			if (other.msgType != null)
				return false;
		} else if (!msgType.equals(other.msgType))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppMessageEntity [code=" + code + ", msgType=" + msgType + ", severity=" + severity + ", isExists=" + isExists + ", isActive=" 
				+ isActive + ", shortDesc=" + shortDesc + ", languageCode=" + languageCode + ", countryCode=" + countryCode + "]";
	}

}
