package com.mize.domain.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;

public class FormElement extends MizeSceEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2467819665340668161L;
	private String alias;
	private String ref;
	private String canskiprules;
	private String skiprules;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getCanskiprules() {
		return canskiprules;
	}

	public void setCanskiprules(String canskiprules) {
		this.canskiprules = canskiprules;
	}

	public String getSkiprules() {
		return skiprules;
	}

	public void setSkiprules(String skiprules) {
		this.skiprules = skiprules;
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((canskiprules == null) ? 0 : canskiprules.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result + ((skiprules == null) ? 0 : skiprules.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormElement other = (FormElement) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (canskiprules == null) {
			if (other.canskiprules != null)
				return false;
		} else if (!canskiprules.equals(other.canskiprules))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (meta == null) {
			if (other.meta != null)
				return false;
		} else if (!meta.equals(other.meta))
			return false;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (skiprules == null) {
			if (other.skiprules != null)
				return false;
		} else if (!skiprules.equals(other.skiprules))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormElement [alias=" + alias + ", ref=" + ref + ", canskiprules=" + canskiprules + ", skiprules=" + skiprules 
				+ ", label=" + label + ", meta=" + meta + "]";
	}
	
}
