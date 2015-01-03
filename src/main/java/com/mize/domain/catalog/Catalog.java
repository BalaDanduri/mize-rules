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
import javax.persistence.Transient;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "catalog")
public class Catalog extends MizeSceEntityAudit implements Comparable<Catalog> {
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private BusinessEntity tenant;
	private String catalogCode;
	private String catalogType;
	private String isActive;
	private String catalogName;
	private List<CatalogEntry> catalogEntry =  new ArrayList<CatalogEntry>();
	private String lastAccessedTime;
	@Transient
	private User user;
	
	public Catalog() {
		super();
	}

	public Catalog(BusinessEntity tenant, String catalogCode,
			String catalogType, String isActive, String catalogName) {
		super();
		this.tenant = tenant;
		this.catalogCode = catalogCode;
		this.catalogType = catalogType;
		this.isActive = isActive;
		this.catalogName = catalogName;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id=id;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "catalog_code")
	public String getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}

	@Column(name = "catalog_type")
	public String getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}

	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Column(name = "catalog_name")
	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	@Transient
	public String getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(String lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	@OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.EAGER, mappedBy = "catalog", orphanRemoval = true)
	@JsonManagedReference(value="catlog")
	@JsonSerialize(using=JPASerializer.class)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size = 30)
	@JsonInclude(Include.NON_NULL)
	public List<CatalogEntry> getCatalogEntry() {
		return catalogEntry;
	}
	

	public void setCatalogEntry(List<CatalogEntry> catalogEntry) {
		this.catalogEntry = catalogEntry;
	}

	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result
				+ ((catalogCode == null) ? 0 : catalogCode.hashCode());
		result = PRIME * result
				+ ((catalogType == null) ? 0 : catalogType.hashCode());
		result = PRIME * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = PRIME * result
				+ ((catalogName == null) ? 0 : catalogName.hashCode());
		result = PRIME * result + ((tenant == null) ? 0 : tenant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Catalog)) {
			return false;
		}
		Catalog other = (Catalog) obj;
		if (catalogCode == null) {
			if (other.catalogCode != null) {
				return false;
			}
		} else if (!catalogCode.equals(other.catalogCode)) {
			return false;
		}
		
		if (catalogType == null) {
			if (other.catalogType != null) {
				return false;
			}
		} else if (!catalogType.equals(other.catalogType)) {
			return false;
		}
		
		if (catalogName == null) {
			if (other.catalogName != null) {
				return false;
			}
		} else if (!catalogName.equals(other.catalogName)) {
			return false;
		}
		
		if (isActive == null) {
			if (other.isActive != null) {
				return false;
			}
		} else if (!isActive.equals(other.isActive)) {
			return false;
		}
		if (tenant == null) {
			if (other.tenant != null) {
				return false;
			}
		} else if (!tenant.equals(other.tenant)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Catalog [tenant=");
		builder.append(tenant);
		builder.append(", catalogCode=");
		builder.append(catalogCode);
		builder.append(", catalogType=");
		builder.append(catalogType);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", catalogName=");
		builder.append(catalogName);
		builder.append(", catalogEntry=");
		builder.append(catalogEntry);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Catalog o) {
		if ( this == o ) 
			return EQUAL;
		else if (this.id < o.id) 
			return BEFORE;
		else if (o.id == this.id) 
			return EQUAL;
		else if (this.id > o.id)
			return AFTER;
		return EQUAL;
	}
}
	

