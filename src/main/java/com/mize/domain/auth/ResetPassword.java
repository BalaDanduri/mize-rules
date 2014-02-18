package com.mize.domain.auth;

import com.mize.domain.common.MizeEntity;

public class ResetPassword extends MizeEntity implements Comparable<ResetPassword> {
   
	private static final long serialVersionUID = 71752897031471580L;
	private String password;	
	private String repeatPassword;	
	private String hashedPassword;	
	private String hashedRepeatPassword;	
	private String oldPassword;	
	private String token;	
	private String email;
	private User user;
	
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
    
}
