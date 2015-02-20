package com.mize.domain.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "brand_skin")
public class BrandSkin extends MizeSceEntity implements Comparable<BrandSkin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2391070381340198345L;

	private Brand brand;
	private String type;
	private String name;
	private String url;
	private Locale locale;

	public BrandSkin() {
		super();
	}

	public BrandSkin(Brand brand, String type, String name,
			String url, Locale locale) {
		super();
		this.brand = brand;
		this.type = type;
		this.name = name;
		this.url = url;
		this.locale = locale;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id")
	@JsonBackReference(value = "skins")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	@Column(name = "skin_type", length = 256, nullable = true)
	public String getType() {
		return type;
	}

	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "skin_file_name", length = 200, nullable = true)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "skin_file_url", length = 256, nullable = true)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
		return "BrandSkin [skinnType=" + type + ", skinFileName="
				+ name + ", locale=" + locale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((url == null) ? 0 : url.hashCode());
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
		BrandSkin other = (BrandSkin) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	@Override
	public int compareTo(BrandSkin o) {
		return 0;
	}

}
