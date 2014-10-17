package com.mize.domain.shipping;

import java.math.BigDecimal;
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
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="shipment_tracking")
public class ShipmentTracking extends MizeEntity implements Comparable<ShipmentTracking>{
	
	private static final long serialVersionUID = -3279332499661281505L;	
	private BusinessEntity tenant;
	private List<ShipmentParty> parties = new ArrayList<ShipmentParty>();
	private List<ShipmentPackage> packages = new ArrayList<ShipmentPackage>();
	private List<ShipmentComment> comments = new ArrayList<ShipmentComment>();
	private Long entityId;
	private String entityCode;
	private String entityType;
	private String trackingNumber;
	private String method;
	private String priority;
	private String carrier;
	private String shipmentCarrierName;
	private DateTime shipmentDate;
	private DateTime deliveryDate;
	private DateTime confirmationDate;
	private String status;
	private String label;
	private String shipmentLinkInfo;
	private String accountNumber;
	private String invoiceNumber;
	private BigDecimal customsValue;
	private String currencyCode;
	private Integer packageCount;
	private BigDecimal shippingAmount;
	private BigDecimal handlingAmount;
	private BigDecimal freightAmount;
	private BigDecimal totalAmount;
	private String deliveryInstructions;
	@Transient
	private EntityComment entityComment;
	@Transient
	private User user;
	private BigDecimal totalWeight;	
	private String totalWeightUOM;	
	@Transient
	private ShipmentEntity shipmentEntity;
	@Transient
	private String fromEntity;
	private List<ShipmentItem> shipmentItems = new ArrayList<ShipmentItem>();
	private String reasonForExport;
	@Transient
	private String isIntlShipment;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JoinColumn(name = "tenant_id")
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipmentTracking",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ShipmentParty> getParties() {
		return parties;
	}

	public void setParties(List<ShipmentParty> partyList) {
		this.parties = partyList;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipmentTracking",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ShipmentPackage> getPackages() {
		return packages;
	}

	public void setPackages(List<ShipmentPackage> packages) {
		this.packages = packages;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipmentTracking",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ShipmentComment> getComments() {
		return comments;
	}

	public void setComments(List<ShipmentComment> comments) {
		this.comments = comments;
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
	@Column(name="shipment_carrier_name")
	public String getShipmentCarrierName() {
		return shipmentCarrierName;
	}

	public void setShipmentCarrierName(String shipmentCarrierName) {
		this.shipmentCarrierName = shipmentCarrierName;
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
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="shipment_label")
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name="shipment_link_info")
	public String getShipmentLinkInfo() {
		return shipmentLinkInfo;
	}

	public void setShipmentLinkInfo(String shipmentLinkInfo) {
		this.shipmentLinkInfo = shipmentLinkInfo;
	}

	@Column(name="shipment_account_number")
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name="invoice_number")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	@Column(name="customs_value")
	public BigDecimal getCustomsValue() {
		return customsValue;
	}

	public void setCustomsValue(BigDecimal customsValue) {
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
	public Integer getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(Integer packageCount) {
		this.packageCount = packageCount;
	}

	public void setShipingAmount(BigDecimal shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	@Column(name="handling_amount")
	public BigDecimal getHandlingAmount() {
		return handlingAmount;
	}

	public void setHandlingAmount(BigDecimal handlingAmount) {
		this.handlingAmount = handlingAmount;
	}

	@Column(name="freight_amount")
	public BigDecimal getFreightAmount() {
		return freightAmount;
	}

	public void setFreightAmount(BigDecimal freightAmount) {
		this.freightAmount = freightAmount;
	}

	@Column(name="total_amount")
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name="shipping_amount")
	public BigDecimal getShippingAmount() {
		return shippingAmount;
	}
	
	@Column(name="entity_id")
	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public void setShippingAmount(BigDecimal shippingAmount) {
		this.shippingAmount = shippingAmount;
	}
	
	@Column(name="delivery_instructions")
	public String getDeliveryInstructions() {
		return deliveryInstructions;
	}

	public void setDeliveryInstructions(String deliveryInstructions) {
		this.deliveryInstructions = deliveryInstructions;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore(false)
	@Column(name = "created_date", updatable = false)
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getCreatedDate() {
		return this.createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonIgnore(false)
	public DateTime getUpdatedDate() {
		return this.updatedDate;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}	

	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@JsonIgnore(false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return this.updatedBy;
	}
	
	@JsonIgnore(false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@JsonIgnore(false)
	@Column(name = "created_by", updatable = false)
	public Long getCreatedBy() {
		return this.createdBy;
	}
	
	@JsonIgnore(false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "total_weight")
	public BigDecimal getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(BigDecimal totalWeight) {
		this.totalWeight = totalWeight;
	}

	@Transient
	public ShipmentEntity getShipmentEntity() {
		return shipmentEntity;
	}

	public void setShipmentEntity(ShipmentEntity shipmentEntity) {
		this.shipmentEntity = shipmentEntity;
	}

	@Transient
	public String getFromEntity() {
		return fromEntity;
	}

	public void setFromEntity(String fromEntity) {
		this.fromEntity = fromEntity;
	}

	@Column(name="total_weight_uom")
	public String getTotalWeightUOM() {
		return totalWeightUOM;
	}

	public void setTotalWeightUOM(String totalWeightUOM) {
		this.totalWeightUOM = totalWeightUOM;
	}
	
	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_NULL)
	@Column(name = "confirmation_date")
	@org.hibernate.annotations.Type(type = "com.mize.domain.util.DateTimeJPA")
	public DateTime getConfirmationDate() {
		return confirmationDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	public void setConfirmationDate(DateTime confirmationDate) {
		this.confirmationDate = confirmationDate;
	}

	@OneToMany(cascade={CascadeType.ALL}, mappedBy="shipmentTracking",orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ShipmentItem> getShipmentItems() {
		return shipmentItems;
	}

	public void setShipmentItems(List<ShipmentItem> shipmentItems) {
		this.shipmentItems = shipmentItems;
	}

	@Column(name="reason_for_export")
	public String getReasonForExport() {
		return reasonForExport;
	}

	public void setReasonForExport(String reasonForExport) {
		this.reasonForExport = reasonForExport;
	}

	@Transient
	public String getIsIntlShipment() {
		return isIntlShipment;
	}

	public void setIsIntlShipment(String isIntlShipment) {
		this.isIntlShipment = isIntlShipment;
	}

	@Override
	public int compareTo(ShipmentTracking o) {
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime
				* result
				+ ((confirmationDate == null) ? 0 : confirmationDate.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((customsValue == null) ? 0 : customsValue.hashCode());
		result = prime * result
				+ ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime
				* result
				+ ((deliveryInstructions == null) ? 0 : deliveryInstructions
						.hashCode());
		result = prime * result
				+ ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((freightAmount == null) ? 0 : freightAmount.hashCode());
		result = prime * result
				+ ((fromEntity == null) ? 0 : fromEntity.hashCode());
		result = prime * result
				+ ((handlingAmount == null) ? 0 : handlingAmount.hashCode());
		result = prime * result
				+ ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result
				+ ((packageCount == null) ? 0 : packageCount.hashCode());
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((shipmentDate == null) ? 0 : shipmentDate.hashCode());
		result = prime * result
				+ ((shipmentEntity == null) ? 0 : shipmentEntity.hashCode());
		result = prime
				* result
				+ ((shipmentLinkInfo == null) ? 0 : shipmentLinkInfo.hashCode());
		result = prime * result
				+ ((shippingAmount == null) ? 0 : shippingAmount.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result
				+ ((totalWeight == null) ? 0 : totalWeight.hashCode());
		result = prime * result
				+ ((totalWeightUOM == null) ? 0 : totalWeightUOM.hashCode());
		result = prime * result
				+ ((trackingNumber == null) ? 0 : trackingNumber.hashCode());
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
		ShipmentTracking other = (ShipmentTracking) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (confirmationDate == null) {
			if (other.confirmationDate != null)
				return false;
		} else if (!confirmationDate.equals(other.confirmationDate))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (customsValue == null) {
			if (other.customsValue != null)
				return false;
		} else if (!customsValue.equals(other.customsValue))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		if (deliveryInstructions == null) {
			if (other.deliveryInstructions != null)
				return false;
		} else if (!deliveryInstructions.equals(other.deliveryInstructions))
			return false;
		if (entityCode == null) {
			if (other.entityCode != null)
				return false;
		} else if (!entityCode.equals(other.entityCode))
			return false;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
			return false;
		if (freightAmount == null) {
			if (other.freightAmount != null)
				return false;
		} else if (!freightAmount.equals(other.freightAmount))
			return false;
		if (fromEntity == null) {
			if (other.fromEntity != null)
				return false;
		} else if (!fromEntity.equals(other.fromEntity))
			return false;
		if (handlingAmount == null) {
			if (other.handlingAmount != null)
				return false;
		} else if (!handlingAmount.equals(other.handlingAmount))
			return false;
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null)
				return false;
		} else if (!invoiceNumber.equals(other.invoiceNumber))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (packageCount == null) {
			if (other.packageCount != null)
				return false;
		} else if (!packageCount.equals(other.packageCount))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (shipmentDate == null) {
			if (other.shipmentDate != null)
				return false;
		} else if (!shipmentDate.equals(other.shipmentDate))
			return false;
		if (shipmentEntity == null) {
			if (other.shipmentEntity != null)
				return false;
		} else if (!shipmentEntity.equals(other.shipmentEntity))
			return false;
		if (shipmentLinkInfo == null) {
			if (other.shipmentLinkInfo != null)
				return false;
		} else if (!shipmentLinkInfo.equals(other.shipmentLinkInfo))
			return false;
		if (shippingAmount == null) {
			if (other.shippingAmount != null)
				return false;
		} else if (!shippingAmount.equals(other.shippingAmount))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalWeight == null) {
			if (other.totalWeight != null)
				return false;
		} else if (!totalWeight.equals(other.totalWeight))
			return false;
		if (totalWeightUOM == null) {
			if (other.totalWeightUOM != null)
				return false;
		} else if (!totalWeightUOM.equals(other.totalWeightUOM))
			return false;
		if (trackingNumber == null) {
			if (other.trackingNumber != null)
				return false;
		} else if (!trackingNumber.equals(other.trackingNumber))
			return false;
		return true;
	}

}
