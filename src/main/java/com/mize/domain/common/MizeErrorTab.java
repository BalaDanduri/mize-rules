package com.mize.domain.common;

import java.io.Serializable;

public class MizeErrorTab implements Serializable{

	private static final long serialVersionUID = -3226912440044184406L;
	private int severity;
	private String tabName;
	
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	
}
