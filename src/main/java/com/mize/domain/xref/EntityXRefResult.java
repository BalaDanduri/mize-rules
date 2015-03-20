package com.mize.domain.xref;

import java.io.Serializable;

import com.mize.domain.common.IEntity;

public class EntityXRefResult implements IEntity, Serializable {

	private static final long serialVersionUID = -3193421149712191082L;

	private EntityXRef entityXRef;
	private String code;
	private String name;

	public EntityXRefResult() {
		super();
	}

	public EntityXRef getEntityXRef() {
		return entityXRef;
	}

	public void setEntityXRef(EntityXRef entityXRef) {
		this.entityXRef = entityXRef;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EntityXRefResult [code=" + code + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EntityXRefResult other = (EntityXRefResult) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
