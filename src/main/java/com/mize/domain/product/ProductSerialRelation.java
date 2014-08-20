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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;

@Entity
@Table(name = "prod_serial_rltn", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class ProductSerialRelation extends MizeEntity{
	
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
	@Column(name = "id", nullable = false, unique = true)
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

	

	@Column(name = "relation_type", nullable = true)
	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	@Column(name = "parent_prod_serial_id", nullable = true)
	public Long getParentProductSerialId() {
		return parentProductSerialId;
	}

	public void setParentProductSerialId(Long parentProductSerialId) {
		this.parentProductSerialId = parentProductSerialId;
	}

	@Column(name = "rltd_prod_srl_no", nullable = true,length = 200)
	public String getParentSerialNumber() {
		return parentSerialNumber;
	}

	@Column(name = "rltd_model", nullable = true ,length = 50)
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
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(value = false)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value = false)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}
	
	@JsonIgnore(value=false)
	@Override
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((parentProductSerialId == null) ? 0 : parentProductSerialId
						.hashCode());
		result = prime * result
				+ ((productSerial == null) ? 0 : productSerial.hashCode());
		result = prime * result
				+ ((relationType == null) ? 0 : relationType.hashCode());
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
		if (parentProductSerialId == null) {
			if (other.parentProductSerialId != null)
				return false;
		} else if (!parentProductSerialId.equals(other.parentProductSerialId))
			return false;
		if (productSerial == null) {
			if (other.productSerial != null)
				return false;
		} else if (!productSerial.equals(other.productSerial))
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

}
