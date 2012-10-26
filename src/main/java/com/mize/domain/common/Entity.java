package com.mize.domain.common;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.appmessage.ApplicationMessage;
import com.mize.domain.appmessage.MessageType;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class Entity {
	protected int createdBy;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime createdDate;
	protected int updatedBy;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime updatedDate;
 
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
	
	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	@JsonIgnore
	public static String STATUS = "status";
	

	public enum SUCCESS {
		TRUE, FALSE
	}

}