package com.mize.domain.appmessage;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ApplicationMessage {
	
	private long id;
	private MessageType messageType;
	private String messageCode;
	private String messageShortDesc;
	private String messageLongDesc;
	private int messageSeverity;
		
	public ApplicationMessage() {
		
	}
	
	public ApplicationMessage(long id, MessageType messageType, String messageCode,
				String messageShortDesc, String messageLongDesc,
				int messageSeverity) {
		this.id = id;
		this.messageType = messageType;
		this.messageCode = messageCode;
		this.messageShortDesc = messageShortDesc;
		this.messageLongDesc = messageLongDesc;
		this.messageSeverity = messageSeverity;
	}

	public MessageType getMessageType() {
		return messageType;
	}
	
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	public String getMessageCode() {
		return messageCode;
	}
	
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	
	public String getMessageShortDesc() {
		return messageShortDesc;
	}
	
	public void setMessageShortDesc(String messageShortDesc) {
		this.messageShortDesc = messageShortDesc;
	}
	
	public String getMessageLongDesc() {
		return messageLongDesc;
	}
	
	public void setMessageLongDesc(String messageLongDesc) {
		this.messageLongDesc = messageLongDesc;
	}
	
	public int getMessageSeverity() {
		return messageSeverity;
	}
	
	public void setMessageSeverity(int messageSeverity) {
		this.messageSeverity = messageSeverity;
	}
	
	@Override
	public String toString() {
		return "ApplicationMessages [messageType=" + messageType
				+ ", messageCode=" + messageCode + ", messageShortDesc="
				+ messageShortDesc + ", messageLongDesc=" + messageLongDesc
				+ ", messageSeverity=" + messageSeverity + "]";
		}
	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((messageType == null) ? 0 : messageType.hashCode());
			result = prime * result
					+ ((messageCode == null) ? 0 : messageCode.hashCode());
			result = prime
					* result
					+ ((messageShortDesc == null) ? 0 : messageShortDesc.hashCode());
			result = prime * result
					+ ((messageLongDesc == null) ? 0 : messageLongDesc.hashCode());
			result = prime * result
					+ (messageSeverity);
			return result;
		}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ApplicationMessage other = (ApplicationMessage) obj;
			if (messageType == null) {
				if (other.messageType != null)
					return false;
			} else if (!messageType.equals(other.messageType))
				return false;
			if (messageCode != other.messageCode)
				return false;
			if (messageShortDesc != other.messageShortDesc)
				return false;
			if (messageLongDesc != other.messageLongDesc)
				return false;
			if (messageSeverity != other.messageSeverity)
				return false;
			return true;
		}
	
		@JsonIgnore
		public Long getId() {
			return id;
		}
		@JsonIgnore
		public void setId(Long id) {
			this.id = id;
		}
	}
