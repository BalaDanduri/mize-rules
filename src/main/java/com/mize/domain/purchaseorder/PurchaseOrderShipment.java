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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "purchase_order_shipment")
public class PurchaseOrderShipment extends MizeEntity implements Comparable<PurchaseOrderShipment>{	

	private static final long serialVersionUID = 261638805962518728L;
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
	@JoinColumn(name="shipment_be_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="shipment_address_id")
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

	@Column(name="drop_ship")
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
