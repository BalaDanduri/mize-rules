package com.mize.domain.shipping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="shipment_tracking")
public class Shipment extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3279332499661281505L;
	
	private BusinessEntity businessEntity;
	private List<ShipmentParty> partyList = new ArrayList<ShipmentParty>();
	private List<ShipmentPackage> shipmentPackages = new ArrayList<ShipmentPackage>();
	private List<ShipmentComment> shipmentComments = new ArrayList<ShipmentComment>();
	private List<PurchaseOrderTracking> purchaseOrderTracking = new ArrayList<PurchaseOrderTracking>();;
	private String entityCode;
	private String entityType;
	private String trackingNumber;
	private String shipmentMethod;
	private String shipmentPriority;
	private String shipmentCarrier;
	private DateTime shipmentDate;
	private DateTime deliveryDate;
	private String shimentStatus;
	private String shipmentLabel;
	private String shipmentLinkInfo;
	private String shipmentAccountNumber;
	private String invoiceNumber;
	private Double customsValue;
	private String currencyCode;
	private Long packageCount;
	private Double shippingAmount;
	private Double handlingAmount;
	private Double freightAmount;
	private Double totalAmount;
	private String deliveryInstructions;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "entity_id")
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipment",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="shipment_party")
	public List<ShipmentParty> getPartyList() {
		return partyList;
	}

	public void setPartyList(List<ShipmentParty> partyList) {
		this.partyList = partyList;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipment",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="shipment_packages")
	public List<ShipmentPackage> getShipmentPackages() {
		return shipmentPackages;
	}

	public void setShipmentPackages(List<ShipmentPackage> shipmentPackages) {
		this.shipmentPackages = shipmentPackages;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipment",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="shipment_comments")
	public List<ShipmentComment> getShipmentComments() {
		return shipmentComments;
	}

	public void setShipmentComments(List<ShipmentComment> shipmentComments) {
		this.shipmentComments = shipmentComments;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipment",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="shipment_po")
	public List<PurchaseOrderTracking> getPurchaseOrderTracking() {
		return purchaseOrderTracking;
	}

	public void setPurchaseOrderTracking(
			List<PurchaseOrderTracking> purchaseOrderTracking) {
		this.purchaseOrderTracking = purchaseOrderTracking;
	}

	@Column(name="entity_code")
	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}

	@Column(name="entity_type")
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@Column(name="tracking_number")
	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Column(name="shipment_method")
	public String getShipmentMethod() {
		return shipmentMethod;
	}

	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	@Column(name="shipment_priority")
	public String getShipmentPriority() {
		return shipmentPriority;
	}

	public void setShipmentPriority(String shipmentPriority) {
		this.shipmentPriority = shipmentPriority;
	}

	@Column(name="shipment_carrier")
	public String getShipmentCarrier() {
		return shipmentCarrier;
	}

	public void setShipmentCarrier(String shipmentCarrier) {
		this.shipmentCarrier = shipmentCarrier;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(false)
	@Column(name = "shipment_date")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getShipmentDate() {
		return shipmentDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setShipmentDate(DateTime shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(false)
	@Column(name = "delivery_date")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getDeliveryDate() {
		return deliveryDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setDeliveryDate(DateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name="shipment_status")
	public String getShimentStatus() {
		return shimentStatus;
	}

	public void setShimentStatus(String shimentStatus) {
		this.shimentStatus = shimentStatus;
	}

	@Column(name="shipment_label")
	public String getShipmentLabel() {
		return shipmentLabel;
	}

	public void setShipmentLabel(String shipmentLabel) {
		this.shipmentLabel = shipmentLabel;
	}

	@Column(name="shipment_link_info")
	public String getShipmentLinkInfo() {
		return shipmentLinkInfo;
	}

	public void setShipmentLinkInfo(String shipmentLinkInfo) {
		this.shipmentLinkInfo = shipmentLinkInfo;
	}

	@Column(name="shipment_account_number")
	public String getShipmentAccountNumber() {
		return shipmentAccountNumber;
	}

	public void setShipmentAccountNumber(String shipmentAccountNumber) {
		this.shipmentAccountNumber = shipmentAccountNumber;
	}

	@Column(name="invoice_number")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@Column(name="customs_value")
	public Double getCustomsValue() {
		return customsValue;
	}

	public void setCustomsValue(Double customsValue) {
		this.customsValue = customsValue;
	}

	@Column(name="currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name="package_count")
	public Long getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(Long packageCount) {
		this.packageCount = packageCount;
	}

	public void setShipingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	@Column(name="handling_amount")
	public Double getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(Double handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	@Column(name="freight_amount")
	public Double getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(Double freightAmount) {
		this.freightAmount = freightAmount;
	}

	@Column(name="total_amount")
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name="shipping_amount")
	public Double getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	@Column(name="delivery_instructions")
	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}

	@Override
	public String toString() {
		return "Shipment [businessEntity=" + businessEntity + ", partyList="
				+ partyList + ", shipmentPackages=" + shipmentPackages
				+ ", shipmentComments=" + shipmentComments
				+ ", purchaseOrderTracking=" + purchaseOrderTracking
				+ ", entityCode=" + entityCode + ", entityType=" + entityType
				+ ", trackingNumber=" + trackingNumber + ", shipmentMethod="
				+ shipmentMethod + ", shipmentPriority=" + shipmentPriority
				+ ", shipmentCarrier=" + shipmentCarrier + ", shipmentDate="
				+ shipmentDate + ", deliveryDate=" + deliveryDate
				+ ", shimentStatus=" + shimentStatus + ", shipmentLabel="
				+ shipmentLabel + ", shipmentLinkInfo=" + shipmentLinkInfo
				+ ", shipmentAccountNumber=" + shipmentAccountNumber
				+ ", invoiceNumber=" + invoiceNumber + ", customsValue="
				+ customsValue + ", currencyCode=" + currencyCode
				+ ", packageCount=" + packageCount + ", shippingAmount="
				+ shippingAmount + ", handlingAmount=" + handlingAmount
				+ ", freightAmount=" + freightAmount + ", totalAmount="
				+ totalAmount + ", deliveryInstructions="
				+ deliveryInstructions + "]";
	}

}
