package com.mize.domain.util;

import java.io.Serializable;

public abstract class MessageConstants implements Serializable{
	private static final long serialVersionUID = 7893011032395196052L;
	
	public static final String ENTITY_CODE_REQUIRED = "ENTITY_CODE_REQUIRED";
	public static final String ENTITY_BRAND_NAME_REQUIRED = "ENTITY_BRAND_NAME_REQUIRED";
	public static final String INVALID_BRAND_MODEL_CATEGORY_COMBINATION = "INVALID_BRAND_MODEL_CATEGORY_COMBINATION";
	public static final String ADDRESS_REQUIRED = "ADDRESS_REQUIRED";
	public static final String INVALID_ADDRESS = "INVALID_ADDRESS";
	public static final String INVALID_ZIP = "INVALID_ZIP";
	public static final String INVALID_STATE = "INVALID_STATE";
	public static final String INVALID_COUNTRY = "INVALID_COUNTRY";
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
	public static final String INVALID_PARENT_ENTITY_CODE = "INVALID_PARENT_ENTITY_CODE";
	public static final String INVALID_BUSINESS_ENTITY_CODE = "INVALID_BUSINESS_ENTITY_CODE";
	public static final String INVALID_BUSINESS_ENTITY_TYPE = "INVALID_BUSINESS_ENTITY_TYPE";
	public static final String INVALID_PARENT_BUSINESS_ENTITY_TYPE = "INVALID_PARENT_BUSINESS_ENTITY_TYPE";
	public static final String INVALID_CURRENCY = "INVALID_CURRENCY";
	public static final String INVALID_LOCALE = "INVALID_LOCALE";
	public static final String INVALID_BUSINESS_ENTITY_NAME = "INVALID_BUSINESS_ENTITY_NAME";
	public static final String INVALID_BRAND = "INVALID_BRAND";
	public static final String INVALID_CONTACT_TYPE = "INVALID_CONTACT_TYPE";
	public static final String INVALID_DEPARTMENT_TYPE = "INVALID_DEPARTMENT_TYPE";
	public static final String INVALID_PHONE_TYPE = "INVALID_PHONE_TYPE";
	public static final String INVALID_PHONE = "INVALID_PHONE";
	public static final String INVALID_ADDRESS_TYPE = "INVALID_ADDRESS_TYPE";
	public static final String INVALID_EMAIL = "INVALID_EMAIL";
	public static final String FIRST_NAME_REQUIRED = "FIRST_NAME_REQUIRED";
	public static final String LAST_NAME_REQUIRED = "LAST_NAME_REQUIRED";
	public static final String PHONE_NUMBER_REQUIRED = "PHONE_NUMBER_REQUIRED";

	
	public static final String INVALID_PART_CODE = "INVALID_PART_CODE";
	public static final String INVALID_TEMPLATE = "INVALID_TEMPLATE";
	public static final String DUPLICATE_PART_CODE = "DUPLICATE_PART_CODE";
	public static final String DUPLICATE_PART_KIT = "DUPLICATE_PART_KIT";
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
	public static final String CUSTOMER_NUMBER_IS_REQUIRED = "CUSTOMER_NUMBER_IS_REQUIRED";
	public static final String INVALID_INVOICE_BUSINESS_ENTITY = "INVALID_INVOICE_BUSINESS_ENTITY";
	public static final String INVALID_PRODUCT_REGISTRATION = "INVALID_PRODUCT_REGISTRATION";
	public static final String INVOICE_BUSINESS_ENTITY_TYPE_IS_REQUIRED = "INVOICE_BUSINESS_ENTITY_TYPE_IS_REQUIRED";
	public static final String INVOICE_BUSINESS_ENTITY_CODE_IS_REQUIRED = "INVOICE_BUSINESS_ENTITY_CODE_IS_REQUIRED";
	
