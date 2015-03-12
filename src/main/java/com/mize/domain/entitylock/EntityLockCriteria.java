package com.mize.domain.entitylock;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name="entity_lock_criteria")
public class EntityLockCriteria extends MizeSceEntity implements Comparable<EntityLockCriteria>{
	
	private static final long serialVersionUID = -4595805163290064209L;
	private EntityLockDefinition entityLockDefinition;
	private Integer serverity;
	private String roleName;
	private String lockCriteria;
	private String renewLock;
	private List<EntityLockCondition> lockConditions = new ArrayList<EntityLockCondition>();
	
	public EntityLockCriteria(){
		super();
	}
	
	public EntityLockCriteria(Integer serverity, String roleName, String lockCriteria, String renewLock) {
		super();
		this.serverity = serverity;
		this.roleName = roleName;
		this.lockCriteria = lockCriteria;
		this.renewLock = renewLock;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lock_defn_id")
	@JsonBackReference(value="criteria_EntityLockDefinition")
	public EntityLockDefinition getEntityLockDefinition() {
		return entityLockDefinition;
	}

	public void setEntityLockDefinition(EntityLockDefinition entityLockDefinition) {
		this.entityLockDefinition = entityLockDefinition;
	}

	@Column(name = "entity_severity")
	public Integer getServerity() {
		return serverity;
	}

	public void setServerity(Integer serverity) {
		this.serverity = serverity;
	}

	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "lock_criteria")
	public String getLockCriteria() {
		return lockCriteria;
	}

	public void setLockCriteria(String lockCriteria) {
		this.lockCriteria = lockCriteria;
	}

	@Column(name = "renew_lock")
	public String getRenewLock() {
		return renewLock;
	}

	public void setRenewLock(String renewLock) {
		this.renewLock = renewLock;
	}

	@Transient
	@JsonInclude(Include.NON_DEFAULT)
	public List<EntityLockCondition> getLockConditions() {
		return lockConditions;
	}

	public void setLockConditions(List<EntityLockCondition> lockConditions) {
		this.lockConditions = lockConditions;
	}

	@Override
	public int compareTo(EntityLockCriteria o) {
		return 0;
	}

	@Override
	public String toString() {
		return "EntityLockCriteria [serverity=" + serverity + ", roleName="
				+ roleName + ", lockCriteria=" + lockCriteria + ", renewLock="
				+ renewLock + ", lockConditions=" + lockConditions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((lockConditions == null) ? 0 : lockConditions.hashCode());
		result = prime * result
				+ ((lockCriteria == null) ? 0 : lockCriteria.hashCode());
		result = prime * result
				+ ((renewLock == null) ? 0 : renewLock.hashCode());
		result = prime * result
				+ ((roleName == null) ? 0 : roleName.hashCode());
		result = prime * result
				+ ((serverity == null) ? 0 : serverity.hashCode());
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
		EntityLockCriteria other = (EntityLockCriteria) obj;
		if (lockConditions == null) {
			if (other.lockConditions != null)
				return false;
		} else if (!lockConditions.equals(other.lockConditions))
			return false;
		if (lockCriteria == null) {
			if (other.lockCriteria != null)
				return false;
		} else if (!lockCriteria.equals(other.lockCriteria))
			return false;
		if (renewLock == null) {
			if (other.renewLock != null)
				return false;
		} else if (!renewLock.equals(other.renewLock))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		if (serverity == null) {
			if (other.serverity != null)
				return false;
		} else if (!serverity.equals(other.serverity))
			return false;
		return true;
	}	
	
}
