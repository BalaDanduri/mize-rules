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

	@Override
	public String toString() {
		return "ApplicationMessage [messageType=" + messageType + ", code=" + code + ", shortDesc=" + shortDesc +
				", longDesc=" + longDesc + ", severity=" + severity + ", id=" + id + "]";
	}

	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((code == null) ? 0 : code.hashCode());
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
