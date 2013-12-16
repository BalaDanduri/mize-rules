package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name="prod_name_intl")
public class ProductIntl extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6977239159157170676L;
	private Product Product;
	private String name;
	private String description;
	private Locale locale;	
	
	public ProductIntl() {
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
	@JsonBackReference(value="productIntl")
	public Product getProduct() {
		return Product;
	}
	
	@Column(name = "prod_name")
	public String getName() {
		return name;
	}

	@Column(name = "prod_desc")
	public String getDescription() {
		return description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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
	
}
