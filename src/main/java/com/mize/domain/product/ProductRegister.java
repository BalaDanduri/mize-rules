package com.mize.domain.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.user.UserAddress;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "prod_regn")
public class ProductRegister extends MizeEntity implements Comparable<ProductRegister>{

	private static final long serialVersionUID = -6338652951554117142L;
	private Brand brand;
	private BusinessEntity businessEntity;
	private Product product;
	private User user;
	private String serialNumber;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime purchaseDate;
	private Double purchasePrice;
	private String purchaseStore;
	@DateTimeFormat (pattern="dd-MM-yyyy")
	private DateTime warrantyExpiryDate;
	private String additionalInfo;
	private String firstName;
	private String lastName;	
	private String email;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phoneMobile;
	private String phoneHome;
	private String phoneWork;
	private List<ProductRegnAttachment> attachments;
	@Transient
	private Long stateId;
	@Transient
	private Long countryId;
	private String regnName;
	private String template = "json";
	
	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	private DateTime createdDateFrom;
	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	private DateTime createdDateTo;
	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	private DateTime updatedDateFrom;
	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	private DateTime updatedDateTo;
	
	private Long addressId;
	@Transient
	private UserAddress address;
	
	public ProductRegister(){
		
	}
	
	public ProductRegister(Long id){
		super();
		this.id = id;
	}
	
	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="prod_regn_id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		super.id = id;
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", nullable = true)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "be_id", nullable = true)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id", nullable = true)
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = true)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name = "prod_srl_no",  nullable = true, length = 200)
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "purchase_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getPurchaseDate() {
		return purchaseDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setPurchaseDate(DateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Column(name = "purchase_price",  nullable = true)
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	@Column(name = "purchase_store",  nullable = true, length = 200)
	public String getPurchaseStore() {
		return purchaseStore;
	}
	public void setPurchaseStore(String purchaseStore) {
		this.purchaseStore = purchaseStore;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "warranty_expiry_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getWarrantyExpiryDate() {
		return warrantyExpiryDate;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setWarrantyExpiryDate(DateTime warrantyExpiryDate) {
		this.warrantyExpiryDate = warrantyExpiryDate;
	}
	
	@Column(name = "addl_info",  nullable = true, length = 500)
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	@Column(name = "first_name",  nullable = true, length = 100)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name",  nullable = true, length = 100)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email",  nullable = true, length = 255)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "address1",  nullable = true, length = 100)
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name = "address2",  nullable = true, length = 100)
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name = "address3",  nullable = true, length = 100)
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	@Column(name = "city",  nullable = true, length = 100)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "state_id",  nullable = true, length = 11)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "postal_code",  nullable = true, length = 11)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name = "country_id",  nullable = true, length = 11)
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Column(name = "phone_mobile",  nullable = true, length = 20)
	public String getPhoneMobile() {
		return phoneMobile;
	}
	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}
	
	@Column(name = "phone_home",  nullable = true, length = 20)
	public String getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	
	@Column(name = "phone_work",  nullable = true, length = 20)
	public String getPhoneWork() {
		return phoneWork;
	}
	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	@JoinColumn(name="prod_regn_id") 
	public List<ProductRegnAttachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<ProductRegnAttachment> attachments) {
		this.attachments = attachments;
	}
	
	@JsonIgnore
	@Transient
	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	@JsonIgnore
	@Transient
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "ProductRegister [brand=" + brand + ", businessEntity="
				+ businessEntity + ", product=" + product + ", user=" + user
				+ ", serialNumber=" + serialNumber + ", purchaseDate="
				+ purchaseDate + ", purchasePrice=" + purchasePrice
				+ ", purchaseStore=" + purchaseStore + ", warrantyExpiryDate="
				+ warrantyExpiryDate + ", additionalInfo=" + additionalInfo
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", address1=" + address1 + ", address2="
				+ address2 + ", address3=" + address3 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode="
				+ zipCode + ", phoneMobile=" + phoneMobile + ", phoneHome="
				+ phoneHome + ", phoneWork=" + phoneWork + ", attachments="
				+ attachments + ", stateId=" + stateId + ", countryId="
				+ countryId + ", regnName=" + regnName + ", template="
				+ template + ", createdDateFrom=" + createdDateFrom
				+ ", createdDateTo=" + createdDateTo + ", updatedDateFrom="
				+ updatedDateFrom + ", updatedDateTo=" + updatedDateTo
				+ ", addressId=" + addressId + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((additionalInfo == null) ? 0 : additionalInfo.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((createdDateFrom == null) ? 0 : createdDateFrom.hashCode());
		result = prime * result + ((createdDateTo == null) ? 0 : createdDateTo.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneHome == null) ? 0 : phoneHome.hashCode());
		result = prime * result + ((phoneMobile == null) ? 0 : phoneMobile.hashCode());
		result = prime * result + ((phoneWork == null) ? 0 : phoneWork.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime * result + ((purchaseStore == null) ? 0 : purchaseStore.hashCode());
		result = prime * result + ((regnName == null) ? 0 : regnName.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		result = prime * result + ((updatedDateFrom == null) ? 0 : updatedDateFrom.hashCode());
		result = prime * result + ((updatedDateTo == null) ? 0 : updatedDateTo.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((warrantyExpiryDate == null) ? 0 : warrantyExpiryDate.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		ProductRegister other = (ProductRegister) obj;
		if (additionalInfo == null) {
			if (other.additionalInfo != null)
				return false;
		} else if (!additionalInfo.equals(other.additionalInfo))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (address3 == null) {
			if (other.address3 != null)
				return false;
		} else if (!address3.equals(other.address3))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (attachments == null) {
			if (other.attachments != null)
				return false;
		} else if (!attachments.equals(other.attachments))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (createdDateFrom == null) {
			if (other.createdDateFrom != null)
				return false;
		} else if (!createdDateFrom.equals(other.createdDateFrom))
			return false;
		if (createdDateTo == null) {
			if (other.createdDateTo != null)
				return false;
		} else if (!createdDateTo.equals(other.createdDateTo))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneHome == null) {
			if (other.phoneHome != null)
				return false;
		} else if (!phoneHome.equals(other.phoneHome))
			return false;
		if (phoneMobile == null) {
			if (other.phoneMobile != null)
				return false;
		} else if (!phoneMobile.equals(other.phoneMobile))
			return false;
		if (phoneWork == null) {
			if (other.phoneWork != null)
				return false;
		} else if (!phoneWork.equals(other.phoneWork))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (purchasePrice == null) {
			if (other.purchasePrice != null)
				return false;
		} else if (!purchasePrice.equals(other.purchasePrice))
			return false;
		if (purchaseStore == null) {
			if (other.purchaseStore != null)
				return false;
		} else if (!purchaseStore.equals(other.purchaseStore))
			return false;
		if (regnName == null) {
			if (other.regnName != null)
				return false;
		} else if (!regnName.equals(other.regnName))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		if (updatedDateFrom == null) {
			if (other.updatedDateFrom != null)
				return false;
		} else if (!updatedDateFrom.equals(other.updatedDateFrom))
			return false;
		if (updatedDateTo == null) {
			if (other.updatedDateTo != null)
				return false;
		} else if (!updatedDateTo.equals(other.updatedDateTo))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (warrantyExpiryDate == null) {
			if (other.warrantyExpiryDate != null)
				return false;
		} else if (!warrantyExpiryDate.equals(other.warrantyExpiryDate))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	
	@Column(name = "regn_name",  nullable = true, length = 50)
	public String getRegnName() {
		return regnName;
	}

	public void setRegnName(String regnName) {
		this.regnName = regnName;
	}
	
	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getCreatedDateFrom() {
		return createdDateFrom;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setCreatedDateFrom(DateTime createdDateFrom) {
		this.createdDateFrom = createdDateFrom;
	}

	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getCreatedDateTo() {
		return createdDateTo;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setCreatedDateTo(DateTime createdDateTo) {
		this.createdDateTo = createdDateTo;
	}

	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getUpdatedDateFrom() {
		return updatedDateFrom;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setUpdatedDateFrom(DateTime updatedDateFrom) {
		this.updatedDateFrom = updatedDateFrom;
	}

	@Transient
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getUpdatedDateTo() {
		return updatedDateTo;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setUpdatedDateTo(DateTime updatedDateTo) {
		this.updatedDateTo = updatedDateTo;
	}

	@Column(name = "user_address_id",  nullable = true, length = 20)
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	@Transient
	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public int compareTo(ProductRegister arg0) {
		return 0;
	}
}
