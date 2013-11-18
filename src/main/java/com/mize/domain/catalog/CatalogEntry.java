package com.mize.domain.catalog;

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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;

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
	
	@Column(name = "item_code", length = 30, nullable = false)
	public String getItemCode() {
		return itemCode;
	}
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_id", nullable = false)    
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
	
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}, mappedBy = "catalogEntry")
	public List<CatalogEntryIntl> getCatalogEntryIntl() {
		return catalogEntryIntl;
	}
	
	public void setCatalogEntryIntl(List<CatalogEntryIntl> catalogEntryIntl) {
		this.catalogEntryIntl = catalogEntryIntl;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date")
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
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
