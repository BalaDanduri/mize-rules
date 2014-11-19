package com.mize.domain.product;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;


@Entity
@Table(name = "prod_regn_warranty")
public class ProductRegistrationWarranty extends MizeSceEntity implements Comparable<ProductRegistrationWarranty> {

	private static final long serialVersionUID = -4939768925948855898L;
	
	private ProductRegistration productRegistration;
	private ProductWarranty  warranty; 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
	@JoinColumn(name="prod_regn_id")
	@JsonBackReference(value="productRegWarranty")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="prod_warranty_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public ProductWarranty getWarranty() {
		return warranty;
	}
	

	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}

	public void setWarranty(ProductWarranty warranty) {
		this.warranty = warranty;
	}
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((productRegistration == null) ? 0 : productRegistration
						.hashCode());
		result = prime * result
				+ ((warranty == null) ? 0 : warranty.hashCode());
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
		if (!(obj instanceof ProductRegistrationWarranty)) {
			return false;
		}
		ProductRegistrationWarranty other = (ProductRegistrationWarranty) obj;
		if (productRegistration == null) {
			if (other.productRegistration != null) {
				return false;
			}
		} else if (!productRegistration.equals(other.productRegistration)) {
			return false;
		}
	
		return true;
	}

	@Override
	public String toString() {
		return "ProductRegistrationWarranty [id=" + id
				+ ", productRegistration=" + productRegistration
				+ ", warranty=" + warranty + "]";
	}

	@Override
	public int compareTo(ProductRegistrationWarranty o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