	public static final String INVALID_CATALOG_NAME = "INVALID_CATALOG_NAME";
	public static final String INVALID_CATALOG = "INVALID_CATALOG";
	public static final String CATALOG_NAME_DOES_NOT_EXIST = "CATALOG_NAME_DOES_NOT_EXIST";
	public static final String CATALOG_NAME_REQUIRED = "CATALOG_NAME_REQUIRED";
	public static final String CATALOG_NAME_ALREADY_EXISTS = "CATALOG_NAME_ALREADY_EXISTS";
	public static final String ENTRY_CODE_REQUIRED = "ENTRY_CODE_REQUIRED";
	public static final String ENTRY_VALUE_REQUIRED = "ENTRY_VALUE_REQUIRED";
	public static final String DUPLICATE_ENTRY_CODE = "DUPLICATE_ENTRY_CODE";
	
	public static final String DISCOUNT_NAME_IS_REQUIRED = "DISCOUNT_NAME_IS_REQUIRED";
	public static final String ORDER_LOCATION_TYPE_IS_REQUIRED= "ORDER_LOCATION_TYPE_IS_REQUIRED";
	public static final String INVALID_ORDER_LOCATION = "INVALID_ORDER_LOCATION";
	public static final String START_DATE_LESS_THAN_END_DATE= "START_DATE_LESS_THAN_END_DATE";
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
	public static final String PRODUCT_SERIAL_ALREADY_EXISTS = "PRODUCT_SERIAL_ALREADY_EXISTS";
	public static final String TENANT_CODE_IS_REQUIRED = "TENANT_CODE_IS_REQUIRED";
	public static final String MODEL_REQUIRED = "MODEL_REQUIRED";
	public static final String FORM_NAME_REQUIRED = "FORM_NAME_REQUIRED";
	public static final String DUPLICATE_FORM_NAME = "DUPLICATE_FORM_NAME";
	public static final String LOCALE_IS_REQUIRED = "LOCALE_IS_REQUIRED";
	public static final String BUILD_DATE_LESS_THAN_SHIP_DATE = "BUILD_DATE_LESS_THAN_SHIP_DATE";
	public static final String ATLEAST_ONE_ATTRIBUTE_REQUIRED = "ATLEAST_ONE_ATTRIBUTE_REQUIRED";
	public static final String INVALID_ENTITY_NUMBER = "INVALID_ENTITY_NUMBER";
	public static final String INVALID_ENTITY_LOCATION_TYPE = "INVALID_ENTITY_LOCATION_TYPE";
	public static final String  DUPLICATE_ATTRIBUTE_TYPE = "DUPLICATE_ATTRIBUTE_TYPE";
	public static final String LANGUAGE_CODE_IS_REQUIRED = "LANGUAGE_CODE_IS_REQUIRED";
	public static final String COUNTRY_CODE_IS_REQUIRED = "COUNTRY_CODE_IS_REQUIRED";
	public static final String ORDER_SEQUENCE_NUMARIC = "ORDER_SEQUENCE_NUMARIC";
	public static final String IS_ACTIVE_VALUE_INVALID = "IS_ACTIVE_VALUE_INVALID";
	public static final String IS_DEFAULT_VALUE_INVALID = "IS_DEFAULT_VALUE_INVALID";
	public static final String USR_PASSWORD_REQD = "USER_PWD_P001";
	public static final String USR_PASSWORD_LENGTH = "USER_PWD_P002";
	public static final String USR_PASSWORD_STRENGTH = "USER_PWD_P003";
	public static final String USR_PASSWORD_UNMATCH = "USER_PWD_P004";
	public static final String USR_OLD_PASSWORD_REQ = "USER_PWD_P005";
	public static final String USR_REPEAT_PASSWORD_REQ = "USER_PWD_P006";
	public static final String USR_NEED_EMAIL = "USER_LOGIN_005";
	public static final String RESET_PASS_PASSWORD_MATCHES = "USER_CHGP_005";
	public static final String PASS_PASSWORD_NOT_MATCHES = "USER_CHGP_105";
	public static final String USR_WRONG_PASSWORD = "USER_LOGIN_002";
	public static final String NO_USER_SESSION = "USER_SESS_001";
	public static final String INVALID_TOKEN = "INVALID_TOKEN";
	
