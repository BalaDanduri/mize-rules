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
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name="batch_job_field_mapping")
public class BatchJobFieldMapper extends MizeSceEntityAudit implements Comparable<BatchJobFieldMapper>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6314940318539396469L;
	private BatchJobBeanMapper batchJobBeanMapper;
	private Integer sequenceNumber;
	private String headerName;
	private String domainName;
	private String aliasName;
	private boolean isUpdated;
	private String isActive;

	public BatchJobFieldMapper() {
		super();
	}
	
	public BatchJobFieldMapper(Integer sequenceNumber, String headerName, String domainName,String aliasName) {
		super();
		this.sequenceNumber = sequenceNumber;
		this.headerName = headerName;
		this.domainName = domainName;
		this.aliasName = aliasName;
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

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="bean_mapping_id")
	@JsonBackReference(value="batchJobFieldMapper")
	public BatchJobBeanMapper getBatchJobBeanMapper() {
		return batchJobBeanMapper;
	}

	public void setBatchJobBeanMapper(BatchJobBeanMapper batchJobBeanMapper) {
		this.batchJobBeanMapper = batchJobBeanMapper;
	}

	@Column(name = "sequence_no")
	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	
	@Column(name = "header_name")
	public String getHeaderName() {
		return headerName;
	}

	public void setHeaderName(String headerName) {
		this.headerName = headerName;
	}

	@Column(name = "domain_name")
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Column(name = "alias_name")
	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
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
	public int compareTo(BatchJobFieldMapper o) {
		return sequenceNumber.compareTo(o.getSequenceNumber());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aliasName == null) ? 0 : aliasName.hashCode());
		result = prime * result + ((batchJobBeanMapper == null) ? 0 : batchJobBeanMapper.hashCode());
		result = prime * result + ((domainName == null) ? 0 : domainName.hashCode());
		result = prime * result + ((headerName == null) ? 0 : headerName.hashCode());
		result = prime * result + ((sequenceNumber == null) ? 0 : sequenceNumber.hashCode());
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
		BatchJobFieldMapper other = (BatchJobFieldMapper) obj;
		if (aliasName == null) {
			if (other.aliasName != null)
				return false;
		} else if (!aliasName.equals(other.aliasName))
			return false;
		if (batchJobBeanMapper == null) {
			if (other.batchJobBeanMapper != null)
				return false;
		} else if (!batchJobBeanMapper.equals(other.batchJobBeanMapper))
			return false;
		if (domainName == null) {
			if (other.domainName != null)
				return false;
		} else if (!domainName.equals(other.domainName))
			return false;
		if (headerName == null) {
			if (other.headerName != null)
				return false;
		} else if (!headerName.equals(other.headerName))
			return false;
		if (sequenceNumber == null) {
			if (other.sequenceNumber != null)
				return false;
		} else if (!sequenceNumber.equals(other.sequenceNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchJobFieldMapper [ sequenceNumber=" + sequenceNumber + ", headerName="
				+ headerName + ", domainName=" + domainName + ", aliasName="
				+ aliasName + "]";
	}

}
