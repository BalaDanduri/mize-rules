package com.mize.domain.common;

import java.io.Serializable;

public class MizeErrorTab implements Serializable{

	private static final long serialVersionUID = -3226912440044184406L;
	private Integer severity;
	private String tabName;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + severity;
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
		if (severity != other.severity)
			return false;
		if (tabName == null) {
			if (other.tabName != null)
				return false;
		} else if (!tabName.equals(other.tabName))
			return false;
		return true;
	}
	
}
