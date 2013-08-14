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
	public static String PRODUCT_ID_NOT_FOUND = "PRODUCT_ID_NOT_FOUND";
	public static String SIMILAR_PRODUCT_ID_NOT_FOUND = "SIMILAR_PRODUCT_ID_NOT_FOUND";
	public static String ACCESSORY_PRODUCT_ID_NOT_FOUND = "ACCESSORY_PRODUCT_ID_NOT_FOUND";
	public static String UPSELL_PRODUCT_ID_NOT_FOUND = "UPSELL_PRODUCT_ID_NOT_FOUND";
	public static String ATTRIBUTE_ID_NOT_FOUND = "ATTRIBUTE_ID_NOT_FOUND";
	public static String CATEGORY_ID_NOT_FOUND = "CATEGORY_ID_NOT_FOUND";
	public static String EXCEPTION = "EXCEPTION";

}
