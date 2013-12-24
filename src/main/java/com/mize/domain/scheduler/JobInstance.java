package com.mize.domain.scheduler;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class JobInstance extends Entity{
	private static final long serialVersionUID = -4823725990646809706L;
	private Long id;
	private String code;
	private String name;
	Long jobId;
	private String addlInfo1;
	private String addlInfo2;
	private String addlInfo3;
	private String addlInfo4;
	private String addlNo1="0";
	private String addlNo2="0";
	private String addlNo3="0";
	private String addlNo4="0";
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime lastRunDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime nextRunDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime executionQueueDate;
	private String isActive;
	private boolean isMasterControlJob = false;
	
	public JobInstance(){
		isActive = "Y";
	}
	public boolean isMasterControlJob() {
		return isMasterControlJob;
	}

	public void setMasterControlJob(boolean isMasterControlJob) {
		this.isMasterControlJob = isMasterControlJob;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddlInfo1() {
		return addlInfo1;
	}

	public void setAddlInfo1(String addlInfo1) {
		this.addlInfo1 = addlInfo1;
	}

	public String getAddlInfo2() {
		return addlInfo2;
	}

	public void setAddlInfo2(String addlInfo2) {
		this.addlInfo2 = addlInfo2;
	}

	public String getAddlInfo3() {
		return addlInfo3;
	}

	public void setAddlInfo3(String addlInfo3) {
		this.addlInfo3 = addlInfo3;
	}

	public String getAddlInfo4() {
		return addlInfo4;
	}

	public void setAddlInfo4(String addlInfo4) {
		this.addlInfo4 = addlInfo4;
	}

	public String getAddlNo1() {
		return addlNo1;
	}

	public void setAddlNo1(String addlNo1) {
		this.addlNo1 = addlNo1;
	}

	public String getAddlNo2() {
		return addlNo2;
	}

	public void setAddlNo2(String addlNo2) {
		this.addlNo2 = addlNo2;
	}

	public String getAddlNo3() {
		return addlNo3;
	}

	public void setAddlNo3(String addlNo3) {
		this.addlNo3 = addlNo3;
	}

	public String getAddlNo4() {
		return addlNo4;
	}

	public void setAddlNo4(String addlNo4) {
		this.addlNo4 = addlNo4;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getLastRunDate() {
		return lastRunDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setLastRunDate(DateTime lastRunDate) {
		this.lastRunDate = lastRunDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getNextRunDate() {
		return nextRunDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setNextRunDate(DateTime nextRunDate) {
		this.nextRunDate = nextRunDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getExecutionQueueDate() {
		return executionQueueDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setExecutionQueueDate(DateTime executionQueueDate) {
		this.executionQueueDate = executionQueueDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
