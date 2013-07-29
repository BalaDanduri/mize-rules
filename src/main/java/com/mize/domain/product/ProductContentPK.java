package com.mize.domain.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductContentPK implements Serializable{
	private static final long serialVersionUID = -6784825869865743206L;
	
	@Column(name = "brand_name",  nullable = true, length = 250,insertable=false,updatable=false)
	private String brandName;
	@Column(name = "product_name",  nullable = true, length = 250)
	private String productName;
	@Column(name = "content_type",  nullable = true, length = 50)
	private String contentType;
	@Column(name = "seq_no",  nullable = true)
	private Integer seqNo;
	
	
	public ProductContentPK(){
		
	}
	
	public ProductContentPK(String brandName, String productName, String contentType, Integer seqNo) {
		super();
		this.brandName = brandName;
		this.productName = productName;
		this.contentType = contentType;
		this.seqNo = seqNo;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public Integer getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((seqNo == null) ? 0 : seqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductContentPK other = (ProductContentPK) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (seqNo == null) {
			if (other.seqNo != null)
				return false;
		} else if (!seqNo.equals(other.seqNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductContentPK [brandName=" + brandName + ", productName=" + productName + ", contentType="
				+ contentType + ", seqNo=" + seqNo + "]";
	}
	
}
