package com.mize.domain.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "prod_regn")
public class ProductRegistration extends MizeEntity {

	private static final long serialVersionUID = 2928234510268602315L;
	
    private BusinessEntity tenant;
    private ProductSerial productSerial;
    private String statusCode;
	private String registrationType;
	private BusinessEntity customer;
	private BusinessEntity invoiceBusinessEntity;
	private EntityAddress customerAddress;
	private DateTime customerDeliveryDate;
	private DateTime purchaseDate;
	private DateTime warrantyExpiryDate;
	private BigDecimal purchasePrice;
	
	@Transient
	private EntityComment entityComment;
	private List<ProductRegistrationComment> comments = new ArrayList<ProductRegistrationComment>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_regn_id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_serial_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public ProductSerial getProductSerial() {
		return productSerial;
	}


	@Column(name = "status_code", nullable = true)
	public String getStatusCode() {
		return statusCode;
	}

	@Column(name = "regn_type", nullable = true)
	public String getRegistrationType() {
		return registrationType;
	}


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cust_be_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getCustomer() {
		return customer;
	}


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_be_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getInvoiceBusinessEntity() {
		return invoiceBusinessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade= CascadeType.ALL)
	@JoinColumn(name="cust_address_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public EntityAddress getCustomerAddress() {
		return customerAddress;
	}
	
	@Column(name = "cust_delivery_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getCustomerDeliveryDate() {
		return customerDeliveryDate;
	}


	@Column(name = "purchase_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getPurchaseDate() {
		return purchaseDate;
	}


	@Column(name = "warranty_expiry_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getWarrantyExpiryDate() {
		return warrantyExpiryDate;
	}


	@Column(name = "purchase_price", nullable = true)
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "productRegistration",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public List<ProductRegistrationComment> getComments() {
		return comments;
	}


	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	
	@Override
	public void setId(Long id) {
		this.id =id;
	}
	
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public void setCustomer(BusinessEntity customer) {
		this.customer = customer;
	}

	public void setInvoiceBusinessEntity(BusinessEntity invoiceBusinessEntity) {
		this.invoiceBusinessEntity = invoiceBusinessEntity;
	}

	public void setCustomerAddress(EntityAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setCustomerDeliveryDate(DateTime customerDeliveryDate) {
		this.customerDeliveryDate = customerDeliveryDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setPurchaseDate(DateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setWarrantyExpiryDate(DateTime warrantyExpireDate) {
		this.warrantyExpiryDate = warrantyExpireDate;
	}


	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	public void setComments(List<ProductRegistrationComment> comments) {
		this.comments = comments;
	}

	

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result
				+ ((purchasePrice == null) ? 0 : purchasePrice.hashCode());
		result = prime
				* result
				+ ((registrationType == null) ? 0 : registrationType.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime
				* result
				+ ((warrantyExpiryDate == null) ? 0 : warrantyExpiryDate
						.hashCode());
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
		if (!(obj instanceof ProductRegistration)) {
			return false;
		}
		ProductRegistration other = (ProductRegistration) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (purchaseDate == null) {
			if (other.purchaseDate != null) {
				return false;
			}
		} else if (!purchaseDate.equals(other.purchaseDate)) {
			return false;
		}
		if (purchasePrice == null) {
			if (other.purchasePrice != null) {
				return false;
			}
		} else if (!purchasePrice.equals(other.purchasePrice)) {
			return false;
		}
		if (registrationType == null) {
			if (other.registrationType != null) {
				return false;
			}
		} else if (!registrationType.equals(other.registrationType)) {
			return false;
		}
		if (statusCode == null) {
			if (other.statusCode != null) {
				return false;
			}
		} else if (!statusCode.equals(other.statusCode)) {
			return false;
		}
		if (warrantyExpiryDate == null) {
			if (other.warrantyExpiryDate != null) {
				return false;
			}
		} else if (!warrantyExpiryDate.equals(other.warrantyExpiryDate)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "ProductRegistration [id=" + id + ", comments=" + comments
				+ ", customer=" + customer + ", customerAddress="
				+ customerAddress + ", customerDeliveryDate="
				+ customerDeliveryDate + ", entityComment=" + entityComment
				+ ", invoiceBusinessEntity=" + invoiceBusinessEntity
				+ ", productSerial=" + productSerial + ", purchaseDate="
				+ purchaseDate + ", purchasePrice=" + purchasePrice
				+ ", registrationType=" + registrationType + ", statusCode="
				+ statusCode + ", tenant=" + tenant + ", warrantyExpireDate="
				+ warrantyExpiryDate + "]";
	}

	

}
