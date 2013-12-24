package com.mize.domain.batch;

import java.util.Date;

import com.mize.domain.common.MizeEntity;

public class MizeJobExecution extends MizeEntity{

	private static final long serialVersionUID = 2316762090397722064L;
	
	private Long id;
	private Long batchExecutionid;
	private Long jobInstanceId;
	private Date startTime;
	private Date endTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBatchExecutionid() {
		return batchExecutionid;
	}
	public void setBatchExecutionid(Long batchExecutionid) {
		this.batchExecutionid = batchExecutionid;
	}
	public Long getJobInstanceId() {
		return jobInstanceId;
	}
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		MizeJobExecution other = (MizeJobExecution) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MizeJobExecution [id=" + id + ", batchExecutionid="
				+ batchExecutionid + ", jobInstanceId=" + jobInstanceId
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
}
