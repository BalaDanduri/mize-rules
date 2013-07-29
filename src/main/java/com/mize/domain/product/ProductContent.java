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



	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((pageIndex == null) ? 0 : pageIndex.hashCode());
		result = prime * result + ((productContentPK == null) ? 0 : productContentPK.hashCode());
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
		return "ProductContent [productContentPK=" + productContentPK + ", title=" + title + ", description="
				+ description + ", url=" + url + ", pageIndex=" + pageIndex + "]";
	}
	
	
}
