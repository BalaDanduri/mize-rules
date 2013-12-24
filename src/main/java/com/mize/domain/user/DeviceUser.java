package com.mize.domain.user;

import com.mize.domain.common.Entity;

public class DeviceUser extends Entity {
	
	private static final long serialVersionUID = 6457592258862233006L;	
	private Long deviceId;
	private Long userId;
	
	public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
