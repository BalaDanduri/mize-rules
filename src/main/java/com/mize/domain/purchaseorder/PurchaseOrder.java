package com.mize.domain.purchaseorder;

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

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
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
	private User user;
	
	public PurchaseOrder(){
		super();
	}
	
	public enum Status{
		Draft,Pending,Approved,Deleted,Rejected,Closed,Open,Completed,
		Shipped,In_Progress;
	}
	
	public enum Type{
		Claim,Warranty,Campaign,Extended_Warranty,PDI,Parts_Warranty,
		Support_Request,Service_Order,Parts_Order;
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
		return number;
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
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
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

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="purchaseOrder")
	public PurchaseOrderRequester getRequester() {
		return requester;
	}

	public void setRequester(PurchaseOrderRequester requester) {
		this.requester = requester;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="purchaseOrder")
	@JoinColumn(name="id")
	public PurchaseOrderPayment getPayment() {
		return payment;
	}

	public void setPayment(PurchaseOrderPayment payment) {
		this.payment = payment;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="purchaseOrder")
	@JoinColumn(name="id")
	public PurchaseOrderShipment getShipment() {
		return shipment;
	}

	public void setShipment(PurchaseOrderShipment shipment) {
		this.shipment = shipment;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	public List<PurchaseOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<PurchaseOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	public List<PurchaseOrderAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<PurchaseOrderAudit> audits) {
		this.audits = audits;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	public List<PurchaseOrderAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<PurchaseOrderAttachment> attachments) {
		this.attachments = attachments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
	public List<PurchaseOrderComment> getComments() {
		return comments;
	}

	public void setComments(List<PurchaseOrderComment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "purchaseOrder",orphanRemoval= true)
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
