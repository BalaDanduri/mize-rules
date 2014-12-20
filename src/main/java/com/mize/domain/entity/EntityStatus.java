package com.mize.domain.entity;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

public class EntityStatus extends MizeSceEntity {

	private static final long serialVersionUID = -6204411001291726205L;

	private String entityName;
	private Boolean isLocked;
	private Boolean isOutOfSync;
	private EntityLock lockInfo;
	
	private User user;
	
	public EntityStatus(){
		
	}
	
	public EntityStatus(Long id,MizeDateTime updatedDate,String updatedByUser,String entityName){
		this.id = id;
		this.updatedDate = updatedDate;
		this.updatedByUser = updatedByUser;
		this.entityName = entityName;
	}
	
	@Override
	public Long getId() {
			return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public Boolean getIsLocked() {
		if(isLocked == null){
			return false;
		}
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public Boolean getIsOutOfSync() {
		if(isOutOfSync == null){
			return false;
		}
		return isOutOfSync;
	}

	public void setIsOutOfSync(Boolean isOutOfSync) {
		this.isOutOfSync = isOutOfSync;
	}

	public EntityLock getLockInfo() {
		return lockInfo;
	}

	public void setLockInfo(EntityLock lockInfo) {
		this.lockInfo = lockInfo;
	}
	
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
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		result = prime * result + ((isLocked == null) ? 0 : isLocked.hashCode());
		result = prime * result + ((isOutOfSync == null) ? 0 : isOutOfSync.hashCode());
		result = prime * result + ((lockInfo == null) ? 0 : lockInfo.hashCode());
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
		if (!(obj instanceof EntityStatus)) {
			return false;
		}
		EntityStatus other = (EntityStatus) obj;
		if (entityName == null) {
			if (other.entityName != null) {
				return false;
			}
		} else if (!entityName.equals(other.entityName)) {
			return false;
		}
		if (isLocked == null) {
			if (other.isLocked != null) {
				return false;
			}
		} else if (!isLocked.equals(other.isLocked)) {
			return false;
		}
		if (isOutOfSync == null) {
			if (other.isOutOfSync != null) {
				return false;
			}
		} else if (!isOutOfSync.equals(other.isOutOfSync)) {
			return false;
		}
		if (lockInfo == null) {
			if (other.lockInfo != null) {
				return false;
			}
		} else if (!lockInfo.equals(other.lockInfo)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EntityStatus [id=" + id + ", updatedDate=" + updatedDate
				+ ", entityName=" + entityName + ", isLocked=" + isLocked
				+ ", isOutOfSync=" + isOutOfSync + ", lockInfo=" + lockInfo
				+ "]";
	}

	
	
}
