package com.mize.domain.product;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
@Entity
@Table(name = "prod_repeat_ship_options")
public class ProductRepeatOrderShipOptions extends MizeSceEntity implements Comparable<ProductRepeatOrderShipOptions>{
	
	private static final long serialVersionUID = -8538782322766644151L;
	private Brand brand;
	private Product product;
	private String code;
	private String description;
	private Double shipAmount;
	@Transient
	private Integer pageIndex;
	
	public ProductRepeatOrderShipOptions(){
		
	}
	
	public ProductRepeatOrderShipOptions(Brand brand, Product product, String code, String description, Double shipAmount,Integer pageIndex) {
		super();
		this.brand = brand;
		this.product = product;
		this.code = code;
		this.description = description;
		this.shipAmount = shipAmount;
		this.pageIndex = pageIndex;
	}	
	
	public ProductRepeatOrderShipOptions(Brand brand, Product product, String code, String description, Double shipAmount,
			Integer pageIndex,Long createdBy,Long updatedBy) {
		super();
		this.brand = brand;
		this.product = product;
		this.code = code;
		this.description = description;
		this.shipAmount = shipAmount;
		this.pageIndex = pageIndex;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "brand_id", nullable = true)
	@JsonBackReference(value="brand_shippings")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id", nullable = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "code",nullable = true, length = 50)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description",nullable = true, length = 200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "ship_amt",nullable = true)
	public Double getShipAmount() {
		return shipAmount;
	}

	public void setShipAmount(Double shipAmount) {
		this.shipAmount = shipAmount;
	}
	
	@Column(name = "created_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by",  nullable = true, length = 20)
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Transient
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((pageIndex == null) ? 0 : pageIndex.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((shipAmount == null) ? 0 : shipAmount.hashCode());
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
		ProductRepeatOrderShipOptions other = (ProductRepeatOrderShipOptions) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (pageIndex == null) {
			if (other.pageIndex != null)
				return false;
		} else if (!pageIndex.equals(other.pageIndex))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (shipAmount == null) {
			if (other.shipAmount != null)
				return false;
		} else if (!shipAmount.equals(other.shipAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductRepeatOrderShipOptions [brand=" + brand + ", product=" + product + ", code=" + code
				+ ", description=" + description + ", shipAmount=" + shipAmount + ", pageIndex=" + pageIndex + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrderShipOptions arg0) {
		return 0;
	}
	
}
