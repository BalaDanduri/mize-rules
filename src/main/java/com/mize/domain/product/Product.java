package com.mize.domain.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.Entity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.NumberValueDeserializer;
import com.mize.domain.util.NumberValueSerializer;

public class Product  extends Entity{
	
	private static final long serialVersionUID = 5379538452565383073L;
	protected Long id;
	protected String name;
	protected Brand brand = new Brand();
	protected Double price;
	protected Set<ProductCategory> category = new HashSet<ProductCategory>();
	private String shortDescription;
	protected String upc;
	protected String qrCode;
	protected ProductSource productSource = new ProductSource();
	protected Double mizeRating;
	protected String imageLink;
	private List<String> listNames ;
	private ProductDetails productDetails;
	private String model;
	private String productLink;
	
	public enum Source{
		MIZE(1),AMAZON(2),ETILIZE(3),BestBuy(4);
		int value;
		Source(int val){
			value = val;
		}
		public int getValue(){
			return value;
		}
	}	
	public Product() {
		category = new HashSet<ProductCategory>();
		productSource = new ProductSource();
		productDetails = new ProductDetails();
	}

	public ProductSource getProductSource() {
		return productSource;
	}


	public void setProductSource(ProductSource productSource) {
		this.productSource = productSource;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@JsonSerialize(using=NumberValueSerializer.class)
	public Double getPrice() {
		return price;
	}

	@JsonDeserialize(using=NumberValueDeserializer.class)	
	public void setPrice(Double price) {
		this.price = price;
	}


	public Set<ProductCategory> getCategory() {
		return category;
	}


	public void setCategory(Set<ProductCategory> category) {
		this.category = category;
	}

	public String getUpc() {
		return upc;
	}


	public void setUpc(String upc) {
		this.upc = upc;
	}


	public String getQrCode() {
		return qrCode;
	}


	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	
	public Double getMizeRating() {
		return mizeRating;
	}


	public void setMizeRating(Double mizeRating) {
		this.mizeRating = mizeRating;
	}


	public ProductDetails getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}


	public String getImageLink() {
		return imageLink;
	}


	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}


	public List<String> getListNames() {
		return listNames;
	}


	public void setListNames(List<String> listNames) {
		this.listNames = listNames;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public String getProductLink() {
		return productLink;
	}


	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}	
	
	@JsonIgnore
	public boolean isAmazonSource(){
		boolean flag = false;
		if(Formatter.longValue(getProductSource().getSourceId()) == Source.AMAZON.getValue()){
			flag = true;
		}
		return flag;
	}
	@JsonIgnore
	public boolean isMizeSource(){
		return (!isAmazonSource());
	}

}
