package com.mize.domain.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.datetime.DateTime;

@MappedSuperclass
public abstract class MizeSceEntityAudit extends MizeSceEntity {
	
	private static final long serialVersionUID = 481118252575043078L;
	
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@Column(name = "created_by_user",updatable=false)
	public String getCreatedByUser() {
		return super.getCreatedByUser();
	}
	
	@Override
	public void setCreatedByUser(String createdByUser) {
		super.setCreatedByUser(createdByUser);
	}
	
	@Override
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return super.getUpdatedByUser();
	}
	
	@Override
	public void setUpdatedByUser(String updatedByUser) {
		super.setUpdatedByUser(updatedByUser);
	}
	
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_date",updatable = false)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name = "updated_date")
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
}