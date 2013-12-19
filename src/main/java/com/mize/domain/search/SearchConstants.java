package com.mize.domain.search;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SearchConstants  implements Serializable{
	private static final long serialVersionUID = 9097466595924320345L;
	public static final String ATTR_TYPE_STRING = "STRING";
	public static final String ATTR_TYPE_NUMBER = "NUMBER";
	public static final String ATTR_TYPE_DATE = "DATE";
	public static final String ATTR_TYPE_DATE_TIME = "DATE_TIME";
	
	public static final String CON_CONTAINS = "CONTAINS";
	public static final String CON_START_WITH = "STARTS";
	public static final String CON_ENDS_WITH = "ENDS";
	public static final String CON_EQUALS = "=";

	public static final String CON_GREATER_THAN = ">";
	public static final String CON_LESS_THAN = "<";
	public static final String CON_RANGE = "RANGE";

	public static final String INVALID_ATTRIBUTE_NAME = "INVALID_ATTRIBUTE_NAME";
	public static final String INVALID_ATTRIBUTE_TYPE = "INVALID_ATTRIBUTE_TYPE";
	public static final String INVALID_CONDITION = "INVALID_CONDITION";
	public static final String INVALID_VALUE = "INVALID_VALUE";
	public static final String INVALID_STRING_VALUE = "INVALID_STRING_VALUE";
	public static final String INVALID_NUMBER_VALUE = "INVALID_NUMBER_VALUE";
	public static final String INVALID_DATE_VALUE = "INVALID_DATE_VALUE";
	
	public static final String MISSING_ATTRIBUTES = "MISSING_ATTRIBUTES";
	
	public static final String ENTITY_PRODUCT = "product";
	public static final String INVALID_ENTITY = "INVALID_ENTITY";
	public static final String INVALID_VERSION = "INVALID_VERSION";
	
	public static final Set<String> getAttributeTypes() {
		Set<String> attrTypesSet = new HashSet<String>();
		attrTypesSet.add(ATTR_TYPE_STRING);
		attrTypesSet.add(ATTR_TYPE_NUMBER);
		attrTypesSet.add(ATTR_TYPE_DATE);
		attrTypesSet.add(ATTR_TYPE_DATE_TIME);
		return attrTypesSet;
	}
	
	public static final Set<String> getStringOperations() {
		Set<String> stringOperationsSet = new HashSet<String>();
		stringOperationsSet.add(CON_CONTAINS);
		stringOperationsSet.add(CON_START_WITH);
		stringOperationsSet.add(CON_ENDS_WITH);
		stringOperationsSet.add(CON_EQUALS);		
		return stringOperationsSet;
	}

	public static final Set<String> getNumericOperations() {
		Set<String> numericOperationsSet = new HashSet<String>();
		numericOperationsSet.add(CON_EQUALS);
		numericOperationsSet.add(CON_GREATER_THAN);
		numericOperationsSet.add(CON_LESS_THAN);
		numericOperationsSet.add(CON_RANGE);
		return numericOperationsSet;
	}

	public static final Set<String> getDateOperations() {
		Set<String> dateOperationsSet = new HashSet<String>();
		dateOperationsSet.add(CON_EQUALS);
		dateOperationsSet.add(CON_GREATER_THAN);
		dateOperationsSet.add(CON_LESS_THAN);
		dateOperationsSet.add(CON_RANGE);	
		return dateOperationsSet;
	}

	public static final Set<String> getEntities() {
		Set<String> entitySet = new HashSet<String>();
		entitySet.add(ENTITY_PRODUCT);
		return entitySet;
	}


}