	public static final String LOGIN_ID_REQUIRED = "LOGIN_ID_REQUIRED";
	public static final String USER_EMAIL_REQUIRED ="USER_EMAIL_REQUIRED";
	public static final String ORGANIZATION_TYPE_REQUIRED = "ORGANIZATION_TYPE_REQUIRED";
	public static final String INVALID_ORGANIZATION_NUMBER = "INVALID_ORGANIZATION_NUMBER";
	public static final String ORGANIZATION_NUMBER_REQUIRED = "ORGANIZATION_NUMBER_REQUIRED";
	public static final String BRAND_REQUIRED  = "BRAND_REQUIRED";
	public static final String TIME_ZONE_REQUIRED = "TIME_ZONE_REQUIRED";
	public static final String LOCALE_REQUIRED = "LOCALE_REQUIRED";
	public static final String GROUP_REQUIRED = "GROUP_REQUIRED";
	public static final String ADDRESS_TYPE_REQUIRED = "ADDRESS_TYPE_REQUIRED";
	public static final String PHONE_TYPE_REQUIRED = "PHONE_TYPE_REQUIRED";
	public static final String COUNTRY_REQUIRED = "COUNTRY_REQUIRED";
	public static final String INVALID_GROUP = "INVALID_GROUP";
	public static final String DUPLICATE_LANGUAGE_CODE = "DUPLICATE_LANGUAGE_CODE";
	public static final String DUPLICATE_LOCALE_DETAILS = "DUPLICATE_LOCALE_DETAILS";
	public static final String MANUFACTURER_TYPE_REQUIRED = "MANUFACTURER_TYPE_REQUIRED";
	public static final String SHIP_LOCATION_TYPE_REQUIRED = "SHIP_LOCATION_TYPE_REQUIRED";
	public static final String CUSTOMER_TYPE_REQUIRED = "CUSTOMER_TYPE_REQUIRED";
	public static final String PART_NUMBER_IS_REQUIRED = "PART_NUMBER_IS_REQUIRED";
	public static final String PART_TYPE_IS_REQUIRED = "PART_TYPE_IS_REQUIRED";
	public static final String PART_UOM_IS_REQUIRED = "PART_UOM_IS_REQUIRED";
	public static final String PART_NAME_IS_REQUIRED = "PART_NAME_IS_REQUIRED";
	public static final String PART_QUANTITY_IS_REQUIRED = "PART_QUANTITY_IS_REQUIRED";
	public static final String PART_DESCRIPTION_IS_REQUIRED = "PART_DESCRIPTION_IS_REQUIRED";
	public static final String CURRENCYCODE_IS_REQUIRED = "CURRENCYCODE_IS_REQUIRED";
	public static final String STARTDATE_IS_REQUIRED = "STARTDATE_IS_REQUIRED";
	public static final String ENDDATE_IS_REQUIRED = "ENDDATE_IS_REQUIRED";
	public static final String UNITPRICE_IS_REQUIRED = "UNITPRICE_IS_REQUIRED";
	public static final String INVALID_ORDER_TYPE = "INVALID_ORDER_TYPE";
	public static final String INVALID_PRODUCT_WARRANTY = "INVALID_PRODUCT_WARRANTY";
	public static final String FAMILY_CODE_REQUIRED = "FAMILY_CODE_REQUIRED";
	public static final String OLD_PART_CODE_REQUIRED = "OLD_PART_CODE_REQUIRED";
	public static final String NEW_PART_CODE_REQUIRED = "NEW_PART_CODE_REQUIRED";
	public static final String FILE_NOT_FOUND = "FILE_NOT_FOUND";
	public static final String SHIPPING_METHOD_REQUIRED = "SHIPPING_METHOD_REQUIRED";
	public static final String SHIPPING_PRIORITY_REQUIRED = "SHIPPING_PRIORITY_REQUIRED";
	public static final String SHIPPING_CARRIER_REQUIRED = "SHIPPING_CARRIER_REQUIRED";
	public static final String PAYMENT_METHOD_REQUIRED = "PAYMENT_METHOD_REQUIRED";
	public static final String INVALID_REGISTRATION_DATE = "INVALID_REGISTRATION_DATE";
	public static final String INVALID_PURCHASE_DATE = "INVALID_PURCHASE_DATE";
	public static final String INVALID_SHIPPING_METHOD = "INVALID_SHIPPING_METHOD";
	public static final String INVALID_SHIPPING_CARRIER = "INVALID_SHIPPING_CARRIER";
	public static final String INVALID_SHIPPING_PRIORITY = "INVALID_SHIPPING_PRIORITY";
	public static final String INVALID_PAYMENT_METHOD = "INVALID_PAYMENT_METHOD";
	public static final String INVALID_STATUS = "INVALID_STATUS";
	public static final String PRODUCT_SERIAL_CREATION_FAILED = "PRODUCT_SERIAL_CREATION_FAILED";
	public static final String CUSTOMER_BUSINESS_ENTITY_CREATION_FAILED = "CUSTOMER_BUSINESS_ENTITY_CREATION_FAILED";
	public static final String ORDER_TYPE_OR_ORDER_LOCATION_IS_REQUIRED = "ORDER_TYPE_OR_ORDER_LOCATION_IS_REQUIRED";
	public static final String AMOUNT_OR_PERCENT_IS_VALID = "AMOUNT_OR_PERCENT_IS_VALID";
	public static final String MIN_LINES_LESS_THAN_MAX_LINES = "MIN_LINES_LESS_THAN_MAX_LINES";
	public static final String OVERLAPPING_RECORD_EXISTS = "OVERLAPPING_RECORD_EXISTS";
	
