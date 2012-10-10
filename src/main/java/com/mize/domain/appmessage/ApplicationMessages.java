package com.mize.domain.appmessage;

import java.util.HashSet;
import java.util.Set;

import com.mize.domain.common.Entity;

public class ApplicationMessages  {
	
	public class Message extends Entity {
		
		private Long id;
		private MessageType messageType;
		private String messageCode;
		private String messageShortDesc;
		private String messageLongDesc;
		private String messageSeverity;
		
		public Message(Long id, MessageType messageType, String messageCode,
				String messageShortDesc, String messageLongDesc,
				String messageSeverity) {
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

		public String getMessageSeverity() {
			return messageSeverity;
		}

		public void setMessageSeverity(String messageSeverity) {
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
					+ ((messageSeverity == null) ? 0 : messageSeverity.hashCode());
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
			Message other = (Message) obj;
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

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
	}

	Set<Message> appMessages = new HashSet<Message>();
	
	public ApplicationMessages() {

	}
	
	
	public boolean addMessage(final Message msg) {
		
		return appMessages.add(msg);
	}
	
	public boolean addMessage(Long id, MessageType messageType, String messageCode,
			String messageShortDesc, String messageLongDesc,
			String messageSeverity) {
	
			return appMessages.add(new Message(id, messageType, messageCode, messageShortDesc, messageLongDesc, messageSeverity));
	}
	
	public Set<Message> getMessages() {
		return appMessages;
	}

}
