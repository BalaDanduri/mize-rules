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
	uniqueConstraints = {@UniqueConstraint (columnNames={"tenant_id", "catalog_code"})})
public class Catalog extends MizeEntity {
	
	private static final long serialVersionUID = -8488237770262609141L;	
	private BusinessEntity tenant;
	private String catalogCode;
	private String catalogType;
	private String isActive;
	private List<CatalogIntl> catalogIntl;
	
	public Catalog() {
		super();
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

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}


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

}
