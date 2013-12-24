package com.mize.domain.exception;

import java.io.Serializable;

public class MizeError implements Serializable{
	
	private static final long serialVersionUID = -6815580489744280485L;
	private String code;
	private String message;
	public MizeError() {		
	}
	
	public MizeError(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return code;
	}
	public void setErrorCode(String code) {
		this.code = code;
	}
	public String getErrorMessage() {
		return message;
	}
	public void setErrorMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return code+"--"+message;
	}

}