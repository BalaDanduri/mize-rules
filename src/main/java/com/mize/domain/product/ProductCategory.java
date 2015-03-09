package com.mize.domain.product;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.TenantSerializer;


@JsonPropertyOrder ({"id", "name", "link", "parent"})
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
@Table(name = "prod_cat")
public class ProductCategory extends MizeSceEntityAudit implements Comparable<ProductCategory>{

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
	private String categoryCode;
	private List<ProductCategoryIntl> intls = new ArrayList<ProductCategoryIntl>();
	
	private User user;
	
	public ProductCategory() {
		super();
	}
	
	public ProductCategory(Long srcCategoryId, String name, String photoLink,
			ProductCategory parent, Set<ProductCategory> children,
			ProdCategorySource sourceCategory, String department,
			Integer level, Integer displayOrder, Integer orderNumber,
			boolean isActive, Integer active, BusinessEntity tenant,
			String categoryCode, List<ProductCategoryIntl> intls) {
		super();
		this.srcCategoryId = srcCategoryId;
		this.name = name;
		this.photoLink = photoLink;
		this.parent = parent;
		this.children = children;
		this.sourceCategory = sourceCategory;
		this.department = department;
		this.level = level;
		this.displayOrder = displayOrder;
		this.orderNumber = orderNumber;
		this.isActive = isActive;
		this.active = active;
		this.tenant = tenant;
		this.categoryCode = categoryCode;
		this.intls = intls;
	}

	public ProductCategory(Long id, String code ,String name,String desc) {
		this.id = id;
		this.categoryCode = code;
		this.name = name;
		this.intls = new ArrayList<ProductCategoryIntl>();
		ProductCategoryIntl categoryIntl = new ProductCategoryIntl();
		categoryIntl.setName(name);
		categoryIntl.setDescription(desc);
		this.getIntls().add(categoryIntl);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="prod_cat_id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="prod_cat_name", length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public ProductCategory getParent() {
		return parent;
	}

	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}

	@Column(name="prod_cat_link", length = 250)
	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String link) {
		this.photoLink = link;
	}

	@Column(name="is_active")
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

	@Column(name="cat_level")
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

	@Column(name="display_order")
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Column(name="order_number")
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
	@JsonSerialize(using = TenantSerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JoinColumn(name="tenant_id") 
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column(name = "prod_cat_code", length = 100, nullable = true)
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Column(name = "department", length = 25, nullable = true)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "productCategory" ,orphanRemoval= true)
	@Fetch(FetchMode.SELECT)
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ProductCategoryIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<ProductCategoryIntl> intls) {
		this.intls = intls;
	}
	
	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((categoryCode == null) ? 0 : categoryCode.hashCode());
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result
				+ ((displayOrder == null) ? 0 : displayOrder.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result
				+ ((photoLink == null) ? 0 : photoLink.hashCode());
		result = prime
				* result
				+ ((intls == null) ? 0 : intls
						.hashCode());
		result = prime * result
				+ ((sourceCategory == null) ? 0 : sourceCategory.hashCode());
		result = prime * result
				+ ((srcCategoryId == null) ? 0 : srcCategoryId.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategory other = (ProductCategory) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (categoryCode == null) {
			if (other.categoryCode != null)
				return false;
		} else if (!categoryCode.equals(other.categoryCode))
			return false;
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
		if (displayOrder == null) {
			if (other.displayOrder != null)
				return false;
		} else if (!displayOrder.equals(other.displayOrder))
			return false;
		if (isActive != other.isActive)
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
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
		if (intls == null) {
			if (other.intls != null)
				return false;
		} else if (!intls.equals(other.intls))
			return false;
		if (sourceCategory == null) {
			if (other.sourceCategory != null)
				return false;
		} else if (!sourceCategory.equals(other.sourceCategory))
			return false;
		if (srcCategoryId == null) {
			if (other.srcCategoryId != null)
				return false;
		} else if (!srcCategoryId.equals(other.srcCategoryId))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductCategory [srcCategoryId=" + srcCategoryId + ", name="
				+ name + ", photoLink=" + photoLink + ", parent=" + parent
				+ ", children=" + children + ", sourceCategory="
				+ sourceCategory + ", department=" + department + ", level="
				+ level + ", displayOrder=" + displayOrder + ", orderNumber="
				+ orderNumber + ", isActive=" + isActive + ", active=" + active
				+ ", tenant=" + tenant + ", categoryCode=" + categoryCode
				+ ", prodCategoryIntls=" + intls + "]";
	}

	@Override
	public int compareTo(ProductCategory o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
