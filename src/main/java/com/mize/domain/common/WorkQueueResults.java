package com.mize.domain.common;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.mize.domain.util.Formatter;

public class WorkQueueResults extends MizeEntity {
	private static final long serialVersionUID = 310189284913911659L;

	private String fieldName;
	private String fieldValue;
	private String fieldType;

	public WorkQueueResults() {
		super();
	}
	
	public WorkQueueResults(String fieldName, String fieldValue,String fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.fieldType = fieldType;
	}

	public String getFieldName(String ...a) {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "WorkQueueResults [fieldName=" + fieldName + ", fieldValue="
				+ fieldValue + ", fieldType=" + fieldType + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result
				+ ((fieldType == null) ? 0 : fieldType.hashCode());
		result = prime * result
				+ ((fieldValue == null) ? 0 : fieldValue.hashCode());
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
		WorkQueueResults other = (WorkQueueResults) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (fieldType == null) {
			if (other.fieldType != null)
				return false;
		} else if (!fieldType.equals(other.fieldType))
			return false;
		if (fieldValue == null) {
			if (other.fieldValue != null)
				return false;
		} else if (!fieldValue.equals(other.fieldValue))
			return false;
		return true;
	}
	
	public void populateResult(Object fieldName ,Object fieldValue){
		if(fieldName != null && fieldValue != null){
			this.fieldName = fieldName.toString();
			if(fieldValue instanceof Integer){
				this.fieldValue = Formatter.toString((Integer)fieldValue);
				this.fieldType = Integer.class.getSimpleName();
			}else if(fieldValue instanceof Long){
				this.fieldValue = Formatter.toString((Long)fieldValue);
				this.fieldType = Long.class.getSimpleName();		
			}else if(fieldValue instanceof Double){
				this.fieldValue = Formatter.toString((Double)fieldValue);
				this.fieldType = Double.class.getSimpleName();
			}else if(fieldValue instanceof BigDecimal){
				this.fieldValue = Formatter.toString((BigDecimal)fieldValue);
				this.fieldType = BigDecimal.class.getSimpleName();
			}else if(fieldValue instanceof DateTime){
				this.fieldValue = Formatter.getDateTime((DateTime)fieldValue);
				this.fieldType = DateTime.class.getSimpleName();
			}			
		}
	}

	
}
