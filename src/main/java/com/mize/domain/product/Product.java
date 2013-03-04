package com.mize.domain.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.Entity;
import com.mize.domain.util.NumberValueSerializer;

public class Product  extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5379538452565383073L;
	protected Long id;
	protected String name;
	protected Brand brand = new Brand();
	@JsonSerialize(using=NumberValueSerializer.class)
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

	
	public Product() {
		// TODO Auto-generated constructor stub
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


	public Double getPrice() {
		return price;
	}


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
	


	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		
		Product prd = new Product();
		prd.id = new Long(1);
		prd.name = "Sample Product";
		prd.brand = new Brand(1, "Sample Brand", "http://brand.co.in/");
		prd.price = 110.34;
		prd.category= new HashSet<ProductCategory>();
		ProductCategory cat1 = new ProductCategory();
		
		cat1.id = new Long(1);
		cat1.name = "sample category";
		prd.category.add(cat1);
		prd.productSource = new ProductSource();
		prd.productSource.setProductId(new Long(1));
		prd.productSource.setSourceId(new Long(1));
		prd.productSource.setSourceProductId("BSX1s87A12");
		
		
		List prdList = new ArrayList();
		
		prdList.add(prd);
		
		Product prd1 = new Product();
		prd1.id = new Long(2);
		prd1.name = "Sample Product 2 ";
		prd1.brand = new Brand(1, "Sample Brand", "http://brand.co.in/");
		prd1.price = 110.34;
		prd1.category= new HashSet<ProductCategory>();
		ProductCategory cat2 = new ProductCategory();
		cat2.id = new Long(2);
		cat2.name = "sample category 2 ";
		
		prd1.category.add(cat2);
		prd1.productSource = new ProductSource();
		//new Long(1), new Long(1), "BSX1s87A12"
		prd1.productSource.setProductId(new Long(1));
		prd1.productSource.setSourceId(new Long(1));
		prd1.productSource.setSourceProductId("BSX1s87A12");
		
		prdList.add(prd1);
		System.out.println(new ObjectMapper().writeValueAsString(prdList));
		
	}

}
