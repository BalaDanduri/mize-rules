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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name = "mize_job_instance_schedule")
public class MizeJobSchedule extends MizeSceEntityAudit implements Comparable<MizeJobSchedule>{

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
	public String toString() {
		return "MizeJobSchedule [instanceId=" + instanceId + ", expr=" + expr
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((expr == null) ? 0 : expr.hashCode());
		result = prime * result
				+ ((instanceId == null) ? 0 : instanceId.hashCode());
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
		if (instanceId == null) {
			if (other.instanceId != null)
				return false;
		} else if (!instanceId.equals(other.instanceId))
			return false;
		return true;
	}

	@Override
	public int compareTo(MizeJobSchedule o) {
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
