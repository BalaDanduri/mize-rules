package com.mize.domain.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Form {

	private final Map<String, String> metadata = new HashMap<String, String>();
	private final List<SectionGroup> sectionGroups = new ArrayList<SectionGroup>();
	
	public void setMetaValue(String key, String value) {
		metadata.put(key, value);
	}
	
	public String getMetaValue(String key) {
		return metadata.get(key);
	}
	
	@JsonIgnore
	public Set<String> getMetaKeys() {
		return metadata.keySet();
	}
	
	public Map<String, String> getMeta() {
		return metadata;
	}

	public List<SectionGroup> getSectionGroups() {
		return sectionGroups;
	}
	
}
