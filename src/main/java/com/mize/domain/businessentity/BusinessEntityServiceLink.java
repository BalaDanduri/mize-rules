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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.brand.Brand;
import com.mize.domain.common.Country;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.common.State;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductCategory;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.PopulateCountry;
import com.mize.domain.util.PopulateState;

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
	private String geoType;
	private String geoValue;
	private String serviceArea;
	@PopulateState
	private State state;
	private Long stateId;
	@PopulateCountry
	private Country country;
	private Long countryId;
	private String isPromoted;
	

	public BusinessEntityServiceLink(){
	}
	
	public BusinessEntityServiceLink(BusinessEntity businessEntity,
			Brand brand, ProductCategory productCategory, Product product,
			Long radius, String radiusUom, String geoType, String geoValue,
			String serviceArea, State state, Country country, String isPromoted) {
		super();
		this.businessEntity = businessEntity;
		this.brand = brand;
		this.productCategory = productCategory;
		this.product = product;
		this.radius = radius;
		this.radiusUom = radiusUom;
		this.geoType = geoType;
		this.geoValue = geoValue;
		this.serviceArea = serviceArea;
		this.state = state;
		this.country = country;
		this.isPromoted = isPromoted;
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
	
	@Column(name = "geo_type")
	public String getGeoType() {
		return geoType;
	}
	
	@Column(name = "geo_value")
	public String getGeoValue() {
		return geoValue;
	}
	
	@Column(name = "srvc_area")
	public String getServiceArea() {
		return serviceArea;
	}
	
	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")*/
	@Transient
	public Country getCountry() {
		return country;
	}
	
	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "state_id")*/
	@Transient
	public State getState() {
		return state;
	}
	
	@Column(name = "is_promoted")
	public String getIsPromoted() {
		return isPromoted;
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
	
	public void setGeoType(String geoType) {
		this.geoType = geoType;
	}
	
	public void setGeoValue(String geoValue) {
		this.geoValue = geoValue;
	}
	
	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public void setIsPromoted(String isPromoted) {
		this.isPromoted = isPromoted;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((geoType == null) ? 0 : geoType.hashCode());
		result = prime * result
				+ ((geoValue == null) ? 0 : geoValue.hashCode());
		result = prime * result
				+ ((isPromoted == null) ? 0 : isPromoted.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((productCategory == null) ? 0 : productCategory.hashCode());
		result = prime * result + ((radius == null) ? 0 : radius.hashCode());
		result = prime * result
				+ ((radiusUom == null) ? 0 : radiusUom.hashCode());
		result = prime * result
				+ ((serviceArea == null) ? 0 : serviceArea.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (geoType == null) {
			if (other.geoType != null)
				return false;
		} else if (!geoType.equals(other.geoType))
			return false;
		if (geoValue == null) {
			if (other.geoValue != null)
				return false;
		} else if (!geoValue.equals(other.geoValue))
			return false;
		if (isPromoted == null) {
			if (other.isPromoted != null)
				return false;
		} else if (!isPromoted.equals(other.isPromoted))
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
		if (serviceArea == null) {
			if (other.serviceArea != null)
				return false;
		} else if (!serviceArea.equals(other.serviceArea))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusinessEntityServiceLink [brand=" + brand
				+ ", productCategory=" + productCategory + ", product="
				+ product + ", radius=" + radius + ", radiusUom=" + radiusUom
				+ ", geoType=" + geoType + ", geoValue=" + geoValue
				+ ", serviceArea=" + serviceArea + ", state=" + state
				+ ", country=" + country + ", isPromoted=" + isPromoted + "]";
	}

	@Override
	public int compareTo(BusinessEntity arg0) {
		return 0;
	}
	
	@Column(name = "country_id")
	@JsonIgnore
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
	@Column(name = "state_id")
	@JsonIgnore
	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

}
