package com.mize.domain.product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mize.domain.brand.Brand;
import com.mize.domain.common.Entity;

public class Product  extends Entity{
	
	protected Long id;
	protected String name;
	protected Brand brand = new Brand();
	protected Double price;
	protected Set<ProductCategory> category = new HashSet<ProductCategory>();
	private String shortDescription;
	protected Double avgRating;
	protected String upc;
	protected String qrCode;
	protected ProductSource productSource = new ProductSource();
	protected Double mizeRating;
	protected String imageLink;
	private List<String> listNames ;
	private ProductDetails productDetails;
	private String model;

	
	public Product() {
		// TODO Auto-generated constructor stub
		category = new HashSet<ProductCategory>();
		productSource = new ProductSource();
		productDetails = new ProductDetails();
	}
	

//	public Product(Long id, String name, String shortDescription, Brand brand,
//			Float price, Set<ProductCategory> category, String logoLink,
//			Integer avgRating) {
//		this.id = id;
//		this.name = name;
//		this.shortDescription = shortDescription;
//		this.brand = brand;
//		this.price = price;
//		this.category = category;
//		this.photoLink = logoLink;
//		this.avgRating = avgRating;
//	}
//
	

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
		prd.avgRating = new Double(3);
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
		
		prd1.avgRating = new Double(3);
		prd1.productSource = new ProductSource();
		//new Long(1), new Long(1), "BSX1s87A12"
		prd1.productSource.setProductId(new Long(1));
		prd1.productSource.setSourceId(new Long(1));
		prd1.productSource.setSourceProductId("BSX1s87A12");
		
		prdList.add(prd1);
		System.out.println(new ObjectMapper().writeValueAsString(prdList));
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((avgRating == null) ? 0 : avgRating.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());		
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());		
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
		Product other = (Product) obj;
		if (avgRating == null) {
			if (other.avgRating != null)
				return false;
		} else if (!avgRating.equals(other.avgRating))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		
		return true;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price
				+ ", category=" + category + ", logoLink="
				+ ", avgRating=" + avgRating + "]";
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

	


	public Double getAvgRating() {
		return avgRating;
	}


	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
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
	
}
