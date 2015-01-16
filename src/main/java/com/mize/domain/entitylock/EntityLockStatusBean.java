package com.mize.domain.entitylock;

import java.io.Serializable;


public class EntityLockStatusBean implements Serializable{
	private static final long serialVersionUID = 1717046760736548338L;
	
	private String[] status;
	
	public EntityLockStatusBean(){
		super();
	}
	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}
	
}
