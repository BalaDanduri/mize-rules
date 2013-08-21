package com.mize.domain.batch;

import java.util.Date;

import com.mize.domain.common.MizeEntity;

public class MizeJobInstance extends MizeEntity{
	private Long id;
	private Long jobId;
	private String jobCode;
	private String instanceName;
	private Date lastRun;
	private Date nextRun;
	public String getJobName() {
		return jobCode;
	}
	public void setJobName(String jobCode) {
		this.jobCode = jobCode;
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
	@Override
	public String toString() {
		return "JobInstance [id=" + id + ", jobId=" + jobId + ", jobCode=" + jobCode + ", instanceName="
				+ instanceName + ", lastRun=" + lastRun + ", nextRun=" + nextRun + "]";
	}
	
}
