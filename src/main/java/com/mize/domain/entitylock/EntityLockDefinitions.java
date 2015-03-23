package com.mize.domain.entitylock;

import java.util.ArrayList;
import java.util.List;

import com.mize.domain.common.MizeSceEntity;

public class EntityLockDefinitions extends MizeSceEntity implements Comparable<EntityLockDefinitions>{
	
	private static final long serialVersionUID = -459581263290064209L;
	private List<EntityLockDefinition> definitions = new ArrayList<EntityLockDefinition>();
	
	public EntityLockDefinitions(){
		super();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<EntityLockDefinition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<EntityLockDefinition> definitions) {
		this.definitions = definitions;
	}

	@Override
	public String toString() {
		return "EntityLockDefinitions [definitions=" + definitions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((definitions == null) ? 0 : definitions.hashCode());
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
		EntityLockDefinitions other = (EntityLockDefinitions) obj;
		if (definitions == null) {
			if (other.definitions != null)
				return false;
		} else if (!definitions.equals(other.definitions))
			return false;
		return true;
	}

	@Override
	public int compareTo(EntityLockDefinitions o) {
		return 0;
	}
}
