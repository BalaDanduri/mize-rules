package com.mize.domain.upload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mize.domain.appmessage.ApplicationMessage;

public final class ErrorRecordEntity implements Serializable {

	private static final long serialVersionUID = 124222531831985362L;
	
	private Object entity;
	private List<ApplicationMessage> messages;
	
	public ErrorRecordEntity(){
		messages = new ArrayList<ApplicationMessage>();
	}
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	public List<ApplicationMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<ApplicationMessage> messages) {
		this.messages = messages;
	}
}
