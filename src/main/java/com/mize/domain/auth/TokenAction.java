package com.mize.domain.auth;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.mize.domain.common.Entity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
import com.mize.domain.auth.User;

public class TokenAction extends Entity {
	
	public enum TokenType {
		EV("EV"),
		PR("PR");

		private String tokenType;
		private TokenType(String tokenType) {
			this.tokenType = tokenType;
		}

		public static final TokenType getTokenType(String tokenType) {
			for (TokenType s : values() ){
				if (s.tokenType.equalsIgnoreCase(tokenType)) return s;
			}
			return null;
		}
	}
	
	private Long id;
	private String token;
	private User targetUser;
	private TokenType type;
	private DateTime created;
	private DateTime expires;

	public TokenAction() {
		
	}
	
	public TokenAction(Long id, String token, User targetUser, TokenType type,
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
	public TokenType getType() {
		return type;
	}
	public void setType(TokenType type) {
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
	
	@JsonProperty("wrapper")
	@JsonIgnore()
	public boolean isValid() {
		return (this.expires!=null?this.expires.isAfter(new DateTime()) : false);
	}

	@Override
	public String toString() {
		return "TokenAction [id=" + id + ", token=" + token + ", targetUser="
				+ targetUser + ", type=" + type + ", created=" + created
				+ ", expires=" + expires + "]";
	}	
	
	
}
