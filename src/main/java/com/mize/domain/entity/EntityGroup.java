package com.mize.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;

public class EntityGroup extends MizeSceEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -553584484380717010L;
	
	private List<EntityStatus> entities = new ArrayList<EntityStatus>();
	private User user;

	@Override
	public Long getId() {
		
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public List<EntityStatus> getEntities() {
		return entities;
	}

	public void setEntities(List<EntityStatus> entities) {
		this.entities = entities;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entities == null) ? 0 : entities.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof EntityGroup)) {
			return false;
		}
		EntityGroup other = (EntityGroup) obj;
		if (entities == null) {
			if (other.entities != null) {
				return false;
			}
		} else if (!entities.equals(other.entities)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EntityGroup [entities=" + entities + ", user=" + user + "]";
	}

	
	
	
	
}
