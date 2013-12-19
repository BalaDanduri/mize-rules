package com.mize.domain.search;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.exception.MizeError;
import com.mize.domain.util.Formatter;

public class SearchRequestAttribute extends BaseSearchAttribute {
	private String name;
	private String type;
	private String condition;
	private String value;
	private String inboundValue;
	private String outboundValue;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCondition() {
		if (Formatter.isNull(condition)) {
			return SearchConstants.CON_EQUALS;
		} else {
			return getFormatedValue(condition);
		}
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getValue() {
		return getFormatedValue(value);
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInboundValue() {
		return getFormatedValue(inboundValue);
	}

	public void setInboundValue(String inboundValue) {
		this.inboundValue = inboundValue;
	}

	public String getOutboundValue() {
		return getFormatedValue(outboundValue);
	}

	public void setOutboundValue(String outboundValue) {
		this.outboundValue = outboundValue;
	}

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

		if (getType().equals(SearchConstants.ATTR_TYPE_STRING)) {
			if (!SearchConstants.getStringOperations().contains(getCondition())) {
				errors.add(new MizeError(SearchConstants.INVALID_CONDITION,
						"Valid conditions for String are "
								+ SearchConstants.getStringOperations()));
			}
		} else if (getType().equals(SearchConstants.ATTR_TYPE_NUMBER)
				|| getType().equals(SearchConstants.ATTR_TYPE_DATE)
				|| getType().equals(SearchConstants.ATTR_TYPE_DATE_TIME)) {
			if (!SearchConstants.getStringOperations().contains(getCondition())) {
				errors.add(new MizeError(SearchConstants.INVALID_CONDITION,
						"Valid conditions for numbers and dates are "
								+ SearchConstants.getNumericOperations()));
			}
		}

		if (Formatter.isNull(getValue())
				&& !getCondition().equals(SearchConstants.CON_RANGE)) {
			errors.add(new MizeError(SearchConstants.INVALID_VALUE,
					"Value must be passed."));
		} else if (getCondition().equals(SearchConstants.CON_RANGE)) {
			if (Formatter.isNull(getInboundValue())
					|| Formatter.isNull(getOutboundValue())) {
				errors.add(new MizeError(SearchConstants.INVALID_VALUE,
						"Outbound and inbound Values must be passed for range."));
			}
		}

		if (getType().equals(SearchConstants.ATTR_TYPE_NUMBER)) {
			try {
				if (getValue() != null) {
					Double.parseDouble(getValue());
				}
				if (getOutboundValue() != null) {
					Double.parseDouble(getOutboundValue());
				}
				if (getInboundValue() != null) {
					Double.parseDouble(getInboundValue());
				}
			} catch (NumberFormatException nfe) {
				errors.add(new MizeError(SearchConstants.INVALID_NUMBER_VALUE,
						"The value must be a number"));
			}
		}

		/**
		 * @@TODO The date and date format validation need to be implemented
		 **/
		if (errors.isEmpty()) {
			return null;
		} else {
			return errors;
		}
	}
}
