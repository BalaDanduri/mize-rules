package com.mize.domain.upload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mize.domain.appmsg.AppMessage;

public final class ErrorRecordEntity implements Serializable {

	private static final long serialVersionUID = 124222531831985362L;
	
	private Object entity;
	private List<AppMessage> messages;
	
	public ErrorRecordEntity(){
		messages = new ArrayList<AppMessage>();
	}
	public Object getEntity() {
		return entity;
	}
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	public List<AppMessage> getMessages() {
		return messages;
	}
	public void setMessages(List<AppMessage> messages) {
		this.messages = messages;
	}
}
