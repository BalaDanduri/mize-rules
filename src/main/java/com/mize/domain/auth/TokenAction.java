package com.mize.domain.auth;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
import com.mize.domain.auth.User;

public class TokenAction extends Entity {
	
	public enum Type {
       EV, PR
	}
	
	private Long id;
	private String token;
	private User targetUser;
	private Type type;
	private DateTime created;
	private DateTime expires;

	public TokenAction() {
		
	}
	
	public TokenAction(Long id, String token, User targetUser, Type type,
			DateTime created, DateTime expires) {
		this.id = id;
		this.token = token;
		this.targetUser = targetUser;
		this.type = type;
		this.expires = expires;
		this.created = created;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getExpires() {
		return expires;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setExpires(DateTime expires) {
		this.expires = expires;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)	
	public DateTime getCreated() {
		return created;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCreated(DateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "TokenAction [id=" + id + ", token=" + token + ", targetUser="
				+ targetUser + ", type=" + type + ", created=" + created
				+ ", expires=" + expires + "]";
	}	
	
	
}
