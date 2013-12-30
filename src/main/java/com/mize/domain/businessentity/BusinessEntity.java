package com.mize.domain.businessentity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityAddressPhone;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "business_entity", uniqueConstraints = {@UniqueConstraint (columnNames={"tenant_id", "code"})})
public class BusinessEntity extends MizeEntity implements Comparable<BusinessEntity>{

	private static final long serialVersionUID = 5842902035928465555L;
	private String code;
	private String typeCode;
	private String subTypeCode;
	private String logo;
	private BusinessEntity tenant;
	private BusinessEntity parentBE;
	private String isActive;
	private String currencyCode;
	private String name;
	private List<BusinessEntityAddress> addresses = new ArrayList<BusinessEntityAddress>();
	private List<BusinessEntityIntl> intl = new ArrayList<BusinessEntityIntl>();
	private List<BusinessEntityBrand> beBrand = new ArrayList<BusinessEntityBrand>();
	private List<BusinessEntityContact> beContact = new ArrayList<BusinessEntityContact>();
	private BusinessEntityAttribute beAttribute = new BusinessEntityAttribute();
	
	public BusinessEntity() {
	}
	
	public BusinessEntity(Long id) {
		this.id = id;
	}
	
	public BusinessEntity(Long id, String code, String name, String typeCode, BusinessEntityIntl intl, 
			BusinessEntityAddress address,String url,String hoursOfOp) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.typeCode = typeCode;		
		this.addresses = new ArrayList<BusinessEntityAddress>();
		this.addresses.add(address);
		List<EntityAddressPhone> phones = new ArrayList<EntityAddressPhone>();		
		this.intl = new ArrayList<BusinessEntityIntl>();
		this.intl.add(intl);
		this.beAttribute.setUrl(url);
		this.beAttribute.setHoursOfOp(hoursOfOp);
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id= id;
	}

	@Column(name = "code",length = 50)
	public String getCode() {
		return code;
	}

	@Column(name = "sub_type_code",length = 50)
	public String getSubTypeCode() {
		return subTypeCode;
	}

	@Column(name = "logo", length = 100)
	public String getLogo() {
		return logo;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_be_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getParentBE() {
		return parentBE;
	}

	@Column(name = "active_indicator",length = 1)
	public String getIsActive() {
		return isActive;
	}

	@Column(name = "currency_code",length = 30)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setSubTypeCode(String subTypeCode) {
		this.subTypeCode = subTypeCode;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setParentBE(BusinessEntity parentBe) {
		this.parentBE = parentBe;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="address")
	public List<BusinessEntityAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<BusinessEntityAddress> addresses) {
		this.addresses = addresses;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "businessEntity" ,orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference(value="intl")
	public List<BusinessEntityIntl> getIntl() {
		return intl;
	}

	public void setIntl(List<BusinessEntityIntl> intl) {
		this.intl = intl;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="be_brand")
	public List<BusinessEntityBrand> getBeBrand() {
		return beBrand;
	}

	public void setBeBrand(List<BusinessEntityBrand> beBrand) {
		this.beBrand = beBrand;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="be_contact")
	public List<BusinessEntityContact> getBeContact() {
		return beContact;
	}

	public void setBeContact(List<BusinessEntityContact> beContact) {
		this.beContact = beContact;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade= CascadeType.ALL ,mappedBy ="businessEntity", orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="be_attribute")
	public BusinessEntityAttribute getBeAttribute() {
		return beAttribute;
	}

	public void setBeAttribute(BusinessEntityAttribute beAttribute) {
		this.beAttribute = beAttribute;
	}
	
	@JsonIgnore
	public static Comparator<BusinessEntity> BusinessEntityAddressDistanceComparator = new  Comparator<BusinessEntity>() {
		public int compare(BusinessEntity be1, BusinessEntity be2) {
		    return BusinessEntityAddress.EntityAddressGeoDistanceComparator.compare(be1.addresses.get(0), be2.addresses.get(0));
		}
	};
	
	@Column(name="type_code",nullable=true,length=50)
	public String getTypeCode() {
		return typeCode;
	}
	
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((intl == null) ? 0 : intl.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parentBE == null) ? 0 : parentBE.hashCode());
		result = prime * result
				+ ((subTypeCode == null) ? 0 : subTypeCode.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
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
		BusinessEntity other = (BusinessEntity) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (intl == null) {
			if (other.intl != null)
				return false;
		} else if (!intl.equals(other.intl))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentBE == null) {
			if (other.parentBE != null)
				return false;
		} else if (!parentBE.equals(other.parentBE))
			return false;
		if (subTypeCode == null) {
			if (other.subTypeCode != null)
				return false;
		} else if (!subTypeCode.equals(other.subTypeCode))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessEntity [code=");
		builder.append(code);
		builder.append(", typeCode=");
		builder.append(typeCode);
		builder.append(", subTypeCode=");
		builder.append(subTypeCode);
		builder.append(", logo=");
		builder.append(logo);
		builder.append(", tenant=");
		builder.append(tenant);
		builder.append(", parentBE=");
		builder.append(parentBE);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", currencyCode=");
		builder.append(currencyCode);
		builder.append(", name=");
		builder.append(name);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", intl=");
		builder.append(intl);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int compareTo(BusinessEntity o) {
		return 0;
	}

}
