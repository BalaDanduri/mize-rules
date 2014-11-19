package com.mize.domain.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name="catalog_entry", uniqueConstraints = {@UniqueConstraint(columnNames = {"catalog_id","item_code"})})
public class CatalogEntry extends MizeSceEntity implements Comparable<CatalogEntry>{
	
	private static final long serialVersionUID = 321241353183431073L;	
	private Catalog catalog;
	private String itemCode;
	private String isActive;
	private String isDefault;
	private Long orderSequence;
	private List<CatalogEntryIntl> catalogEntryIntl = new ArrayList<CatalogEntryIntl>();
	
	public CatalogEntry() {
		super();
	}	

	public CatalogEntry(Catalog catalog, String itemCode, String isActive, String isDefault, Long orderSequence,
			List<CatalogEntryIntl> catalogEntryIntl) {
		this.catalog = catalog;
		this.itemCode = itemCode;
		this.isActive = isActive;
		this.isDefault = isDefault;
		this.orderSequence = orderSequence;
		this.catalogEntryIntl = catalogEntryIntl;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {		
		super.id = id;
	}
	
	@Column(name = "item_code", length = 50, nullable = false)
	public String getItemCode() {
		return itemCode;
	}
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_id", nullable = false)    
	@JsonBackReference(value="catlog")
	public Catalog getCatalog() {
		return catalog;
	}
	
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	@Column(name = "is_active", length = 1)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}		
	
	@Column(name = "is_default", length = 1)
	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	@Column(name = "order_sequence", length = 20)
	public Long getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(Long orderSequence) {
		this.orderSequence = orderSequence;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}, mappedBy = "catalogEntry" ,orphanRemoval= true)
	@Fetch(FetchMode.SUBSELECT)
	@JsonManagedReference(value="catlog_entry")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<CatalogEntryIntl> getCatalogEntryIntl() {
		return catalogEntryIntl;
	}
	
	public void setCatalogEntryIntl(List<CatalogEntryIntl> catalogEntryIntl) {
		this.catalogEntryIntl = catalogEntryIntl;
	}
	
	@Column(name = "created_date", updatable = false)
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(false)
	public MizeDateTime getCreatedDate() {
		return this.createdDate;
	}


	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.MizeDateTimeJPA")
	@JsonIgnore(false)
	public MizeDateTime getUpdatedDate() {
		return this.updatedDate;
	}
	

	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	} 
	
	@Override
	@JsonIgnore
	@Column(name = "created_by")
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = prime
				* result
				+ ((catalogEntryIntl == null) ? 0 : catalogEntryIntl.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result
				+ ((isDefault == null) ? 0 : isDefault.hashCode());
		result = prime * result
				+ ((orderSequence == null) ? 0 : orderSequence.hashCode());
		result = prime * result
				+ ((itemCode == null) ? 0 : itemCode.hashCode());
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
		CatalogEntry other = (CatalogEntry) obj;
		if (catalog == null) {
			if (other.catalog != null)
				return false;
		} else if (!catalog.getId().equals(other.catalog.getId()))
			return false;
		if (catalogEntryIntl == null) {
			if (other.catalogEntryIntl != null)
				return false;
		} else if (!catalogEntryIntl.equals(other.catalogEntryIntl))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isDefault == null) {
			if (other.isDefault != null)
				return false;
		} else if (!isDefault.equals(other.isDefault))
			return false;
		if (orderSequence == null) {
			if (other.orderSequence != null)
				return false;
		} else if (!orderSequence.equals(other.orderSequence))
			return false;
		if (itemCode == null) {
			if (other.itemCode != null)
				return false;
		} else if (!itemCode.equals(other.itemCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer();
		builder.append("CatalogEntry [catalog=");
		builder.append(catalog);
		builder.append(", itemCode=");
		builder.append(itemCode);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", isDefault=");
		builder.append(isDefault);
		builder.append(", orderSequence=");
		builder.append(orderSequence);
		builder.append(", catalogEntryIntl=");
		builder.append(catalogEntryIntl);		
		return builder.toString();		
	}

	@Override
	public int compareTo(CatalogEntry o) {
		return 0;
	}

}
