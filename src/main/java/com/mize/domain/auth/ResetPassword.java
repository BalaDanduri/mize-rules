package com.mize.domain.auth;

import com.mize.domain.common.MizeSceEntity;

public class ResetPassword extends MizeSceEntity implements Comparable<ResetPassword> {
   
	private static final long serialVersionUID = 71752897031471580L;
	private String password;	
	private String repeatPassword;	
	private String hashedPassword;	
	private String hashedRepeatPassword;	
	private String oldPassword;
	private String hashedOldPassword;	
	private String token;	
	private String email;
	private boolean isPasswordMatched;
	private User user;
	private String loginId;
	private String deviceUID;
	private String deviceOS;
	
    @Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepeatPassword() {
		return repeatPassword;
	}


	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}


	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getHashedRepeatPassword() {
		return hashedRepeatPassword;
	}

	public void setHashedRepeatPassword(String hashedRepeatPassword) {
		this.hashedRepeatPassword = hashedRepeatPassword;
	}

	public String getHashedOldPassword() {
		return hashedOldPassword;
	}

	public void setHashedOldPassword(String hashedOldPassword) {
		this.hashedOldPassword = hashedOldPassword;
	}

	public boolean isPasswordMatched() {
		return isPasswordMatched;
	}

	public void setPasswordMatched(boolean isPasswordMatched) {
		this.isPasswordMatched = isPasswordMatched;
	}

	public int compareTo(ResetPassword entity) {
		if ( this == entity ) 
			return EQUAL;
		else if (this.id < entity.id) 
			return BEFORE;
		else if (entity.id == this.id) 
			return EQUAL;
		else if (this.id > entity.id)
			return AFTER;
		return EQUAL;		
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDeviceUID() {
		return deviceUID;
	}

	public void setDeviceUID(String deviceUID) {
		this.deviceUID = deviceUID;
	}

	public String getDeviceOS() {
		return deviceOS;
	}

	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}

	@Override
	public String toString() {
		return "ResetPassword [password=" + password + ", repeatPassword="
				+ repeatPassword + ", oldPassword=" + oldPassword + ", token="
				+ token + ", email=" + email + ", loginId="
				+ loginId + ", deviceUID=" + deviceUID + ", deviceOS="
				+ deviceOS + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((deviceOS == null) ? 0 : deviceOS.hashCode());
		result = prime * result
				+ ((deviceUID == null) ? 0 : deviceUID.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result
				+ ((oldPassword == null) ? 0 : oldPassword.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((repeatPassword == null) ? 0 : repeatPassword.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		ResetPassword other = (ResetPassword) obj;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (oldPassword == null) {
			if (other.oldPassword != null)
				return false;
		} else if (!oldPassword.equals(other.oldPassword))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (repeatPassword == null) {
			if (other.repeatPassword != null)
				return false;
		} else if (!repeatPassword.equals(other.repeatPassword))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}
    
}
