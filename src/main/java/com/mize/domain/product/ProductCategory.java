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
	protected ProductCategory parent = null;
	@JsonIgnore
	protected Set<ProductCategory> children = new HashSet<ProductCategory>();
	protected ProdCategorySource sourceCategory  = new ProdCategorySource();
	protected boolean isActive;
	
	public ProductCategory() {
		
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


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", link=" + photoLink
				+ ", parent=" + parent + "]";
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
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
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
		if (photoLink == null) {
			if (other.photoLink != null)
				return false;
		} else if (!photoLink.equals(other.photoLink))
			return false;
		if (sourceCategory == null) {
			if (other.sourceCategory != null)
				return false;
		} else if (!sourceCategory.equals(other.sourceCategory))
			return false;
		return true;
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
		if ((children == null || children.isEmpty()) ) {
//		if ((children == null || children.isEmpty()) && (parent!= null)) {
			return true;
		} else {
			return false;
		}
	}

	public void setLeaf(boolean leaf) {
		// Not needed as it is based on the Children
	}


	public ProdCategorySource getSourceCategory() {
		return sourceCategory;
	}


	public void setSourceCategory(ProdCategorySource sourceCategory) {
		this.sourceCategory = sourceCategory;
	}
}
