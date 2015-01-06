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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="token_action")
public class TokenAction extends MizeSceEntityAudit implements Comparable<TokenAction> {
	
	private static final long serialVersionUID = 7260474936022570280L;
	private String token;
	private User targetUser;
	private TokenType type;
	private MizeDateTime created;
	private MizeDateTime expires;
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
			MizeDateTime created, MizeDateTime expires) {
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
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getExpires() {
		return expires;
	}
	
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public void setExpires(MizeDateTime expires) {
		this.expires = expires;
	}
	
	@Column(name="created",updatable = false)
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getCreated() {
		return created;
	}

	public void setCreated(MizeDateTime created) {
		this.created = created;
	}
	
	@Transient
	@JsonProperty("wrapper")
	@JsonIgnore
	public boolean isValid() {
		return ((this.expires!=null && this.expires.getDateTime() != null)?this.expires.getDateTime().isAfter(DateTime.now()) : false);
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
