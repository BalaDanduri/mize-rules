package com.mize.domain.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UploadError implements Serializable{
	
	private static final long serialVersionUID = 105580489744280485L;
	private String code;
	private String message;
	private List<String> records = new ArrayList<String>();
	private Integer lineNumber;
	private String exception;
	public UploadError() {		
	}
	
	public UploadError(String code,String exception) {
		super();
		this.code = code;
		this.exception = exception;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorCode() {
		return code;
	}
	public void setErrorCode(String code) {
		this.code = code;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public List<String> getRecords() {
		return records;
	}

	public void setRecords(List<String> records) {
		this.records = records;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	@Override
	public String toString() {
		return "UploadError [code=" + code + ", message=" + message
				+ ", records=" + records + ", exception=" + exception + "]";
	}

	

	
}