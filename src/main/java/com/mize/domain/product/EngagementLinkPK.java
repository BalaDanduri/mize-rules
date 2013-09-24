package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import com.mize.domain.common.MizeEntity;

@Embeddable
public class EngagementLinkPK  extends MizeEntity{

	private static final long serialVersionUID = 3572751841558747212L;
	
	@Column(name = "engagement_options_id",  nullable = true, length = 20)
	private Long engagementOptionsId;
	@Column(name = "prod_cat_id",  nullable = true, length = 15)
	private Integer prodCatId;
	@Column(name = "prod_id",  nullable = true, length = 20)
	private Long productId;
	@Column(name = "brand_id",  nullable = true, length = 20)
	private Long brandId;
	
	public EngagementLinkPK(){
		
	}
	
	public EngagementLinkPK(Long engagementOptionsId, Integer prodCatId, Long productId) {
		super();
		this.engagementOptionsId = engagementOptionsId;
		this.prodCatId = prodCatId;
		this.productId = productId;
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

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
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
		EngagementLinkPK other = (EngagementLinkPK) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
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

	@Override
	public String toString() {
		return "EngagementLinkPK [engagementOptionsId=" + engagementOptionsId + ", prodCatId=" + prodCatId
				+ ", productId=" + productId + ", brandId=" + brandId + "]";
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

}
