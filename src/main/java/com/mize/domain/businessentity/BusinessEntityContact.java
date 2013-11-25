package com.mize.domain.businessentity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnore;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="business_entity_contact")
public class BusinessEntityContact extends MizeEntity implements Comparable<BusinessEntityContact> {
	private static final long serialVersionUID = -1908157637318196738L;
	 	private BusinessEntity businessEntity;
	 	private Brand brand;
		private String isPrimary;
		private String firstName;
		private String lastName;
		private String middleName;
		private String phone;
		private String phoneExt;
		private String fax;
		private String faxExt;
		private String email;
		private String department;

	@Id
	@Column(name="id",nullable=false,unique=true)
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonIgnore
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Column(name="is_primary",nullable=true)
	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	@Column(name="first_name",nullable=true)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="last_name",nullable=true)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="middle_initial",nullable=true)
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name="phone",nullable=true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="phone_ext",nullable=true)
	public String getPhoneExt() {
		return phoneExt;
	}

	public void setPhoneExt(String phoneExt) {
		this.phoneExt = phoneExt;
	}

	@Column(name="fax",nullable=true)
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name="fax_ext",nullable=true)
	public String getFaxExt() {
		return faxExt;
	}

	public void setFaxExt(String faxExt) {
		this.faxExt = faxExt;
	}

	@Column(name="email",nullable=true)
	public String getEmail() {
		return email;
	}

	@Column(name="email",nullable=true)
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="department",nullable=true)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public int compareTo(BusinessEntityContact o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + ((faxExt == null) ? 0 : faxExt.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((isPrimary == null) ? 0 : isPrimary.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((phoneExt == null) ? 0 : phoneExt.hashCode());
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
		BusinessEntityContact other = (BusinessEntityContact) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.equals(other.businessEntity))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (faxExt == null) {
			if (other.faxExt != null)
				return false;
		} else if (!faxExt.equals(other.faxExt))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isPrimary == null) {
			if (other.isPrimary != null)
				return false;
		} else if (!isPrimary.equals(other.isPrimary))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (phoneExt == null) {
			if (other.phoneExt != null)
				return false;
		} else if (!phoneExt.equals(other.phoneExt))
			return false;
		return true;
	}
	
	

}
