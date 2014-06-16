package com.mize.domain.upload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public final class ErrorRecord implements Serializable {

	private static final long serialVersionUID = 824222531831985362L;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime createdTime;
	private List<ErrorRecordEntity> errorEntityList = new ArrayList<ErrorRecordEntity>();

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedTime() {
		return createdTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCreatedTime(DateTime createdTime) {
		this.createdTime = createdTime;
	}

	public List<ErrorRecordEntity> getErrorEntityList() {
		return errorEntityList;
	}

	public void setErrorEntityList(List<ErrorRecordEntity> errorEntityList) {
		this.errorEntityList = errorEntityList;
	}
	
}
