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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="batch_job_bean_mapping")
public class BatchJobBeanMapper extends MizeSceEntityAudit implements Comparable<BatchJobBeanMapper>{

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
	private String methodName;
	
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
	
	@Column(name = "method_name")
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
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
	public int compareTo(BatchJobBeanMapper o) {
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
