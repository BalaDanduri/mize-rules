package com.mize.domain.batch;

import com.mize.domain.common.MizeEntity;

public class MizeJobParameters extends MizeEntity{
	private Long jobId;
	private Long jobInstanceId;
	private String parmName;
	private String parmType;
	private String parmValue;

	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getJobInstanceId() {
		return jobInstanceId;
	}
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}

	public String getParmName() {
		return parmName;
	}
	public void setParmName(String parmName) {
		this.parmName = parmName;
	}
	public String getParmType() {
		return parmType;
	}
	public void setParmType(String parmType) {
		this.parmType = parmType;
	}
	public String getParmValue() {
		return parmValue;
	}
	public void setParmValue(String parmValue) {
		this.parmValue = parmValue;
	}
	
	@Override
	public String toString() {
		return "MizeJobParameters [jobId=" + jobId + ", jobInstanceId=" + jobInstanceId + ", parmName=" + parmName
				+ ", parmType=" + parmType + ", parmValue=" + parmValue + "]";
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}


}
