package com.mize.domain.businessentity;

import java.math.BigDecimal;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductCategory;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;

@Entity
@Table(name = "business_entity_service_rate")
public class BusinessEntityServiceRate extends MizeSceEntityAudit implements Comparable<BusinessEntity>{
	private static final long serialVersionUID = -434328833392204604L;
	private BusinessEntity businessEntity;
	private Brand brand;
	private ProductCategory productCategory;
	private Product product;
	private String serviceType;
	private String currencyCode;
	private MizeDate startDate;
	private MizeDate endDate;
	private BigDecimal serviceRate;
	@Transient
	private User user;

	public BusinessEntityServiceRate(){
	}
	
	public BusinessEntityServiceRate(Long id,String serviceType,BigDecimal serviceRate){
		this.id = id;
		this.serviceType = serviceType;
		this.serviceRate = serviceRate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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
	@JsonBackReference(value="be_serviceRate")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="brand_id")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_cat_id")
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name ="service_type")
	public String getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	@Column(name ="currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
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
	
	@Column(name = "service_rate")
    public BigDecimal getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(BigDecimal serviceRate) {
		this.serviceRate = serviceRate;
	}

	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result
				+ ((serviceRate == null) ? 0 : serviceRate.hashCode());
		result = prime * result
				+ ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		BusinessEntityServiceRate other = (BusinessEntityServiceRate) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productCategory == null) {
			if (other.productCategory != null)
				return false;
		} else if (!productCategory.equals(other.productCategory))
			return false;
		if (serviceRate == null) {
			if (other.serviceRate != null)
				return false;
		} else if (!serviceRate.equals(other.serviceRate))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BusinessEntityServiceRate [brand=" + brand
				+ ", productCategory=" + productCategory + ", product="
				+ product + ", serviceType=" + serviceType + ", currencyCode="
				+ currencyCode + ", startDate=" + startDate + ", endDate="
				+ endDate + ", serviceRate=" + serviceRate + ", id=" + id + "]";
	}

	@Override
	public int compareTo(BusinessEntity arg0) {
		return 0;
	}
}
