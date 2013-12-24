package com.mize.domain.batch;

import java.util.List;

import com.mize.domain.common.MizeEntity;

public class MizeJob extends MizeEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9090898975271779926L;
	private Long id;
	private String jobCode;
	private String jobName;
	private String jobDescription;
	private List<MizeJobInstance> jobInstances;
	private Boolean active;
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
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public List<MizeJobInstance> getJobInstances() {
		return jobInstances;
	}
	public void setJobInstances(List<MizeJobInstance> jobInstances) {
		this.jobInstances = jobInstances;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MizeJob other = (MizeJob) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MizeJob [id=" + id + ", jobCode=" + jobCode + ", jobName="
				+ jobName + ", jobDescription=" + jobDescription
				+ ", jobInstances=" + jobInstances + ", active=" + active + "]";
	}

	
}