	public static final String INVALID_ENTITY_PARAMETER_TYPE = "INVALID_ENTITY_PARAMETER_TYPE";
	public static final String INVALID_ATTRIBUTE_VALUE = "INVALID_ATTRIBUTE_VALUE";
	public static final String INVALID_ATTRIBUTE_TYPE = "INVALID_ATTRIBUTE_TYPE";
	
	public static final String INVALID_PART_KIT_TYPE = "INVALID_PART_KIT_TYPE";
	public static final String INVALID_PRICE_METHOD = "INVALID_PRICE_METHOD";
	
	public static final String DATE_RANGE_OVERLAP = "DATE_RANGE_OVERLAP";
	public static final String DATE_RANGE_DUPLICATE = "DATE_RANGE_DUPLICATE";
	public static final String SUBSTITUTE_DATE_REQUIRED = "SUBSTITUTE_DATE_REQUIRED";
	public static final String INVALID_SUBSTITUTE_CODE_TYPE = "INVALID_SUBSTITUTE_CODE_TYPE";
	public static final String PART_SUBSTITUTE = "PART_SUBSTITUTE";
	
	public static final String INVALID_PRODUCT ="INVALID_PRODUCT";
	public static final String INVALID_COVERAGE_TYPE ="INVALID_COVERAGE_TYPE";
	public static final String INVALID_REGISTRATION_INDUSTRY ="INVALID_REGISTRATION_INDUSTRY";
	public static final String INVALID_CUSTOMER_TYPE = "INVALID_CUSTOMER_TYPE";
	public static final String INVALID_INVOICE_BUSINESS_ENTITY_TYPE = "INVALID_INVOICE_BUSINESS_ENTITY_TYPE";
	public static final String INVOICE_NUMBER_IS_REQUIRED = "INVOICE_NUMBER_IS_REQUIRED";
	
	public static final String BUILD_DATE_LESS_THAN_INVOICE_DATE = "BUILD_DATE_LESS_THAN_INVOICE_DATE";
	public static final String INVOICE_DATE_LESS_THAN_SHIP_DATE = "INVOICE_DATE_LESS_THAN_SHIP_DATE";
	public static final String INVOICE_LOCATION_TYPE_REQUIRED = "INVOICE_LOCATION_TYPE_REQUIRED";
	public static final String INVALID_INVOICE_LOCATION ="INVALID_INVOICE_LOCATION";
	
