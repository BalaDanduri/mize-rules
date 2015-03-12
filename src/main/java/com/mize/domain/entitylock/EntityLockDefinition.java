package com.mize.domain.entitylock;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="entity_lock_defn")
public class EntityLockDefinition extends MizeSceEntityAudit implements Comparable<EntityLockDefinition>{
	
	private static final long serialVersionUID = -4595805163290064209L;
	private Long tenantId;
	private String entityType;
	private String entityTypeName;
	private String entityClass;
	private String renewLock;
	private String isActive;
	private List<EntityLockCriteria> lockCriterias = new ArrayList<EntityLockCriteria>();
	private User user;
	
	public EntityLockDefinition(){
		super();
	}
	
	public EntityLockDefinition(Long id,Long tenantId, String entityType, String entityClass, String renewLock, String isActive) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.entityType = entityType;
		this.entityClass = entityClass;
		this.renewLock = renewLock;
		this.isActive = isActive;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "tenant_id")
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
	@Column(name = "entity_type")
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	@Column(name = "entity_class")
	public String getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}
	
	@Column(name = "renew_lock")
	public String getRenewLock() {
		return renewLock;
	}
	public void setRenewLock(String renewLock) {
		this.renewLock = renewLock;
	}
	
	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "entityLockDefinition",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<EntityLockCriteria> getLockCriterias() {
		return lockCriterias;
	}

	public void setLockCriterias(List<EntityLockCriteria> lockCriterias) {
		this.lockCriterias = lockCriterias;
	}

	@Transient
	public String getEntityTypeName() {
		return entityTypeName;
	}

	public void setEntityTypeName(String entityTypeName) {
		this.entityTypeName = entityTypeName;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityClass == null) ? 0 : entityClass.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((renewLock == null) ? 0 : renewLock.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
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
		EntityLockDefinition other = (EntityLockDefinition) obj;
		if (entityClass == null) {
			if (other.entityClass != null)
				return false;
		} else if (!entityClass.equals(other.entityClass))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (renewLock == null) {
			if (other.renewLock != null)
				return false;
		} else if (!renewLock.equals(other.renewLock))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntityLockDefinition [tenantId=" + tenantId + ", entityType="
				+ entityType + ", entityClass=" + entityClass + ", renewLock="
				+ renewLock + ", isActive=" + isActive + ", lockCriterias="
				+ lockCriterias + "]";
	}

	@Override
	public int compareTo(EntityLockDefinition o) {
		return 0;
	}	
	
}
