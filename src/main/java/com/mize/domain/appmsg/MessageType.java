package com.mize.domain.appmsg;

import com.mize.domain.common.MizeSceEntity;


public class MessageType extends MizeSceEntity implements Comparable<MessageType>{
	
	private static final long serialVersionUID = 1023272589160106886L;
	
	private String type;

	public MessageType() {
	}

	public enum Type{
		Application(1),Error(2),Validation(3);
		long val;
		Type(long l){
			val = l;
		}
		public long getValue(){
			return val;
		}
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result + ((type == null) ? 0 : type.hashCode());
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
		MessageType other = (MessageType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessageType [type=" + type + ", id=" + id + "]";
	}

	public int compareTo(MessageType o) {
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