	public static final String INVALID_PICKLIST_NUMBER = "INVALID_PICKLIST_NUMBER";
	public static final String INVALID_PICKLIST_TYPE = "INVALID_PICKLIST_TYPE";
	public static final String INVALID_PART_NUMBER = "INVALID_PART_NUMBER";
	public static final String INVALID_PART_QUANTITY = "INVALID_PART_QUANTITY";
	public static final String INVALID_PICKLIST_LOCATION_TYPE = "INVALID_PICKLIST_LOCATION_TYPE";
	public static final String INVALID_PICKLIST_LOCATION = "INVALID_PICKLIST_LOCATION";
	public static final String INVALID_PICKLIST_LOCATION_CODE = "INVALID_PICKLIST_LOCATION_CODE";
	
	public static final String INVALID_STATUS_UPDATE_DRAFT = "INVALID_STATUS_UPDATE_DRAFT";
	public static final String INVALID_STATUS_UPDATE = "INVALID_STATUS_UPDATE";
	public static final String INVALID_PRODUCT_SERIAL_ATTACHMENT = "INVALID_PRODUCT_SERIAL_ATTACHMENT";
	public static final String INVALID_PURCHASE_DATE_SHIP_DATE = "INVALID_PURCHASE_DATE_SHIP_DATE";
	public static final String INVALID_PURCHASE_DATE_ATTACHMENT = "INVALID_PURCHASE_DATE_ATTACHMENT";
	
	public static final String USER_REQUIRED="USER_REQUIRED";
	public static final String INVOICE_NUMBER="INVOICE_NUMBER";
	
	public static final String INVALID_SHIPMENT_BUSINESS_ENTITY_CODE = "INVALID_SHIPMENT_BUSINESS_ENTITY_CODE";
	public static final String INVALID_PAYMENT_BUSINESS_ENTITY_CODE = "INVALID_PAYMENT_BUSINESS_ENTITY_CODE";
	public static final String DUPLICATE_PART_NAME = "DUPLICATE_PART_NAME";
	
	public static final String PART_NUMBER_REQUIRED = "PART_NUMBER_REQUIRED";
	public static final String PART_KIT_TYPE_REQUIRED= "PART_KIT_TYPE_REQUIRED";
	public static final String PRICE_METHOD_REQUIRED= "PRICE_METHOD_REQUIRED";
	public static final String START_DATE_REQUIRED= "START_DATE_REQUIRED";
	public static final String END_DATE_REQUIRED= "END_DATE_REQUIRED";
	public static final String PART_QUANTITY_REQUIRED= "PART_QUANTITY_REQUIRED";
	public static final String ATLEAST_ONE_PART_REQUIRED = "ATLEAST_ONE_PART_REQUIRED";
	public static final String END_DATE_GREATER_THAN_OR_EQUAL_TO_START_DATE= "END_DATE_GREATER_THAN_OR_EQUAL_TO_START_DATE";
	
	public static final String INVALID_ENTITY_IDS = "INVALID_ENTITY_IDS";
	public static final String INVALID_TO_ENTITY_ID = "INVALID_TO_ENTITY_ID";
	public static final String TO_ID_GREATER_THAN_OR_EQUAL_TO_FROM_ID = "TO_ID_GREATER_THAN_OR_EQUAL_TO_FROM_ID";
	public static final String INVALID_FROM_ENTITY_ID = "INVALID_FROM_ENTITY_ID";
	public static final String INVALID_ENTITY_ID = "INVALID_ENTITY_ID";
	public static final String INVALID_SOLR_ENTITY = "INVALID_SOLR_ENTITY";
	
	public static final String INVALID_BRAND_MODEL_SERIAL_COMBINATION = "INVALID_BRAND_MODEL_SERIAL_COMBINATION";
	public static final String PRODUCT_COVERAGE_REQUIRED = "PRODUCT_COVERAGE_REQUIRED";
	
	

}
