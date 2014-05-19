package com.mize.domain.purchaseorder;

import java.math.BigDecimal;
import java.util.List;

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

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "purchase_order_shipment")
public class PurchaseOrderShipment extends MizeEntity implements Comparable<PurchaseOrderShipment>{	

	private static final long serialVersionUID = 261638805962518728L;
	//shipTolocaton
	private BusinessEntity businessEntity;
	private EntityAddress address;
	private String method;
	private String priority;
	private String carrier;
	private String estimatedShipmentDays;
	private String dropShip;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime estimatedShipmentDate;
	private BigDecimal estimatedShipmentCost;
	private PurchaseOrder purchaseOrder;
	@Transient
	private String updateMasterAddress;
	private String shipComplete;
	@Transient
	private Long shipmentBeAddressId;
	private String isFreeShipping;
	private BusinessEntity shipmentFromBE;
	private EntityAddress shipmentFromAddress;
	@Transient
	private Long shipmentFromBeAddressId;
	private String isNewShipFrom;
	@Transient
	List<BusinessEntity> childBusinessEntities;
	@Transient
	List<BusinessEntity> childShipFromBusinessEntities;
	
	
	public PurchaseOrderShipment(){
		super();
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
	@JoinColumn(name="shipment_to_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="shipment_to_address_id")
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

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "estimated_ship_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getEstimatedShipmentDate() {
		return estimatedShipmentDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEstimatedShipmentDate(DateTime estimatedShipmentDate) {
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

	@Transient
	public String getUpdateMasterAddress() {
		return updateMasterAddress;
	}

	public void setUpdateMasterAddress(String updateMasterAddress) {
		this.updateMasterAddress = updateMasterAddress;
	}

	@Column(name = "is_free_shipping")
	public String getIsFreeShipping() {
		return isFreeShipping;
	}

	public void setIsFreeShipping(String isFreeShipping) {
		this.isFreeShipping = isFreeShipping;
	}
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shipment_from_be_id")
	public BusinessEntity getShipmentFromBE() {
		return shipmentFromBE;
	}

	public void setShipmentFromBE(BusinessEntity shipmentFromBE) {
		this.shipmentFromBE = shipmentFromBE;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="shipment_from_address_id")
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

	@Transient
	public List<BusinessEntity> getChildBusinessEntities() {
		return childBusinessEntities;
	}

	public void setChildBusinessEntities(List<BusinessEntity> childBusinessEntities) {
		this.childBusinessEntities = childBusinessEntities;
	}
	
	@Transient
	public List<BusinessEntity> getChildShipFromBusinessEntities() {
		return childShipFromBusinessEntities;
	}

	public void setChildShipFromBusinessEntities(
			List<BusinessEntity> childShipFromBusinessEntities) {
		this.childShipFromBusinessEntities = childShipFromBusinessEntities;
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
		return "PurchaseOrderShipment [address=" + address + ", method="
				+ method + ", priority=" + priority + ", carrier=" + carrier
				+ ", estimatedShipmentDays=" + estimatedShipmentDays
				+ ", dropShip=" + dropShip + ", estimatedShipmentDate="
				+ estimatedShipmentDate + ", estimatedShipmentCost="
				+ estimatedShipmentCost + "]";
	}
	
	

}
