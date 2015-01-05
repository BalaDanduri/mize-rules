package com.mize.domain.purchaseorder;

import java.math.BigDecimal;

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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDate;

@Entity
@Table(name = "purchase_order_shipment")
public class PurchaseOrderShipment extends MizeSceEntity implements Comparable<PurchaseOrderShipment>{	

	private static final long serialVersionUID = 261638805962518728L;
	private PurchaseOrder purchaseOrder;
	//shipTolocaton
	private BusinessEntity businessEntity;
	private EntityAddress address;	
	private String dropShip;	
	@Transient
	private Long shipmentBeAddressId;	
	private String beCode;
	private String beTypeCode;
	private String beSubTypeCode;
	private String beName;
	private String beFirstName;
	private String beLastName;
	private String beMiddleInitial;
	
	//shipFromlocaton
	private BusinessEntity shipmentFromBE;
	private EntityAddress shipmentFromAddress;
	@Transient
	private Long shipmentFromBeAddressId;
	private String isNewShipFrom;	
	private String fromBECode;
	private String fromBETypeCode;
	private String fromBESubTypeCode;
	private String fromBEName;
	private String fromBEFirstName;
	private String fromBELastName;
	private String fromBEMiddleInitial;
	
	
	private String accountNumber;
	private String isFreeShipping;
	private String method;
	private String priority;
	private String carrier;
	private String estimatedShipmentDays;
	private MizeDate estimatedShipmentDate;
	private BigDecimal estimatedShipmentCost;
	private String shipComplete;
	@Transient
	private EntityComment entityComment;
	private String fromBEReferenceNumber;
	private String beReferenceNumber;
	
	public PurchaseOrderShipment(){
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
	@JoinColumn(name="ship_to_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ship_to_address_id")
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}
	
