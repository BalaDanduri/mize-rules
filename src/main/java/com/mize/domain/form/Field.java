package com.mize.domain.form;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Field {
	private final Map<String, String> meta = new HashMap<String, String>();
	public void setMetaValue(String key, String value) {
		meta.put(key, value);
	}
	
	public String getMetaValue(String key) {
		return meta.get(key);
	}
	
	@JsonIgnore
	public Set<String> getMetaKeys() {
		return meta.keySet();
	}
		
	public Map<String, String> getMeta() {
		return meta;
	}
}
