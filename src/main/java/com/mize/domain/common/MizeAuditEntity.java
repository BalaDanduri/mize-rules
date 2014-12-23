package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.util.MizeDateTime;

@MappedSuperclass
public abstract class MizeAuditEntity extends MizeSceEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4275213588169261386L;

	protected String statusCode;
	protected MizeDateTime statusDate;
	protected Long statusBy;
	protected String statusByUser;

	public MizeAuditEntity() {
		super();
	}

	@Column(name = "status_date",updatable = false)
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(false)
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(MizeDateTime statusDate) {
		this.statusDate = statusDate;
	}

	@Column(name = "status_by")
	public Long getStatusBy() {
		return statusBy;
	}

	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}

	
	@Column(name = "status_by_user")
	public String getStatusByUser() {
		return statusByUser;
	}

	public void setStatusByUser(String statusByUser) {
		this.statusByUser = statusByUser;
	}
	

	@Column(name = "status_code")
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result + ((statusByUser == null) ? 0 : statusByUser.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
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
		MizeAuditEntity other = (MizeAuditEntity) obj;
		if (statusBy == null) {
			if (other.statusBy != null)
				return false;
		} else if (!statusBy.equals(other.statusBy))
			return false;
		if (statusByUser == null) {
			if (other.statusByUser != null)
				return false;
		} else if (!statusByUser.equals(other.statusByUser))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MizeAuditEntity [statusCode=" + statusCode + ", statusDate=" + statusDate + ", statusBy=" + statusBy
				+ ", statusByUser=" + statusByUser + "]";
	}
	
}
