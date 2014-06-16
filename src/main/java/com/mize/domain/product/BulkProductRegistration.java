package com.mize.domain.product;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

public class BulkProductRegistration extends MizeEntity {
	

	private static final long serialVersionUID = -382244544017949006L;
	
	private String invoiceNumber;
	private BusinessEntity invoiceEntity;
	private BusinessEntity customer;
	private EntityAddress customerAddress;
	private DateTime purchaseDate;
	private EntityComment entityComment;
	private List<ProductRegistration> productRegistrations = new ArrayList<ProductRegistration>();
	private User user;
	private String dealerCustomerReference;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public BulkProductRegistration() {
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public BusinessEntity getInvoiceEntity() {
		return invoiceEntity;
	}
	
	public BusinessEntity getCustomer() {
		return customer;
	}

	public EntityAddress getCustomerAddress() {
		return customerAddress;
	}
	
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getPurchaseDate() {
		return purchaseDate;
	}

	public EntityComment getEntityComment() {
		return entityComment;
	}

	public List<ProductRegistration> getProductRegistrations() {
		return productRegistrations;
	}
	
	public User getUser() {
		return user;
	}
	
	public String getDealerCustomerReference() {
		return dealerCustomerReference;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public void setInvoiceEntity(BusinessEntity invoiceEntity) {
		this.invoiceEntity = invoiceEntity;
	}

	public void setCustomer(BusinessEntity customer) {
		this.customer = customer;
	}

	public void setCustomerAddress(EntityAddress customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setPurchaseDate(DateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	public void setProductRegistrations(List<ProductRegistration> productRegistrations) {
		this.productRegistrations = productRegistrations;
	}
	
	public void setDealerCustomerReference(String dealerCustomerReference) {
		this.dealerCustomerReference = dealerCustomerReference;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = 1;
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result
				+ ((entityComment == null) ? 0 : entityComment.hashCode());
		result = prime * result
				+ ((invoiceEntity == null) ? 0 : invoiceEntity.hashCode());
		result = prime * result
				+ ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
		result = prime
				* result
				+ ((productRegistrations == null) ? 0 : productRegistrations
						.hashCode());
		result = prime * result
				+ ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BulkProductRegistration)) {
			return false;
		}
		BulkProductRegistration other = (BulkProductRegistration) obj;
		if (customer == null) {
			if (other.customer != null) {
				return false;
			}
		} else if (!customer.equals(other.customer)) {
			return false;
		}
		if (customerAddress == null) {
			if (other.customerAddress != null) {
				return false;
			}
		} else if (!customerAddress.equals(other.customerAddress)) {
			return false;
		}
		if (entityComment == null) {
			if (other.entityComment != null) {
				return false;
			}
		} else if (!entityComment.equals(other.entityComment)) {
			return false;
		}
		if (invoiceEntity == null) {
			if (other.invoiceEntity != null) {
				return false;
			}
		} else if (!invoiceEntity.equals(other.invoiceEntity)) {
			return false;
		}
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null) {
				return false;
			}
		} else if (!invoiceNumber.equals(other.invoiceNumber)) {
			return false;
		}
		if (productRegistrations == null) {
			if (other.productRegistrations != null) {
				return false;
			}
		} else if (!productRegistrations.containsAll(other.productRegistrations)) {
			return false;
		}
		if (purchaseDate == null) {
			if (other.purchaseDate != null) {
				return false;
			}
		} else if (!purchaseDate.equals(other.purchaseDate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BulkProductRegistration [customer=" + customer
				+ ", customerAddress=" + customerAddress + ", entityComment="
				+ entityComment + ", invoiceEntity=" + invoiceEntity
				+ ", invoiceNumber=" + invoiceNumber
				+ ", productRegistrations=" + productRegistrations
				+ ", purchaseDate=" + purchaseDate + "]";
	}

}
