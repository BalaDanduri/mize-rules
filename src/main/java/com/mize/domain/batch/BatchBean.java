package com.mize.domain.batch;

import java.util.Arrays;
import java.util.Map;


public class BatchBean implements IBatchBean{
	private String className;
	private String[] fieldNames;
	private String[] keyNames;
	private String multiRecord;
	private String sequence;
	private Map<String,BatchBean> childBeanMap;
	private String method;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public Map<String, BatchBean> getChildBeanMap() {
		return childBeanMap;
	}

	public void setChildBeanMap(Map<String, BatchBean> childBeanMap) {
		this.childBeanMap = childBeanMap;
	}

	public String getMultiRecord() {
		return multiRecord;
	}

	public void setMultiRecord(String multiRecord) {
		this.multiRecord = multiRecord;
	}

	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String[] getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(String[] fieldNames) {
		this.fieldNames = fieldNames;
	}
	
	public boolean isSingleRecord(){
		return !"Y".equalsIgnoreCase(getMultiRecord());
	}
	
	public String[] getKeyNames() {
		return keyNames;
	}

	public void setKeyNames(String[] keyNames) {
		this.keyNames = keyNames;
	}

	@Override
	public String toString() {
		return "BatchBean [className=" + className + ", fieldNames="
				+ Arrays.toString(fieldNames) + ", keyNames="
				+ Arrays.toString(keyNames) + ", multiRecord=" + multiRecord
				+ ", sequence=" + sequence + ", method=" + method + "]";
	}

	
}
