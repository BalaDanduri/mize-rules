package com.mize.domain.common;


public class WorkQueueResults extends MizeSceEntity implements Comparable<WorkQueueResults>{
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

	public String getFieldName() {
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
	
	@Override
	public int compareTo(WorkQueueResults arg0) {
		return 0;
	}

	
}
