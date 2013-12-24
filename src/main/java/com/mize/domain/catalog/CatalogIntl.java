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
import javax.persistence.UniqueConstraint;

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

	public CatalogIntl(Catalog catalog, Locale locale, String catalogName,
			String catalogDescription) {
		this.catalog = catalog;
		this.locale = locale;
		this.catalogName = catalogName;
		this.catalogDescription = catalogDescription;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 10)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_id", nullable = false)
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="locale_id")
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

	@Column(name="catalog_description", nullable=true, length=500)
	public String getCatalogDescription() {
		return catalogDescription;
	}

	public void setCatalogDescription(String catalogDescription) {
		this.catalogDescription = catalogDescription;
	}

	@Override
	public int hashCode() {

		int result = super.hashCode();
		result = PRIME * result + ((catalog == null) ? 0 : catalog.hashCode());
		result = PRIME
				* result
				+ ((catalogDescription == null) ? 0 : catalogDescription
						.hashCode());
		result = PRIME * result
				+ ((catalogName == null) ? 0 : catalogName.hashCode());
		result = PRIME * result + ((locale == null) ? 0 : locale.hashCode());
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
		if (!(obj instanceof CatalogIntl)) {
			return false;
		}
		CatalogIntl other = (CatalogIntl) obj;
		if (catalog == null) {
			if (other.catalog != null) {
				return false;
			}
		} else if (!catalog.getId().equals(other.catalog.getId())) {
			return false;
		}
		if (catalogDescription == null) {
			if (other.catalogDescription != null) {
				return false;
			}
		} else if (!catalogDescription.equals(other.catalogDescription)) {
			return false;
		}
		if (catalogName == null) {
			if (other.catalogName != null) {
				return false;
			}
		} else if (!catalogName.equals(other.catalogName)) {
			return false;
		}
		if (locale == null) {
			if (other.locale != null) {
				return false;
			}
		} else if (!locale.equals(other.locale)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CatalogIntl [catalog=");
		builder.append(catalog);
		builder.append(", locale=");
		builder.append(locale);
		builder.append(", catalogName=");
		builder.append(catalogName);
		builder.append(", catalogDescription=");
		builder.append(catalogDescription);
		builder.append("]");
		return builder.toString();
	}

}
