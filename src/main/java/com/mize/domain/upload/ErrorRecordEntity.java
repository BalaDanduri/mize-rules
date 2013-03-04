package com.mize.domain.upload;

import java.io.Serializable;

import com.mize.domain.appmessage.ApplicationMessage;

public final class ErrorRecordEntity implements Serializable {

	private static final long serialVersionUID = 124222531831985362L;
	
	private Object entity;
	private ApplicationMessage applicationMessage;
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	public ApplicationMessage getApplicationMessage() {
		return applicationMessage;
	}
	public void setApplicationMessage(ApplicationMessage applicationMessage) {
		this.applicationMessage = applicationMessage;
	}
	
}
