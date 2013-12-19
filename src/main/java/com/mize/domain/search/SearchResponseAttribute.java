package com.mize.domain.search;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.exception.MizeError;
import com.mize.domain.util.Formatter;

public class SearchResponseAttribute extends BaseSearchAttribute {
	public List<MizeError> validate() {
		List<MizeError> errors = new ArrayList<MizeError>();
		if (Formatter.isNull(getName())) {
			errors.add(new MizeError(SearchConstants.INVALID_ATTRIBUTE_NAME,
					"Attribute Name cannot be null."));
		}

		if (Formatter.isNull(getType())) {
			errors.add(new MizeError(SearchConstants.INVALID_ATTRIBUTE_TYPE,
					"Attribute Name cannot be null."));
		} else {
			if (!SearchConstants.getAttributeTypes().contains(getType())) {
				errors.add(new MizeError(
						SearchConstants.INVALID_ATTRIBUTE_TYPE,
						"Valid Attributes are "
								+ SearchConstants.getAttributeTypes()));
			}
		}
		if (errors.isEmpty()) {
			return null;
		} else {
			return errors;
		}
	}
}
