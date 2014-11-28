package com.mize.domain.product;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "prod_serial", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class ProductSerial extends MizeSceEntity implements Comparable<ProductSerial>{
	
	private static final long serialVersionUID = 1396934864607540803L;
	private BusinessEntity tenant;
	private Product product;
	private String serialNumber;
	private BusinessEntity shippedBusinessEntity;
	private MizeDate buildDate;
	@Transient
	private EntityComment entityComment;
	private List<ProductSerialComment> comments = new ArrayList<ProductSerialComment>();
	@Transient
	private User user;
	private MizeDate shipDate;
	private String isValid;
	private BusinessEntity invoiceBusinessEntity;
	private MizeDate invoiceDate;
	private String invoiceNumber;
	private List<ProductSerialRelation> productSerialRelations = new ArrayList<ProductSerialRelation>();
	private List<ProductWarranty> productWarrantyList = new ArrayList<ProductWarranty>();
	
	public ProductSerial(){
		super();
	}

	public ProductSerial(BusinessEntity tenantId, Product product, String serialNumber,BusinessEntity invoiceBusinessEntity,
			BusinessEntity shippedBusinessEntity, MizeDate deliveryDate, MizeDate buildDate) {
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
	@Column(name = "id", nullable = false, unique = true)
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

	@Column(name = "prod_srl_no", nullable = true)
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


	
	@Column(name = "build_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(MizeDate buildDate) {
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
	
	@Column(name= "is_valid", length = 1)
	public String getIsValid() {
		return isValid;
	}
	
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	
	
	@Column(name = "ship_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getShipDate() {
		return shipDate;
	}
	
	public void setShipDate(MizeDate shipDate) {
		this.shipDate = shipDate;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="invoice_be_id", nullable = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getInvoiceBusinessEntity() {
		return invoiceBusinessEntity;
	}

	public void setInvoiceBusinessEntity(BusinessEntity invoiceBusinessEntity) {
		this.invoiceBusinessEntity = invoiceBusinessEntity;
	}

	
	@Column(name = "invoice_date", nullable = true)
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(MizeDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Column(name = "invoice_no", nullable = true)
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

	@Override	
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(false)
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@Type(type="com.mize.domain.util.MizeDateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(false)
	public MizeDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@JsonIgnore(false)
	public void setCreatedDate(MizeDateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@JsonIgnore(false)
	public void setUpdatedDate(MizeDateTime updatedDate) {
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
	
	
	@Override
	public void setCreatedByUser(String createdByUser){
	      this.createdByUser=createdByUser;
	}
	@Override
	@JsonIgnore(value=false)
	@Column(name = "created_by_user" , updatable=false)
	public String getCreatedByUser(){
		 return createdByUser;
		 
	}
	
	@Override
	@JsonIgnore(value=false)
	@Column(name = "updated_by_user")
	public String getUpdatedByUser() {
		return updatedByUser;
	}
    
	@JsonIgnore(value=false)
	@Override
	public void setUpdatedByUser(String updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	@JsonIgnore(value=false)
	@Override
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@JsonIgnore(value=false)
	@Override
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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
