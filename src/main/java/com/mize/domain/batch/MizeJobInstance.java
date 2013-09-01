package com.mize.domain.batch;

import java.util.Date;

import com.mize.domain.common.MizeEntity;

public class MizeJobInstance extends MizeEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1638699269504919603L;
	private Long id;
	private Long jobId;
	private String instanceCode;
	private String instanceName;
	private Date lastRun;
	private Date nextRun;
	public String getJobName() {
		return instanceCode;
	}
	public void setJobName(String jobCode) {
		this.instanceCode = jobCode;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getInstanceCode() {
		return instanceCode;
	}
	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}
	@Override
	public String toString() {
		return "MizeJobInstance [id=" + id + ", jobId=" + jobId + ", instanceCode=" + instanceCode + ", instanceName="
				+ instanceName + ", lastRun=" + lastRun + ", nextRun=" + nextRun + "]";
	}
	
}
