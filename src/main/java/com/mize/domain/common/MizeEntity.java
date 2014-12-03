package com.mize.domain.common;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.exception.UploadError;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Deprecated
public abstract class MizeEntity implements IEntity {
	
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
	@JsonIgnore
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime createdDate;	
	protected Long updatedBy;
	@JsonIgnore
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime updatedDate;	
	protected Long id;

	@JsonIgnore
	public static String STATUS = "status";
	
	public enum Result{
		TRUE,FALSE;
	}
	
	public abstract Long getId();

	public abstract void setId(Long id);

	@JsonIgnore
	public Long getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
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
		MizeEntity other = (MizeEntity) obj;
		
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