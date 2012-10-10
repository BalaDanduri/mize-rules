package com.mize.domain.common;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mize.domain.appmessage.ApplicationMessages;
import com.mize.domain.appmessage.ApplicationMessages.Message;

public class Entity {
	
	private String message; // need to use object and have more customized object for messages
	private ApplicationMessages messages;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Set<Message> getMessages() {
		return messages.getMessages();
	}
	
}
