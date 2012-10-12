package com.mize.domain.common;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.mize.domain.appmessage.ApplicationMessage;
import com.mize.domain.appmessage.MessageType;

public class Entity {
	
	private String message; // need to use object and have more customized object for messages
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonIgnore
	Set<ApplicationMessage> appMessages = new HashSet<ApplicationMessage>();
	
	@JsonIgnore
	public boolean addMessage(final ApplicationMessage msg) {
		
		return appMessages.add(msg);
	}
	
	@JsonIgnore
	public boolean addMessage(long id, MessageType messageType, String messageCode,
			String messageShortDesc, String messageLongDesc,
			int messageSeverity) {
	
			return appMessages.add(new ApplicationMessage(id, messageType, messageCode, messageShortDesc, messageLongDesc, messageSeverity));
	}
	
	@JsonIgnore
	public Set<ApplicationMessage> getApplicationMessages() {
		return appMessages;
	}
	
	@JsonIgnore
	public static String STATUS = "status";
	

	public enum SUCCESS {
		TRUE, FALSE
	}

}