package com.mize.domain.servicelocator;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="business_entity")
public class BusinessEntity  extends MizeEntity implements Comparable<BusinessEntity>{
	
	private static final long serialVersionUID = 3712437162456355278L;	
	private String code;	
	private TypeCode typeCode;
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
	
	public BusinessEntity(Long id) {
		super();
		this.id = id;
	}
	
	public enum TypeCode {
		company, dealer, store
	}
	
	public BusinessEntity(Long id, String code, TypeCode typeCode, String subTypeCode, String name, String logo,
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval=true,mappedBy="businessEntity")
	public List<BusinessEntityAddress> getBusinessEntityAddressList() {
		return businessEntityAddressList;
	}
	public void setBusinessEntityAddressList(
			List<BusinessEntityAddress> businessEntityAddressList) {
		this.businessEntityAddressList = businessEntityAddressList;
	}
	
	@Id
	@GenericGenerator(name= "businessEntityId" , strategy="increment")
	@GeneratedValue(generator="businessEntityId")
	@Column(name="id", nullable=false,unique=true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name="type_code",nullable=true,length=50)
	@Enumerated(EnumType.STRING)
	public TypeCode getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(TypeCode typeCode) {
		this.typeCode = typeCode;
	}
	@Column(name="sub_type_code",nullable=true,length=50)
	public String getSubTypeCode() {
		return subTypeCode;
	}
	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}
	@Column(name="name",nullable=true,length=200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="logo",nullable=true,length=100)
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@JsonIgnore
	@Transient
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
	@Transient
	public int getAddressCount() {
		return businessEntityAddressList==null?0:businessEntityAddressList.size();
	}
	
	@JsonIgnore
	@Transient
	public BusinessEntityAddress getAddressAt(int index) {
		return (businessEntityAddressList!=null&& businessEntityAddressList.size()>index)? businessEntityAddressList.get(index) : null;
	}
	
	@JsonIgnore
	@Transient
	public boolean updateAddressAt(int index,BusinessEntityAddress businessEntityAddress) {
		if(businessEntityAddressList!=null&& businessEntityAddressList.size()>index) {
			businessEntityAddressList.set(index, businessEntityAddress);
			return true;
		}
		return false;
	}
	@Transient
	public long getEntityId() {
		return entityId;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	@Transient
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
		if(id == null) {
			if (other.id != null) {
				return false;
			}
		} else if(id.compareTo(other.id) != 0) {
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
	@Transient
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	@JsonIgnore
	@Transient
	public static TypeCode getEntityTypeCode(String typeCode){
		for (TypeCode entityTypeCode : TypeCode.values()) {
			if( entityTypeCode.toString().equals(typeCode) ){
				return entityTypeCode;
			}
		}
		return null;
	}

	@Override
	public int compareTo(BusinessEntity o) {
		return 0;
	}
	
}
