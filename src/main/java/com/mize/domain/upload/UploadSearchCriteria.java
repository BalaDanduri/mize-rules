package com.mize.domain.upload;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public final class UploadSearchCriteria extends MizeSceEntity implements Comparable<UploadSearchCriteria> {

	private static final long serialVersionUID = 8241322531831985362L;
	
	private String entityType;
	private String fileType;
	//@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private MizeDateTime fromDate;
//	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private MizeDateTime toDate;
	private String status;
	private String fileName;
	private User user;
	private Integer pageIndex;
	private boolean isAdmin;
	private Integer pageSize;
	private List<UploadSearchResult> results = new ArrayList<UploadSearchResult>();
	
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
	public MizeDateTime getFromDate() {
		return fromDate;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	*/
	public void setFromDate(MizeDateTime fromDate) {
		this.fromDate = fromDate;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)*/
	public MizeDateTime getToDate() {
		return toDate;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	*/
	public void setToDate(MizeDateTime toDate) {
		this.toDate = toDate;
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
	public int compareTo(UploadSearchCriteria o) {
		return 0;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<UploadSearchResult> getResults() {
		return results;
	}

	public void setResults(List<UploadSearchResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "UploadSearchCriteria [entityType=" + entityType + ", fileType="
				+ fileType + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", status=" + status + ", fileName=" + fileName + ", user="
				+ user + " isAdmin=" + isAdmin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result
				+ ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + (Boolean.valueOf(isAdmin).hashCode());
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
		UploadSearchCriteria other = (UploadSearchCriteria) obj;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
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
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if(isAdmin != other.isAdmin){
			return false;
		}
		return true;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
