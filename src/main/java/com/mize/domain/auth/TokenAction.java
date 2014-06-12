package com.mize.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="token_action")
public class TokenAction extends MizeEntity implements Comparable<TokenAction> {
	
	private static final long serialVersionUID = 7260474936022570280L;
	private String token;
	private User targetUser;
	private TokenType type;
	private DateTime created;
	private DateTime expires;
	private String tokenType;
	public TokenAction() {		
	}
	
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

		public String toString() {
			return tokenType;
		}
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

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="token")
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	@JoinColumn(name="target_user_id")
	@ManyToOne(fetch = FetchType.EAGER)
	public User getTargetUser() {
		return targetUser;
	}
	
	public void setTargetUser(User targetUser) {
		this.targetUser = targetUser;
	}
	
	@Transient
	public TokenType getType() {
		return type;
	}
	
	public void setType(TokenType type) {
		this.type = type;
	}
	
	@Column(name="type")
	public String getTokenType() {
		if(type != null){
			tokenType = type.toString();
		}
		return tokenType;
	}
	
	public void setTokenType(String type) {
		this.type = TokenType.valueOf(type);
	}
	
	@Column(name="expires")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getExpires() {
		return expires;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setExpires(DateTime expires) {
		this.expires = expires;
	}

	@Column(name="created",updatable = false)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreated() {
		return created;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setCreated(DateTime created) {
		this.created = created;
	}
	
	@Transient
	@JsonProperty("wrapper")
	@JsonIgnore
	public boolean isValid() {
		return (this.expires!=null?this.expires.isAfter(DateTime.now()) : false);
	}

	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "created_by", updatable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}
	
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "created_date", updatable = false)
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@Column(name = "updated_date")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Override
	public String toString() {
		return "TokenAction [id=" + id + ", token=" + token + ", type=" + type + ", created=" + created
				+ ", expires=" + expires + "]";
	}	
	
	public int compareTo(TokenAction entity) {
		if ( this == entity ) 
			return EQUAL;
		else if (this.id < entity.id) 
			return BEFORE;
		else if (entity.id == this.id) 
			return EQUAL;
		else if (this.id > entity.id)
			return AFTER;
		return EQUAL;		
	}

}
