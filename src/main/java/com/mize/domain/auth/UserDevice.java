package com.mize.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name="user_device")
public class UserDevice extends MizeSceEntityAudit implements Comparable<UserDevice>{

	private static final long serialVersionUID = 4316489367828861386L;
	
	private String deviceToken;
	private String deviceOS;
	private Long userId;
	private String  isActive;
	private User user;

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="device_token")
	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	@Column(name="device_os")
	public String getDeviceOS() {
		return deviceOS;
	}

	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}

	@Column(name="user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((isActive == null) ? 0 : deviceOS.hashCode());
		result = prime * result + ((deviceOS == null) ? 0 : deviceOS.hashCode());
		result = prime * result + ((deviceToken == null) ? 0 : deviceToken.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserDevice other = (UserDevice) obj;
		if (isActive != other.isActive)
			return false;
		if (deviceOS == null) {
			if (other.deviceOS != null)
				return false;
		} else if (!deviceOS.equals(other.deviceOS))
			return false;
		if (deviceToken == null) {
			if (other.deviceToken != null)
				return false;
		} else if (!deviceToken.equals(other.deviceToken))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UserDevice [deviceToken=" + deviceToken + ", deviceOS=" + deviceOS + ", userId=" + userId + ", active="
				+ isActive + "]";
	}

	@Override
	public int compareTo(UserDevice arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
