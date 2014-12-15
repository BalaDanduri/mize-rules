package com.mize.domain.batch;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "mize_job")
public class MizeJob extends MizeSceEntityAudit implements Comparable<MizeJob>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9090898975271779926L;
	private String jobCode;
	private String jobName;
	private String jobDescription;
	private List<MizeJobInstance> jobInstances;
	private Boolean active;
	private String isActive;
	private List<MizeJobParameter> jobParameters;
	private BusinessEntity tenant;
	private User user;
	
	public MizeJob() {
		
	}
	
	public MizeJob(Long id, String jobCode, String jobName, String jobDescription, String isActive) {
		super();
		super.id = id;
		this.jobCode = jobCode;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "job_code")
	public String getJobCode() {
		return jobCode;
	}
	
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	
	@Column(name = "job_name")
	public String getJobName() {
		return jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	@Column(name = "job_description")
	public String getJobDescription() {
		return jobDescription;
	}
	
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	@Transient
	@JsonManagedReference(value = "jobInstance")
	public List<MizeJobInstance> getJobInstances() {
		return jobInstances;
	}
	public void setJobInstances(List<MizeJobInstance> jobInstances) {
		this.jobInstances = jobInstances;
	}
	
	@Transient
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "job", orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value = "job")
	public List<MizeJobParameter> getJobParameters() {
		return jobParameters;
	}

	public void setJobParameters(List<MizeJobParameter> jobParameters) {
		this.jobParameters = jobParameters;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id", nullable = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
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
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((jobCode == null) ? 0 : jobCode.hashCode());
		result = prime * result + ((jobDescription == null) ? 0 : jobDescription.hashCode());
		result = prime * result + ((jobInstances == null) ? 0 : jobInstances.hashCode());
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result + ((jobParameters == null) ? 0 : jobParameters.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		MizeJob other = (MizeJob) obj;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (jobCode == null) {
			if (other.jobCode != null)
				return false;
		} else if (!jobCode.equals(other.jobCode))
			return false;
		if (jobDescription == null) {
			if (other.jobDescription != null)
				return false;
		} else if (!jobDescription.equals(other.jobDescription))
			return false;
		if (jobInstances == null) {
			if (other.jobInstances != null)
				return false;
		} else if (!jobInstances.equals(other.jobInstances))
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (jobParameters == null) {
			if (other.jobParameters != null)
				return false;
		} else if (!jobParameters.equals(other.jobParameters))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MizeJob [jobCode=" + jobCode + ", jobName=" + jobName + ", jobDescription=" + jobDescription 
				+ ", jobInstances=" + jobInstances + ", isActive=" + isActive + ", jobParameters=" + jobParameters 
				+ ", tenant=" + tenant + ", id=" + id + "]";
	}

	@Override
	public int compareTo(MizeJob o) {
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
	
}
