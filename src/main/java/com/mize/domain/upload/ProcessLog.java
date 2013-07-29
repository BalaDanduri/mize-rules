package com.mize.domain.upload;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class ProcessLog extends MizeEntity implements Comparable<ProcessLog> {

	private static final long serialVersionUID = -8664572130656627545L;
	private Long uploadFileId;
	private Long entityId;
	private String entityCode;
	private String status;
	private Integer recordNumber;
	private Object inputRecord;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime createdTime;
	private Object entity;
	private List<ErrorLog> errorLogs = new ArrayList<ErrorLog>();
	
	public enum Status{
		SUCCESS,FAILURE;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUploadFileId() {
		return uploadFileId;
	}

	public void setUploadFileId(Long uploadFileId) {
		this.uploadFileId = uploadFileId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(Integer recordNumber) {
		this.recordNumber = recordNumber;
	}

	public Object getInputRecord() {
		return inputRecord;
	}

	public void setInputRecord(Object inputRecord) {
		this.inputRecord = inputRecord;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getCreatedTime() {
		return createdTime;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCreatedTime(DateTime createdTime) {
		this.createdTime = createdTime;
	}
	
	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}	

	public List<ErrorLog> getErrorLogs() {
		return errorLogs;
	}

	public void setErrorLogs(List<ErrorLog> errorLogs) {
		this.errorLogs = errorLogs;
	}

	@Override
	public int compareTo(ProcessLog o) {
		return 0;
	}

	@Override
	public String toString() {
		return "ProcessLog [uploadFileId=" + uploadFileId + ", entityId="
				+ entityId + ", entityCode=" + entityCode + ", status="
				+ status + ", recordNumber=" + recordNumber + ", inputRecord="
				+ inputRecord + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((inputRecord == null) ? 0 : inputRecord.hashCode());
		result = prime * result
				+ ((recordNumber == null) ? 0 : recordNumber.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((uploadFileId == null) ? 0 : uploadFileId.hashCode());
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
		ProcessLog other = (ProcessLog) obj;
		if (entityCode == null) {
			if (other.entityCode != null)
				return false;
		} else if (!entityCode.equals(other.entityCode))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (inputRecord == null) {
			if (other.inputRecord != null)
				return false;
		} else if (!inputRecord.equals(other.inputRecord))
			return false;
		if (recordNumber == null) {
			if (other.recordNumber != null)
				return false;
		} else if (!recordNumber.equals(other.recordNumber))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (uploadFileId == null) {
			if (other.uploadFileId != null)
				return false;
		} else if (!uploadFileId.equals(other.uploadFileId))
			return false;
		return true;
	}	

}
