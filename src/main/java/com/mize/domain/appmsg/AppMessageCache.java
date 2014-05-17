package com.mize.domain.appmsg;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class AppMessageCache extends MizeEntity implements Comparable<AppMessageCache> {

	private static final long serialVersionUID = 16153638967617947L;
	private String code;
	private String messageType;
	private Integer severity;
	private String shortDesc;
	private String longDesc;
	private boolean isExists;
	private BusinessEntity tenant;
	private User user;
	
	public AppMessageCache() {
		super();
	}
	
	public AppMessageCache(boolean isExists) {
		super();
		this.isExists = isExists;
	}	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = makeNotNullString(code);
	}
	
	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}	
	
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)
	@JsonIgnore(false)
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)	
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	} 
		
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isExists() {
		return isExists;
	}

	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}

	@JsonIgnore
	public static String makeNotNullString(String str){
		return str == null ? null:str.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (isExists ? 1231 : 1237);
		result = prime * result
				+ ((longDesc == null) ? 0 : longDesc.hashCode());
		result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		AppMessageCache other = (AppMessageCache) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (isExists != other.isExists)
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
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
		return "AppMessageCache [code=" + code + ", messageType=" + messageType
				+ ", severity=" + severity + ", shortDesc=" + shortDesc
				+ ", longDesc=" + longDesc + ", isExists=" + isExists + "]";
	}

	@Override
	public int compareTo(AppMessageCache o) {
		return 0;
	}	
	
}
