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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "mize_job_parameters")
public class MizeJobParameter extends MizeSceEntityAudit implements Comparable<MizeJobParameter>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 976447039451815450L;
	private Long jobId;
	private Long jobInstanceId;
	private MizeJob job;
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
	@JoinColumn(name = "job_id")
	@JsonBackReference(value = "job")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public MizeJob getJob() {
		return job;
	}

	public void setJob(MizeJob job) {
		this.job = job;
	}

	@Transient
	public Long getJobId() {
		return jobId;
	}
	
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	
	@Column(name = "instance_id",nullable = true)
	public Long getJobInstanceId() {
		return jobInstanceId;
	}
	
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	@Column(name = "param_name", nullable = true, length = 50)
	public String getParmName() {
		return parmName;
	}
	
	public void setParmName(String parmName) {
		this.parmName = parmName;
	}
	
	@Column(name = "param_type", nullable = true, length = 50)
	public String getParmType() {
		return parmType;
	}
	
	public void setParmType(String parmType) {
		this.parmType = parmType;
	}
	
	@Column(name = "param_value", nullable = true, length = 50)
	public String getParmValue() {
		return parmValue;
	}
	
	public void setParmValue(String parmValue) {
		this.parmValue = parmValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		result = prime * result + ((jobInstanceId == null) ? 0 : jobInstanceId.hashCode());
		result = prime * result + ((parmName == null) ? 0 : parmName.hashCode());
		result = prime * result + ((parmType == null) ? 0 : parmType.hashCode());
		result = prime * result + ((parmValue == null) ? 0 : parmValue.hashCode());
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
		MizeJobParameter other = (MizeJobParameter) obj;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		if (jobInstanceId == null) {
			if (other.jobInstanceId != null)
				return false;
		} else if (!jobInstanceId.equals(other.jobInstanceId))
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
	public String toString() {
		return "MizeJobParameter [jobId=" + jobId + ", jobInstanceId=" + jobInstanceId 
				+ ", job=" + job + ", parmName=" + parmName + ", parmType=" + parmType 
				+ ", parmValue=" + parmValue + ", id=" + id + "]";
	}

	@Override
	public int compareTo(MizeJobParameter o) {
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
