package com.mize.domain.purchaseorder;

import java.math.BigDecimal;

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

import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "purchase_order_ship_package")
public class PurchaseOrderShipPackage extends MizeEntity implements Comparable<PurchaseOrderShipPackage> {
	
	private static final long serialVersionUID = -2022440556429781784L;
	private PurchaseOrderShipment orderShipment;
	private String number;
	private BigDecimal weight;
	private String method;
	private String priority;
	private String carrier;
	private DateTime shipmentDate;
	private String trackingNumber;
	private String status;
	private String label;
	private String linkInfo;
	private String warehouseCode;
	private String warehouseName;
	private String warehouseItemStatus;
	private BigDecimal handlingAmount;
	private BigDecimal freightAmount;
	private BigDecimal totalAmount;

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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ship_package_id")
	@JsonBackReference(value="package_orderShipment")
	public PurchaseOrderShipment getOrderShipment() {
		return orderShipment;
	}

	public void setOrderShipment(PurchaseOrderShipment orderShipment) {
		this.orderShipment = orderShipment;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public DateTime getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(DateTime shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLinkInfo() {
		return linkInfo;
	}

	public void setLinkInfo(String linkInfo) {
		this.linkInfo = linkInfo;
	}

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public String getWarehouseItemStatus() {
		return warehouseItemStatus;
	}

	public void setWarehouseItemStatus(String warehouseItemStatus) {
		this.warehouseItemStatus = warehouseItemStatus;
	}

	public BigDecimal getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(BigDecimal handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
 
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "created_by" , updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@Override
	public int compareTo(PurchaseOrderShipPackage o) {
		return 0;
	}

}
