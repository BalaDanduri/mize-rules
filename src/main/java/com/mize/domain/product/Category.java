package com.mize.domain.product;


import java.io.IOException;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mize.domain.common.Entity;

@JsonPropertyOrder ({"id", "name", "link", "parent"})

public class Category {

	
	public Long id;
	public String name;
	public String link;
	public Category parent;
	@JsonIgnore
	public Set<Category> children;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	
	public Category(Long id, String name, String link, Category parent) {
		this.id = id;
		this.name = name;
		this.link = link;
		this.parent = parent;
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

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
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
		return "Category [id=" + id + ", name=" + name + ", link=" + link
				+ ", parent=" + parent + "]";
	}

	
	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		
		Category cat1 = new Category(new Long(1), "Electronics", null, null );
		Category cat2 = new Category(new Long(2), "Computer", null, cat1 );
		Category cat3 = new Category(new Long(3), "Laptop", null, cat2 );
		
		System.out.println(new ObjectMapper().writeValueAsString(cat3));
		
	}


	@JsonIgnore
	public Set<Category> getChildren() {
		return children;
	}

	@JsonIgnore
	public void setChildren(Set<Category> children) {
		this.children = children;
	}
}
