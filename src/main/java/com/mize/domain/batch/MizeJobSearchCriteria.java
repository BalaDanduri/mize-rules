package com.mize.domain.batch;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeEntity;

public class MizeJobSearchCriteria extends MizeEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9090898975271779926L;
	private Long id;
	private String jobCode;
	private String jobName;
	private Long instanceId;
	private String instanceCode;
	private String fromDate;
	private String toDate;
	private Boolean active;
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
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
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
				+ ", instanceCode=" + instanceCode + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", active=" + active + ", roles="
				+ roles + "]";
	}
}
