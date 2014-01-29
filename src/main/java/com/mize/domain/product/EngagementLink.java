package com.mize.domain.product;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="engagement_options_link")
public class EngagementLink extends MizeEntity{
	private static final long serialVersionUID = 8076842078721402700L;
	
	
	@Transient
	private Long engagementOptionsId;
	@Transient
	private Integer prodCatId;
	@Transient
	private Long productId;
	@Transient
	private Long brandId;
	@EmbeddedId
	private EngagementLinkPK engagementLinkPK;
	
	private Product product;
	private Brand brand;
	private ProductCategory productCategory;
	
	
	
	public EngagementLink(){
		
	}

	public EngagementLink(Long engagementOptionsId, Integer prodCatId, Long productId, EngagementLinkPK engagementLinkPK) {
		super();
		this.engagementOptionsId = engagementOptionsId;
		this.prodCatId = prodCatId;
		this.productId = productId;
		this.engagementLinkPK = engagementLinkPK;
	}

	@Transient
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getEngagementOptionsId() {
		return engagementOptionsId;
	}

	public void setEngagementOptionsId(Long engagementOptionsId) {
		this.engagementOptionsId = engagementOptionsId;
	}

	public Integer getProdCatId() {
		return prodCatId;
	}

	public void setProdCatId(Integer prodCatId) {
		this.prodCatId = prodCatId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public EngagementLinkPK getEngagementLinkPK() {
		return engagementLinkPK;
	}

	public void setEngagementLinkPK(EngagementLinkPK engagementLinkPK) {
		this.engagementLinkPK = engagementLinkPK;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((engagementLinkPK == null) ? 0 : engagementLinkPK.hashCode());
		result = prime * result + ((engagementOptionsId == null) ? 0 : engagementOptionsId.hashCode());
		result = prime * result + ((prodCatId == null) ? 0 : prodCatId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		EngagementLink other = (EngagementLink) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (engagementLinkPK == null) {
			if (other.engagementLinkPK != null)
				return false;
		} else if (!engagementLinkPK.equals(other.engagementLinkPK))
			return false;
		if (engagementOptionsId == null) {
			if (other.engagementOptionsId != null)
				return false;
		} else if (!engagementOptionsId.equals(other.engagementOptionsId))
			return false;
		if (prodCatId == null) {
			if (other.prodCatId != null)
				return false;
		} else if (!prodCatId.equals(other.prodCatId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "EngagementLink [engagementOptionsId=" + engagementOptionsId
				+ ", prodCatId=" + prodCatId + ", productId=" + productId
				+ ", brandId=" + brandId + ", engagementLinkPK="
				+ engagementLinkPK + ", product=" + product + ", brand="
				+ brand + ", productCategory=" + productCategory + ", id=" + id
				+ "]";
	}
	
}
