package com.mize.domain.entitylock;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="entity_lock")
public class EntityLock extends MizeSceEntity implements Comparable<EntityLock>{
	
	private static final long serialVersionUID = -4595805163290064209L;
	
	private BusinessEntity tenant;
	private Long lockedBy;
	private String lockedByUser;
	private String loginId; 
	private Long entityId;
	private String entityType;
	private String entityCode;
	private String lockAction;
	private MizeDateTime lockDate;
	private MizeDateTime inactiveStartTime;
	@Transient
	private List<Long> entityLockIds;
	@Transient
	private User user;
	@Transient
	private String entityStatus;
	
	public EntityLock(){
		super();
	}
	
	public EntityLock(Long id,  String entityType, String entityCode, Long entityId,MizeDateTime lockDate,String lockedByUser) {
		super();
		this.id = id;
		this.entityType = entityType;
		this.entityCode = entityCode;
		this.entityId = entityId;
		this.lockDate = lockDate;
		this.lockedByUser = lockedByUser;
	}

	public EntityLock(String entityType, String entityCode, Long entityId,String entityStatus, User user, BusinessEntity tenant) {
		super();
		this.entityType = entityType;
		this.entityCode = entityCode;
		this.entityId = entityId;
		this.entityStatus = entityStatus;
		this.user = user;
		this.tenant = tenant;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}
	
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column(name="locked_by")
	public Long getLockedBy() {
		return lockedBy;
	}
	
	public void setLockedBy(Long lockedBy) {
		this.lockedBy = lockedBy;
	}
	
	@Column(name="locked_by_user", length=250)
	public String getLockedByUser() {
		return lockedByUser;
	}
	
	public void setLockedByUser(String lockedByUser) {
		this.lockedByUser = lockedByUser;
	}
	
	@Column(name="login_id")
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	@Column(name="entity_id")
	public Long getEntityId() {
		return entityId;
	}
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	
	@Column(name = "entity_type", length = 50)
	public String getEntityType() {
		return entityType;
	}
	
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	@Column(name = "entity_code", length = 50)
	public String getEntityCode() {
		return entityCode;
	}
	
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
	
	@Column(name = "lock_action", length = 50)
	public String getLockAction() {
		return lockAction;
	}
	
	public void setLockAction(String lockAction) {
		this.lockAction = lockAction;
	}
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "lock_date")
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getLockDate() {
		return lockDate;
	}
	
	public void setLockDate(MizeDateTime lockDate) {
		this.lockDate = lockDate;
	}
	
	@JsonInclude(Include.NON_NULL)
	@Column(name = "inactive_start_time")
	@Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getInactiveStartTime() {
		return inactiveStartTime;
	}
	
	public void setInactiveStartTime(MizeDateTime inactiveStartTime) {
		this.inactiveStartTime = inactiveStartTime;
	}
	
	@Transient
	public List<Long> getEntityLockIds() {
		return entityLockIds;
	}
	public void setEntityLockIds(List<Long> entityLockIds) {
		this.entityLockIds = entityLockIds;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public String getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}

	@Override
	public int compareTo(EntityLock arg0) {
		return 0;
	}



	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result + ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result + ((inactiveStartTime == null) ? 0 : inactiveStartTime.hashCode());
		result = prime * result + ((lockAction == null) ? 0 : lockAction.hashCode());
		result = prime * result + ((lockDate == null) ? 0 : lockDate.hashCode());
		result = prime * result + ((lockedBy == null) ? 0 : lockedBy.hashCode());
		result = prime * result + ((lockedByUser == null) ? 0 : lockedByUser.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
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
		EntityLock other = (EntityLock) obj;
		if (entityCode == null) {
			if (other.entityCode != null)
				return false;
		} else if (!entityCode.equals(other.entityCode))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (inactiveStartTime == null) {
			if (other.inactiveStartTime != null)
				return false;
		} else if (!inactiveStartTime.equals(other.inactiveStartTime))
			return false;
		if (lockAction == null) {
			if (other.lockAction != null)
				return false;
		} else if (!lockAction.equals(other.lockAction))
			return false;
		if (lockDate == null) {
			if (other.lockDate != null)
				return false;
		} else if (!lockDate.equals(other.lockDate))
			return false;
		if (lockedBy == null) {
			if (other.lockedBy != null)
				return false;
		} else if (!lockedBy.equals(other.lockedBy))
			return false;
		if (lockedByUser == null) {
			if (other.lockedByUser != null)
				return false;
		} else if (!lockedByUser.equals(other.lockedByUser))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "EntityLock [lockedBy=" + lockedBy + ", lockedByUser=" + lockedByUser + ", loginId=" + loginId
				+ ", entityId=" + entityId + ", entityType=" + entityType + ", entityCode=" + entityCode
				+ ", lockAction=" + lockAction + ", lockDate=" + lockDate + ", inactiveStartTime=" + inactiveStartTime
				+ "]";
	}
	
	
	
	
}
