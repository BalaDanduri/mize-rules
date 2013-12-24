package com.mize.domain.partsorder;

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

import org.codehaus.jackson.annotate.JsonIgnore;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "parts_order_payment")
public class PartsOrderPayment extends MizeEntity implements Comparable<PartsOrderPayment>{	

	private static final long serialVersionUID = 261638805962518728L;	
	private Long orderId;
	private BusinessEntity businessEntity;
	private EntityAddress address = null;
	private String method;
	private PartsOrder partsOrder;

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
	
	@Transient
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payee_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade =CascadeType.ALL)
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
	@JsonIgnore
	public PartsOrder getPartsOrder() {
		return partsOrder;
	}

	public void setPartsOrder(PartsOrder partsOrder) {
		this.partsOrder = partsOrder;
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
		PartsOrderPayment other = (PartsOrderPayment) obj;
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
	public int compareTo(PartsOrderPayment o) {
		return 0;
	}

}
