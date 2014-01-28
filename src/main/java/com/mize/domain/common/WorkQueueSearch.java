package com.mize.domain.common;

import com.mize.domain.servicelocator.BusinessEntity;

public class WorkQueueSearch extends MizeEntity {

	private static final long serialVersionUID = -1226485305364653303L;
	
	private BusinessEntity businessEntity;
	private String type;
	
	public enum EntityType{
		Claim,Service_Order,Support_Request,Parts_Order,Service_Entity,Inspection
	}
	
	public WorkQueueSearch(){
		super();
	}
	
	
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}
	
	public String getType() {
		return type;
	}
	
	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	
	public void setType(String type) {
		this.type = type;
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
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
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
		WorkQueueSearch other = (WorkQueueSearch) obj;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.equals(other.businessEntity))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkQueueSearch [id=");
		builder.append(id);
		builder.append(", businessEntity=");
		builder.append(businessEntity);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}
	

}
