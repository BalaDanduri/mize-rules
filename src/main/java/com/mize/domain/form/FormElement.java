package com.mize.domain.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeEntity;

public class FormElement extends MizeEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2467819665340668161L;
	private String name;
	private String ref;
	private FormLabel label;
	private Map<String, String> meta;
	
	public FormElement() {
		super();
		meta = new HashMap<String, String>();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public FormLabel getLabel() {
		return label;
	}

	public void setLabel(FormLabel label) {
		this.label = label;
	}

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
