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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="batch_job_bean_mapping")
public class BatchJobBeanMapper extends MizeSceEntity implements Comparable<BatchJobBeanMapper>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1564937178179560119L;

	private BatchJobMapper batchJobMapper;
	private Integer lineId;
	private String beanName;
	private String aliasName;
	private List<BatchJobFieldMapper> batchJobFieldMappers;
	private String isActive;
	private boolean isUpdated;
	
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

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="mapping_id")
	@JsonBackReference(value="batchJobBeanMapper")
	public BatchJobMapper getBatchJobMapper() {
		return batchJobMapper;
	}

	public void setBatchJobMapper(BatchJobMapper batchJobMapper) {
		this.batchJobMapper = batchJobMapper;
	}

	@Column(name = "line_id")
	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	@Column(name = "bean_name")
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Column(name = "alias_name")
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="batchJobBeanMapper",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="batchJobFieldMapper")
	@OrderBy("sequenceNumber") 
	public List<BatchJobFieldMapper> getBatchJobFieldMappers() {
		return batchJobFieldMappers;
	}

	public void setBatchJobFieldMappers(
			List<BatchJobFieldMapper> batchJobFieldMappers) {
		this.batchJobFieldMappers = batchJobFieldMappers;
	}
	
	@Override
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name="created_date",updatable=false)
	@JsonIgnore(value=false)
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	@JsonIgnore(value=false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name="updated_date")
	@JsonIgnore(value=false)
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
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

	@Override
	public int compareTo(BatchJobBeanMapper arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aliasName == null) ? 0 : aliasName.hashCode());
		result = prime * result + ((batchJobFieldMappers == null) ? 0 : batchJobFieldMappers.hashCode());
		result = prime * result + ((batchJobMapper == null) ? 0 : batchJobMapper.hashCode());
		result = prime * result + ((beanName == null) ? 0 : beanName.hashCode());
		result = prime * result + ((lineId == null) ? 0 : lineId.hashCode());
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
		BatchJobBeanMapper other = (BatchJobBeanMapper) obj;
		if (aliasName == null) {
			if (other.aliasName != null)
				return false;
		} else if (!aliasName.equals(other.aliasName))
			return false;
		if (batchJobFieldMappers == null) {
			if (other.batchJobFieldMappers != null)
				return false;
		} else if (!batchJobFieldMappers.equals(other.batchJobFieldMappers))
			return false;
		if (batchJobMapper == null) {
			if (other.batchJobMapper != null)
				return false;
		} else if (!batchJobMapper.equals(other.batchJobMapper))
			return false;
		if (beanName == null) {
			if (other.beanName != null)
				return false;
		} else if (!beanName.equals(other.beanName))
			return false;
		if (lineId == null) {
			if (other.lineId != null)
				return false;
		} else if (!lineId.equals(other.lineId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchJobBeanMapper [ lineId=" + lineId + ", beanName=" + beanName + ", aliasName=" + aliasName
				+ ", batchJobFieldMappers=" + batchJobFieldMappers + "]";
	}

}
