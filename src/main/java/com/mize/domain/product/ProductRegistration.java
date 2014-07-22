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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.brand.Brand;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.businessentity.BusinessEntityIntl;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateSerializer;

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
	private DateTime registrationDate;
	private String registrationRef;
	private String registrationSource;
	private String registrationApplication;
	private String registrationIndustry;
	private String additionalInfo;
	private String dealerCustomerReference;
	private boolean customerUpdated; 
	private String invoiceNumber;
	private String salesPerson;
	private boolean registered;
	private List<ProductRegistrationAudit> audits = new ArrayList<ProductRegistrationAudit>();
	
	private List<ProductRegistrationWarranty> warrantyList = new ArrayList<ProductRegistrationWarranty>();
	
	@Transient
	private EntityComment entityComment;
	private List<ProductRegistrationComment> comments = new ArrayList<ProductRegistrationComment>();
	
	private List<ProductRegistrationAttachment> attachments = new ArrayList<ProductRegistrationAttachment>();
	
	@Transient
	private User user;
	
	@Transient
	private Long count;
	
	public enum RegistrationType{
		New,Transfer
	}
	public enum Status{
		Open,Draft,Registered,Pending,Rejected,Transferred,NeedInfo
	}	
	public ProductRegistration(){
		
	}
	
	public ProductRegistration(String statusCode,Long count){
		this.statusCode = statusCode;
		this.count = count;
	}
	
	public ProductRegistration(Long id,String statusCode,String registrationType,DateTime purchaseDate,DateTime registrationDate){
		this.id = id;
		this.statusCode = statusCode;
		this.registrationType = registrationType;
		this.purchaseDate = purchaseDate;
		this.registrationDate = registrationDate;
	}
	
	public ProductRegistration(Long id,String statusCode,String registrationType,List<ProductRegistrationAudit> audits){
		this.id = id;
		this.statusCode = statusCode;
		this.registrationType = registrationType;
		this.audits = audits;
	}
	
	public ProductRegistration(Long id,String statusCode,String serialNumber,DateTime shipDate, String brandName,String model,String productName) {
		this.id = id;
		this.statusCode = statusCode;
		ProductSerial productSerial = new ProductSerial();
		Product product = new Product();
		product.setModel(model);
		Brand brand = new Brand();
		brand.setName(brandName);
		ProductIntl productIntl = new ProductIntl();
		productIntl.setName(productName);
		productSerial.setSerialNumber(serialNumber);
		productSerial.setShipDate(shipDate);
		product.getProductIntl().add(productIntl);
		product.setBrand(brand);
		productSerial.setProduct(product);
		this.productSerial = productSerial;
		
	}
	
	public ProductRegistration(Long id,String statusCode,String serialNumber,DateTime shipDate, String brandName,String model,String productName,String invoiceBeType,String invoiceBeCode,String invoiceBEName,String shippedBeType,String shippedBeCode,String shippedBeName) {
		this.id = id;
		this.statusCode = statusCode;
		ProductSerial productSerial = new ProductSerial();
		Product product = new Product();
		product.setModel(model);
		Brand brand = new Brand();
		brand.setName(brandName);
		ProductIntl productIntl = new ProductIntl();
		productIntl.setName(productName);
		productSerial.setSerialNumber(serialNumber);
		productSerial.setShipDate(shipDate);
		product.getProductIntl().add(productIntl);
		product.setBrand(brand);
		productSerial.setProduct(product);
		if(Formatter.isNotNull(invoiceBeCode) && Formatter.isNotNull(invoiceBeType) ){
			BusinessEntity invoiceBusinessEntity = new BusinessEntity();
			invoiceBusinessEntity.setTypeCode(invoiceBeType);
			invoiceBusinessEntity.setCode(invoiceBeCode);
			BusinessEntityIntl intl = new BusinessEntityIntl();
			intl.setName(invoiceBEName);
			invoiceBusinessEntity.getIntl().add(intl);
			this.invoiceBusinessEntity = invoiceBusinessEntity;
		}else if(Formatter.isNotNull(shippedBeType) && Formatter.isNotNull(shippedBeCode) ){
			BusinessEntity invoiceBusinessEntity = new BusinessEntity();
			invoiceBusinessEntity.setTypeCode(shippedBeType);
			invoiceBusinessEntity.setCode(shippedBeCode);
			BusinessEntityIntl intl = new BusinessEntityIntl();
			intl.setName(shippedBeName);
			invoiceBusinessEntity.getIntl().add(intl);
			this.invoiceBusinessEntity = invoiceBusinessEntity;
		}
		this.productSerial = productSerial;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_regn_id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_serial_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getCustomer() {
		return customer;
	}


	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getInvoiceBusinessEntity() {
		return invoiceBusinessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="cust_address_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public EntityAddress getCustomerAddress() {
		return customerAddress;
	}
	
	@Column(name = "cust_delivery_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getCustomerDeliveryDate() {
		return customerDeliveryDate;
	}


	@Column(name = "purchase_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getPurchaseDate() {
		return purchaseDate;
	}


	@Column(name = "warranty_expiry_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ProductRegistrationComment> getComments() {
		return comments;
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
	
	
	
	@Column(name = "regn_date ", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getRegistrationDate() {
		return registrationDate;
	}

	@Column(name = "regn_reference")
	public String getRegistrationRef() {
		return registrationRef;
	}

	@Column(name = "regn_source")
	public String getRegistrationSource() {
		return registrationSource;
	}

	@Column(name = "regn_application")
	public String getRegistrationApplication() {
		return registrationApplication;
	}

	@Column(name = "regn_industry")
	public String getRegistrationIndustry() {
		return registrationIndustry;
	}
	

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setCustomerDeliveryDate(DateTime customerDeliveryDate) {
		this.customerDeliveryDate = customerDeliveryDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setPurchaseDate(DateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
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
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setRegistrationDate(DateTime registrationDate) {
		this.registrationDate = registrationDate;
	}


	public void setRegistrationRef(String registrationRef) {
		this.registrationRef = registrationRef;
	}


	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}


	public void setRegistrationApplication(String registrationApplication) {
		this.registrationApplication = registrationApplication;
	}


	public void setRegistrationIndustry(String registrationIndustry) {
		this.registrationIndustry = registrationIndustry;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "productRegistration",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@Fetch(FetchMode.SELECT)
	@JsonManagedReference(value="productRegWarranty")
	@JsonIgnore
	@Transient
	public List<ProductRegistrationWarranty> getWarrantyList() {
		return warrantyList;
	}	
	
	public void setWarrantyList(List<ProductRegistrationWarranty> warrantyList) {
		this.warrantyList = warrantyList;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "productRegistration",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_EMPTY)
	@JsonManagedReference(value="productRegistration_audit")
	public List<ProductRegistrationAudit> getAudits() {
		return audits;
	}
	
	public void setAudits(List<ProductRegistrationAudit> audits) {
		this.audits = audits;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "productRegistration",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="prodRegn_attachments")
	public List<ProductRegistrationAttachment> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(List<ProductRegistrationAttachment> attachments) {
		this.attachments = attachments;
	}
	

	@Column(name = "addl_info")
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	
	@Column(name = "invoice_customer_reference", length = 100, nullable = true)
	public String getDealerCustomerReference() {
		return dealerCustomerReference;
	}
	
	public void setDealerCustomerReference(String dealerCustomerReference) {
		this.dealerCustomerReference = dealerCustomerReference;
	}
	
	@Transient
	@JsonIgnore
	public boolean isCustomerUpdated() {
		return customerUpdated;
	}


	public void setCustomerUpdated(boolean customerUpdated) {
		this.customerUpdated = customerUpdated;
	}

	
	@Column(name = "invoice_no")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	@Column(name = "sales_person")
	public String getSalesPerson() {
		return salesPerson;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	@Transient
	@JsonIgnore
	public boolean getRegistered() {
		return registered;
	}
	
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	
	
	@Transient
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
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
		return "ProductRegistration [id=" + id + ", additionalInfo="
				+ additionalInfo + ", attachments=" + attachments
				+ ", comments=" + comments + ", customer=" + customer
				+ ", customerAddress=" + customerAddress
				+ ", customerDeliveryDate=" + customerDeliveryDate
				+ ", entityComment=" + entityComment
				+ ", invoiceBusinessEntity=" + invoiceBusinessEntity
				+ ", productSerial=" + productSerial + ", purchaseDate="
				+ purchaseDate + ", purchasePrice=" + purchasePrice
				+ ", registrationApplication=" + registrationApplication
				+ ", registrationDate=" + registrationDate
				+ ", registrationIndustry=" + registrationIndustry
				+ ", registrationRef=" + registrationRef
				+ ", registrationSource=" + registrationSource
				+ ", registrationType=" + registrationType + ", statusCode="
				+ statusCode + ", tenant=" + tenant + ", user=" + user
				+ ", warrantyExpiryDate=" + warrantyExpiryDate
				+ ", warrantyList=" + warrantyList + "]";
	}



}
