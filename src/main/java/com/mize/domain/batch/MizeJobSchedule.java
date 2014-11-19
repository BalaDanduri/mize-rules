package com.mize.domain.batch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "mize_job_instance_schedule")
public class MizeJobSchedule extends MizeSceEntity implements Comparable<MizeJobSchedule>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1040968045922261957L;
	private Long instanceId;
	private MizeJobInstance jobInstance;
	private String expr;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	public Long getInstanceId() {
		return instanceId;
	}
	
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "instance_id")
	@JsonBackReference(value = "schedule")
	public MizeJobInstance getJobInstance() {
		return jobInstance;
	}

	public void setJobInstance(MizeJobInstance jobInstance) {
		this.jobInstance = jobInstance;
	}

	@Column(name = "schedule_expr",nullable = false,length = 50)
	public String getExpr() {
		return expr;
	}
	
	public void setExpr(String expr) {
		this.expr = expr;
	}
	
	@Override
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name="created_date",updatable=false)
	@JsonIgnore(value=false)
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
	
	@Override
	public String toString() {
		return "MizeJobSchedule [jobInstance=" + jobInstance + ", expr=" + expr + ", id=" + id + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		result = prime * result + ((jobInstance == null) ? 0 : jobInstance.hashCode());
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
		MizeJobSchedule other = (MizeJobSchedule) obj;
		if (expr == null) {
			if (other.expr != null)
				return false;
		} else if (!expr.equals(other.expr))
			return false;
		if (jobInstance == null) {
			if (other.jobInstance != null)
				return false;
		} else if (!jobInstance.equals(other.jobInstance))
			return false;
		return true;
	}

	@Override
	public int compareTo(MizeJobSchedule o) {
		
		return 0;
	}
	
}
