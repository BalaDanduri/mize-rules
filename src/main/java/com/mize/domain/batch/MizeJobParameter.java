package com.mize.domain.batch;

import com.mize.domain.common.MizeEntity;

public class MizeJobParameter extends MizeEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 976447039451815450L;
	private Long jobId;
	private Long jobInstanceId;
	private String parmName;
	private String parmType;
	private String parmValue;

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
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
		return "MizeJobParameter [jobId=" + jobId + ", jobInstanceId=" + jobInstanceId + ", parmName=" + parmName
				+ ", parmType=" + parmType + ", parmValue=" + parmValue + ", id=" + id + "]";
	}

}
