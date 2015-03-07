package com.mize.domain.shipping;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.common.MizeSceEntity;

public class ShipmentEmailNotifications extends MizeSceEntity implements Comparable<ShipmentEmailNotifications>{

	private static final long serialVersionUID = 2683333586298356542L;

	private List<ShipmentEmailNotification>  notifications = new ArrayList<ShipmentEmailNotification>();
	
	public ShipmentEmailNotifications(){
		super();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonInclude(Include.NON_DEFAULT)
	public List<ShipmentEmailNotification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<ShipmentEmailNotification> notifications) {
		this.notifications = notifications;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((notifications == null) ? 0 : notifications.hashCode());
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
		ShipmentEmailNotifications other = (ShipmentEmailNotifications) obj;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		return true;
	}

	@Override
	public int compareTo(ShipmentEmailNotifications o) {
		return 0;
	}

}
