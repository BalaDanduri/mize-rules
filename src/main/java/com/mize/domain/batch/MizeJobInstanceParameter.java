package com.mize.domain.batch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "mize_job_parameters")
public class MizeJobInstanceParameter extends MizeSceEntityAudit implements Comparable<MizeJobInstanceParameter>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 976447039451815450L;
	private Long jobId;
	private MizeJobInstance jobInstance;
	private String parmName;
	private String parmType;
	private String parmValue;

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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "instance_id")
	@JsonBackReference(value = "jobInstance")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public MizeJobInstance getJobInstance() {
		return jobInstance;
	}

	public void setJobInstance(MizeJobInstance jobInstance) {
		this.jobInstance = jobInstance;
	}

	@Column(name = "job_id")
	public Long getJobId() {
		return jobId;
	}
	
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	@Column(name = "param_name")
	public String getParmName() {
		return parmName;
	}
	
	public void setParmName(String parmName) {
		this.parmName = parmName;
	}
	
	@Column(name = "param_type")
	public String getParmType() {
		return parmType;
	}
	
	public void setParmType(String parmType) {
		this.parmType = parmType;
	}
	
	@Column(name = "param_value")
	public String getParmValue() {
		return parmValue;
	}
	
	public void setParmValue(String parmValue) {
		this.parmValue = parmValue;
	}
	
	@Override
	public String toString() {
		return "MizeJobInstanceParameter [jobId=" + jobId + ", parmName="
				+ parmName + ", parmType=" + parmType + ", parmValue="
				+ parmValue + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result
				+ ((parmName == null) ? 0 : parmName.hashCode());
		result = prime * result
				+ ((parmType == null) ? 0 : parmType.hashCode());
		result = prime * result
				+ ((parmValue == null) ? 0 : parmValue.hashCode());
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
		MizeJobInstanceParameter other = (MizeJobInstanceParameter) obj;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (parmName == null) {
			if (other.parmName != null)
				return false;
		} else if (!parmName.equals(other.parmName))
			return false;
		if (parmType == null) {
			if (other.parmType != null)
				return false;
		} else if (!parmType.equals(other.parmType))
			return false;
		if (parmValue == null) {
			if (other.parmValue != null)
				return false;
		} else if (!parmValue.equals(other.parmValue))
			return false;
		return true;
	}

	@Override
	public int compareTo(MizeJobInstanceParameter o) {
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
