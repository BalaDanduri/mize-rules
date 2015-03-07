package com.mize.domain.shipping;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.common.MizeSceEntity;

public class ShipmentEmailNotification extends MizeSceEntity implements Comparable<ShipmentEmailNotification>{
	
	private static final long serialVersionUID = -350317419410443313L;
	private String recipientType;
	private String notificationCode;
	private String email;
	private List<NotificationType>  notificationTypes = new ArrayList<NotificationType>();
	
	public ShipmentEmailNotification() {
		super();
	}

	public ShipmentEmailNotification(String recipientType, String notificationCode, String email,List<NotificationType> notificationTypes) {
		super();
		this.recipientType = recipientType;
		this.notificationCode = notificationCode;
		this.email = email;
		this.notificationTypes = notificationTypes;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getRecipientType() {
		return recipientType;
	}

	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}

	public String getNotificationCode() {
		return notificationCode;
	}

	public void setNotificationCode(String notificationCode) {
		this.notificationCode = notificationCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	public List<NotificationType> getNotificationTypes() {
		return notificationTypes;
	}
	public void setNotificationTypes(List<NotificationType> notificationTypes) {
		this.notificationTypes = notificationTypes;
	}
	
	@Override
	public int compareTo(ShipmentEmailNotification o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime
				* result
				+ ((notificationCode == null) ? 0 : notificationCode.hashCode());
		result = prime
				* result
				+ ((notificationTypes == null) ? 0 : notificationTypes
						.hashCode());
		result = prime * result
				+ ((recipientType == null) ? 0 : recipientType.hashCode());
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
		ShipmentEmailNotification other = (ShipmentEmailNotification) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (notificationCode == null) {
			if (other.notificationCode != null)
				return false;
		} else if (!notificationCode.equals(other.notificationCode))
			return false;
		if (notificationTypes == null) {
			if (other.notificationTypes != null)
				return false;
		} else if (!notificationTypes.equals(other.notificationTypes))
			return false;
		if (recipientType == null) {
			if (other.recipientType != null)
				return false;
		} else if (!recipientType.equals(other.recipientType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShipmentEmailNotification [recipientType=" + recipientType
				+ ", notificationCode=" + notificationCode + ", email=" + email
				+ ", notificationTypes=" + notificationTypes + "]";
	}
	
}
