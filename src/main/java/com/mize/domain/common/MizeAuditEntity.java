package com.mize.domain.common;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.util.MizeDateTime;

public abstract class MizeAuditEntity extends MizeSceEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4275213588169261386L;

	protected MizeDateTime statusDate;
	protected Long statusBy;
	protected String statusByUser;

	public MizeAuditEntity() {
		super();
	}

	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(false)
	public MizeDateTime getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(MizeDateTime statusDate) {
		this.statusDate = statusDate;
	}

	public Long getStatusBy() {
		return statusBy;
	}

	public void setStatusBy(Long statusBy) {
		this.statusBy = statusBy;
	}

	public String getStatusByUser() {
		return statusByUser;
	}

	public void setStatusByUser(String statusByUser) {
		this.statusByUser = statusByUser;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((statusBy == null) ? 0 : statusBy.hashCode());
		result = prime * result + ((statusByUser == null) ? 0 : statusByUser.hashCode());
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
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MizeAuditEntity [statusDate=" + statusDate + ", statusBy=" + statusBy + ", statusByUser=" + statusByUser + "]";
	}

}
