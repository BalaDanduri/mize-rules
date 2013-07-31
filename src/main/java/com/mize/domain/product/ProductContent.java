package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_content")
public class ProductContent extends MizeEntity{
	
	private static final long serialVersionUID = -76159028571766886L;
	
	@EmbeddedId
	private ProductContentPK productContentPK;
	private String title;
	private String description;
	private String url;
	@Transient
	private Integer pageIndex;	
	@Transient
    private String brandName;
    @Transient
    private String productName;
    @Transient
    private String contentType;
    @Transient
    private Integer seqNo;


	public ProductContent(){
		
	}	
	
	public ProductContent(ProductContentPK productContentPK, String title, String description, String url,
			Integer pageIndex) {
		super();
		this.productContentPK = productContentPK;
		this.title = title;
		this.description = description;
		this.url = url;
		this.pageIndex = pageIndex;
	}


	public enum ContentType{
		faq,video,manuals; 
	}
	
	public static ContentType getContentType(String num){
		for (ContentType cType : ContentType.values()) {
			if( cType.toString().equals(num) ){
				return cType;
			}
		}
		return null;
	}
	
	@Column(name = "title",  nullable = true, length = 250)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name = "description",  nullable = true, length = 1000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "url",  nullable = true, length = 250)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Transient
	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
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

	public ProductContentPK getProductContentPK() {
		return productContentPK;
	}

	public void setProductContentPK(ProductContentPK productContentPK) {
		this.productContentPK = productContentPK;
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
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result
				+ ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((pageIndex == null) ? 0 : pageIndex.hashCode());
		result = prime
				* result
				+ ((productContentPK == null) ? 0 : productContentPK.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((seqNo == null) ? 0 : seqNo.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		ProductContent other = (ProductContent) obj;
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
		if (productContentPK == null) {
			if (other.productContentPK != null)
				return false;
		} else if (!productContentPK.equals(other.productContentPK))
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductContent [productContentPK=" + productContentPK
				+ ", title=" + title + ", description=" + description
				+ ", url=" + url + ", pageIndex=" + pageIndex + ", brandName="
				+ brandName + ", productName=" + productName + ", contentType="
				+ contentType + ", seqNo=" + seqNo + "]";
	}
	
}
