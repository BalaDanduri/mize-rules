package com.mize.domain.appmsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="application_messages")
public class AppMessage extends MizeSceEntityAudit implements Comparable<AppMessage> {

	private static final long serialVersionUID = 6836153638967617947L;
	private BusinessEntity tenant;
	private String code;
	private String msgType;
	private Integer severity;
	private List<AppMessageIntl> intls;
	private String isActive;
	
	@Transient
	private Locale locale = new Locale();
	@Transient
	private String shortDesc;
	@Transient
	private String longDesc;
	@Transient
	private String field;
	@Transient
	private String fieldKey;
	@Transient
	private User user;
	@Transient
	private MessageType messageType = new MessageType();
	
	@Transient
	private boolean isDuplicate;
	@Transient
	private Map<String,Object> hotSpotMap;
	private String lastAccessedTime;

	public enum Severity {
		one(1),two(2),three(3),four(4),five(5),dummy(100);
		int val;
		Severity(int v){
			val = v;
		}
		public int getValue(){
			return val;
		}
	}
	
	
	public AppMessage(Long id ,String code,String msgType, Integer severity) {
		super();
		this.id = id;
		this.code = makeNotNullString(code);
		this.msgType = msgType;
		this.severity = severity;
	}
	
	public AppMessage(Long id ,String code,Integer severity){
		super();
		this.id = id;
		this.code = makeNotNullString(code);
		this.severity = severity;
	}

	public AppMessage(String code, String shortDesc, String longDesc, Integer severity, String field, String fieldKey, MessageType.Type messageType) {
		this.code = makeNotNullString(code);	
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.severity = severity;
		this.field = field;
		this.fieldKey = fieldKey;
		this.messageType.setType(messageType.toString());
		this.msgType = messageType.toString();
	}
	
	public AppMessage(String code, String shortDesc, String longDesc, Integer severity, String field, String fieldKey, MessageType.Type messageType, String message) {
		this.code = makeNotNullString(code);	
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.severity = severity;
		this.field = field;
		this.fieldKey = fieldKey;
		this.messageType.setType(messageType.toString());
		this.msgType = messageType.toString();
		this.shortDesc = message;
	}
	
	public AppMessage(String code, String shortDesc, String longDesc, Integer severity, String field, String fieldKey, MessageType.Type messageType,Map<String,Object> hotSpotMap) {
		this.code = makeNotNullString(code);	
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.severity = severity;
		this.field = field;
		this.fieldKey = fieldKey;
		this.messageType.setType(messageType.toString());
		this.hotSpotMap = hotSpotMap;
		this.msgType = messageType.toString();
	}
		
	public AppMessage(String code,String shortDesc,String longDesc) {
		this.code = makeNotNullString(code);
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}
	
	public AppMessage(Integer severity, String code) {
		this.severity = severity;
		this.code = code;		
	}
	
	public AppMessage(String code) {
		this.code = code;		
	}
	
	public AppMessage(Integer severity, String code,String shortDesc) {
		this.severity = severity;
		this.code = code;		
		this.shortDesc = shortDesc;
	}
	
	public AppMessage() {
		super();
		intls = new ArrayList<AppMessageIntl>();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}	
	
	@Transient
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Column(name = "message_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = makeNotNullString(code);
	}
	
	@Column(name = "message_type")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@Transient
	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	@Transient
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	@Column(name="message_severity")
	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}
	
	@Transient
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	@Transient
	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}
	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "appMessage", orphanRemoval = true)
	@JsonManagedReference(value="intl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 30)
	public List<AppMessageIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<AppMessageIntl> intls) {
		this.intls = intls;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	@JsonIgnore
	public boolean isDuplicate() {
		return isDuplicate;
	}

	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	@Transient
	public String getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(String lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	@Override
	public String toString() {
		return "AppMessage [code=" + code + ", msgType=" + msgType
				+ ", severity=" + severity + ", isActive=" + isActive
				+ ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", field=" + field + ", fieldKey=" + fieldKey + "]";
	}

	@Transient
	public Map<String, Object> getHotSpotMap() {
		return hotSpotMap;
	}

	public void setHotSpotMap(Map<String, Object> hotSpotMap) {
		this.hotSpotMap = hotSpotMap;
	}

	@Transient
	@JsonIgnore
	public static String makeNotNullString(String str){
		return str == null ? null:str.trim();
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
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
		AppMessage other = (AppMessage) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (msgType == null) {
			if (other.msgType != null)
				return false;
		} else if (!msgType.equals(other.msgType))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;		
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}

	public int compareTo(AppMessage o) {
		if ( this == o ) 
			return EQUAL;
		else if (this.id < o.id) 
			return BEFORE;
		else if (o.id == this.id) 
			return EQUAL;
		else if (this.id > o.id)
			return AFTER;
		return EQUAL;
	}

}
