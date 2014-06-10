package com.mize.domain.batch;

import java.util.Map;


public interface IBatchBean {
	
	public String getMethod();

	public void setMethod(String method);

	public String getSequence();

	public void setSequence(String sequence);

	public Map<String, BatchBean> getChildBeanMap();

	public void setChildBeanMap(Map<String, BatchBean> childBeanMap);

	public String getMultiRecord();

	public void setMultiRecord(String multiRecord);

	public String getClassName();
	
	public void setClassName(String className);
	
	public String[] getFieldNames();

	public void setFieldNames(String[] fieldNames);
	
	public boolean isSingleRecord();
	
	public String[] getKeyNames();

	public void setKeyNames(String[] keyNames);

}
