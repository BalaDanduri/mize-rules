package com.mize.domain.appmsg;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;


public class AppMessages extends MizeSceEntity implements Comparable<AppMessages> {

	private static final long serialVersionUID = 9139589850515749395L;
	List<AppMessage> appMessages = new ArrayList<AppMessage>();
	
	public List<AppMessage> getAppMessages() {
		return appMessages;
	}

	public void setAppMessages(List<AppMessage> appMessages) {
		this.appMessages = appMessages;
	}

	@Override
	public int compareTo(AppMessages arg0) {
		return 0;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;	
	}
	
	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((appMessages == null) ? 0 : appMessages.hashCode());
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
		AppMessages other = (AppMessages) obj;
		if (appMessages == null) {
			if (other.appMessages != null)
				return false;
		} else if (!appMessages.equals(other.appMessages))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "";
	}
	 
}
