package com.mize.domain.batch;

import java.util.Date;

import com.mize.domain.common.MizeEntity;

public class MizeJobInstance extends MizeEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1638699269504919603L;
	private Long id;
	private MizeJob job;
	private String instanceCode;
	private String instanceName;
	private Date lastRun;
	private Date nextRun;
	private String jobStatus;
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MizeJob getJob() {
		return job;
	}
	public void setJob(MizeJob job) {
		this.job = job;
	}
	public String getInstanceCode() {
		return instanceCode;
	}
	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public Date getLastRun() {
		return lastRun;
	}
	public void setLastRun(Date lastRun) {
		this.lastRun = lastRun;
	}
	public Date getNextRun() {
		return nextRun;
	}
	public void setNextRun(Date nextRun) {
		this.nextRun = nextRun;
	}
	@Override
	public String toString() {
		return "MizeJobInstance [id=" + id + ", job=" + job + ", instanceCode="
				+ instanceCode + ", instanceName=" + instanceName
				+ ", lastRun=" + lastRun + ", nextRun=" + nextRun
				+ ", jobStatus=" + jobStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((instanceCode == null) ? 0 : instanceCode.hashCode());
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
		MizeJobInstance other = (MizeJobInstance) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instanceCode == null) {
			if (other.instanceCode != null)
				return false;
		} else if (!instanceCode.equals(other.instanceCode))
			return false;
		return true;
	}
	
}
