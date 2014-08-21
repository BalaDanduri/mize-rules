package com.mize.domain.sce.serviceentity;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityContact;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.Product;
import com.mize.domain.product.ProductRegistration;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rqst_prd")
public class ServiceEntityRequestProduct extends MizeEntity {

	private static final long serialVersionUID = -1812475489451721317L;
	
	private ServiceEntityRequest serviceEntityRequest;
	private Product product;
	private Long productId;
	private ProductSerial productSerial;
	private Long productSerialId;
	private ProductRegistration registration;
	private Long ProdRegnId;
	private String productName;
	private String model;
	private String brandName;
	private String categoryName;
	private String serialNumber;
	private Long customerId;
	private String customerCode;
	private String customerTypeCode;
	private String customerSubTypeCode;
	private String customerName;
	private String customerFirstName;
	private String customerLastName;
	private String customerMiddleInitial;
	private String customerReference;
	private EntityAddress customerAddress;
	private EntityContact customerContact;
	private String isNewCustomer;

	public ServiceEntityRequestProduct() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_request_id")
	@JsonBackReference(value="service_request_product")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityRequest getServiceEntityRequest() {
		return serviceEntityRequest;
	}

	public void setServiceEntityRequest(ServiceEntityRequest serviceEntityRequest) {
		this.serviceEntityRequest = serviceEntityRequest;
	}
	
	@Transient
	@JsonIgnore
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Column(name = "prod_id", nullable = true)
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	@Transient
	@JsonIgnore
	public ProductSerial getProductSerial() {
		return productSerial;
	}	
	
	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}
	
	@Column(name = "prod_serial_id", nullable = true)
	public Long getProductSerialId() {
		return productSerialId;
	}
	
	public void setProductSerialId(Long productSerialId) {
		this.productSerialId = productSerialId;
	}
	
	@Transient
	@JsonIgnore
	public ProductRegistration getRegistration() {
		return registration;
	}

	public void setRegistration(ProductRegistration registration) {
		this.registration = registration;
	}
	
	@Column(name = "prod_regn_id", nullable = true)
	public Long getProdRegnId() {
		return ProdRegnId;
	}
	
	public void setProdRegnId(Long prodRegnId) {
		ProdRegnId = prodRegnId;
	}
	
	@Column(name = "prod_name", length = 250)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "model", length = 50)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name = "brand_name", length = 250)
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	@Column(name = "prod_cat_name", length = 250)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Column(name = "prod_srl_no", length = 200)
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}	
	
	@Column(name = "customer_be_id")
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	@Column(name = "customer_be_code", length = 50)
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	@Column(name = "customer_be_type_code", length = 50)
	public String getCustomerTypeCode() {
		return customerTypeCode;
	}

	public void setCustomerTypeCode(String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
	}
	
	@Column(name = "customer_be_sub_type_code", length = 50)
	public String getCustomerSubTypeCode() {
		return customerSubTypeCode;
	}
	
	
	public void setCustomerSubTypeCode(String customerSubTypeCode) {
		this.customerSubTypeCode = customerSubTypeCode;
	}
	
	@Column(name = "customer_be_name", length = 250)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Column(name = "customer_be_first_name", length = 100)
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	
	@Column(name = "customer_be_last_name", length = 100)
	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	
	@Column(name = "customer_be_middle_initial", length = 50)
	public String getCustomerMiddleInitial() {
		return customerMiddleInitial;
	}

	public void setCustomerMiddleInitial(String customerMiddleInitial) {
		this.customerMiddleInitial = customerMiddleInitial;
	}
	
	@Column(name = "customer_be_reference", length = 100)
	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "customer_address_id")
	public EntityAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(EntityAddress customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "customer_contact_id")
	public EntityContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(EntityContact customerContact) {
		this.customerContact = customerContact;
	}
	
	@Column(name = "is_new_customer", length = 1)
	public String getIsNewCustomer() {
		return isNewCustomer;
	}

	public void setIsNewCustomer(String isNewCustomer) {
		this.isNewCustomer = isNewCustomer;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result
				+ ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((productSerial == null) ? 0 : productSerial.hashCode());
		result = prime * result
				+ ((registration == null) ? 0 : registration.hashCode());
		result = prime * result
				+ ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime
				* result
				+ ((serviceEntityRequest == null) ? 0 : serviceEntityRequest
						.hashCode());
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
		ServiceEntityRequestProduct other = (ServiceEntityRequestProduct) obj;
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productSerial == null) {
			if (other.productSerial != null)
				return false;
		} else if (!productSerial.equals(other.productSerial))
			return false;
		if (registration == null) {
			if (other.registration != null)
				return false;
		} else if (!registration.equals(other.registration))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (serviceEntityRequest == null) {
			if (other.serviceEntityRequest != null)
				return false;
		} else {
			if(serviceEntityRequest.getId() == null) {
				if(other.serviceEntityRequest.getId() != null)
					return false;
			} else if(!serviceEntityRequest.getId().equals(other.serviceEntityRequest.getId()))
				return false;
		}
		return true;
	}	
	

}
