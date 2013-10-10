package com.mize.domain.sce.catalog;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="catalog_entry", uniqueConstraints = {@UniqueConstraint(columnNames = {"catalog_id","item_code"})})
public class CatalogEntry extends MizeEntity {
	
	private static final long serialVersionUID = 321241353183431073L;	
	private Catalog catalog;
	private String itemCode;
	private String isActive;
	private List<CatalogEntryIntl> catalogEntryIntl;
	
	public CatalogEntry() {
		super();
	}	

	public CatalogEntry(Catalog catalog, String itemCode, String isActive,
			List<CatalogEntryIntl> catalogEntryIntl) {
		this.catalog = catalog;
		this.itemCode = itemCode;
		this.isActive = isActive;
		this.catalogEntryIntl = catalogEntryIntl;
	}


	@Id
	@GenericGenerator(name = "catalogEntryId", strategy = "increment")
	@GeneratedValue(generator = "catalogEntryId")
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {		
		super.id = id;
	}
	
	@Column(name = "item_code", length = 30, nullable = false)
	public String getItemCode() {
		return itemCode;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_id")
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "catalogEntry")
	public List<CatalogEntryIntl> getCatalogEntryIntl() {
		return catalogEntryIntl;
	}
	
	public void setCatalogEntryIntl(List<CatalogEntryIntl> catalogEntryIntl) {
		this.catalogEntryIntl = catalogEntryIntl;
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
		} else if (!catalog.equals(other.catalog))
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
		builder.append(", catalogEntryIntl=");
		builder.append(catalogEntryIntl);		
		return builder.toString();		
	}

}
