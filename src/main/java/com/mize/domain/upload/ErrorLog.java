package com.mize.domain.upload;

import com.mize.domain.common.MizeEntity;

public class ErrorLog extends MizeEntity implements Comparable<ErrorLog> {

	private static final long serialVersionUID = -5103607209709356737L;
	Long processLogId;
	String code;
	String field;
	Integer severity;

	public ErrorLog(){		
	}
	
	public ErrorLog(String field,String code){
		this.field = field;
		this.code = code;
	}
	
	public ErrorLog(Long processLogId,String field,String code){
		this.processLogId = processLogId;
		this.field = field;
		this.code = code;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProcessLogId() {
		return processLogId;
	}

	public void setProcessLogId(Long processLogId) {
		this.processLogId = processLogId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}

	@Override
	public int compareTo(ErrorLog o) {
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result
				+ ((processLogId == null) ? 0 : processLogId.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
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
		ErrorLog other = (ErrorLog) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (processLogId == null) {
			if (other.processLogId != null)
				return false;
		} else if (!processLogId.equals(other.processLogId))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ErrorLog [processLogId=" + processLogId + ", code=" + code
				+ ", field=" + field + ", severity=" + severity + "]";
	}
	
}
