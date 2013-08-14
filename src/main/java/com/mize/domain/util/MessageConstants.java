package com.mize.domain.util;

import java.io.Serializable;

public abstract class MessageConstants implements Serializable{
	private static final long serialVersionUID = 7893011032395196052L;
	
	public static String ENTITY_CODE_REQUIRED = "ENTITY_CODE_REQUIRED";
	public static String ENTITY_BRAND_NAME_REQUIRED = "ENTITY_BRAND_NAME_REQUIRED";
	public static String ADDRESS_REQUIRED = "ADDRESS_REQUIRED";
	public static String INVALID_ADDRESS = "INVALID_ADDRESS";
	public static String CREATED_BY_REQUIRED = "CREATED_BY_REQUIRED";
	public static String INVALID_ENTITY_TYPE_CODE = "VALID_ENTITY_TYPE_CODE_REQUIRED";
	public static String PARENT_RECORD_NOT_FOUND = "PARENT_RECORD_NOT_FOUND";
	public static String EXCEPTION = "EXCEPTION";

}
