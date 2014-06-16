package com.mize.domain.purchaseorder;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.Formatter;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
@Entity
@Table(name = "purchase_order", uniqueConstraints = {@UniqueConstraint (columnNames = {"order_number"})})
public class PurchaseOrder extends MizeEntity implements Comparable<PurchaseOrder>{	
	
	private static final long serialVersionUID = 6676650598420396291L;
	private BusinessEntity tenant;
	private String number;
	private String type;			
	private String requestType;
	private String status;
	private Locale locale;
	private String currencyCode;
	private String orderReference;
	private String salesPerson;
	private Long discountId;
	private PurchaseOrderAmount amount = new PurchaseOrderAmount();
	private PurchaseOrderRequester requester;
	private PurchaseOrderPayment payment;
	private PurchaseOrderShipment shipment;
	private List<PurchaseOrderAudit> audits = new ArrayList<PurchaseOrderAudit>();
	private List<PurchaseOrderAttachment> attachments = new ArrayList<PurchaseOrderAttachment>();
	private List<PurchaseOrderComment> comments = new ArrayList<PurchaseOrderComment>();
	private List<PurchaseOrderMessage> messages = new ArrayList<PurchaseOrderMessage>();
	private List<PurchaseOrderItem> orderItems = new ArrayList<PurchaseOrderItem>();
	@Transient
	private EntityComment entityComment;
	@Transient
	private EntityAttachment entityAttachment;
	@Transient
	private User user;
	private String applyHandlingCharge;
	@Transient
	private BigDecimal handlingChargePercentage;
	@Transient
	private String pickListCode;
	@Transient
	private String importFileName;
	@Transient
	private PurchaseOrderParameter orderParameter;
	private Long entityParameterId;
	private String model;
	private String productSerial;
	@Transient
	private String importFrom;
	@Transient
	private String importFileType;
	@Transient
	private String originalOrderNumber;
	@Transient
	private String tabName;
	
	public PurchaseOrder(){
		super();
	}
	
