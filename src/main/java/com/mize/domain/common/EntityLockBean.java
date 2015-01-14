package com.mize.domain.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class EntityLockBean implements Serializable{
	private static final long serialVersionUID = 1717146760736548338L;
	
	private String allowLockTimeRenewal;
	private Map<String,EntityLockStatusBean> entityLockStatusMap = new HashMap<String,EntityLockStatusBean>();
	
	public EntityLockBean(){
		super();
	}
	
	public boolean isAllowLockTimeRenewal() {
		return "Y".equalsIgnoreCase(allowLockTimeRenewal);
	}
	
	public void setAllowLockTimeRenewal(String allowLockTimeRenewal) {
		this.allowLockTimeRenewal = allowLockTimeRenewal;
	}
	
	public Map<String, EntityLockStatusBean> getEntityLockStatusMap() {
		return entityLockStatusMap;
	}
	
	public void setEntityLockStatusMap(Map<String, EntityLockStatusBean> entityLockStatusMap) {
		this.entityLockStatusMap = entityLockStatusMap;
	}
	
	public EntityLockStatusBean getEntityLockStatusBean(String role) {
		return this.entityLockStatusMap.get(role);
	}
	
		
}
