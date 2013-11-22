package com.mize.domain.partsorder;

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
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;
@Entity
@Table(name = "parts_order", uniqueConstraints = {@UniqueConstraint (columnNames = {"order_code"})})
public class PartsOrder extends MizeEntity implements Comparable<PartsOrder>{	

	private static final long serialVersionUID = 261638805962518728L;
	private String type;
	private String code;
	@Transient
	private User user;
	private String requestType;
	private String status;
	private Locale locale;
	private String currencyCode;
	private String orderReference;
	private String salesPerson;
	private String shipComplete;
	private PartsOrderAmount amount = new PartsOrderAmount();
	private PartsOrderRequester requester;
	private List<PartsOrderPart> parts = new ArrayList<PartsOrderPart>(); 
	private List<PartsOrderComment> comments = new ArrayList<PartsOrderComment>();
	private List<PartsOrderAudit> audits = new ArrayList<PartsOrderAudit>();
	private PartsOrderPayment payment;
	private PartsOrderShipment shipment;

	public PartsOrder(){
		super();
	}
	
	public enum Status{
		Draft,Pending,Approved,Deleted,Rejected,Closed,Open,Completed,Shipped,
		In_Progress;
	}
	
	public enum Type{
		Claim,Warranty,Campaign,Extended_Warranty,PDI,Parts_Warranty,Support_Request,Service_Order,Parts_Order;
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

	@Column(name = "order_code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	@OneToOne(fetch = FetchType.LAZY)
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

	@Column(name = "ship_complete")
	public String getShipComplete() {
		return shipComplete;
	}

	public void setShipComplete(String shipComplete) {
		this.shipComplete = shipComplete;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade= CascadeType.ALL)
	@JoinColumn(name="amount_id")
	public PartsOrderAmount getAmount() {
		return amount;
	}

	public void setAmount(PartsOrderAmount amount) {
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
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	public PartsOrderRequester getRequester() {
		return requester;
	}

	public void setRequester(PartsOrderRequester requester) {
		this.requester = requester;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "partsOrder")
	public List<PartsOrderPart> getParts() {
		return parts;
	}

	public void setParts(List<PartsOrderPart> parts) {
		this.parts = parts;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "partsOrder")
	public List<PartsOrderComment> getComments() {
		return comments;
	}

	public void setComments(List<PartsOrderComment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "partsOrder")
	public List<PartsOrderAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<PartsOrderAudit> audits) {
		this.audits = audits;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	public PartsOrderPayment getPayment() {
		return payment;
	}

	public void setPayment(PartsOrderPayment payment) {
		this.payment = payment;
	}

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	public PartsOrderShipment getShipment() {
		return shipment;
	}

	public void setShipment(PartsOrderShipment shipment) {
		this.shipment = shipment;
	}
	
	
	

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		PartsOrder other = (PartsOrder) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
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
		return "PartsOrder [type=" + type + ", code=" + code + ", requestType="
				+ requestType + ", status=" + status + "]";
	}

	@Override
	public int compareTo(PartsOrder o) {
		return 0;
	}

}
