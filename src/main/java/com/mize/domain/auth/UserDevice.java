package com.mize.domain.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Table(name="user_device")
public class UserDevice extends MizeSceEntityAudit implements Comparable<UserDevice>{

	private static final long serialVersionUID = 4316489367828861386L;
	
	private String deviceUID;
	private String deviceOS;
	private String  isActive;
	private User user;

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
	
	@Column(name="device_uid")
	public String getDeviceUID() {
		return deviceUID;
	}

	public void setDeviceUID(String deviceUID) {
		this.deviceUID = deviceUID;
	}

	@Column(name="device_os")
	public String getDeviceOS() {
		return deviceOS;
	}

	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
	@JsonBackReference(value="user_userDevice")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((isActive == null) ? 0 : deviceOS.hashCode());
		result = prime * result + ((deviceOS == null) ? 0 : deviceOS.hashCode());
		result = prime * result + ((deviceUID == null) ? 0 : deviceUID.hashCode());
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
		if (deviceUID == null) {
			if (other.deviceUID != null)
				return false;
		} else if (!deviceUID.equals(other.deviceUID))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UserDevice [deviceToken=" + deviceUID + ", deviceOS=" + deviceOS + ", active="
				+ isActive + "]";
	}

	@Override
	public int compareTo(UserDevice arg0) {
		return 0;
	}

}
