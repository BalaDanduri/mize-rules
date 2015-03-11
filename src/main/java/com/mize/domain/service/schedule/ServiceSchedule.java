package com.mize.domain.service.schedule;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.Country;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.common.State;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.product.Product;
import com.mize.domain.user.UserAddress;

@Entity
@Table(name="service_schedule")
public class ServiceSchedule  extends MizeSceEntity  implements Comparable<ServiceSchedule> {	
	
	private static final long serialVersionUID = -5351211947355990640L;	
	
	private Product product;
	private User user;
	private User userBE;
	private User source;
	private Brand brand;
	private String serviceFormat;
	private Long beId;
	private String serviceType;
	private String problem;
	Long productCategoryId;
	private Long productSubCategoryId;		
	private DateTime scheduledDate;
	private String startTime;
	private String endTime;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private State state;
	private Country country;
	private String email;
	private String zipCode;
	private String mobilePhone;
	private String homePhone;
	private String workPhone;
	private String additionalInfo;
	private String warrantyStatus;
	private String scheduledStatus;
	private String serviceOrderNumber;
	private String confirmationNumber;
	private UserAddress address;
	private Long addressId;
	private String firstName;
	private String lastName;
	private String caseNumber;	
	private String serialNumber;
	private String processId;
	
	public enum Formatt{
		in_home,carry_in,support_request
	}
	
	public enum Status{
		Completed
	}
	
	public static Formatt getFormatt(String formatt){
		for(Formatt f : Formatt.values()){
			if(f.toString().equalsIgnoreCase(formatt)){
				return f;
			}
		}
		return null;
	}
	public ServiceSchedule() {
		user = new User();
		brand = new Brand();
		address = new UserAddress();
		
	}	

	
	
	public ServiceSchedule(User user, Brand brand, String serviceFormat,
			Long beId, String serviceType, String problem,
			Long productCategoryId, Long productSubCategoryId,
			DateTime scheduledDate, String startTime, String endTime,
			String address1, String address2, String address3, String city,
			State state, Country country, String email, String zipCode,
			String mobilePhone, String homePhone, String workPhone,
			String additionalInfo, String warrantyStatus,
			String scheduledStatus, String serviceOrderNumber,
			String confirmationNumber, UserAddress address, Long addressId,
			String firstName, String lastName) {
		super();
		this.user = user;
		this.brand = brand;
		this.serviceFormat = serviceFormat;
		this.beId = beId;
		this.serviceType = serviceType;
		this.problem = problem;
		this.productCategoryId = productCategoryId;
		this.productSubCategoryId = productSubCategoryId;
		this.scheduledDate = scheduledDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
		this.zipCode = zipCode;
		this.mobilePhone = mobilePhone;
		this.homePhone = homePhone;
		this.workPhone = workPhone;
		this.additionalInfo = additionalInfo;
		this.warrantyStatus = warrantyStatus;
		this.scheduledStatus = scheduledStatus;
		this.serviceOrderNumber = serviceOrderNumber;
		this.confirmationNumber = confirmationNumber;
		this.address = address;
		this.addressId = addressId;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	@ManyToOne(targetEntity=User.class,fetch=FetchType.EAGER)		
	@JoinColumn(name="user_id",nullable=true)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(targetEntity=Brand.class)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name="brand_id",nullable=true)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	@Column(name="service_format",length=50,nullable=true)
	public String getServiceFormat() {
		return serviceFormat;
	}

	public void setServiceFormat(String serviceFormat) {
		this.serviceFormat = serviceFormat;
	}
	
	@Column(name="be_id",nullable=true)
	public Long getBeId() {
		return beId;
	}

	public void setBeId(Long beId) {
		this.beId = beId;
	}
	
