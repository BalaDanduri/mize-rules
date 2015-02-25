package com.mize.domain.shipping;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;

public class ShipmentEmailNotications extends MizeSceEntity implements Comparable<ShipmentEmailNotications>{

	private static final long serialVersionUID = 2683333586298356542L;

	private String onDelivery;
	private String onShipTo;
	private String notification3;
	private List<ShipmentEmailNotification>  notifications = new ArrayList<ShipmentEmailNotification>();
	
	public ShipmentEmailNotications(){
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
	
	public String getOnDelivery() {
		return onDelivery;
	}
	
	public void setOnDelivery(String onDelivery) {
		this.onDelivery = onDelivery;
	}
	
	public String getOnShipTo() {
		return onShipTo;
	}
	
	public void setOnShipTo(String onShipTo) {
		this.onShipTo = onShipTo;
	}
	public String getNotification3() {
		return notification3;
	}
	public void setNotification3(String notification3) {
		this.notification3 = notification3;
	}
	
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
				+ ((notification3 == null) ? 0 : notification3.hashCode());
		result = prime * result
				+ ((onDelivery == null) ? 0 : onDelivery.hashCode());
		result = prime * result
				+ ((onShipTo == null) ? 0 : onShipTo.hashCode());
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
		ShipmentEmailNotications other = (ShipmentEmailNotications) obj;
		if (notification3 == null) {
			if (other.notification3 != null)
				return false;
		} else if (!notification3.equals(other.notification3))
			return false;
		if (onDelivery == null) {
			if (other.onDelivery != null)
				return false;
		} else if (!onDelivery.equals(other.onDelivery))
			return false;
		if (onShipTo == null) {
			if (other.onShipTo != null)
				return false;
		} else if (!onShipTo.equals(other.onShipTo))
			return false;
		return true;
	}
	@Override
	public int compareTo(ShipmentEmailNotications o) {
		return 0;
	}

}
