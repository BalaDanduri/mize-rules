package com.mize.domain.purchaseorder;

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

import org.codehaus.jackson.annotate.JsonBackReference;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "purchase_order_payment")
public class PurchaseOrderPayment extends MizeEntity implements Comparable<PurchaseOrderPayment>{	

	private static final long serialVersionUID = 261638805962518728L;
	private BusinessEntity businessEntity;
	private EntityAddress address;
	private String method;
	private PurchaseOrder purchaseOrder;

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
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="payee_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade =CascadeType.ALL)
	@JoinColumn(name="payee_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	@Column(name="payment_method")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="payment_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PurchaseOrderPayment other = (PurchaseOrderPayment) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartsOrderPayment [id=" + id + ", address=" + address
				+ ", method=" + method + "]";
	}

	@Override
	public int compareTo(PurchaseOrderPayment o) {
		return 0;
	}

}
