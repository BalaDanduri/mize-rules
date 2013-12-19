package com.mize.domain.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mize.domain.exception.MizeError;
import com.mize.domain.util.Formatter;

public class SearchRequest {
	private String entityName;
	private String version;
	private List<SearchRequestAttribute> attributes;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<SearchRequestAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<SearchRequestAttribute> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "SearchMeta [entityName=" + getEntityName() + ", version="
				+ getVersion() + ", attributes=" + getAttributes() + "]";
	}

	public Map<String, List<MizeError>> validate() {
		Map<String, List<MizeError>> errorMap = new HashMap<String, List<MizeError>>();
		List<MizeError> errors = new ArrayList<MizeError>();
		 
		if (getEntityName() == null
				|| SearchConstants.getEntities().contains(getEntityName())) {
			errors.add(new MizeError(SearchConstants.INVALID_ENTITY,
					"Valid entities are " + SearchConstants.getEntities()));
			errorMap.put("entityName", errors);
			errors = new ArrayList<MizeError>();
		}

		if (Formatter.isNull(getVersion())) {
			errors.add(new MizeError(SearchConstants.INVALID_ENTITY,
					"Valid entities are " + SearchConstants.getEntities()));
			errorMap.put("version", errors);
		}
		if (getAttributes() == null || getAttributes().isEmpty()) {
			errors.add(new MizeError(SearchConstants.MISSING_ATTRIBUTES,
					"No attributes in the criteria."));
		} else {
			for (SearchRequestAttribute attr : getAttributes()) {
				errors = attr.validate();
				if (errors != null && !errors.isEmpty()) {
					errorMap.put("attribute:" + attr.getName(), errors);
				}
			}
		}
		if (errorMap.isEmpty()) {
			return null;
		} else {
			return errorMap;
		}
	}
}
