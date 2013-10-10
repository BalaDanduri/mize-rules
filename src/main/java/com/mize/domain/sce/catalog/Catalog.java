package com.mize.domain.sce.catalog;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;

@Entity
@Table(name = "catalog", 
	uniqueConstraints = {@UniqueConstraint (columnNames={"catalog_code"})})
public class Catalog extends MizeEntity {
	
	private static final long serialVersionUID = -8488237770262609141L;	
	//private BusinessEntity tenant;
	private String catalogCode;
	private String catalogType;
	private String isActive;
	private List<CatalogIntl> catalogIntl;
	
	public Catalog() {
		super();
	}

	/**
	 * @param tenant
	 * @param catalogCode
	 * @param catalogType
	 * @param isActive
	 * @param catalogIntl
	 */
	public Catalog(BusinessEntity tenant, String catalogCode,
			String catalogType, String isActive, List<CatalogIntl> catalogIntl) {
		super();
		//this.tenant = tenant;
		this.catalogCode = catalogCode;
		this.catalogType = catalogType;
		this.isActive = isActive;
		this.catalogIntl = catalogIntl;
	}


	@Id
	@GenericGenerator(name="catalogId" , strategy="increment")
	@GeneratedValue(generator="catalogId")
	@Column(name = "id", unique = true, nullable = false, length = 10)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id=id;
	}

/*	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
*/

	@Column(name = "catalog_code",  nullable = true, length = 30)
	public String getCatalogCode() {
		return catalogCode;
	}

	public void setCatalogCode(String catalogCode) {
		this.catalogCode = catalogCode;
	}

	@Column(name = "catalog_type",  nullable = true, length = 100)
	public String getCatalogType() {
		return catalogType;
	}

	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}

	@Column(name = "is_active",  nullable = true, length = 1)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@OneToMany(fetch=FetchType.EAGER, mappedBy="catalog")
	public List<CatalogIntl> getCatalogIntl() {
		return catalogIntl;
	}


	public void setCatalogIntl(List<CatalogIntl> catalogIntl) {
		this.catalogIntl = catalogIntl;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = PRIME * result
				+ ((catalogCode == null) ? 0 : catalogCode.hashCode());
		result = PRIME * result
				+ ((catalogIntl == null) ? 0 : catalogIntl.hashCode());
		result = PRIME * result
				+ ((catalogType == null) ? 0 : catalogType.hashCode());
		result = PRIME * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		//result = PRIME * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		if (catalogIntl == null) {
			if (other.catalogIntl != null) {
				return false;
			}
		} else if (!catalogIntl.equals(other.catalogIntl)) {
			return false;
		}
		if (catalogType == null) {
			if (other.catalogType != null) {
				return false;
			}
		} else if (!catalogType.equals(other.catalogType)) {
			return false;
		}
		if (isActive == null) {
			if (other.isActive != null) {
				return false;
			}
		} else if (!isActive.equals(other.isActive)) {
			return false;
		}
		/*if (tenant == null) {
			if (other.tenant != null) {
				return false;
			}
		} else if (!tenant.equals(other.tenant)) {
			return false;
		}*/
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Catalog [tenant=");
	//	builder.append(tenant);
		builder.append(", catalogCode=");
		builder.append(catalogCode);
		builder.append(", catalogType=");
		builder.append(catalogType);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", catalogIntl=");
		builder.append(catalogIntl);
		builder.append("]");
		return builder.toString();
	}

}
