package com.mize.domain.appmsg;

import java.util.List;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="application_messages")
public class AppMessage extends MizeEntity implements Comparable<AppMessage> {

	private static final long serialVersionUID = 6836153638967617947L;
	private BusinessEntity tenant;
	private String code;
	private String msgType;
	private Integer severity;
	private List<AppMessageIntl> intls;
	
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
	private boolean isExists;
	@Transient
	private boolean isDuplicate;	

	public enum Severity {
		one(1),two(2),three(3),four(4),five(5);
		int val;
		Severity(int v){
			val = v;
		}
		public int getValue(){
			return val;
		}
	}
	
	public enum MsgType {
		Application(1),Error(2);
		int val;
		MsgType(int v){
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
		//this.intls = intls;
	}

	public AppMessage(String code, String shortDesc, String longDesc, Integer severity, String field, String fieldKey, MessageType.Type messageType) {
		this.code = makeNotNullString(code);	
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.severity = severity;
		this.field = field;
		this.fieldKey = fieldKey;
		this.messageType.setType(messageType.toString());
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
	
	public AppMessage(Integer severity, String code,String shortDesc) {
		this.severity = severity;
		this.code = code;		
		this.shortDesc = shortDesc;
	}
	
	public AppMessage() {
		super();
	}
	
	public AppMessage(boolean isExists) {
		super();
		this.isExists = isExists;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
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
	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "appMessage" ,orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference(value="intl")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
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
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)
	@JsonIgnore(false)
	@Column(name = "created_date", updatable = false)
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = JsonSerialize.Inclusion.NON_DEFAULT)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	} 
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by",updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Transient
	public boolean isExists() {
		return isExists;
	}

	public void setExists(boolean isExists) {
		this.isExists = isExists;
	}

	@Transient
	@JsonIgnore
	public boolean isDuplicate() {
		return isDuplicate;
	}

	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}

	@Override
	public String toString() {
		return "AppMessage [code=" + code + ", msgType=" + msgType
				+ ", severity=" + severity +", isExists=" + isExists + "]";
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
