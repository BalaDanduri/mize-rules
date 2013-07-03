package com.mize.domain.servicelocator;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.mize.domain.common.Entity;

public class BusinessEntity  extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3712437162456355278L;
	long id;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String name;
	private String logo;
	private int pageIndex;
	@JsonProperty
	private List<BusinessEntityAddress> businessEntityAddressList;
	
	long entityId;
	String entityName;
	
	public BusinessEntity() {
		
	}
	
	public BusinessEntity(long id, String code, String typeCode, String subTypeCode, String name, String logo,
			List<BusinessEntityAddress> businessEntityAddressList, long entityId, String entityName) {
		this.id = id;
		this.code = code;
		this.typeCode = typeCode;
		this.subTypeCode = subTypeCode;
		this.name = name;
		this.logo = logo;
		this.businessEntityAddressList = businessEntityAddressList;
		this.entityId = entityId;
		this.entityName = entityName;
	}
	
	public List<BusinessEntityAddress> getBusinessEntityAddressList() {
		return businessEntityAddressList;
	}
	public void setBusinessEntityAddressList(
			List<BusinessEntityAddress> businessEntityAddressList) {
		this.businessEntityAddressList = businessEntityAddressList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getSubTypeCode() {
		return subTypeCode;
	}
	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@JsonIgnore
	public boolean addAddress(BusinessEntityAddress businessEntityAddress) {
		if(businessEntityAddressList==null) {
			businessEntityAddressList = new ArrayList<BusinessEntityAddress>();
		}
		if(businessEntityAddressList.contains(businessEntityAddress) && businessEntityAddress.getId()>0 ) {
			businessEntityAddressList.set(businessEntityAddressList.lastIndexOf(businessEntityAddress), businessEntityAddress);
		} else {
			businessEntityAddressList.add(businessEntityAddress);
		}
		return true;
	}
	
	@JsonIgnore
	public int getAddressCount() {
		return businessEntityAddressList==null?0:businessEntityAddressList.size();
	}
	
	@JsonIgnore
	public BusinessEntityAddress getAddressAt(int index) {
		return (businessEntityAddressList!=null&& businessEntityAddressList.size()>index)? businessEntityAddressList.get(index) : null;
	}
	
	@JsonIgnore
	public boolean updateAddressAt(int index,BusinessEntityAddress businessEntityAddress) {
		if(businessEntityAddressList!=null&& businessEntityAddressList.size()>index) {
			businessEntityAddressList.set(index, businessEntityAddress);
			return true;
		}
		return false;
	}
	public long getEntityId() {
		return entityId;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessEntityAddressList == null) ? 0 : businessEntityAddressList.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (int) (entityId ^ (entityId >>> 32));
		result = prime * result + ((entityName == null) ? 0 : entityName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subTypeCode == null) ? 0 : subTypeCode.hashCode());
		result = prime * result + ((typeCode == null) ? 0 : typeCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BusinessEntity)) {
			return false;
		}
		BusinessEntity other = (BusinessEntity) obj;
		if (businessEntityAddressList == null) {
			if (other.businessEntityAddressList != null) {
				return false;
			}
		} else if (!businessEntityAddressList.equals(other.businessEntityAddressList)) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (entityId != other.entityId) {
			return false;
		}
		if (entityName == null) {
			if (other.entityName != null) {
				return false;
			}
		} else if (!entityName.equals(other.entityName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (logo == null) {
			if (other.logo != null) {
				return false;
			}
		} else if (!logo.equals(other.logo)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (subTypeCode == null) {
			if (other.subTypeCode != null) {
				return false;
			}
		} else if (!subTypeCode.equals(other.subTypeCode)) {
			return false;
		}
		if (typeCode == null) {
			if (other.typeCode != null) {
				return false;
			}
		} else if (!typeCode.equals(other.typeCode)) {
			return false;
		}
		return true;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
}
