package com.mize.domain.util;

import java.io.Serializable;

public abstract class MessageConstants implements Serializable{
	private static final long serialVersionUID = 7893011032395196052L;
	
	public static final String ENTITY_CODE_REQUIRED = "ENTITY_CODE_REQUIRED";
	public static final String ENTITY_BRAND_NAME_REQUIRED = "ENTITY_BRAND_NAME_REQUIRED";
	public static final String ADDRESS_REQUIRED = "ADDRESS_REQUIRED";
	public static final String INVALID_ADDRESS = "INVALID_ADDRESS";
	public static final String INVALID_BRAND_NAME = "INVALID_BRAND_NAME";
	public static final String INVALID_DATE_RANGE = "INVALID_DATE_RANGE";
	public static final String BRAND_NAME_REQUIRED = "BRAND_NAME_REQUIRED";
	public static final String CREATED_BY_REQUIRED = "CREATED_BY_REQUIRED";
	public static final String INVALID_ENTITY_TYPE_CODE = "VALID_ENTITY_TYPE_CODE_REQUIRED";
	public static final String PRODUCT_ID_NOT_FOUND = "PRODUCT_ID_NOT_FOUND";
	public static final String SIMILAR_PRODUCT_ID_NOT_FOUND = "SIMILAR_PRODUCT_ID_NOT_FOUND";
	public static final String ACCESSORY_PRODUCT_ID_NOT_FOUND = "ACCESSORY_PRODUCT_ID_NOT_FOUND";
	public static final String UPSELL_PRODUCT_ID_NOT_FOUND = "UPSELL_PRODUCT_ID_NOT_FOUND";
	public static final String ATTRIBUTE_ID_NOT_FOUND = "ATTRIBUTE_ID_NOT_FOUND";
	public static final String CATEGORY_ID_NOT_FOUND = "CATEGORY_ID_NOT_FOUND";
	public static final String NO_RESULTS_FOUND = "NO_RESULTS_FOUND";
	public static final String GEN_TECH_EXCEPTION = "GEN_TEC_001";
	public static final String EXCEPTION = "EXCEPTION";
	public static final String INVALID_STATE_CODE = "INVALID_STATE_CODE";
	public static final String INVALID_COUNTRY_CODE = "INVALID_COUNTRY_CODE";
	public static final String INVALID_LOCALE_CODE = "INVALID_LOCALE_CODE";
	public static final String MIZE_PRODUCT_NOT_FOUND = "MIZE_PRODUCT_NOT_FOUND";
	public static final String EBAY_ERROR = "EBAY_ERROR";
	public static final String ROLE_ID_DOESNOT_EXISTS = "ROLE_ID_DOESNOT_EXISTS";
	public static final String GROUP_ID_DOES_NOT_EXISTS = "GROUP_ID_DOES_NOT_EXISTS";
	public static final String USER_ID_DOES_NOT_EXISTS = "USER_ID_DOES_NOT_EXISTS";
	public static final String GROUP_NAME_ALREADY_EXISTS = "GROUP_NAME_ALREADY_EXISTS";
	public static final String COMPANY_ID_DOES_NOT_EXISTS = "COMPANY_ID_DOES_NOT_EXISTS";
	public static final String COMPANY_NAME_DOES_NOT_EXISTS = "COMPANY_NAME_DOES_NOT_EXISTS";
	public static final String BRAND_ID_DOES_NOT_EXISTS = "BRAND_ID_DOES_NOT_EXISTS";
	public static final String USER_AND_BRAND_DOES_NOT_EXIXTS = "USER_AND_BRAND_DOES_NOT_EXIXTS";
	public static final String INVALID_SCHEDULE_ID = "INVALID_SCHEDULE_ID";
	public static final String INVALID_BRAND_ID = "INVALID_BRAND_ID";
	public static final String INVALID_ADDRESS_ID = "INVALID_ADDRESS_ID";
	public static final String BRAND_ID_REQUIRED = "BRAND_ID_REQUIRED";
	public static final String INVALID_SCHEDULED_DATE = "INVALID_SCHEDULED_DATE";
	public static final String INVALID_SERVICE_FORMAT = "INVALID_SERVICE_FORMAT";
	public static final String PRODUCT_ID_REQUIRED = "PRODUCT_ID_REQUIRED";
	public static final String PRODUCT_ID_OR_BRAND_ID_REQUIRED = "PRODUCT_ID_OR_BRAND_ID_REQUIRED";
	public static final String JDBC_UPDATE_ZERO_RECORDS = "ZERO_RECORDS_UPDATE";
	public static final String DAO_ERROR = "DAO_ERROR";
	public static final String INVALID_COUNTRY_OR_STATE = "INVALID_COUNTRY_OR_STATE";
	public static final String INVALID_ENROLLMENT_TOKEN = "INVALID_ENROLLMENT_TOKEN";
	public static final String ALREADY_ENROLLED = "ALREADY_ENROLLED";
	public static final String ENROLLMENT_EMAIL_NOT_VALIDATED = "ENROLLMENT_EMAIL_NOT_VALIDATED";
	public static final String INVALID_SEARCH_TYPE ="INVALID_SEARCH_TYPE";
	public static final String UNIT_ID_NOT_FOUND ="UNIT_ID_NOT_FOUND";
	public static final String BASE_UNIT_ID_NOT_FOUND ="BASE_UNIT_ID_NOT_FOUND";
	public static final String CASE_NUMBER_REQUIRED ="CASE_NUMBER_REQUIRED";
	public static final String INVAID_CASE_NUMBER ="INVAID_CASE_NUMBER";
	public static final String PROVIDER_CODE_REQUIRED ="PROVIDER_CODE_REQUIRED";
	public static final String INVALID_PROVIDER_CODE ="INVALID_PROVIDER_CODE";
	public static final String REQUESTER_CODE_REQUIRED ="REQUESTER_CODE_REQUIRED";
	public static final String INVALID_REQUESTER_CODE ="INVALID_REQUESTER_CODE";
	public static final String TEMPLATE_CODE_REQUIRED = "TEMPLATE_CODE_REQUIRED";
	public static final String DUPLICATE_TEMPLATE_CODE = "DUPLICATE_TEMPLATE_CODE";
	public static final String TEMPLATE_ALREADY_EXISTS = "TEMPLATE_ALREADY_EXISTS";
	public static final String INVALID_MODEL = "INVALID_MODEL";
	public static final String INVALID_MODEL_SERIAL_COMBINATION = "INVALID_MODEL_AND_SERIAL_COMBINATION";
	public static final String FORM_ALREADY_EXISTS = "FORM_ALREADY_EXISTS";
	public static final String BUSINESS_ENTITY_CODE_REQUIRED = "BUSINESS_ENTITY_CODE_REQUIRED";
	public static final String BUSINESS_ENTITY_CODE_ALL_READY_EXISTS = "BUSINESS_ENTITY_CODE_ALL_READY_EXISTS";
	public static final String INVALID_BUSINESS_ENTITY_CODE = "INVALID_BUSINESS_ENTITY_CODE";
	public static final String INVALID_PART_CODE = "INVALID_PART_CODE";
	public static final String INVALID_TEMPLATE = "INVALID_TEMPLATE";
	public static final String DUPLICATE_PART_CODE = "DUPLICATE_PART_CODE";
	public static final String PART_CODE_DOES_NOT_EXIST = "PART_CODE_DOES_NOT_EXIST";
	public static final String OLD_PART_CODE_DOES_NOT_EXIST = "OLD_PART_CODE_DOES_NOT_EXIST";
	public static final String NEW_PART_CODE_DOES_NOT_EXIST = "NEW_PART_CODE_DOES_NOT_EXIST";
	public static final String INVALID_PICK_LIST_CODE = "INVALID_PICK_LIST_CODE";
	public static final String INVALID_PICK_LIST_ID = "INVALID_PICK_LIST_ID";
	public static final String INVALID_PICK_LIST = "INVALID_PICK_LIST_ID_OR_CODE";
	public static final String INVALID_BUSINESS_ENTITY = "INVALID_BUSINESS_ENTITY";
	public static final String INVALID_TENANT = "INVALID_TENANT";
	public static final String DUPLICATE_PICK_LIST_CODE = "DUPLICATE_PICK_LIST_CODE";
	public static final String INVALID_PART_KIT_ID = "INVALID_PART_KIT_ID";
	public static final String INVALID_PART_SUBSTITUTE = "INVALID_PART_SUBSTITUTE";
	public static final String VALID_PART_CODE ="VALID_PART_CODE";
	public static final String INVALID_PROD_ID ="INVALID_PROD_ID";
	public static final String INVALID_COMMENT_ID ="INVALID_COMMENT_ID";
	public static final String INVALID_PROD_SRL_NO ="INVALID_PROD_SRL_NO";
	public static final String INVALID_DELIVERY_BE_ID ="INVALID_DELIVERY_BE_ID";
	
