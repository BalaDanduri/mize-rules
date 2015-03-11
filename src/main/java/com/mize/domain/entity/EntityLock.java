package com.mize.domain.entity;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

public class EntityLock extends MizeSceEntity {

	private static final long serialVersionUID = 2211876390954824452L;

	private Boolean islocked;
	private String lockedBy;
	private DateTime lockedDate;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getLockedBy() {
		return lockedBy;
	}

	public void setLockedBy(String lockedBy) {
		this.lockedBy = lockedBy;
	}

	public DateTime getLockedDate() {
		return lockedDate;
	}

	public void setLockedDate(DateTime lockedDate) {
		this.lockedDate = lockedDate;
	}

	public Boolean getIslocked() {
		return islocked;
	}

	public void setIslocked(Boolean islocked) {
		this.islocked = islocked;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((islocked == null) ? 0 : islocked.hashCode());
		result = prime * result + ((lockedBy == null) ? 0 : lockedBy.hashCode());
		result = prime * result + ((lockedDate == null) ? 0 : lockedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EntityLock)) {
			return false;
		}
		EntityLock other = (EntityLock) obj;
		if (islocked == null) {
			if (other.islocked != null) {
				return false;
			}
		} else if (!islocked.equals(other.islocked)) {
			return false;
		}
		if (lockedBy == null) {
			if (other.lockedBy != null) {
				return false;
			}
		} else if (!lockedBy.equals(other.lockedBy)) {
			return false;
		}
		if (lockedDate == null) {
			if (other.lockedDate != null) {
				return false;
			}
		} else if (!lockedDate.equals(other.lockedDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EntityLock [id=" + id + ", islocked=" + islocked
				+ ", lockedBy=" + lockedBy + ", lockedDate=" + lockedDate + "]";
	}

	
	

	
	
	
	
}
