package com.mize.domain.sce.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name="catalog_intl" , uniqueConstraints={@UniqueConstraint (columnNames={"catalog_id","locale_id"})})
public class CatalogIntl extends MizeEntity {
	private static final long serialVersionUID = -3123713017328959018L;
	private Catalog catalog;
	private Locale locale;
	private String catalogName;
	private String catalogDescription;
	
	public CatalogIntl() {
	}

	@Id
	@GenericGenerator(name="catalogIntlId" , strategy="increment")
	@GeneratedValue(generator="catalogIntlId")
	@Column(name = "id", unique = true, nullable = false, length = 10)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="catalog_id")
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="local_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Column(name="catalog_name", nullable=false, length=100)
	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	@Column(name="catalog_desc", nullable=true, length=500)
	public String getCatalogDescription() {
		return catalogDescription;
	}

	public void setCatalogDescription(String catalogDescription) {
		this.catalogDescription = catalogDescription;
	}

}
