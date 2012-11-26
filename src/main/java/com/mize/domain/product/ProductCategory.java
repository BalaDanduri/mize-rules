package com.mize.domain.product;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mize.domain.common.Entity;

@JsonPropertyOrder ({"id", "name", "link", "parent"})

public class ProductCategory {

	
	protected Long id;
	protected String name;
	protected String photoLink;
	protected ProductCategory parent;
	@JsonIgnore
	protected Set<ProductCategory> children;
	protected boolean isLeaf;
	protected ProdCategorySource sourceCategory;
	
	public ProductCategory() {
		// TODO Auto-generated constructor stub
		parent = new ProductCategory();
		children = new HashSet<ProductCategory>();
		sourceCategory = new ProdCategorySource();
	}

	
//	public ProductCategory(Long id, String name, String link, ProductCategory parent) {
//		this.id = id;
//		this.name = name;
//		this.photoLink = link;
//		this.parent = parent;
//	}
//

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

	public ProductCategory getParent() {
		return parent;
	}

	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String link) {
		this.photoLink = link;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((photoLink == null) ? 0 : photoLink.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		ProductCategory other = (ProductCategory) obj;
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
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", link=" + photoLink
				+ ", parent=" + parent + "]";
	}

	
	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		
//		ProductCategory cat1 = new ProductCategory(new Long(1), "Electronics", null, null );
//		ProductCategory cat2 = new ProductCategory(new Long(2), "Computer", null, cat1 );
//		ProductCategory cat3 = new ProductCategory(new Long(3), "Laptop", null, cat2 );
//		
//		System.out.println(new ObjectMapper().writeValueAsString(cat3));
		
	}


	@JsonIgnore
	public Set<ProductCategory> getChildren() {
		return children;
	}

	@JsonIgnore
	public void setChildren(Set<ProductCategory> children) {
		this.children = children;
	}


	public boolean isLeaf() {
		return isLeaf;
	}


	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	public ProdCategorySource getSourceCategory() {
		return sourceCategory;
	}


	public void setSourceCategory(ProdCategorySource sourceCategory) {
		this.sourceCategory = sourceCategory;
	}
}
