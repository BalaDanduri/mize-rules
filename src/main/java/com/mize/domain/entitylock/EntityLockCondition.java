package com.mize.domain.entitylock;

import com.mize.domain.common.MizeSceEntity;

public class EntityLockCondition extends MizeSceEntity implements Comparable<EntityLockCondition>{
	
	private static final long serialVersionUID = -4595805163290064209L;
	private String fieldPath;
	private String fieldType;
	private String conditionValue;
	
	public EntityLockCondition(){
		super();
	}
	
	public EntityLockCondition(String fieldPath, String fieldType, String conditionValue) {
		super();
		this.fieldPath = fieldPath;
		this.fieldType = fieldType;
		this.conditionValue = conditionValue;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFieldPath() {
		return fieldPath;
	}

	public void setFieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getConditionValue() {
		return conditionValue;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

	@Override
	public String toString() {
		return "EntityLockCondition [fieldPath=" + fieldPath + ", fieldType="
				+ fieldType + ", conditionValue=" + conditionValue + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((conditionValue == null) ? 0 : conditionValue.hashCode());
		result = prime * result
				+ ((fieldPath == null) ? 0 : fieldPath.hashCode());
		result = prime * result
				+ ((fieldType == null) ? 0 : fieldType.hashCode());
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
		EntityLockCondition other = (EntityLockCondition) obj;
		if (conditionValue == null) {
			if (other.conditionValue != null)
				return false;
		} else if (!conditionValue.equals(other.conditionValue))
			return false;
		if (fieldPath == null) {
			if (other.fieldPath != null)
				return false;
		} else if (!fieldPath.equals(other.fieldPath))
			return false;
		if (fieldType == null) {
			if (other.fieldType != null)
				return false;
		} else if (!fieldType.equals(other.fieldType))
			return false;
		return true;
	}

	@Override
	public int compareTo(EntityLockCondition o) {
		return 0;
	}	
	
}
