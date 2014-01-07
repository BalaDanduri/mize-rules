package com.mize.domain.common;

public enum AuthType {
      USER("User"),BUSINESS_ENTITY("Business_Entity"),GROUP("Group");
      
      	private String authType;
      
	  	private AuthType(String authType) {
	  		this.authType = authType;
	  	}
	   
	  	public String getValue() {
	  		return authType;
	  	}
   
}
