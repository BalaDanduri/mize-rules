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

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="batch_job_mapping")
public class BatchJobMapper extends MizeEntity implements Comparable<BatchJobMapper>{

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
	
	@JsonIgnore(false)
	@Column(name = "created_by", updatable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}
	
	@JsonIgnore(false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore(false)
	@Column(name = "created_date", updatable = false)
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}
	
	@JsonIgnore(false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	public int compareTo(BatchJobMapper o) {
		// TODO Auto-generated method stub
		return 0;
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
