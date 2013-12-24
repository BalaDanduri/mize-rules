package com.mize.domain.scheduler;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;

import com.mize.domain.common.Entity;

public class JobExecution extends Entity{
	private static final long serialVersionUID = 6391299596384607699L;
	public static final String PENDING_STATUS = "PENDING";
	public static final String QUEUED_STATUS = "QUEUED";
	public static final String INPROCESS_STATUS = "INPROCESS";
	public static final String COMPLETED_STATUS = "COMPLETED";
	public static final String ERROR_STATUS = "ERROR";
	public static final String CANCELLED_STATUS = "CANCELLED";
	public static final String PARAM_CONTROL_JOB_PARM ="ControlJobParm";
	public static final String PARAM_MASTER_CONTROL_JOB_PARM ="MasterControlJobParm";

	private Long executionId; 
	private Long jobId;
	private Long jobInstanceId;
	private String jobType;
	private String jobTriggerType;
	private String langCode;	
	private String jobCode;	
	private String jobInstanceCode;	
	private String status;
	private DateTime scheduleTime;
	private DateTime queueTime;
	private DateTime startTime;
	private DateTime endTime;	
	private String message;
	private String startTimeControlJob;
	private String startTimeAmPmControlJob; 
	private String successMail; 
	private String failureMail;
	private String jobInstnaceName;	
	private boolean isJobSuccessful;	
	private boolean isExecutionExitNeeded;		
	private boolean isDependentJob;
	private boolean isAsynchronous;
	private Map<String, Object> parameters = new HashMap<String,Object>();
	
	public Long getExecutionId() {
		return executionId;
	}
	public void setExecutionId(Long executionId) {
		this.executionId = executionId;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobTriggerType() {
		return jobTriggerType;
	}
	public void setJobTriggerType(String jobTriggerType) {
		this.jobTriggerType = jobTriggerType;
	}
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public Long getJobInstanceId() {
		return jobInstanceId;
	}
	public void setJobInstanceId(Long jobInstanceId) {
		this.jobInstanceId = jobInstanceId;
	}
	public String getJobInstanceCode() {
		return jobInstanceCode;
	}
	public void setJobInstanceCode(String jobInstanceCode) {
		this.jobInstanceCode = jobInstanceCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DateTime getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(DateTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public DateTime getQueueTime() {
		return queueTime;
	}
	public void setQueueTime(DateTime queueTime) {
		this.queueTime = queueTime;
	}
	public DateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}
	public DateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStartTimeControlJob() {
		return startTimeControlJob;
	}
	public void setStartTimeControlJob(String startTimeControlJob) {
		this.startTimeControlJob = startTimeControlJob;
	}
	public String getStartTimeAmPmControlJob() {
		return startTimeAmPmControlJob;
	}
	public void setStartTimeAmPmControlJob(String startTimeAmPmControlJob) {
		this.startTimeAmPmControlJob = startTimeAmPmControlJob;
	}
	public String getSuccessMail() {
		return successMail;
	}
	public void setSuccessMail(String successMail) {
		this.successMail = successMail;
	}
	public String getFailureMail() {
		return failureMail;
	}
	public void setFailureMail(String failureMail) {
		this.failureMail = failureMail;
	}
	public String getJobInstnaceName() {
		return jobInstnaceName;
	}
	public void setJobInstnaceName(String jobInstnaceName) {
		this.jobInstnaceName = jobInstnaceName;
	}
	public boolean isJobSuccessful() {
		return isJobSuccessful;
	}
	public void setJobSuccessful(boolean isJobSuccessful) {
		this.isJobSuccessful = isJobSuccessful;
	}
	public boolean isExecutionExitNeeded() {
		return isExecutionExitNeeded;
	}
	public void setExecutionExitNeeded(boolean isExecutionExitNeeded) {
		this.isExecutionExitNeeded = isExecutionExitNeeded;
	}
	public boolean isDependentJob() {
		return isDependentJob;
	}
	public void setDependentJob(boolean isDependentJob) {
		this.isDependentJob = isDependentJob;
	}
	public boolean isAsynchronous() {
		return isAsynchronous;
	}
	public void setAsynchronous(boolean isAsynchronous) {
		this.isAsynchronous = isAsynchronous;
	}
}
