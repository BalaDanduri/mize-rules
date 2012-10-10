package com.mize.domain.appmessage;

import com.mize.domain.common.Entity;

public class MessageType extends Entity {
	private int messageTypeId;
	private String messageType;

	public MessageType() {

	}

	public MessageType(int messageTypeId, String messageType) {
		this.messageTypeId = messageTypeId;
		this.messageType = messageType;
	}

	public int getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(int messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("messageTypeId = " + messageTypeId + ",")
				.append("messageType = " + messageType + "} \n").toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageType other = (MessageType) obj;
		if (messageTypeId != other.messageTypeId)
			return false;
		if (messageType == null) {
			if (other.messageType != null)
				return false;
		} else if (!messageType.equals(other.messageType))
			return false;
		return true;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + messageTypeId;
		result = prime * result
				+ ((messageType == null) ? 0 : messageType.hashCode());
		return result;
	}
}
