package com.mize.domain.common;

import java.io.Serializable;

public class MizeErrorTab implements Serializable{

	private static final long serialVersionUID = -3226912440044184406L;
	private Integer severity;
	private String tabName;
	private String fieldName;
	
	public Integer getSeverity() {
		return severity;
	}
	public void setSeverity(Integer severity) {
		this.severity = severity;
	}
	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((tabName == null) ? 0 : tabName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MizeErrorTab other = (MizeErrorTab) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		if (tabName == null) {
			if (other.tabName != null)
				return false;
		} else if (!tabName.equals(other.tabName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MizeErrorTab [severity=" + severity + ", tabName=" + tabName
				+ ", fieldName=" + fieldName + "]";
	}
	
		
}
