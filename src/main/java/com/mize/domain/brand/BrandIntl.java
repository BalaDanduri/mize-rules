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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityIntl;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, include="all")
@Table(name = "brand_intl")
public class BrandIntl extends MizeSceEntityIntl implements Comparable<BrandIntl> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6629278807316658365L;
	private Brand brand;
	private String name;
	private String desc;

	public BrandIntl() {
		super();
	}

	public BrandIntl(Brand brand, String name, String desc,
			Locale locale) {
		super();
		this.brand = brand;
		this.name = name;
		this.desc = desc;
		super.locale = locale;
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
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "brand_id")
	@JsonBackReference(value = "intl")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
	
	@Column(name = "brand_name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "brand_description")
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "BrandIntl [Name=" + name + ", Desc=" + desc
				+ ", locale=" + locale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((desc == null) ? 0 : desc.hashCode());
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
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
		BrandIntl other = (BrandIntl) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		return true;
	}

	@Override
	public int compareTo(BrandIntl o) {
		return 0;
	}

}
