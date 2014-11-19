package com.mize.domain.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.exception.UploadError;
import com.mize.domain.util.MizeDateTime;

public abstract class MizeSceEntity implements IEntity {
	
	private static final long serialVersionUID = 4810418252575043078L;	
	public static final int EQUAL = 0;
	public static final int BEFORE = -1;
	public static final int AFTER = 1;
	public static final int PRIME = 31;	
	public static final int HASH_CODE_START = 17;
	protected UploadError uploadError;
	@JsonIgnore
	protected Boolean isValid = Boolean.TRUE;
			
	protected Long createdBy;
	protected MizeDateTime createdDate;	
	protected Long updatedBy;
	protected MizeDateTime updatedDate;	
	protected Long id;
	
	protected String createdByUser;
	
	protected String updatedByUser;

	@JsonIgnore
	public static String STATUS = "status";
	
	public enum Result{
		TRUE,FALSE;
	}
	
	public abstract Long getId();

	public abstract void setId(Long id);

	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public MizeDateTime getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@JsonIgnore
	public UploadError getUploadError() {
		return uploadError;
	}
	
	@JsonIgnore
	public void setUploadError(UploadError uploadError) {
		this.isValid = Boolean.FALSE;
		this.uploadError = uploadError;
	}
	
	
	public String getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}

	
	public String getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	
	@JsonIgnore
	public boolean isValid() {
		if(this.isValid == null){
			return true;
		}
		return this.isValid.booleanValue();
	}
	
	@Override
	public int hashCode() {
		int result = HASH_CODE_START;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
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
		MizeSceEntity other = (MizeSceEntity) obj;		
		if (!isLongFieldsEquals(this.id, other.id)) {
			return false;
		}		
		return true;
	}
	
	public boolean isLongFieldsEquals(Long tHis, Long tHat) {
		if (tHis == null) {
			if (tHat != null) {
				return false;
			}
		} else if (!tHis.equals(tHat)) {
			return false;
		}
		return true;
	}
	
}