package com.mize.domain.appmsg;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.datetime.DateTime;

public class AppMessageCache implements Comparable<AppMessageCache> , Serializable {

	private static final long serialVersionUID = 16153638967617947L;
	private Long id;
	private String code;
	private String msgType;
	private Integer severity;
	private boolean isExists;
	private Long tenantId;
	private DateTime createdDate;
	private DateTime updatedDate;
	private Map<Long,AppMessageIntlCache> intlMap = new ConcurrentHashMap<Long, AppMessageIntlCache>();
	private String isActive;
	
	public AppMessageCache() {
		super();
	}
	
	public AppMessageCache(boolean isExists) {
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
		this.code = makeNotNullString(code);
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

	@JsonIgnore(false)
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
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

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
	public Map<Long, AppMessageIntlCache> getIntlMap() {
		if(intlMap == null){
			intlMap = new ConcurrentHashMap<Long, AppMessageIntlCache>();
		}
		return intlMap;
	}

	public void setIntlMap(Map<Long, AppMessageIntlCache> intlMap) {
		this.intlMap = intlMap;
	}

	@Override
	public int compareTo(AppMessageCache o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isExists ? 1231 : 1237);
		result = prime * result
				+ ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
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
		AppMessageCache other = (AppMessageCache) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isExists != other.isExists)
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
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AppMessageCache [id=" + id + ", code=" + code + ", msgType="
				+ msgType + ", severity=" + severity + ", isExists=" + isExists
				+ ", tenantId=" + tenantId + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", intlMap=" + intlMap + ", isActive=" + isActive + "]";
	}

	
	
}
