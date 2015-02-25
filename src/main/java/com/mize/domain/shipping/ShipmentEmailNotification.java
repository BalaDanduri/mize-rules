package com.mize.domain.shipping;

import com.mize.domain.common.MizeSceEntity;

public class ShipmentEmailNotification extends MizeSceEntity implements Comparable<ShipmentEmailNotification>{
	
	private static final long serialVersionUID = -350317419410443313L;
	private String reciepentType;
	private String email;
	
	public ShipmentEmailNotification() {
		super();
	}
	
	public ShipmentEmailNotification(String reciepentType, String email) {
		super();
		this.reciepentType = reciepentType;
		this.email = email;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getReciepentType() {
		return reciepentType;
	}

	public void setReciepentType(String reciepentType) {
		this.reciepentType = reciepentType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int compareTo(ShipmentEmailNotification o) {
		return 0;
	}

}
