package com.mize.domain.common;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mize.domain.appmessage.ApplicationMessages;
import com.mize.domain.appmessage.ApplicationMessages.Message;

public class Entity {
	
	// TODO : remove message and remove ignore from messages once changes are done in code.
	private String message; // need to use object and have more customized object for messages
	@JsonIgnore
	private ApplicationMessages messages;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonIgnore
	public Set<Message> getMessages() {
		return messages.getMessages();
	}
	
}
