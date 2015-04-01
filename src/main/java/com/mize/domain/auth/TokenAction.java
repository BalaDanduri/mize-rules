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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.DateTime;


@Entity
@Table(name="token_action")
public class TokenAction extends MizeSceEntityAudit implements Comparable<TokenAction> {
	
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
		PR("PR"),
		AT("AT");

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
	@JsonBackReference(value="user_tokenAction")
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
	public DateTime getExpires() {
		return expires;
	}
	
	public void setExpires(DateTime expires) {
		this.expires = expires;
	}
	
	@Column(name="created",updatable = false)
	public DateTime getCreated() {
		return created;
	}

	public void setCreated(DateTime created) {
		this.created = created;
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((expires == null) ? 0 : expires.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result
				+ ((tokenType == null) ? 0 : tokenType.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenAction other = (TokenAction) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (expires == null) {
			if (other.expires != null)
				return false;
		} else if (!expires.equals(other.expires))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (tokenType == null) {
			if (other.tokenType != null)
				return false;
		} else if (!tokenType.equals(other.tokenType))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	

}