	public PurchaseOrder(Long id,String number,String status,String type,String requestType,DateTime createdDate,DateTime updatedDate){
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.requestType = requestType;
		this.status = status;	
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	
	public PurchaseOrder(Long id,String number,String status,String type,String requestType,
			DateTime createdDate,DateTime updatedDate,String itemNumber,BigDecimal quantity,String isReturnable,String originalOrderNumber){
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.requestType = requestType;
		this.status = status;	
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.orderItems = new ArrayList<PurchaseOrderItem>();
		PurchaseOrderItem item = new PurchaseOrderItem();
		item.setNumber(itemNumber);
		item.setRequestedQuantity(quantity);
		item.setIsReturnable(isReturnable);
		item.setOriginalOrderNumber(originalOrderNumber);
		this.getOrderItems().add(item);
	}
	
	public enum Status{
		Draft,Pending,Approved,Deleted,Rejected,Closed,Open,Completed,
		Shipped,In_Process,Submitted,Cancelled,NeedInfo;
	}
	
	public enum Type{
		Claim,Warranty,Campaign,Extended_Warranty,PDI,Parts_Warranty,
		Support_Request,Service_Order,Parts_Order,Purchase_Order,PartsReturn,Stock,Emergency;
	}
	
	public enum TabName{
		Order,Items,Parts,Shipping,Payment,Summary,FullView
	}
	
	public enum RequestType{
		Order,Return;
	}
	
	public enum ResonType{
		Overstock,WrongPart,BadPart;
	}
	
	public enum ImportType{
		CSV,Excel;
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
	
	@Column(name = "order_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	@Column(name = "order_number")
	public String getNumber() {
		return String.valueOf(id);
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "request_type")
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Column(name = "order_status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Column(name = "currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Column(name = "order_reference")
	public String getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(String orderReference) {
		this.orderReference = orderReference;
	}

	@Column(name = "sales_person")
	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	@OneToOne(fetch=FetchType.EAGER ,cascade= CascadeType.ALL)
	@JoinColumn(name="amount_id")
	public PurchaseOrderAmount getAmount() {
		return amount;
	}

	public void setAmount(PurchaseOrderAmount amount) {
		this.amount = amount;
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
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "discount_id")
	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}	

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="purchaseOrder")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public PurchaseOrderRequester getRequester() {
		return requester;
	}

	public void setRequester(PurchaseOrderRequester requester) {
		this.requester = requester;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="purchaseOrder")
	@JoinColumn(name="id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public PurchaseOrderPayment getPayment() {
		return payment;
	}

	public void setPayment(PurchaseOrderPayment payment) {
		this.payment = payment;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="purchaseOrder")
	@JoinColumn(name="id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public PurchaseOrderShipment getShipment() {
		return shipment;
	}

	public void setShipment(PurchaseOrderShipment shipment) {
		this.shipment = shipment;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PurchaseOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<PurchaseOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PurchaseOrderAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<PurchaseOrderAudit> audits) {
		this.audits = audits;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	@JsonManagedReference(value="purchaseOrder_attachment")
	public List<PurchaseOrderAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<PurchaseOrderAttachment> attachments) {
		this.attachments = attachments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PurchaseOrderComment> getComments() {
		return comments;
	}

	public void setComments(List<PurchaseOrderComment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PurchaseOrderMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<PurchaseOrderMessage> messages) {
		this.messages = messages;
	}

	@Override
	public int compareTo(PurchaseOrder o) {
		return 0;
	}

	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Transient
	public EntityAttachment getEntityAttachment() {
		return entityAttachment;
	}

	public void setEntityAttachment(EntityAttachment entityAttachment) {
		this.entityAttachment = entityAttachment;
	}
	
	@Column(name="apply_handling_charge")
	public String getApplyHandlingCharge() {
		return applyHandlingCharge;
	}

	public void setApplyHandlingCharge(String applyHandlingCharge) {
		this.applyHandlingCharge = applyHandlingCharge;
	}

	@Transient
	public BigDecimal getHandlingChargePercentage() {
		return handlingChargePercentage;
	}

	public void setHandlingChargePercentage(BigDecimal handlingChargePercentage) {
		this.handlingChargePercentage = handlingChargePercentage;
	}

	@Transient
	public String getPickListCode() {
		return pickListCode;
	}

	public void setPickListCode(String pickListCode) {
		this.pickListCode = pickListCode;
	}

	@Transient
	public PurchaseOrderParameter getOrderParameter() {
		return orderParameter;
	}

	public void setOrderParameter(PurchaseOrderParameter orderParameter) {
		this.orderParameter = orderParameter;
	}

	@Column(name="entity_parameter_id")
	public Long getEntityParameterId() {
		return entityParameterId;
	}

	public void setEntityParameterId(Long entityParameterId) {
		this.entityParameterId = entityParameterId;
	}

	@Column(name="prod_model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name="prod_srl_no")
	public String getProductSerial() {
		return productSerial;
	}

	public void setProductSerial(String productSerial) {
		this.productSerial = productSerial;
	}
	
	@Transient
	public String getImportFileName() {
		return importFileName;
	}
	
	public void setImportFileName(String importFileName) {
		this.importFileName = importFileName;
	}
	
	@Transient
	public String getImportFrom() {
		return importFrom;
	}
	
	public void setImportFrom(String importFrom) {
		this.importFrom = importFrom;
	}
	
	@Transient
	@JsonIgnore
	public boolean isPartsReturn(){
		return Formatter.equalIgnoreCase(RequestType.Return, requestType);
	}
	
	@Transient
	@JsonIgnore
	public boolean isDraftStatus(){
		return Formatter.equalIgnoreCase(Status.Draft, this.status);
	}
	
	@Transient
	@JsonIgnore
	public boolean isNeedInfoStatus(){
		return Formatter.equalIgnoreCase(Status.NeedInfo, this.status);
	}
	
	@Transient
	@JsonIgnore
	public boolean isDeletedStatus(){
		return Formatter.equalIgnoreCase(Status.Deleted, this.status);
	}
	
	@Transient
	@JsonIgnore
	public boolean isCancelledtatus(){
		return Formatter.equalIgnoreCase(Status.Cancelled, this.status);
	}
	
	@Transient
	@JsonIgnore
	public boolean isPendingStatus(){
		return Formatter.equalIgnoreCase(Status.Pending, this.status);
	}
	
	@Transient
	@JsonIgnore
	public boolean isInProcessStatus(){
		return Formatter.equalIgnoreCase(Status.In_Process, this.status);
	}
	
	@Transient
	@JsonIgnore
	public boolean isOrderTab(){
		return Formatter.equalIgnoreCase(TabName.Order, this.tabName);
	}
	
	@Transient
	@JsonIgnore
	public boolean isItemsTab(){
		return Formatter.equalIgnoreCase(TabName.Items, this.tabName);
	}
	
	@Transient
	@JsonIgnore
	public boolean isPartsTab(){
		return Formatter.equalIgnoreCase(TabName.Parts, this.tabName);
	}
	
	@Transient
	@JsonIgnore
	public boolean isShppingTab(){
		return Formatter.equalIgnoreCase(TabName.Shipping, this.tabName);
	}
	
	@Transient
	@JsonIgnore
	public boolean isPaymentTab(){
		return Formatter.equalIgnoreCase(TabName.Payment, this.tabName);
	}
	
	@Transient
	@JsonIgnore
	public boolean isFullView(){
		return Formatter.equalIgnoreCase(TabName.FullView, this.tabName);
	}
	
	@Transient
	@JsonIgnore
	public boolean isTabbedView(){
		return !Formatter.equalIgnoreCase(TabName.FullView, this.tabName);
	}
	
	@Transient
	public String getImportFileType() {
		return importFileType;
	}

	public void setImportFileType(String importFileType) {
		this.importFileType = importFileType;
	}

	@Transient
	public String getOriginalOrderNumber() {
		return originalOrderNumber;
	}

	public void setOriginalOrderNumber(String originalOrderNumber) {
		this.originalOrderNumber = originalOrderNumber;
	}

	@Transient
	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((discountId == null) ? 0 : discountId.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((orderReference == null) ? 0 : orderReference.hashCode());
		result = prime * result
				+ ((requestType == null) ? 0 : requestType.hashCode());
		result = prime * result
				+ ((salesPerson == null) ? 0 : salesPerson.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (discountId == null) {
			if (other.discountId != null)
				return false;
		} else if (!discountId.equals(other.discountId))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (orderReference == null) {
			if (other.orderReference != null)
				return false;
		} else if (!orderReference.equals(other.orderReference))
			return false;
		if (requestType == null) {
			if (other.requestType != null)
				return false;
		} else if (!requestType.equals(other.requestType))
			return false;
		if (salesPerson == null) {
			if (other.salesPerson != null)
				return false;
		} else if (!salesPerson.equals(other.salesPerson))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [number=" + number + ", type=" + type
				+ ", requestType=" + requestType + ", status=" + status
				+ ", currencyCode=" + currencyCode + ", orderReference="
				+ orderReference + ", salesPerson=" + salesPerson
				+ ", discountId=" + discountId + ", amount=" + amount + "]";
	}
	
	

}
