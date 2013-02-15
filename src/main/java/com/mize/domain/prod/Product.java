package com.mize.domain.prod;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class Product extends Entity{

	private static final long serialVersionUID = 6738887069779058581L;
	private Long id;	
	private Long manufacturerId;
	private Integer isActive;
	private String mfgPartNo;	
	private Double equivalency;
		
	private Long categoryId;
	private Integer isAccesory;
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime modifiedDate;
	
	private ProductAccessories accessories;
	private ProductAttribute attribute;
	private ProductDescription prdDescription;
	private List<ProductImages>  images;
	private ProductMarket market;
	private ProductMultimedia multimedia;
	private ProductSku sku;
	private ProductSummaryDesc summaryDesc;
	private List<SimilarProduct> similarProducts;
	
	
	public Long getId() {
		return id;
	}
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
	public ProductAccessories getAccessories() {
		return accessories;
	}
	public void setAccessories(ProductAccessories accessories) {
		this.accessories = accessories;
	}
	public ProductAttribute getAttribute() {
		return attribute;
	}
	public void setAttribute(ProductAttribute attribute) {
		this.attribute = attribute;
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
	public ProductMarket getMarket() {
		return market;
	}
	public void setMarket(ProductMarket market) {
		this.market = market;
	}
	public ProductMultimedia getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(ProductMultimedia multimedia) {
		this.multimedia = multimedia;
	}
	public ProductSku getSku() {
		return sku;
	}
	public void setSku(ProductSku sku) {
		this.sku = sku;
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
	
	
}
