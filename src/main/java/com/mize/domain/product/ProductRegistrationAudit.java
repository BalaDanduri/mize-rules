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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeAuditEntity;

@Entity
@Table(name = "prod_regn_audit")
public class ProductRegistrationAudit extends MizeAuditEntity implements Comparable<ProductRegistrationAudit>{	

	private static final long serialVersionUID = -5121973394689627876L;
	private ProductRegistration productRegistration;

	public ProductRegistrationAudit(){
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="prod_regn_id")
	@JsonBackReference(value="productRegistration_audit")
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}
	
	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}

	@Override
	public int compareTo(ProductRegistrationAudit o) {
		return 0;
	}

}
