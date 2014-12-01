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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductCategory;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "business_entity_service_link")
public class BusinessEntityServiceLink extends MizeSceEntityAudit implements Comparable<BusinessEntity>{
	private static final long serialVersionUID = 7777734836386834403L;
	private BusinessEntity businessEntity;
	private Brand brand;
	private ProductCategory productCategory;
	private Product product;
	private Long radius;
	private String radiusUom;

	public BusinessEntityServiceLink(){
	}
	
	public BusinessEntityServiceLink(BusinessEntity businessEntity,
			Brand brand, ProductCategory productCategory, Product product,
			Long radius, String radiusUom) {
		super();
		this.businessEntity = businessEntity;
		this.brand = brand;
		this.productCategory = productCategory;
		this.product = product;
		this.radius = radius;
		this.radiusUom = radiusUom;
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
	@JsonBackReference(value="be_servicelink")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="brand_id")
	public Brand getBrand() {
		return brand;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_cat_id")
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	@Column(name ="radius")
	public Long getRadius() {
		return radius;
	}

	@Column(name ="radius_uom")
	public String getRadiusUom() {
		return radiusUom;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setRadius(Long radius) {
		this.radius = radius;
	}

	public void setRadiusUom(String radiusUom) {
		this.radiusUom = radiusUom;
	}

	
	/*@Column(name = "created_date",updatable=false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@JsonInclude(Include.NON_DEFAULT)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}

	public void setUpdatedDate(MizeDateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Column(name = "created_by" ,updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}

	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "created_by_user", updatable=false)
	public String getCreatedByUser() {
		return createdByUser;
	}
	
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return updatedByUser;
	}
	
	public void setCreatedByUser(String createdByUser) {
		this.createdByUser = createdByUser;
	}
	
	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}*/

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result
				+ ((radiusUom == null) ? 0 : radiusUom.hashCode());
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
		BusinessEntityServiceLink other = (BusinessEntityServiceLink) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
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
		if (radius == null) {
			if (other.radius != null)
				return false;
		} else if (!radius.equals(other.radius))
			return false;
		if (radiusUom == null) {
			if (other.radiusUom != null)
				return false;
		} else if (!radiusUom.equals(other.radiusUom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusinessEntityServiceLink [brand=" + brand
				+ ", productCategory=" + productCategory + ", product="
				+ product + ", radius=" + radius + ", radiusUom=" + radiusUom
				+ ", id=" + id + "]";
	}

	@Override
	public int compareTo(BusinessEntity arg0) {
		return 0;
	}
}
