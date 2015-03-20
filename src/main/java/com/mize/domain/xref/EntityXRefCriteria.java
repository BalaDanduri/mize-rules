package com.mize.domain.xref;

import java.io.Serializable;

import com.mize.domain.common.IEntity;

public class EntityXRefCriteria implements IEntity, Serializable {

	private static final long serialVersionUID = -3193421149712191082L;

	private EntityXRef entityXRef;
	private String key;
	private String code;
	private String type;

	public EntityXRefCriteria() {
		super();
	}

	public EntityXRef getEntityXRef() {
		return entityXRef;
	}

	public void setEntityXRef(EntityXRef entityXRef) {
		this.entityXRef = entityXRef;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EntityXRefCriteria [code=" + code + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		EntityXRefCriteria other = (EntityXRefCriteria) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
