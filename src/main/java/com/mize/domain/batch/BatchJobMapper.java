package com.mize.domain.batch;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="batch_job_mapping")
public class BatchJobMapper extends MizeSceEntityAudit implements Comparable<BatchJobMapper>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 559083512618133107L;
	private String jobCode;
	private String description;
	private Long businessEntityId;
	private String isDefault;
	private String versionNumber;
	private List<BatchJobBeanMapper> batchJobBeanMappers;
	private boolean isUpdated;
	private String isActive;
	private User user;
	
	public BatchJobMapper() {
	}
	
	public BatchJobMapper(Long id, String jobCode, String description, String isDefault, String versionNumber) {
		super();
		super.id = id;
		this.jobCode = jobCode;
		this.description = description;
		this.isDefault = isDefault;
		this.versionNumber = versionNumber;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Column(name="job_code")
	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="be_id")
	public Long getBusinessEntityId() {
		return businessEntityId;
	}

	public void setBusinessEntityId(Long businessEntityId) {
		this.businessEntityId = businessEntityId;
	}

	@Column(name="is_default")
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Column(name="version_no")
	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="batchJobMapper",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="batchJobBeanMapper")
	public List<BatchJobBeanMapper> getBatchJobBeanMappers() {
		return batchJobBeanMappers;
	}

	public void setBatchJobBeanMappers(List<BatchJobBeanMapper> batchJobBeanMappers) {
		this.batchJobBeanMappers = batchJobBeanMappers;
	}

	@Override
	public int compareTo(BatchJobMapper o) {
		if ( this == o ) 
			return EQUAL;
		else if (this.id < o.id) 
			return BEFORE;
		else if (o.id == this.id) 
			return EQUAL;
		else if (this.id > o.id)
			return AFTER;
		return EQUAL;
	}
	
	@Transient
	public boolean getIsUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	
	@Column(name="is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}	
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((batchJobBeanMappers == null) ? 0 : batchJobBeanMappers.hashCode());
		result = prime * result + ((businessEntityId == null) ? 0 : businessEntityId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result + ((jobCode == null) ? 0 : jobCode.hashCode());
		result = prime * result + ((versionNumber == null) ? 0 : versionNumber.hashCode());
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
		BatchJobMapper other = (BatchJobMapper) obj;
		if (batchJobBeanMappers == null) {
			if (other.batchJobBeanMappers != null)
				return false;
		} else if (!batchJobBeanMappers.equals(other.batchJobBeanMappers))
			return false;
		if (businessEntityId == null) {
			if (other.businessEntityId != null)
				return false;
		} else if (!businessEntityId.equals(other.businessEntityId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (jobCode == null) {
			if (other.jobCode != null)
				return false;
		} else if (!jobCode.equals(other.jobCode))
			return false;
		if (versionNumber == null) {
			if (other.versionNumber != null)
				return false;
		} else if (!versionNumber.equals(other.versionNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchJobMapper [jobCode=" + jobCode + ", description="
				+ description + ", businessEntityId=" + businessEntityId
				+ ", isDefault=" + isDefault + ", versionNumber="
				+ versionNumber + ", batchJobBeanMappers="
				+ batchJobBeanMappers + "]";
	}
	
}
