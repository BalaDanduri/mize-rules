package com.mize.domain.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "catalog_entry_intl")
public class CatalogEntryIntl extends MizeSceEntity implements Comparable<CatalogEntryIntl> {
	

	private static final long serialVersionUID = 3807391169608135552L;
	private CatalogEntry catalogEntry;
	private String itemName;
	private String itemDescription;
	private Locale locale;	
	
	public CatalogEntryIntl() {
		super();
	}	
	
	public CatalogEntryIntl(CatalogEntry catalogEntry, String itemName,
			String itemDescription, Locale locale) {		
		this.catalogEntry = catalogEntry;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.locale = locale;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_entry_id")
	@JsonBackReference(value="catlog_entry")
	public CatalogEntry getCatalogEntry() {
		return catalogEntry;
	}

	public void setCatalogEntry(CatalogEntry catalogEntry) {
		this.catalogEntry = catalogEntry;
	}
	
	@Column(name = "item_name", nullable = true, length = 100)
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Column(name = "item_description", nullable = true, length = 500)
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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
	@Column(name = "created_by", updatable = false)
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
		result = prime * result
				+ ((catalogEntry == null) ? 0 : catalogEntry.hashCode());
		result = prime * result
				+ ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
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
		CatalogEntryIntl other = (CatalogEntryIntl) obj;
		if (catalogEntry == null) {
			if (other.catalogEntry != null)
				return false;
		} else if (!catalogEntry.getId().equals(other.catalogEntry.getId()))
			return false;
		if (itemDescription == null) {
			if (other.itemDescription != null)
				return false;
		} else if (!itemDescription.equals(other.itemDescription))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatalogEntryIntl [catalogEntry=");
		builder.append(catalogEntry);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", itemDescription=");
		builder.append(itemDescription);
		builder.append(", locale=");
		builder.append(locale);
		builder.append("]");		
		return builder.toString();
	}

	@Override
	public int compareTo(CatalogEntryIntl o) {
		return 0;
	}
	

}
