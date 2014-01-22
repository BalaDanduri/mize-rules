package com.mize.domain.etilize;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductCategory;
import com.mize.domain.product.ProductContent;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class Product extends MizeEntity{

	private static final long serialVersionUID = 6738887069779058581L;
	private Long manufacturerId;
	private Integer isActive;
	private String mfgPartNo;	
	private Double equivalency;
	private String brandName;
	private Long categoryId;
	private Integer isAccesory;
	private Long brandId;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime modifiedDate;
	private List<ProductAccessories> accessories = new ArrayList<ProductAccessories>();
	private ProductDescription prdDescription;
	private List<ProductImages>  images = new ArrayList<ProductImages>();
	private ProductSummaryDesc summaryDesc;
	private List<SimilarProduct> similarProducts = new ArrayList<SimilarProduct>();
	private String name;
	private String description;
	private String upc;
	private String model;
	private Integer isConsumable;
	private ProductPrice productPrice;
	private Long prodId;
	private List<ProductCategory> categories = new ArrayList<ProductCategory>();
	private List<ProductKeywords> keywords = new ArrayList<ProductKeywords>();
	private List<ProductAttribute> attributes = new ArrayList<ProductAttribute>();
	private List<ProductContent> contents = new ArrayList<ProductContent>();
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getMfgPartNo() {
		return mfgPartNo;
	}
	public void setMfgPartNo(String mfgPartNo) {
		this.mfgPartNo = mfgPartNo;
	}
	public Long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	
	
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getIsAccesory() {
		return isAccesory;
	}
	public void setIsAccesory(Integer isAccesory) {
		this.isAccesory = isAccesory;
	}
	
	
	public Double getEquivalency() {
		return equivalency;
	}
	public void setEquivalency(Double equivalency) {
		this.equivalency = equivalency;
	}
	public List<ProductAccessories> getAccessories() {
		return accessories;
	}
	public void setAccessories(List<ProductAccessories> accessories) {
		this.accessories = accessories;
	}
	
	public ProductDescription getPrdDescription() {
		return prdDescription;
	}
	public void setPrdDescription(ProductDescription prdDescription) {
		this.prdDescription = prdDescription;
	}
	public List<ProductImages> getImages() {
		return images;
	}
	public void setImages(List<ProductImages> images) {
		this.images = images;
	}
	
	public ProductSummaryDesc getSummaryDesc() {
		return summaryDesc;
	}
	public void setSummaryDesc(ProductSummaryDesc summaryDesc) {
		this.summaryDesc = summaryDesc;
	}
	public List<SimilarProduct> getSimilarProducts() {
		return similarProducts;
	}
	public void setSimilarProducts(List<SimilarProduct> similarProducts) {
		this.similarProducts = similarProducts;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getModifiedDate() {
		return modifiedDate;
	}
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setModifiedDate(DateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Integer getIsConsumable() {
		return isConsumable;
	}

	public void setIsConsumable(Integer isConsumable) {
		this.isConsumable = isConsumable;
	}

	public ProductPrice getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(ProductPrice productPrice) {
		this.productPrice = productPrice;
	}	
	
	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public List<ProductKeywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<ProductKeywords> keywords) {
		this.keywords = keywords;
	}

	public List<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}

	public List<ProductAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ProductAttribute> attributes) {
		this.attributes = attributes;
	}

	public List<ProductContent> getContents() {
		return contents;
	}

	public void setContents(List<ProductContent> contents) {
		this.contents = contents;
	}
	
}
