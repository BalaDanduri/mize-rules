package com.mize.domain.product;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeSceEntityAudit;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("ProductSerialRltn")
@Table(name = "prod_serial_rltn")
public class ProductSerialRelation extends MizeSceEntityAudit implements Comparable<ProductSerialRelation>{
	
	private static final long serialVersionUID = -2610914671026405288L;
	private ProductSerial productSerial;
	private Long parentProductSerialId;
	private String relationType;
	private String parentSerialNumber;
	private String parentModel;
	
	public ProductSerialRelation(){
		super();
	}
	
	public ProductSerialRelation(ProductSerial productSerial,
			Long parentProductSerialId, String relationType) {
		super();
		this.productSerial = productSerial;
		this.parentProductSerialId = parentProductSerialId;
		this.relationType = relationType;
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
	@JoinColumn(name="prod_serial_id")
	@JsonBackReference(value="relation_productSerial")
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}


	@Column(name = "relation_type")
	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	@Column(name = "parent_prod_serial_id")
	public Long getParentProductSerialId() {
		return parentProductSerialId;
	}

	public void setParentProductSerialId(Long parentProductSerialId) {
		this.parentProductSerialId = parentProductSerialId;
	}

	@Column(name = "rltd_prod_srl_no")
	public String getParentSerialNumber() {
		return parentSerialNumber;
	}

	@Column(name = "rltd_model")
	public String getParentModel() {
		return parentModel;
	}

	public void setParentSerialNumber(String parentSerialNumber) {
		this.parentSerialNumber = parentSerialNumber;
	}

	public void setParentModel(String parentModel) {
		this.parentModel = parentModel;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((parentModel == null) ? 0 : parentModel.hashCode());
		result = prime * result + ((parentProductSerialId == null) ? 0 : parentProductSerialId.hashCode());
		result = prime * result + ((parentSerialNumber == null) ? 0 : parentSerialNumber.hashCode());
		result = prime * result + ((relationType == null) ? 0 : relationType.hashCode());
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
		ProductSerialRelation other = (ProductSerialRelation) obj;
		if (parentModel == null) {
			if (other.parentModel != null)
				return false;
		} else if (!parentModel.equals(other.parentModel))
			return false;
		if (parentProductSerialId == null) {
			if (other.parentProductSerialId != null)
				return false;
		} else if (!parentProductSerialId.equals(other.parentProductSerialId))
			return false;
		if (parentSerialNumber == null) {
			if (other.parentSerialNumber != null)
				return false;
		} else if (!parentSerialNumber.equals(other.parentSerialNumber))
			return false;
		if (relationType == null) {
			if (other.relationType != null)
				return false;
		} else if (!relationType.equals(other.relationType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductSerialRelation [productSerial=" + productSerial
				+ ", parentProductSerial=" + parentProductSerialId
				+ ", relationType=" + relationType + "]";
	}

	@Override
	public int compareTo(ProductSerialRelation o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
