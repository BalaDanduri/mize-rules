package com.mize.domain.etilize;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
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
	private ProductAttribute attribute;
	private ProductDescription prdDescription;
	private List<ProductImages>  images = new ArrayList<ProductImages>();
	private ProductMarket market;
	private ProductMultimedia multimedia;
	private ProductSku sku;
	private ProductSummaryDesc summaryDesc;
	private List<SimilarProduct> similarProducts = new ArrayList<SimilarProduct>();
	private String name;
	private String description;
	private String upc;
	private String model;
	private Integer isConsumable;
	private ProductPrice productPrice;
	
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
	
	@Override
	public String toString() {
		return "Product [manufacturerId=" + manufacturerId + ", isActive="
				+ isActive + ", mfgPartNo=" + mfgPartNo + ", equivalency="
				+ equivalency + ", categoryId=" + categoryId + ", isAccesory="
				+ isAccesory + ", modifiedDate=" + modifiedDate
				+ ", accessories=" + accessories + ", attribute=" + attribute
				+ ", prdDescription=" + prdDescription + ", images=" + images
				+ ", market=" + market + ", multimedia=" + multimedia
				+ ", sku=" + sku + ", summaryDesc=" + summaryDesc
				+ ", similarProducts=" + similarProducts + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy="
				+ updatedBy + ", updatedDate=" + updatedDate + ", id=" + id
				+ "]";
	}

	
	
}