	public static final String INVALID_MANUFACTURER_BE_ID = "INVALID_MANUFACTURER_BE_ID";
	public static final String INVALID_PROD_NAME = "INVALID_PROD_NAME";
	public static final String INVALID_ITEM_NUMBER = "INVALID_ITEM_NUMBER";
	public static final String INVALID_CATEGORY_NAME = "INVALID_CATEGORY_NAME";
	public static final String NAME_REQUIRED = "NAME_REQUIRED";	
	public static final String DUPLICATE_TYPE_AND_CODE = "DUPLICATE_TYPE_AND_CODE";	
	public static final String INVALID_LINK_TYPE = "INVALID_LINK_TYPE";
	public static final String INVALID_PARENT_BUSINESS_ENTITY_CODE = "INVALID_PARENT_BUSINESS_ENTITY_CODE";
	public static final String USER_CODE_REQUIRED = "USER_CODE_REQUIRED";
	public static final String GROUP_CODE_REQUIRED = "GROUP_CODE_REQUIRED";
	public static final String DUPLICATE_GROUP_NAME= "DUPLICATE_GROUP_NAME";
	public static final String DUPLICATE_WORK_QUEUE_CODE = "DUPLICATE_WORK_QUEUE_NAME";
	public static final String DUPLICATE_WORK_QUEUE_AUTH_CODE = "DUPLICATE_WORK_QUEUE_AUTH_CODE";
	public static final String DUPLICATE_ROLE_NAME= "DUPLICATE_ROLE_NAME";
	public static final String INVALID_WQ_AUTHORIZATION= "INVALID_WQ_AUTHORIZATION";

