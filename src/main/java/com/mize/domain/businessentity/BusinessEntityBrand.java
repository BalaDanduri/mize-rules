package com.mize.domain.businessentity;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("BusinessEntityBrand")
@Table(name="business_entity_brand",uniqueConstraints = { @UniqueConstraint(columnNames = {"be_id","brand_id"} )} )
public class BusinessEntityBrand extends MizeEntity implements Comparable<BusinessEntityBrand>{
	private static final long serialVersionUID = -269538922800687629L;
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
	
	@Column(name="is_active",nullable=true)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonBackReference(value="be_brand")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="brand_id")
	/*@JsonBackReference(value="brand_be")*/
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
		return "BusinessEntityBrand [isActive=" + isActive + ", id=" + id + "]";
	}

	@Override
	public int compareTo(BusinessEntityBrand arg0) {
		return 0;
	}
}
