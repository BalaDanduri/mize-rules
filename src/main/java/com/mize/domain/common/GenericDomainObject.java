package com.mize.domain.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenericDomainObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<String> headers = new ArrayList<String>();
	private Map<String, String> headersTypeMap = new HashMap<String, String>();
	private List<List<Object>> rowvalues = new ArrayList<List<Object>>();
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	public List<List<Object>> getValues() {
		return rowvalues;
	}
	public void setValues(List<List<Object>> values) {
		this.rowvalues = values;
	}
	public void addRowValues(List<Object> row) {
		rowvalues.add(row);
	}
	public Map<String, String> getHeadersTypeMap() {
		return headersTypeMap;
	}
	public void setHeadersTypeMap(Map<String, String> headersTypeMap) {
		this.headersTypeMap = headersTypeMap;
	}
			

}
  