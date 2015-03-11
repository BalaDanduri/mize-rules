package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.Date;
import com.mize.domain.util.JPASerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("ProductSerial")
@Table(name = "prod_serial")
public class ProductSerial extends MizeSceEntityAudit implements Comparable<ProductSerial>{
	
	private static final long serialVersionUID = 1396934864607540803L;
	private BusinessEntity tenant;
	private Product product;
	private String serialNumber;
	private BusinessEntity shippedBusinessEntity;
	private Date buildDate;
	@Transient
	private EntityComment entityComment;
	private List<ProductSerialComment> comments = new ArrayList<ProductSerialComment>();
	@Transient
	private User user;
	private Date shipDate;
	private String isValid;
	private BusinessEntity invoiceBusinessEntity;
	private Date invoiceDate;
	private String invoiceNumber;
	private List<ProductSerialRelation> productSerialRelations = new ArrayList<ProductSerialRelation>();
	private List<ProductWarranty> productWarrantyList = new ArrayList<ProductWarranty>();
	
	public ProductSerial(){
		super();
	}

	public ProductSerial(BusinessEntity tenantId, Product product, String serialNumber,BusinessEntity invoiceBusinessEntity,
			BusinessEntity shippedBusinessEntity, Date deliveryDate, Date buildDate) {
		super();
		this.tenant = tenantId;
		this.product = product;
		this.serialNumber = serialNumber;
		this.invoiceBusinessEntity = invoiceBusinessEntity;
		this.shippedBusinessEntity = shippedBusinessEntity;
		this.buildDate = buildDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "prod_srl_no")
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ship_be_id", nullable = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getShippedBusinessEntity() {
		return shippedBusinessEntity;
	}

	public void setShippedBusinessEntity(BusinessEntity shippedBE) {
		this.shippedBusinessEntity = shippedBE;
	}


	
	@Column(name = "build_date")
	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}


	
	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "productSerial",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ProductSerialComment> getComments() {
		return comments;
	}

	public void setComments(List<ProductSerialComment> comments) {
		this.comments = comments;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name= "is_valid")
	public String getIsValid() {
		return isValid;
	}
	
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	
	@Column(name = "ship_date")
	public Date getShipDate() {
		return shipDate;
	}
	
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getInvoiceBusinessEntity() {
		return invoiceBusinessEntity;
	}

	public void setInvoiceBusinessEntity(BusinessEntity invoiceBusinessEntity) {
		this.invoiceBusinessEntity = invoiceBusinessEntity;
	}

	
	@Column(name = "invoice_date")
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Column(name = "invoice_no")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "productSerial",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ProductSerialRelation> getProductSerialRelations() {
		return productSerialRelations;
	}

	public void setProductSerialRelations(
			List<ProductSerialRelation> productSerialRelations) {
		this.productSerialRelations = productSerialRelations;
	}


	
	@OneToMany(cascade={CascadeType.ALL },fetch = FetchType.LAZY, mappedBy = "productSerial",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="productSerial_warranty")
	public List<ProductWarranty> getProductWarrantyList() {
		return productWarrantyList;
	}
	
	public void setProductWarrantyList(List<ProductWarranty> productWarrantyList) {
		this.productWarrantyList = productWarrantyList;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((buildDate == null) ? 0 : buildDate.hashCode());
		result = prime * result
				+ ((invoiceBusinessEntity == null) ? 0 : invoiceBusinessEntity.hashCode());
		result = prime * result
				+ ((shippedBusinessEntity == null) ? 0 : shippedBusinessEntity.hashCode());
		result = prime
				* result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
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
		if (invoiceBusinessEntity == null) {
			if (other.invoiceBusinessEntity != null)
				return false;
		} else if (!invoiceBusinessEntity.equals(other.invoiceBusinessEntity))
			return false;
		if (shippedBusinessEntity == null) {
			if (other.shippedBusinessEntity != null)
				return false;
		} else if (!shippedBusinessEntity.equals(other.shippedBusinessEntity))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
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
				+ ", serialNumber=" + serialNumber + ", invoiceBE="
				+ invoiceBusinessEntity + ",deliveryBE="
				+ shippedBusinessEntity + ", buildDate=" + buildDate + "]";
	}

	@Override
	public int compareTo(ProductSerial o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
