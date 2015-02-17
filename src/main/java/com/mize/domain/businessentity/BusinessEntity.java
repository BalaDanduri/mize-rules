package com.mize.domain.businessentity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityAddressGeo;
import com.mize.domain.common.EntityContact;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.CachedEntity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("BusinessEntity")
@Table(name = "business_entity")
public class BusinessEntity extends MizeSceEntityAudit implements Comparable<BusinessEntity>, Cloneable{
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
	private String businessEntityReference;
	@Transient
	private User user;
	private String statusCode;
	private MizeDate startDate;
	private MizeDate endDate;
	@CachedEntity
	private List<BusinessEntityAddress> addresses = new ArrayList<BusinessEntityAddress>();
	private List<BusinessEntityIntl> intl = new ArrayList<BusinessEntityIntl>();
	private List<BusinessEntityBrand> beBrand = new ArrayList<BusinessEntityBrand>();
	private List<BusinessEntityContact> beContact = new ArrayList<BusinessEntityContact>();
	private BusinessEntityAttribute beAttribute;
	@CachedEntity
	private List<BusinessEntityRelation> relatedEntities = new ArrayList<BusinessEntityRelation>();
	@CachedEntity
	private List<BusinessEntityServiceLink> beServiceLinks = new ArrayList<BusinessEntityServiceLink>();
	private List<BusinessEntityServiceRate> beServiceRates = new ArrayList<BusinessEntityServiceRate>();
	@CachedEntity
	private BusinessEntityRelation customerEntityRelation;
	private String referenceNumber;
	
	private List<Brand> brandList = new ArrayList<Brand>();

	public BusinessEntity() {
	}

	public BusinessEntity(Long id) {
		this.id = id;
	}

	public BusinessEntity(Long id, String code, String typeCode) {
		this.id = id;
		this.code = code;
		this.typeCode = typeCode;
	}

	public BusinessEntity(Long id,String code,String name,String firstName,String lastName) {
		this.id = id;
		this.code = code;
		BusinessEntityIntl beIntl = new BusinessEntityIntl();
		beIntl.setName(name);
		beIntl.setFirstName(firstName);
		beIntl.setLastName(lastName);
	}

	public BusinessEntity(Long id, String code, String name, String typeCode, String bename, String firstName,String lastName,String middleInitial, Locale locale, Long beaId,
			Long eaId, String addressType, String address1, String address2, String address3, String zip, String zipExt, String city, Long stateId,
			Long countryId, String email, String landMark,Long becId, String certificationInfo,
			Long ecId, String isActive, String contactType, String contactName, String cfirstName, String clastName, String cmiddleInitial, String phone, String phoneExt,
			String alternatePhone,String alternatePhoneExt, String fax, String faxExt, String cemail, String department, 
			BigDecimal latitude, BigDecimal longitude, Long geoId, String url, String isPromoted, String hoursOfOp) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.typeCode = typeCode;
		BusinessEntityAddress address = new BusinessEntityAddress();
		address.setId(beaId);
		address.setIsPreferred("Y");
		EntityAddress entityAddress = new EntityAddress();
		entityAddress.setId(eaId);
		entityAddress.setType(addressType);
		entityAddress.setAddress1(address1);
		entityAddress.setAddress2(address2);
		entityAddress.setAddress3(address3);
		entityAddress.setZip(zip);
		entityAddress.setZipExt(zipExt);
		entityAddress.setCity(city);
		entityAddress.setStateId(stateId);
		entityAddress.setCountryId(countryId);
		/*State state = new State();
		state.setId(geoId)*/
		/*state.setCode(stateCode);
		state.setName(stateName);*/
		/*Country country = new Country();
		country.setCode(countryCode);
		country.setName(countryName);
		country.setCode3(countryCode3);
		entityAddress.setState(state);
		entityAddress.setCountry(country);*/
		entityAddress.setEmail(email);
		entityAddress.setLandmark(landMark);		
		EntityAddressGeo addressGeo = new EntityAddressGeo();
		addressGeo.setId(geoId);
		addressGeo.setLatitude(latitude);
		addressGeo.setLongitude(longitude);
		entityAddress.setAddressGeo(addressGeo);
		address.setEntityAddress(entityAddress);		
		this.addresses = new ArrayList<BusinessEntityAddress>();
		this.addresses.add(address);
		
