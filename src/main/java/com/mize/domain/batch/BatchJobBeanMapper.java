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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="batch_job_bean_mapping")
public class BatchJobBeanMapper extends MizeEntity implements Comparable<BatchJobBeanMapper>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1564937178179560119L;

	private BatchJobMapper batchJobMapper;
	private Integer lineId;
	private String beanName;
	private String aliasName;
	private List<BatchJobFieldMapper> batchJobFieldMappers;
	
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
	public List<BatchJobFieldMapper> getBatchJobFieldMappers() {
		return batchJobFieldMappers;
	}

	public void setBatchJobFieldMappers(
			List<BatchJobFieldMapper> batchJobFieldMappers) {
		this.batchJobFieldMappers = batchJobFieldMappers;
	}

	@Override
	public int compareTo(BatchJobBeanMapper arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "BatchJobBeanMapper [ lineId=" + lineId + ", beanName=" + beanName + ", aliasName=" + aliasName
				+ ", batchJobFieldMappers=" + batchJobFieldMappers + "]";
	}

}
