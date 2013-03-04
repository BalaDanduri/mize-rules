package com.mize.domain.upload;

import java.io.Serializable;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public final class UploadEntity implements Serializable {

	private static final long serialVersionUID = 8241122531831985362L;
	private Long id;
	private Integer count;
	private Integer errorsCount;
	private String className;
	private String category;
	private String fileName;
	private String status;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime startTime;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime endTime;
	private Object entity;
	private ErrorRecord errorRecord;;
	
	public enum Status{
		IN_PROGRESS,COMPLETED;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getStartTime() {
		return startTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getEndTime() {
		return endTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	public ErrorRecord getErrorRecord() {
		return errorRecord;
	}
	public void setErrorRecord(ErrorRecord errorRecord) {
		this.errorRecord = errorRecord;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getErrorsCount() {
		return errorsCount;
	}
	public void setErrorsCount(Integer errorsCount) {
		this.errorsCount = errorsCount;
	}
	
}
