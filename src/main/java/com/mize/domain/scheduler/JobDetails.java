package com.mize.domain.scheduler;

import com.mize.domain.common.Entity;

public class JobDetails extends Entity{
	private static final long serialVersionUID = 7629816238654728627L;

	private Long id;
	private String isActive;
	private String code;
	private String type;
	private String triggerType;
	private String status;
	
	public JobDetails(){
		isActive = "Y";
	}
	public enum JobType{
		Control_Job,Batch_Process,Inbound_Interface,Outbound_Interface,Upload,Other;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
