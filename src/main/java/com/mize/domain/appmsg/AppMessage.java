package com.mize.domain.appmsg;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

public class AppMessage extends MizeEntity implements Comparable<AppMessage> {

	private static final long serialVersionUID = 6836153638967617947L;
	private MessageType messageType = new MessageType();
	private String code;
	private String shortDesc;
	private String longDesc;
	private Integer severity;
	private String field;
	private String fieldKey;
	private Locale locale = new Locale();

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
	
	
	public AppMessage(String code, String shortDesc, String longDesc, Integer severity, String field, String fieldKey, MessageType.Type messageType) {
		this.code = code;		
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.severity = severity;
		this.field = field;
		this.fieldKey = fieldKey;
		this.messageType.setType(messageType.toString());
	}
	
	public AppMessage(String code,String shortDesc,String longDesc) {
		this.code = code;
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
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}	
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public Integer getSeverity() {
		return severity;
	}

	public void setSeverity(Integer severity) {
		this.severity = severity;
	}
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	public String getFieldKey() {
		return fieldKey;
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

	@Override
	public String toString() {
		return "AppMessage [messageType=" + messageType + ", code=" + code
				+ ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", severity=" + severity + ", field=" + field + ", fieldKey="
				+ fieldKey + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result
				+ ((fieldKey == null) ? 0 : fieldKey.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((longDesc == null) ? 0 : longDesc.hashCode());
		result = prime * result
				+ ((messageType == null) ? 0 : messageType.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		result = prime * result
				+ ((shortDesc == null) ? 0 : shortDesc.hashCode());
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
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (fieldKey == null) {
			if (other.fieldKey != null)
				return false;
		} else if (!fieldKey.equals(other.fieldKey))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc))
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		if (severity == null) {
			if (other.severity != null)
				return false;
		} else if (!severity.equals(other.severity))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
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
