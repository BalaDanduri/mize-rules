package com.mize.domain.common;

import java.util.HashSet;
import java.util.Set;

import com.mize.domain.appmsg.AppMessage;
import com.mize.domain.appmsg.MessageType;

public class Messages {

	private Set<AppMessage> appMessages = new HashSet<AppMessage>();
	
	public boolean addMessage(final AppMessage msg) {		
		return appMessages.add(msg);
	}
	
	public boolean addMessage(long id, MessageType messageType, String messageCode,
			String messageShortDesc, String messageLongDesc,
			int messageSeverity) {
		AppMessage message= new AppMessage();
		message.setId(new Long(id));
		message.setMessageType(messageType);
		message.setCode(messageCode);
		message.setLongDesc(messageLongDesc);
		message.setShortDesc(messageShortDesc);
			return appMessages.add(message);
	}
	
	public Set<AppMessage> getApplicationMessages() {
		return appMessages;
	}

}