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
@Table(name = "purchase_order_requester")
public class PurchaseOrderRequester extends MizeEntity implements Comparable<PurchaseOrderRequester>{	

	private static final long serialVersionUID = 444432988617420731L;
	private PurchaseOrder purchaseOrder;
	private BusinessEntity businessEntity;
	private EntityAddress address = null;

	public PurchaseOrderRequester(){
		super();
	}
	
	public PurchaseOrderRequester(BusinessEntity businessEntity,EntityAddress address){
		super();
		this.businessEntity = businessEntity;
		this.address = address;
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

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="requester_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade =CascadeType.ALL)
	@JoinColumn(name="requester_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="requester_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public int compareTo(PurchaseOrderRequester o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
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
		PurchaseOrderRequester other = (PurchaseOrderRequester) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PartsOrderRequester [id=" + id + "]";
	}	

}