	public static final String INVALID_CUSTOMER = "INVALID_CUSTOMER";
	public static final String INVALID_INVOICE_BUSINESS_ENTITY = "INVALID_INVOICE_BUSINESS_ENTITY";
	public static final String INVALID_PRODUCT_REGISTRATION = "INVALID_PRODUCT_REGISTRATION";
	
	public static final String INVALID_CATALOG_NAME = "INVALID_CATALOG_NAME";
	public static final String CATALOG_NAME_DOES_NOT_EXIST = "CATALOG_NAME_DOES_NOT_EXIST";
	public static final String CATALOG_NAME_REQUIRED = "CATALOG_NAME_REQUIRED";
	public static final String CATALOG_NAME_ALREADY_EXISTS = "CATALOG_NAME_ALREADY_EXISTS";
	public static final String ENTRY_CODE_REQUIRED = "ENTRY_CODE_REQUIRED";
	public static final String ENTRY_VALUE_REQUIRED = "ENTRY_VALUE_REQUIRED";
	public static final String DUPLICATE_ENTRY_CODE = "DUPLICATE_ENTRY_CODE";
	
	public static final String INVALID_ORDER_BE_ID= "INVALID_ORDER_BE_ID";
	public static final String INVALID_START_AND_END_DATES= "INVALID_START_AND_END_DATES";
	public static final String DUPLICATE_DISCOUNT_NUMBER= "DUPLICATE_DISCOUNT_NUMBER";
	public static final String MIN_AMT_LESS_THAN_MAX_AMT= "MIN_AMT_LESS_THAN_MAX_AMT";
	public static final String MIN_QTY_LESS_THAN_MAX_QTY= "MIN_QTY_LESS_THAN_MAX_QTY";
	public static final String EITHER_AMOUNT_OR_PERCENT_ISREQUIRED= "EITHER_AMOUNT_OR_PERCENT_ISREQUIRED";
	public static final String ACTIVITI_NOT_FOUND = "ACTIVITI_NOT_FOUND";
	public static final String INVALID_SHIP_BE_ID ="INVALID_SHIP_BE_ID";
	
	public static final String ATLEAST_ONE_PRODUCT_NAME_REQUIRED = "ATLEAST_ONE_PRODUCT_NAME_DETAILS_REQUIRED";
	public static final String PRODUCT_NAME_REQUIRED = "PRODUCT_NAME_REQUIRED";
	public static final String DUPLICATE_BRAND_AND_MODEL = "DUPLICATE_BRAND_AND_MODEL";
	public static final String PRODUCT_EXISTS_FOR_BRAND_MODEL = "PRODUCT_EXISTS_FOR_BRAND_MODEL";
	public static final String DUPLICATE_PRODUCT_NAME = "DUPLICATE_PRODUCT_NAME";
	public static final String DUPLICATE_CATEGORY = "DUPLICATE_CATEGORY";
	public static final String DUPLICATE_INSTANCE_LINK = "DUPLICATE_INSTANCE_LINK";
	public static final String PRODUCT_SERIAL_IS_REQUIRED = "PRODUCT_SERIAL_IS_REQUIRED";
	public static final String INVALID_PRODUCT_SERIAL = "INVALID_PRODUCT_SERIAL";
	public static final String INVALID_SHIP_LOCATION ="INVALID_SHIP_LOCATION";
	public static final String DUPLICATE_BRAND_MODEL_SERIAL_COMBINATION = "DUPLICATE_BRAND_MODEL_SERIAL_COMBINATION";
	
	public static final String INVALID_BRAND_MODEL_COMBINATION = "INVALID_BRAND_MODEL_COMBINATION";
	public static final String INVALID_FORM_DEFINITON = "INVALID_FORM_DEFINITON";
}



