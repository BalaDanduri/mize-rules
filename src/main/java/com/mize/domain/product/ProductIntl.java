package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="prod_intl")
public class ProductIntl extends MizeEntity implements Comparable<ProductIntl>{
	
	private static final long serialVersionUID = -6977239159157170676L;
	private Product Product;
	private String name;
	private String description;
	private Locale locale = new Locale();	
	
	public ProductIntl() {
		super();
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
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prod_id")
	@JsonBackReference(value="productIntl_product")
	public Product getProduct() {
		return Product;
	}
	
	@Column(name = "prod_name")
	public String getName() {
		return name;
	}

	@Column(name = "prod_description")
	public String getDescription() {
		return description;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locale_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setProduct(Product Product) {
		this.Product = Product;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProductIntl other = (ProductIntl) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductIntl [name=" + name + ", description=" + description
				+ ", locale=" + locale + "]";
	}

	@Override
	public int compareTo(ProductIntl o) {
		return 0;
	}
	
}
