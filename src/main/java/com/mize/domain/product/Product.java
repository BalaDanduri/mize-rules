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

public class Product  {
	
	public Long id;
	public String name;
	public String shortDescription;
	public Brand brand;
	public Float price;
	public Set<ProductCategory> category;
	public String photoLink;
	public Integer avgRating;
	public Long upc;
	public String qrCode;
	public ProductSource productSource;
	public Integer mizeRating;
	

	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	public Product(Long id, String name, String shortDescription, Brand brand,
			Float price, Set<ProductCategory> category, String logoLink,
			Integer avgRating) {
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.photoLink = logoLink;
		this.avgRating = avgRating;
	}

	

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		
		Product prd = new Product();
		prd.id = new Long(1);
		prd.name = "Sample Product";
		prd.shortDescription = "Sample short Description";
		prd.brand = new Brand(1, "Sample Brand", "http://brand.co.in/");
		prd.price = 110.34F;
		prd.category= new HashSet<ProductCategory>();
		ProductCategory cat1 = new ProductCategory();
		
		cat1.id = new Long(1);
		cat1.name = "sample category";
		prd.category.add(cat1);
		prd.photoLink = "sampleprd.png";
		prd.avgRating = new Integer(3);
		prd.productSource = new ProductSource(new Long(1), new Long(1), "ASD10987A");
		
		
		List prdList = new ArrayList();
		
		prdList.add(prd);
		
		Product prd1 = new Product();
		prd1.id = new Long(2);
		prd1.name = "Sample Product 2 ";
		prd1.shortDescription = "Sample short Description -- new ";
		prd1.brand = new Brand(1, "Sample Brand", "http://brand.co.in/");
		prd1.price = 110.34F;
		prd1.category= new HashSet<ProductCategory>();
		ProductCategory cat2 = new ProductCategory();
		cat2.id = new Long(2);
		cat2.name = "sample category 2 ";
		
		prd1.category.add(cat2);
		
		prd1.photoLink = "sampleprd.png";
		prd1.avgRating = new Integer(3);
		prd1.productSource = new ProductSource(new Long(1), new Long(1), "BSX1s87A12");
		
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
		result = prime * result
				+ ((photoLink == null) ? 0 : photoLink.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime
				* result
				+ ((shortDescription == null) ? 0 : shortDescription.hashCode());
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
		if (photoLink == null) {
			if (other.photoLink != null)
				return false;
		} else if (!photoLink.equals(other.photoLink))
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
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", shortDescription="
				+ shortDescription + ", brand=" + brand + ", price=" + price
				+ ", category=" + category + ", logoLink=" + photoLink
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


	public String getShortDescription() {
		return shortDescription;
	}


	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public Set<ProductCategory> getCategory() {
		return category;
	}


	public void setCategory(Set<ProductCategory> category) {
		this.category = category;
	}


	public String getPhotoLink() {
		return photoLink;
	}


	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}


	public Integer getAvgRating() {
		return avgRating;
	}


	public void setAvgRating(Integer avgRating) {
		this.avgRating = avgRating;
	}


	public Long getUpc() {
		return upc;
	}


	public void setUpc(Long upc) {
		this.upc = upc;
	}


	public String getQrCode() {
		return qrCode;
	}


	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}


	public Integer getMizeRating() {
		return mizeRating;
	}


	public void setMizeRating(Integer mizeRating) {
		this.mizeRating = mizeRating;
	}
}
