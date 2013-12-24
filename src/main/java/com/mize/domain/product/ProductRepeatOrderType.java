package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_repeat_type")
public class ProductRepeatOrderType extends MizeEntity implements Comparable<ProductRepeatOrderType> {

	private static final long serialVersionUID = 6185921069844911176L;


	private Brand brand;
	private Product product;
	private String code;
	private Integer frequencyValue;
	private Unit frequencyUnit;
	private String description;
	
	
	public enum Unit{
		DAYS,WEEKS,MONTHS,YEARS
	}
	

	public ProductRepeatOrderType(){
		
	}

	public ProductRepeatOrderType(Brand brand, Product product, String code,
			Integer frequencyValue, Unit frequencyUnit, String description) {
		super();
		this.brand = brand;
		this.product = product;
		this.code = code;
		this.frequencyValue = frequencyValue;
		this.frequencyUnit = frequencyUnit;
		this.description = description;
	}
		
	@Id
	@GenericGenerator(name="id" , strategy="increment")
	@GeneratedValue(generator="id")
	@Column(name="id",unique=true,nullable=false,length=11)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	

	@Column(name="CODE" ,nullable = true) 
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "FREQ_VAL",nullable = true)
	public Integer getFrequencyValue() {
		return frequencyValue;
	}


	public void setFrequencyValue(Integer frequencyValue) {
		this.frequencyValue = frequencyValue;
	}

    
	@Column(name="FREQ_UNIT" ,nullable = true) 
	@Enumerated(EnumType.ORDINAL) 
	public Unit getFrequencyUnit() {
		return frequencyUnit;
	}


	public void setFrequencyUnit(Unit frequencyUnit) {
		this.frequencyUnit = frequencyUnit;
	}

	@Column(name = "DESCRIPTION",  nullable = true, length = 2000)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRAND_ID", nullable = true)
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROD_ID", nullable = true)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductRepeatOption [brand=" + brand + ", product=" + product
				+ ", code=" + code + ", frequencyValue=" + frequencyValue
				+ ", frequencyUnit=" + frequencyUnit + ", description="
				+ description + ", id=" + id + "]";
	}

	@Override
	public int compareTo(ProductRepeatOrderType o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((frequencyUnit == null) ? 0 : frequencyUnit.hashCode());
		result = prime * result
				+ ((frequencyValue == null) ? 0 : frequencyValue.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		ProductRepeatOrderType other = (ProductRepeatOrderType) obj;
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
		if (frequencyUnit != other.frequencyUnit)
			return false;
		if (frequencyValue == null) {
			if (other.frequencyValue != null)
				return false;
		} else if (!frequencyValue.equals(other.frequencyValue))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	
}
