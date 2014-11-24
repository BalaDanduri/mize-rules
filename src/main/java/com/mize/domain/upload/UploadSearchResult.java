package com.mize.domain.upload;

import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public final class UploadSearchResult extends MizeSceEntity implements Comparable<UploadSearchResult> {

	private static final long serialVersionUID = 8241322531831985362L;
	
	private String entityType;
	private String fileType;
//	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private MizeDateTime startTime;
//	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private MizeDateTime endTime;
	private String status;
	private String fileName;
	private Integer recordCount;
	private Integer successCount;
	private Integer failureCount;
	private String logFileURI;
	private String rejectedFileURI;
	private String uploadedByName;
	private Long uploadedBy;
	private String uploadedByBEName;
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)*/
	public MizeDateTime getStartTime() {
		return startTime;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	*/
	public void setStartTime(MizeDateTime startTime) {
		this.startTime = startTime;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)*/
	public MizeDateTime getEndTime() {
		return endTime;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	*/
	public void setEndTime(MizeDateTime endTime) {
		this.endTime = endTime;
	}
	
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int compareTo(UploadSearchResult o) {
		return 0;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Integer successCount) {
		this.successCount = successCount;
	}

	public Integer getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(Integer failureCount) {
		this.failureCount = failureCount;
	}

	public String getLogFileURI() {
		return logFileURI;
	}

	public void setLogFileURI(String logFileURI) {
		this.logFileURI = logFileURI;
	}

	public String getRejectedFileURI() {
		return rejectedFileURI;
	}

	public void setRejectedFileURI(String rejectedFileURI) {
		this.rejectedFileURI = rejectedFileURI;
	}

	@Override
	public String toString() {
		return "UploadSearchResult [entityType=" + entityType + ", fileType="
				+ fileType + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + ", fileName=" + fileName
				+ ", recordCount=" + recordCount
				+ ", successCount=" + successCount + ", failureCount="
				+ failureCount + ", logFileURI=" + logFileURI + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((failureCount == null) ? 0 : failureCount.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result
				+ ((logFileURI == null) ? 0 : logFileURI.hashCode());
		result = prime * result
				+ ((recordCount == null) ? 0 : recordCount.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((successCount == null) ? 0 : successCount.hashCode());
		
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
		UploadSearchResult other = (UploadSearchResult) obj;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (failureCount == null) {
			if (other.failureCount != null)
				return false;
		} else if (!failureCount.equals(other.failureCount))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (logFileURI == null) {
			if (other.logFileURI != null)
				return false;
		} else if (!logFileURI.equals(other.logFileURI))
			return false;
		if (recordCount == null) {
			if (other.recordCount != null)
				return false;
		} else if (!recordCount.equals(other.recordCount))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (successCount == null) {
			if (other.successCount != null)
				return false;
		} else if (!successCount.equals(other.successCount))
			return false;
		return true;
	}

	public String getUploadedByName() {
		return uploadedByName;
	}

	public void setUploadedByName(String uploadedByName) {
		this.uploadedByName = uploadedByName;
	}

	public Long getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	
	public String getUploadedByBEName() {
		return uploadedByBEName;
	}

	public void setUploadedByBEName(String uploadedByBEName) {
		this.uploadedByBEName = uploadedByBEName;
	}
}
