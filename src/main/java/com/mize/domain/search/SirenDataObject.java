package com.mize.domain.search;

public class SirenDataObject {
	private String entityType;
	private String className;
	private Object domainObject;
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Object getDomainObject() {
		return domainObject;
	}
	public void setDomainObject(Object domainObject) {
		this.domainObject = domainObject;
	}

	@Override
	public String toString() {
		return "SirenDataObject [entityType=" + entityType + ", className="
				+ className + ", domainObject=" + domainObject + "]";
	}

}
