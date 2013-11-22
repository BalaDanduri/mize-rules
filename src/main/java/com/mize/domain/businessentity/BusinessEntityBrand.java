package com.mize.domain.businessentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.codehaus.jackson.annotate.JsonIgnore;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="business_entity_brand")
public class BusinessEntityBrand extends MizeEntity implements Comparable<BusinessEntityBrand>{
	private static final long serialVersionUID = -269538922800687629L;
	private Long be_id;
	private String isActive;
	private BusinessEntity businessEntity;
	private Brand brand;

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
	
	@Transient
	@Column(name="be_id",insertable=false,updatable=false)
	@JsonIgnore
	public Long getBe_id() {
		return be_id;
	}

	public void setBe_id(Long be_id) {
		this.be_id = be_id;
	}

	@Column(name="is_active",nullable=true)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
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

	@OneToOne(targetEntity=Brand.class)
	@JoinColumn(name="brand_id")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((be_id == null) ? 0 : be_id.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
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
		BusinessEntityBrand other = (BusinessEntityBrand) obj;
		if (be_id == null) {
			if (other.be_id != null)
				return false;
		} else if (!be_id.equals(other.be_id))
			return false;
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
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessEntityBrand [be_id=");
		builder.append(be_id);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", businessEntity=");
		builder.append(businessEntity);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int compareTo(BusinessEntityBrand arg0) {
		return 0;
	}

}