	@Column(name="shipment_method")
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name="shipment_priority")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Column(name="shipment_carrier")
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Column(name="is_new_ship_to")
	public String getDropShip() {
		return dropShip;
	}

	public void setDropShip(String dropShip) {
		this.dropShip = dropShip;
	}

	@Column(name = "estimated_ship_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateJPA")
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)
	public MizeDate getEstimatedShipmentDate() {
		return estimatedShipmentDate;
	}

	public void setEstimatedShipmentDate(MizeDate estimatedShipmentDate) {
		this.estimatedShipmentDate = estimatedShipmentDate;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonBackReference(value="shipment_purchaseOrder")
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Column(name="estimated_ship_days")
	public String getEstimatedShipmentDays() {
		return estimatedShipmentDays;
	}

	public void setEstimatedShipmentDays(String estimatedShipmentDays) {
		this.estimatedShipmentDays = estimatedShipmentDays;
	}

	@Column(name="estimated_ship_cost")
	public BigDecimal getEstimatedShipmentCost() {
		return estimatedShipmentCost;
	}

	public void setEstimatedShipmentCost(BigDecimal estimatedShipmentCost) {
		this.estimatedShipmentCost = estimatedShipmentCost;
	}
		
	@Override
	public int compareTo(PurchaseOrderShipment o) {
		return 0;
	}
	
	@Column(name = "ship_complete")
	public String getShipComplete() {
		return shipComplete;
	}

	public void setShipComplete(String shipComplete) {
		this.shipComplete = shipComplete;
	}

	@Transient
	public Long getShipmentBeAddressId() {
		return shipmentBeAddressId;
	}

	public void setShipmentBeAddressId(Long shipmentBeAddressId) {
		this.shipmentBeAddressId = shipmentBeAddressId;
	}

	@Column(name = "is_free_shipping")
	public String getIsFreeShipping() {
		return isFreeShipping;
	}

	public void setIsFreeShipping(String isFreeShipping) {
		this.isFreeShipping = isFreeShipping;
	}
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ship_from_be_id")
	public BusinessEntity getShipmentFromBE() {
		return shipmentFromBE;
	}

	public void setShipmentFromBE(BusinessEntity shipmentFromBE) {
		this.shipmentFromBE = shipmentFromBE;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="ship_from_address_id")
	public EntityAddress getShipmentFromAddress() {
		return shipmentFromAddress;
	}

	public void setShipmentFromAddress(EntityAddress shipmentFromAddress) {
		this.shipmentFromAddress = shipmentFromAddress;
	}

	@Column(name="is_new_ship_from")
	public String getIsNewShipFrom() {
		return isNewShipFrom;
	}

	public void setIsNewShipFrom(String isNewShipFrom) {
		this.isNewShipFrom = isNewShipFrom;
	}
	
	@Transient
	public Long getShipmentFromBeAddressId() {
		return shipmentFromBeAddressId;
	}

	public void setShipmentFromBeAddressId(Long shipmentFromBeAddressId) {
		this.shipmentFromBeAddressId = shipmentFromBeAddressId;
	}

	@Column(name="account_no")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Column(name = "ship_to_be_code")
	public String getBeCode() {
		return beCode;
	}

	public void setBeCode(String beCode) {
		this.beCode = beCode;
	}

	@Column(name = "ship_to_be_type_code")
	public String getBeTypeCode() {
		return beTypeCode;
	}

	public void setBeTypeCode(String beTypeCode) {
		this.beTypeCode = beTypeCode;
	}

	@Column(name = "ship_to_be_sub_type_code")
	public String getBeSubTypeCode() {
		return beSubTypeCode;
	}

	public void setBeSubTypeCode(String beSubTypeCode) {
		this.beSubTypeCode = beSubTypeCode;
	}

	@Column(name = "ship_to_be_name")
	public String getBeName() {
		return beName;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	@Column(name = "ship_to_be_first_name")
	public String getBeFirstName() {
		return beFirstName;
	}

	public void setBeFirstName(String beFirstName) {
		this.beFirstName = beFirstName;
	}

	@Column(name = "ship_to_be_last_name")
	public String getBeLastName() {
		return beLastName;
	}

	public void setBeLastName(String beLastName) {
		this.beLastName = beLastName;
	}

	@Column(name = "ship_to_be_middle_initial")
	public String getBeMiddleInitial() {
		return beMiddleInitial;
	}

	public void setBeMiddleInitial(String beMiddleInitial) {
		this.beMiddleInitial = beMiddleInitial;
	}

	@Column(name = "ship_from_be_code")
	public String getFromBECode() {
		return fromBECode;
	}

	public void setFromBECode(String fromBECode) {
		this.fromBECode = fromBECode;
	}

	@Column(name = "ship_from_be_type_code")
	public String getFromBETypeCode() {
		return fromBETypeCode;
	}

	public void setFromBETypeCode(String fromBETypeCode) {
		this.fromBETypeCode = fromBETypeCode;
	}

	@Column(name = "ship_from_be_sub_type_code")
	public String getFromBESubTypeCode() {
		return fromBESubTypeCode;
	}

	public void setFromBESubTypeCode(String fromBESubTypeCode) {
		this.fromBESubTypeCode = fromBESubTypeCode;
	}

	@Column(name = "ship_from_be_name")
	public String getFromBEName() {
		return fromBEName;
	}

	public void setFromBEName(String fromBEName) {
		this.fromBEName = fromBEName;
	}

	@Column(name = "ship_from_be_first_name")
	public String getFromBEFirstName() {
		return fromBEFirstName;
	}

	public void setFromBEFirstName(String fromBEFirstName) {
		this.fromBEFirstName = fromBEFirstName;
	}

	@Column(name = "ship_from_be_last_name")
	public String getFromBELastName() {
		return fromBELastName;
	}

	public void setFromBELastName(String fromBELastName) {
		this.fromBELastName = fromBELastName;
	}

	@Column(name = "ship_from_be_middle_initial")
	public String getFromBEMiddleInitial() {
		return fromBEMiddleInitial;
	}

	public void setFromBEMiddleInitial(String fromBEMiddleInitial) {
		this.fromBEMiddleInitial = fromBEMiddleInitial;
	}

	@Column(name = "ship_from_be_reference")
	public String getFromBEReferenceNumber() {
		return fromBEReferenceNumber;
	}

	public void setFromBEReferenceNumber(String fromBEReferenceNumber) {
		this.fromBEReferenceNumber = fromBEReferenceNumber;
	}

	@Column(name = "ship_to_be_reference")
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
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result
				+ ((dropShip == null) ? 0 : dropShip.hashCode());
		result = prime
				* result
				+ ((estimatedShipmentCost == null) ? 0 : estimatedShipmentCost
						.hashCode());
		result = prime
				* result
				+ ((estimatedShipmentDate == null) ? 0 : estimatedShipmentDate
						.hashCode());
		result = prime
				* result
				+ ((estimatedShipmentDays == null) ? 0 : estimatedShipmentDays
						.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
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
		PurchaseOrderShipment other = (PurchaseOrderShipment) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (dropShip == null) {
			if (other.dropShip != null)
				return false;
		} else if (!dropShip.equals(other.dropShip))
			return false;
		if (estimatedShipmentCost == null) {
			if (other.estimatedShipmentCost != null)
				return false;
		} else if (!estimatedShipmentCost.equals(other.estimatedShipmentCost))
			return false;
		if (estimatedShipmentDate == null) {
			if (other.estimatedShipmentDate != null)
				return false;
		} else if (!estimatedShipmentDate.equals(other.estimatedShipmentDate))
			return false;
		if (estimatedShipmentDays == null) {
			if (other.estimatedShipmentDays != null)
				return false;
		} else if (!estimatedShipmentDays.equals(other.estimatedShipmentDays))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrderShipment [dropShip=" + dropShip
				+ ", shipmentBeAddressId=" + shipmentBeAddressId + ", beCode="
				+ beCode + ", beTypeCode=" + beTypeCode + ", beSubTypeCode="
				+ beSubTypeCode + ", beName=" + beName + ", beFirstName="
				+ beFirstName + ", beLastName=" + beLastName
				+ ", beMiddleInitial=" + beMiddleInitial
				+ ", shipmentFromBeAddressId=" + shipmentFromBeAddressId
				+ ", isNewShipFrom=" + isNewShipFrom + ", fromBECode="
				+ fromBECode + ", fromBETypeCode=" + fromBETypeCode
				+ ", fromBESubTypeCode=" + fromBESubTypeCode + ", fromBEName="
				+ fromBEName + ", fromBEFirstName=" + fromBEFirstName
				+ ", fromBELastName=" + fromBELastName
				+ ", fromBEMiddleInitial=" + fromBEMiddleInitial
				+ ", accountNumber=" + accountNumber + ", isFreeShipping="
				+ isFreeShipping + ", method=" + method + ", priority="
				+ priority + ", carrier=" + carrier
				+ ", estimatedShipmentDays=" + estimatedShipmentDays
				+ ", estimatedShipmentDate=" + estimatedShipmentDate
				+ ", estimatedShipmentCost=" + estimatedShipmentCost
				+ ", shipComplete=" + shipComplete + ", fromBEReferenceNumber="
				+ fromBEReferenceNumber + ", beReferenceNumber="
				+ beReferenceNumber + "]";
	}
	
}