	@Column(name="service_type",length=50,nullable=true)
	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name="problem",length=100,nullable=true)	
	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}
	
	@Column(name="prod_cat_id",nullable=true)
	public Long getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Column(name="prod_sub_cat_id",nullable=true)
	public Long getProductSubCategoryId() {
		return productSubCategoryId;
	}

	public void setProductSubCategoryId(Long productSubCategoryId) {
		this.productSubCategoryId = productSubCategoryId;
	}

	@Column(name="first_name",nullable=true,length=100)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="last_name",nullable=true,length=100)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	/*@DateTimeFormat(pattern="MM-dd-yyyy")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)*/
	@Column(name="scheduled_date",nullable=true)
	public DateTime getScheduledDate() {
		return scheduledDate;
	}
	
	/*@DateTimeFormat(pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)*/
	public void setScheduledDate(DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	@Column(name="start_time",length=20,nullable=true)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name="end_time",length=20,nullable=true)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	@Column(name="address1",length=100,nullable=true)
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name="address2",length=100,nullable=true)
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name="address3",length=100,nullable=true)
	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Column(name="city",length=100,nullable=true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Transient
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	@Transient
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name="email",length=255,nullable=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="postal_code",length=11,nullable=true)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Column(name="phone_mobile",length=20,nullable=true)
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	@Column(name="phone_home",length=20,nullable=true)
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name="phone_work",length=20,nullable=true)
	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	@Column(name="addl_info",length=200,nullable=true)
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	@Column(name="warranty_status",length=50,nullable=true)
	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}
	
	@Column(name="scheduled_status",length=50,nullable=true)
	public String getScheduledStatus() {
		return scheduledStatus;
	}

	public void setScheduledStatus(String scheduledStatus) {
		this.scheduledStatus = scheduledStatus;
	}
	
	@Column(name="service_order_no",length=50,nullable=true)
	public String getServiceOrderNumber() {
		return serviceOrderNumber;
	}

	public void setServiceOrderNumber(String serviceOrderNumber) {
		this.serviceOrderNumber = serviceOrderNumber;
	}
	
	@Column(name="confirmation_no",length=50,nullable=true)
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	@Override
	@Id
	@GenericGenerator(name="scheduleId",strategy="increment")
	@GeneratedValue(generator="scheduleId")
	@Column(name="id",nullable=false,unique=true)
	public Long getId() {	
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=UserAddress.class)	
	@JoinColumn(name="user_address_id",nullable=true,updatable=false)
	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	@Override
	public int compareTo(ServiceSchedule o) {		
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((additionalInfo == null) ? 0 : additionalInfo.hashCode());
		result = prime * result
				+ ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result
				+ ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result
				+ ((address3 == null) ? 0 : address3.hashCode());
		result = prime * result + ((beId == null) ? 0 : beId.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime
				* result
				+ ((confirmationNumber == null) ? 0 : confirmationNumber
						.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((problem == null) ? 0 : problem.hashCode());
		result = prime
				* result
				+ ((productCategoryId == null) ? 0 : productCategoryId
						.hashCode());
		result = prime
				* result
				+ ((productSubCategoryId == null) ? 0 : productSubCategoryId
						.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
		result = prime * result
				+ ((scheduledStatus == null) ? 0 : scheduledStatus.hashCode());
		result = prime * result
				+ ((serviceFormat == null) ? 0 : serviceFormat.hashCode());
		result = prime
				* result
				+ ((serviceOrderNumber == null) ? 0 : serviceOrderNumber
						.hashCode());
		result = prime * result
				+ ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((warrantyStatus == null) ? 0 : warrantyStatus.hashCode());
		result = prime * result
				+ ((workPhone == null) ? 0 : workPhone.hashCode());
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
		ServiceSchedule other = (ServiceSchedule) obj;
		if (additionalInfo == null) {
			if (other.additionalInfo != null)
				return false;
		} else if (!additionalInfo.equals(other.additionalInfo))
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
		if (beId == null) {
			if (other.beId != null)
				return false;
		} else if (!beId.equals(other.beId))
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
		if (confirmationNumber == null) {
			if (other.confirmationNumber != null)
				return false;
		} else if (!confirmationNumber.equals(other.confirmationNumber))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (id.compareTo(other.id) != 0)
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (problem == null) {
			if (other.problem != null)
				return false;
		} else if (!problem.equals(other.problem))
			return false;
		if (productCategoryId == null) {
			if (other.productCategoryId != null)
				return false;
		} else if (!productCategoryId.equals(other.productCategoryId))
			return false;
		if (productSubCategoryId == null) {
			if (other.productSubCategoryId != null)
				return false;
		} else if (!productSubCategoryId.equals(other.productSubCategoryId))
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
		if (scheduledDate == null) {
			if (other.scheduledDate != null)
				return false;
		} else if (!scheduledDate.equals(other.scheduledDate))
			return false;
		if (scheduledStatus == null) {
			if (other.scheduledStatus != null)
				return false;
		} else if (!scheduledStatus.equals(other.scheduledStatus))
			return false;
		if (serviceFormat == null) {
			if (other.serviceFormat != null)
				return false;
		} else if (!serviceFormat.equals(other.serviceFormat))
			return false;
		if (serviceOrderNumber == null) {
			if (other.serviceOrderNumber != null)
				return false;
		} else if (!serviceOrderNumber.equals(other.serviceOrderNumber))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (warrantyStatus == null) {
			if (other.warrantyStatus != null)
				return false;
		} else if (!warrantyStatus.equals(other.warrantyStatus))
			return false;
		if (workPhone == null) {
			if (other.workPhone != null)
				return false;
		} else if (!workPhone.equals(other.workPhone))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		if(address == null) {
			if(other.address != null) 
				return false;			
		} else if(!address.equals(other.address)) 
			return false;
		if(addressId == null) {
			if(other.addressId != null)
				return false;
		} else if(!addressId.equals(other.addressId))
			return false;
		return true;
	}
	
	@Transient
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCaseNumber() {
		return caseNumber;
	}
	
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public User getUserBE() {
		return userBE;
	}
	public void setUserBE(User userBE) {
		this.userBE = userBE;
	}
	public User getSource() {
		return source;
	}
	public void setSource(User source) {
		this.source = source;
	}
	
}
