package com.mize.domain.batch;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDate;

public class MizeJobSearchCriteria extends MizeSceEntity implements Comparable<MizeJobSearchCriteria>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9090898975271779926L;
	private Long id;
	private String jobCode;
	private String jobName;
	private Long instanceId;
	private String instanceCode;
	private MizeDate jobFromDate;
	private MizeDate jobToDate;
	private MizeDate instanceFromDate;
	private MizeDate instanceToDate;
	private Boolean jobActive;
	private Boolean instanceActive;
	private List<String> roles = new ArrayList<String>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public Long getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(Long instanceId) {
		this.instanceId = instanceId;
	}
	public String getInstanceCode() {
		return instanceCode;
	}
	public void setInstanceCode(String instanceCode) {
		this.instanceCode = instanceCode;
	}
	public MizeDate getJobFromDate() {
		return jobFromDate;
	}
	public void setJobFromDate(MizeDate jobFromDate) {
		this.jobFromDate = jobFromDate;
	}
	public MizeDate getJobToDate() {
		return jobToDate;
	}
	public void setJobToDate(MizeDate jobToDate) {
		this.jobToDate = jobToDate;
	}
	public MizeDate getInstanceFromDate() {
		return instanceFromDate;
	}
	public void setInstanceFromDate(MizeDate instanceFromDate) {
		this.instanceFromDate = instanceFromDate;
	}
	public MizeDate getInstanceToDate() {
		return instanceToDate;
	}
	public void setInstanceToDate(MizeDate instanceToDate) {
		this.instanceToDate = instanceToDate;
	}
	public Boolean getJobActive() {
		return jobActive;
	}
	public void setJobActive(Boolean jobActive) {
		this.jobActive = jobActive;
	}
	public Boolean getInstanceActive() {
		return instanceActive;
	}
	public void setInstanceActive(Boolean instanceActive) {
		this.instanceActive = instanceActive;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "MizeJobSearchCriteria [id=" + id + ", jobCode=" + jobCode
				+ ", jobName=" + jobName + ", instanceId=" + instanceId
				+ ", instanceCode=" + instanceCode + ", jobFromDate="
				+ jobFromDate + ", jobToDate=" + jobToDate
				+ ", instanceFromDate=" + instanceFromDate
				+ ", instanceToDate=" + instanceToDate + ", jobActive="
				+ jobActive + ", instanceActive=" + instanceActive + ", roles="
				+ roles + "]";
	}
	@Override
	public int compareTo(MizeJobSearchCriteria o) {
	
		return 0;
	}
	
}
