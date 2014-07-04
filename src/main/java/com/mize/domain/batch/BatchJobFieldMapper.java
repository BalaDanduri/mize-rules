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
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="batch_job_field_mapping")
public class BatchJobFieldMapper extends MizeEntity implements Comparable<BatchJobFieldMapper>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6314940318539396469L;
	private BatchJobBeanMapper batchJobBeanMapper;
	private Integer sequenceNumber;
	private String headerName;
	private String domainName;
	private String aliasName;

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

	@Override
	public int compareTo(BatchJobFieldMapper o) {
		return sequenceNumber.compareTo(o.getSequenceNumber());
	}

	@Override
	public String toString() {
		return "BatchJobFieldMapper [ sequenceNumber=" + sequenceNumber + ", headerName="
				+ headerName + ", domainName=" + domainName + ", aliasName="
				+ aliasName + "]";
	}

}
