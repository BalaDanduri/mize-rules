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
	public Set<Category> category;
	public String logoLink;
	public Integer avgRating;

	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	

	public Product(Long id, String name, String shortDescription, Brand brand,
			Float price, Set<Category> category, String logoLink,
			Integer avgRating) {
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.logoLink = logoLink;
		this.avgRating = avgRating;
	}

	

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		
		Product prd = new Product();
		prd.id = new Long(1);
		prd.name = "Sample Product";
		prd.shortDescription = "Sample short Description";
		prd.brand = new Brand(1, "Sample Brand", "http://brand.co.in/");
		prd.price = 110.34F;
		prd.category= new HashSet<Category>();
		Category cat1 = new Category();
		
		cat1.id = new Long(1);
		cat1.name = "sample category";
		prd.category.add(cat1);
		prd.logoLink = "sampleprd.png";
		prd.avgRating = new Integer(3);
		
		List prdList = new ArrayList();
		
		prdList.add(prd);
		
		Product prd1 = new Product();
		prd1.id = new Long(2);
		prd1.name = "Sample Product 2 ";
		prd1.shortDescription = "Sample short Description -- new ";
		prd1.brand = new Brand(1, "Sample Brand", "http://brand.co.in/");
		prd1.price = 110.34F;
		prd1.category= new HashSet<Category>();
		Category cat2 = new Category();
		cat2.id = new Long(2);
		cat2.name = "sample category 2 ";
		
		prd1.category.add(cat2);
		
		prd1.logoLink = "sampleprd.png";
		prd1.avgRating = new Integer(3);
		
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
				+ ((logoLink == null) ? 0 : logoLink.hashCode());
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
		if (logoLink == null) {
			if (other.logoLink != null)
				return false;
		} else if (!logoLink.equals(other.logoLink))
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
				+ ", category=" + category + ", logoLink=" + logoLink
				+ ", avgRating=" + avgRating + "]";
	}
}
