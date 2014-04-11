package com.mize.domain.common;



public class EntityReference extends MizeEntity implements Comparable<EntityReference>{

	private static final long serialVersionUID = 11149014756400338L;
	private String reference;
	private String referenceType;
	private String referenceCode;

	public EntityReference() {
	}
	
	public enum ReferenceType{
		//OrderLocation,PurchaseOrderType,OrderTypenLocation
	}
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	@Override
	public int compareTo(EntityReference entityReference) {
		if (this == entityReference)
			return EQUAL;
		else if (this.id < entityReference.id)
			return BEFORE;
		else if (entityReference.id == this.id)
			return EQUAL;
		else if (this.id > entityReference.id)
			return AFTER;
		return EQUAL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((reference == null) ? 0 : reference.hashCode());
		result = prime * result
				+ ((referenceCode == null) ? 0 : referenceCode.hashCode());
		result = prime * result
				+ ((referenceType == null) ? 0 : referenceType.hashCode());
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
		EntityReference other = (EntityReference) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (referenceCode == null) {
			if (other.referenceCode != null)
				return false;
		} else if (!referenceCode.equals(other.referenceCode))
			return false;
		if (referenceType == null) {
			if (other.referenceType != null)
				return false;
		} else if (!referenceType.equals(other.referenceType))
			return false;
		return true;
	}

	
	
}