		BusinessEntityContact contact = new BusinessEntityContact();
		contact.setId(becId);
		contact.setCertificationInfo(certificationInfo);
		EntityContact entityContact = new EntityContact();
		entityContact.setId(ecId);
		entityContact.setIsActive(isActive);
		entityContact.setContactType(contactType);
		entityContact.setContactName(contactName);
		entityContact.setFirstName(cfirstName);
		entityContact.setLastName(clastName);
		entityContact.setMiddleInitial(cmiddleInitial);
		entityContact.setPhone(phone);
		entityContact.setPhoneExt(phoneExt);
		entityContact.setAlternatePhone(alternatePhone);
		entityContact.setAlternatePhoneExt(alternatePhoneExt);
		entityContact.setFax(fax);
		entityContact.setFaxExt(faxExt);
		entityContact.setEmail(cemail);
		entityContact.setDepartment(department);
		
		contact.setEntityContact(entityContact);		
		this.beContact = new ArrayList<BusinessEntityContact>();
		if(Formatter.isNotNull(entityContact.getContactType())){
			this.beContact.add(contact);
		}
		
		BusinessEntityIntl beIntl = new BusinessEntityIntl();
		beIntl.setName(bename);
		beIntl.setFirstName(firstName);
		beIntl.setLastName(lastName);
		beIntl.setMiddleInitial(middleInitial);
		beIntl.setLocale(locale);
		this.intl = new ArrayList<BusinessEntityIntl>();
		this.intl.add(beIntl);
		this.beAttribute = new BusinessEntityAttribute();
		this.beAttribute.setUrl(url);
		if(Formatter.isNull(isPromoted)) {
			this.beAttribute.setIsPromoted("N");
		} else {
			this.beAttribute.setIsPromoted(isPromoted);
		}
		this.beAttribute.setHoursOfOp(hoursOfOp);
	}



	public enum TypeCode{
		dealer,company,service_center,brand;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id= id;
	}

	@Column(name = "code")
	public String getCode() {
		return code;
	}

	@Column(name = "sub_type_code")
	public String getSubTypeCode() {
		return subTypeCode;
	}

	@Column(name = "logo")
	public String getLogo() {
		return logo;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getParentBE() {
		return parentBE;
	}

	@Column(name = "active_indicator")
	public String getIsActive() {
		return isActive;
	}

	@Column(name = "currency_code")
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="be_brand")
	public List<BusinessEntityBrand> getBeBrand() {
		return beBrand;
	}

	public void setBeBrand(List<BusinessEntityBrand> beBrand) {
		this.beBrand = beBrand;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="be_contact")
	public List<BusinessEntityContact> getBeContact() {
		return beContact;
	}

	public void setBeContact(List<BusinessEntityContact> beContact) {
		this.beContact = beContact;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade= CascadeType.ALL ,mappedBy ="businessEntity", orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
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

	@Column(name="type_code")
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="be_relation")
	public List<BusinessEntityRelation> getRelatedEntities() {
		return relatedEntities;
	}

	public void setRelatedEntities(List<BusinessEntityRelation> relatedEntities) {
		this.relatedEntities = relatedEntities;
	}

	public void setBusinessEntityReference(String businessEntityReference) {
		this.businessEntityReference = businessEntityReference;
	}

	@Column(name = "business_entity_reference")
	public String getBusinessEntityReference() {
		return businessEntityReference;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Column(name = "status_code")
	public String getStatusCode() {
		return statusCode;
	}

	@Column(name = "start_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDate getStartDate() {
		return startDate;
	}

	public void setStartDate(MizeDate startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDate getEndDate() {
		return endDate;
	}

	public void setEndDate(MizeDate endDate) {
		this.endDate = endDate;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="be_servicelink")
	public List<BusinessEntityServiceLink> getBeServiceLinks() {
		return beServiceLinks;
	}

	public void setBeServiceLinks(List<BusinessEntityServiceLink> beServiceLinks) {
		this.beServiceLinks = beServiceLinks;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "businessEntity")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="be_serviceRate")
	public List<BusinessEntityServiceRate> getBeServiceRates() {
		return beServiceRates;
	}

	public void setBeServiceRates(List<BusinessEntityServiceRate> beServiceRates) {
		this.beServiceRates = beServiceRates;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result
				+ ((beAttribute == null) ? 0 : beAttribute.hashCode());
		result = prime * result + ((beBrand == null) ? 0 : beBrand.hashCode());
		result = prime * result
				+ ((beContact == null) ? 0 : beContact.hashCode());
		result = prime * result
				+ ((beServiceLinks == null) ? 0 : beServiceLinks.hashCode());
		result = prime * result
				+ ((beServiceRates == null) ? 0 : beServiceRates.hashCode());
		result = prime * result
				+ ((brandList == null) ? 0 : brandList.hashCode());
		result = prime
				* result
				+ ((businessEntityReference == null) ? 0
						: businessEntityReference.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime
				* result
				+ ((customerEntityRelation == null) ? 0
						: customerEntityRelation.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((intl == null) ? 0 : intl.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parentBE == null) ? 0 : parentBE.hashCode());
		result = prime * result
				+ ((referenceNumber == null) ? 0 : referenceNumber.hashCode());
		result = prime * result
				+ ((relatedEntities == null) ? 0 : relatedEntities.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
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
		if (beAttribute == null) {
			if (other.beAttribute != null)
				return false;
		} else if (!beAttribute.equals(other.beAttribute))
			return false;
		if (beBrand == null) {
			if (other.beBrand != null)
				return false;
		} else if (!beBrand.equals(other.beBrand))
			return false;
		if (beContact == null) {
			if (other.beContact != null)
				return false;
		} else if (!beContact.equals(other.beContact))
			return false;
		if (beServiceLinks == null) {
			if (other.beServiceLinks != null)
				return false;
		} else if (!beServiceLinks.equals(other.beServiceLinks))
			return false;
		if (beServiceRates == null) {
			if (other.beServiceRates != null)
				return false;
		} else if (!beServiceRates.equals(other.beServiceRates))
			return false;
		if (brandList == null) {
			if (other.brandList != null)
				return false;
		} else if (!brandList.equals(other.brandList))
			return false;
		if (businessEntityReference == null) {
			if (other.businessEntityReference != null)
				return false;
		} else if (!businessEntityReference
				.equals(other.businessEntityReference))
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
		if (customerEntityRelation == null) {
			if (other.customerEntityRelation != null)
				return false;
		} else if (!customerEntityRelation.equals(other.customerEntityRelation))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (referenceNumber == null) {
			if (other.referenceNumber != null)
				return false;
		} else if (!referenceNumber.equals(other.referenceNumber))
			return false;
		if (relatedEntities == null) {
			if (other.relatedEntities != null)
				return false;
		} else if (!relatedEntities.equals(other.relatedEntities))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
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
		return "BusinessEntity [code=" + code + ", typeCode=" + typeCode
				+ ", subTypeCode=" + subTypeCode + ", logo=" + logo
				+ ", tenant=" + tenant + ", parentBE=" + parentBE
				+ ", isActive=" + isActive + ", currencyCode=" + currencyCode
				+ ", name=" + name + ", businessEntityReference="
				+ businessEntityReference + ", statusCode=" + statusCode
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", addresses=" + addresses + ", intl=" + intl + ", beBrand="
				+ beBrand + ", beContact=" + beContact + ", beAttribute="
				+ beAttribute + ", relatedEntities=" + relatedEntities
				+ ", beServiceLinks=" + beServiceLinks + ", beServiceRates="
				+ beServiceRates + ", customerEntityRelation="
				+ customerEntityRelation + ", referenceNumber="
				+ referenceNumber + ", brandList=" + brandList + "]";
	}

	@Override
	public int compareTo(BusinessEntity o) {
		return 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@JsonIgnore
	public static Comparator<BusinessEntity> BusinessEntityPromotedComparator = new  Comparator<BusinessEntity>() {
		public int compare(BusinessEntity be1, BusinessEntity be2) {
			return BusinessEntityAttribute.PromotedComparator.compare(be1.getBeAttribute(), be2.getBeAttribute());
		}
	};

	@Transient
	public BusinessEntityRelation getCustomerEntityRelation() {
		return customerEntityRelation;
	}

	public void setCustomerEntityRelation(BusinessEntityRelation customerEntityRelation) {
		this.customerEntityRelation = customerEntityRelation;
	}

	@Transient
	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Transient
	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}
}
