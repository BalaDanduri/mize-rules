package com.mize.domain.product;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;


@JsonPropertyOrder ({"id", "name", "link", "parent"})
@Entity
@Table(name = "prod_cat")

public class ProductCategory extends MizeSceEntity implements Comparable<ProductCategory>{

	private static final long serialVersionUID = -2450196415219764436L;
	@JsonIgnore
	private Long srcCategoryId;
	private String name;
	private String photoLink;
	private ProductCategory parent = null;
	@JsonIgnore
	private Set<ProductCategory> children = new HashSet<ProductCategory>();
	private ProdCategorySource sourceCategory  = new ProdCategorySource();
	private String department;
	private Integer level;
	@JsonIgnore
	private Integer displayOrder;
	@JsonIgnore
	private Integer orderNumber;
	@Transient
	private boolean isActive;
	@JsonIgnore
	private Integer active;
	private BusinessEntity tenant;
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}	
	
	public ProductCategory() {
		
	}
	
	@Id
	@GenericGenerator(name="prod_cat_id",strategy="increment")
	@GeneratedValue
	@Column(name="prod_cat_id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="prod_cat_name",nullable=true,length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@OneToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name="prod_cat_id")
	//@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@Transient
	public ProductCategory getParent() {
		return parent;
	}

	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}

	@Column(name="prod_cat_link",nullable=true,length=250)
	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String link) {
		this.photoLink = link;
	}

	@Column(name="is_active",nullable=true,length=1)
	@Transient
	public boolean isActive() {
		return isActive;
	}
	
	@JsonIgnore
	@Transient
	public Set<ProductCategory> getChildren() {
		return children;
	}

	@JsonIgnore
	public void setChildren(Set<ProductCategory> children) {
		this.children = children;
	}

	@Transient
	public boolean isLeaf() {
		if ((children == null || children.isEmpty()) ) {
			return true;
		} else {
			return false;
		}
	}

	public void setLeaf(boolean leaf) {
	}

	@Transient
	public ProdCategorySource getSourceCategory() {
		return sourceCategory;
	}

	public void setSourceCategory(ProdCategorySource sourceCategory) {
		this.sourceCategory = sourceCategory;
	}

	@Column(name="cat_level",nullable=true,length=11)
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Transient
	public Long getSrcCategoryId() {
		return srcCategoryId;
	}

	public void setSrcCategoryId(Long srcCategoryId) {
		this.srcCategoryId = srcCategoryId;
	}

	@Column(name="display_order",nullable=true,length=11)
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Column(name="order_number",nullable=true,length=11)
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Transient
	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JoinColumn(name="tenant_id") 
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", name=" + name + ", photoLink="
				+ photoLink + ","
				+ ", sourceCategory=" + sourceCategory + ", department="
				+ department + ", isActive=" + isActive + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = 1;
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((photoLink == null) ? 0 : photoLink.hashCode());
		result = prime * result
				+ ((sourceCategory == null) ? 0 : sourceCategory.hashCode());
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
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
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

	@Override
	public int compareTo(ProductCategory o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
