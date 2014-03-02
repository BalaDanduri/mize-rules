package com.mize.domain.product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "prod_regn_attach")
public class ProductRegistrationAttachment extends MizeEntity {

	
	private static final long serialVersionUID = 688498435019563124L;
	
	private ProductRegistration productRegistration;
	private EntityAttachment entityAttachment;
	
	public ProductRegistrationAttachment() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "prod_regn_id")
	@JsonBackReference(value="prodRegn_attachments")
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}

	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}
	
	@OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name = "attach_id")
	public EntityAttachment getEntityAttachment() {
		return entityAttachment;
	}

	public void setEntityAttachment(EntityAttachment entityAttachment) {
		this.entityAttachment = entityAttachment;
	}
	
	

}
