package com.mize.domain.common;

public enum AuthType {
      USER("User"),BUSINESS_ENTITY("BusinessEntity"),GROUP("Group");
      
      	private String authType;
      
	  	private AuthType(String authType) {
	  		this.authType = authType;
	  	}
	   
	  	public String getValue() {
	  		return authType;
	  	}
   
}
