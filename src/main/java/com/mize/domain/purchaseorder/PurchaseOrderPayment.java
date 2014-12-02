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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeSceEntity;

@Entity
@Table(name = "purchase_order_payment")
public class PurchaseOrderPayment extends MizeSceEntity implements Comparable<PurchaseOrderPayment>{	

	private static final long serialVersionUID = 261638805962518728L;
	private BusinessEntity businessEntity;
	private EntityAddress address;
	private String method;
	private PurchaseOrder purchaseOrder;
	private String paymentReference;
	@Transient
	private Long paymentBeAddressId;
	@Transient
	private String updateMasterAddress;
	private String beCode;
	private String beTypeCode;
	private String beSubTypeCode;
	private String beName;
	private String beFirstName;
	private String beLastName;
	private String beMiddleInitial;
	private String beReferenceNumber;
	public PurchaseOrderPayment(){
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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
		
	@Column(name="payment_reference")
	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	@Transient
	public Long getPaymentBeAddressId() {
		return paymentBeAddressId;
	}

	public void setPaymentBeAddressId(Long paymentBeAddressId) {
		this.paymentBeAddressId = paymentBeAddressId;
	}

	@Transient	
	public String getUpdateMasterAddress() {
		return updateMasterAddress;
	}

	public void setUpdateMasterAddress(String updateMasterAddress) {
		this.updateMasterAddress = updateMasterAddress;
	}
	
	@Column(name="payee_be_code")
	public String getBeCode() {
		return beCode;
	}

	public void setBeCode(String beCode) {
		this.beCode = beCode;
	}

	@Column(name="payee_be_type_code")
	public String getBeTypeCode() {
		return beTypeCode;
	}

	public void setBeTypeCode(String beTypeCode) {
		this.beTypeCode = beTypeCode;
	}

	@Column(name="payee_be_sub_type_code")
	public String getBeSubTypeCode() {
		return beSubTypeCode;
	}

	public void setBeSubTypeCode(String beSubTypeCode) {
		this.beSubTypeCode = beSubTypeCode;
	}

	@Column(name="payee_be_name")
	public String getBeName() {
		return beName;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	@Column(name="payee_be_first_name")
	public String getBeFirstName() {
		return beFirstName;
	}

	public void setBeFirstName(String beFirstName) {
		this.beFirstName = beFirstName;
	}

	@Column(name="payee_be_last_name")
	public String getBeLastName() {
		return beLastName;
	}

	public void setBeLastName(String beLastName) {
		this.beLastName = beLastName;
	}

	@Column(name="payee_be_middle_initial")
	public String getBeMiddleInitial() {
		return beMiddleInitial;
	}

	public void setBeMiddleInitial(String beMiddleInitial) {
		this.beMiddleInitial = beMiddleInitial;
	}

	@Column(name="payee_be_reference")	
	public String getBeReferenceNumber() {
		return beReferenceNumber;
	}

	public void setBeReferenceNumber(String beReferenceNumber) {
		this.beReferenceNumber = beReferenceNumber;
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
		return "PurchaseOrderPayment [method=" + method + ", paymentReference="
				+ paymentReference + ", paymentBeAddressId="
				+ paymentBeAddressId + ", updateMasterAddress="
				+ updateMasterAddress + ", beCode=" + beCode + ", beTypeCode="
				+ beTypeCode + ", beSubTypeCode=" + beSubTypeCode + ", beName="
				+ beName + ", beFirstName=" + beFirstName + ", beLastName="
				+ beLastName + ", beMiddleInitial=" + beMiddleInitial
				+ ", beReferenceNumber=" + beReferenceNumber + "]";
	}

	@Override
	public int compareTo(PurchaseOrderPayment o) {
		return 0;
	}

}
