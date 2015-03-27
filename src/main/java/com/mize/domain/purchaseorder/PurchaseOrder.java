package com.mize.domain.purchaseorder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeErrorTab;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.DateTime;
import com.mize.domain.util.CachedEntity;
import com.mize.domain.util.DateTimeUtils;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.TenantSerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("PurchaseOrder")
@Table(name = "purchase_order")
public class PurchaseOrder extends MizeSceEntityAudit implements Comparable<PurchaseOrder>{	
	
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
	@CachedEntity
	private PurchaseOrderRequester requester;
	@CachedEntity
	private PurchaseOrderPayment payment;
	@CachedEntity
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
	@Transient
	private String submittedBy;
	@Transient
	private DateTime submittedDate;
	@Transient
	private String imageURL;
	@Transient
	private String action;
	@Transient
	private List<MizeErrorTab> errorTabs = new ArrayList<MizeErrorTab>();
	@Transient
	private String dbStatus;
	@CachedEntity
	private List<PurchaseOrderTracking> orderTrackings = new ArrayList<PurchaseOrderTracking>();
	private String email;
	
	public PurchaseOrder(){
		super();
	}
	
	public PurchaseOrder(Long id,String number,String status,String type,String requestType,DateTime createdDate,DateTime updatedDate,Locale locale){
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.requestType = requestType;
		this.status = status;	
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.locale = locale;
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
	
	@Column(name = "order_type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	@Column(name = "order_number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Transient
	@JsonIgnore
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
	@Fetch(FetchMode.SELECT)
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
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=TenantSerializer.class)
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
	
	@Transient
	public String getSubmittedBy() {
		return submittedBy;
	}
	
	
	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	
	@Transient
    @JsonInclude(Include.NON_NULL)
	public DateTime getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(DateTime submittedDate) {
		this.submittedDate = submittedDate;
	}

	@Transient
	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	@Transient
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	@Transient
	public String getFormattedDisplayDate(DateTime inputDate) {
		String date="";
		if(inputDate!=null){
			date = DateTimeUtils.formattedDate(inputDate,user);
		}
		return date;
	}
	
	@Transient
	public List<MizeErrorTab> getErrorTabs() {
		return errorTabs;
	}

	public void setErrorTabs(List<MizeErrorTab> errorTabs) {
		this.errorTabs = errorTabs;
	}
	
	@Transient
	public String getDbStatus() {
		return dbStatus;
	}

	public void setDbStatus(String dbStatus) {
		this.dbStatus = dbStatus;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<PurchaseOrderTracking> getOrderTrackings() {
		return orderTrackings;
	}

	public void setOrderTrackings(List<PurchaseOrderTracking> orderTrackings) {
		this.orderTrackings = orderTrackings;
	}

	@Transient
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
