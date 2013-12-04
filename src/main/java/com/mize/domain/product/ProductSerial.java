package com.mize.domain.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "prod_serial", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class ProductSerial extends MizeEntity{

	private static final long serialVersionUID = 5827509183800749241L;
	private BusinessEntity tenant;
	private Product product;
	private String prodSerialNumber;
	private BusinessEntity deliveryBE;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	protected DateTime deliveryDate;	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime buildDate;
	
	public ProductSerial(){
	}

	public ProductSerial(BusinessEntity tenantId, Product product, String prodSerialNumber,
			BusinessEntity deliveryBE, DateTime deliveryDate, DateTime buildDate) {
		super();
		this.tenant = tenantId;
		this.product = product;
		this.prodSerialNumber = prodSerialNumber;
		this.deliveryBE = deliveryBE;
		this.deliveryDate = deliveryDate;
		this.buildDate = buildDate;
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

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToOne(cascade={CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "prod_srl_no", nullable = true)
	public String getProdSerialNumber() {
		return prodSerialNumber;
	}

	public void setProdSerialNumber(String prodSerialNumber) {
		this.prodSerialNumber = prodSerialNumber;
	}

	@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name="delivery_be_id")
	public BusinessEntity getDeliveryBE() {
		return deliveryBE;
	}

	public void setDeliveryBE(BusinessEntity deliveryBE) {
		this.deliveryBE = deliveryBE;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "delivery_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getDeliveryDate() {
		return deliveryDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setDeliveryDate(DateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "build_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getBuildDate() {
		return buildDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setBuildDate(DateTime buildDate) {
		this.buildDate = buildDate;
	}

	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((buildDate == null) ? 0 : buildDate.hashCode());
		result = prime * result
				+ ((deliveryBE == null) ? 0 : deliveryBE.hashCode());
		result = prime * result
				+ ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime
				* result
				+ ((prodSerialNumber == null) ? 0 : prodSerialNumber.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
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
		ProductSerial other = (ProductSerial) obj;
		if (buildDate == null) {
			if (other.buildDate != null)
				return false;
		} else if (!buildDate.equals(other.buildDate))
			return false;
		if (deliveryBE == null) {
			if (other.deliveryBE != null)
				return false;
		} else if (!deliveryBE.equals(other.deliveryBE))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (prodSerialNumber == null) {
			if (other.prodSerialNumber != null)
				return false;
		} else if (!prodSerialNumber.equals(other.prodSerialNumber))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductSerial [tenant=" + tenant + ", product=" + product
				+ ", prodSerialNumber=" + prodSerialNumber + ", deliveryBE="
				+ deliveryBE + ", deliveryDate=" + deliveryDate
				+ ", buildDate=" + buildDate + "]";
	}

	
}
