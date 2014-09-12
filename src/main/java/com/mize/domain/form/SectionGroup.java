package com.mize.domain.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SectionGroup {
	private final Map<String, String> metadata = new HashMap<String, String>();
	private final List<Section> sections = new ArrayList<Section>();
	
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
	
	public List<Section> getSections() {
		return sections;
	}

	public Map<String, String> getMeta() {
		return metadata;
	}
	
}
