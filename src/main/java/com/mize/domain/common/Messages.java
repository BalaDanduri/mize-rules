package com.mize.domain.common;

import java.util.HashSet;
import java.util.Set;

import com.mize.domain.appmessage.ApplicationMessage;
import com.mize.domain.appmessage.MessageType;

public class Messages {


	private Set<ApplicationMessage> appMessages = new HashSet<ApplicationMessage>();
	
	public boolean addMessage(final ApplicationMessage msg) {
		
		return appMessages.add(msg);
	}
	
	public boolean addMessage(long id, MessageType messageType, String messageCode,
			String messageShortDesc, String messageLongDesc,
			int messageSeverity) {
	
			return appMessages.add(new ApplicationMessage(id, messageType, messageCode, messageShortDesc, messageLongDesc, messageSeverity));
	}
	
	public Set<ApplicationMessage> getApplicationMessages() {
		return appMessages;
	}

}