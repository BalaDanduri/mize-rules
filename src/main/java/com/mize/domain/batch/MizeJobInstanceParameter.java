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

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;

@Entity
@Table(name = "mize_job_parameters")
public class MizeJobInstanceParameter extends MizeEntity{
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
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public MizeJobInstance getJobInstance() {
		return jobInstance;
	}

	public void setJobInstance(MizeJobInstance jobInstance) {
		this.jobInstance = jobInstance;
	}

	@Column(name = "job_id",nullable = false)
	public Long getJobId() {
		return jobId;
	}
	
	public void setJobId(Long jobId) {
		this.jobId = jobId;
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
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name="created_date",updatable=false)
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name="updated_date")
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override	
	@JsonIgnore
	@Column(name = "created_by", nullable = true, length = 20, updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by", nullable = true, length = 20)
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	@Override
	public String toString() {
		return "MizeJobParameter [jobInstance=" + jobInstance + ", parmName=" + parmName 
				+ ", parmType=" + parmType + ", parmValue=" + parmValue + ", id=" + id + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((jobInstance == null) ? 0 : jobInstance.hashCode());
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
		MizeJobInstanceParameter other = (MizeJobInstanceParameter) obj;
		if (jobInstance == null) {
			if (other.jobInstance != null)
				return false;
		} else if (!jobInstance.equals(other.jobInstance))
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

}
