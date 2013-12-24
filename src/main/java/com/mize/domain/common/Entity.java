package com.mize.domain.common;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class Entity implements Serializable{
	
	private static final long serialVersionUID = 6651571123697401305L;

	protected Integer createdBy;
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime createdDate;
	
	protected Integer updatedBy;
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime updatedDate;
 
	@JsonIgnore
	private Messages messages; // need to use object and have more customized object for messages
	@JsonIgnore
	public Messages getMessages() {
		return messages;
	}
	@JsonIgnore
	public void setMessages(Messages messages) {
		this.messages = messages;
	}
	
	@JsonIgnore
	public Integer getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}

	@JsonIgnore
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonIgnore
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}


	@JsonIgnore
	public static String STATUS = "status";
	

	public enum SUCCESS {
		TRUE, FALSE
	}

}