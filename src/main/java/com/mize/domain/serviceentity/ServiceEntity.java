
package com.mize.domain.serviceentity;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.auth.User;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

@Entity(name = "se.ServiceEntity")
@Table(name = "service_entity", uniqueConstraints = {@UniqueConstraint (columnNames = {"entity_code"})})
public class ServiceEntity extends MizeSceEntity implements Comparable<ServiceEntity> {

	private static final long serialVersionUID = 6821133638967617947L;
	private String code;
	private String status;
	private String currencyCode;
	private String entityReference;
	private String serviceType;
	private String salesPerson;
	private String shipComplete;
	private String processId;
	@Transient
	private String type;
	@Transient
	private String DBStatus;
	
	private Locale locale;
	private ServiceEntityAmount partAmount = new ServiceEntityAmount();
	private ServiceEntityAmount laborAmount = new ServiceEntityAmount();
	private ServiceEntityAmount otherAmount = new ServiceEntityAmount();
	private ServiceEntityAmount totalAmount = new ServiceEntityAmount();
	
	@Transient
	private ServiceEntityRelation relation;
	
	private ServiceEntityRequester requester;
	private ServiceEntityProvider provider;
	
	@Transient
	private User user;
	
	private List<ServiceEntityAudit> audits = new ArrayList<ServiceEntityAudit>();
	private List<ServiceEntityNotes> notes = new ArrayList<ServiceEntityNotes>();
	private List<ServiceEntityRequest> requests = new ArrayList<ServiceEntityRequest>();
	private List<ServiceEntityAttachment> attachments = new ArrayList<ServiceEntityAttachment>();
	
	

	public ServiceEntity(String code, String status, String currencyCode,
			String entityReference, String serviceType, String salesPerson,
			String shipComplete, String processId, String type,
			String DBStatus, Locale locale, ServiceEntityAmount partAmount,
			ServiceEntityAmount laborAmount, ServiceEntityAmount otherAmount, ServiceEntityAmount totalAmount,
			ServiceEntityRelation relation, ServiceEntityRequester requester, ServiceEntityProvider provider,
			User user, List<ServiceEntityAudit> audits, List<ServiceEntityNotes> notes,
			List<ServiceEntityRequest> requests, List<ServiceEntityAttachment> attachments) {
		super();
		this.code = code;
		this.status = status;
		this.currencyCode = currencyCode;
		this.entityReference = entityReference;
		this.serviceType = serviceType;
		this.salesPerson = salesPerson;
		this.shipComplete = shipComplete;
		this.processId = processId;
		this.type = type;
		this.DBStatus = DBStatus;
		this.locale = locale;
		this.partAmount = partAmount;
		this.laborAmount = laborAmount;
		this.otherAmount = otherAmount;
		this.totalAmount = totalAmount;
		this.relation = relation;
		this.requester = requester;
		this.provider = provider;
		this.user = user;
		this.audits = audits;
		this.notes = notes;
		this.requests = requests;
		this.attachments = attachments;
	}

	public ServiceEntity() {
		super();
	}
	
	public enum Status{
		Draft,Pending,Corrections_Needed,Approved,Deleted,Rejected,Closed,Open,Completed,Shipped,
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
	
	@Column(name = "entity_code", nullable = false)
	public String getCode() {
		return code;
	}

	@Column(name = "entity_status")
	public String getStatus() {
		return status;
	}

	@Column(name = "currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	@Column(name="entity_reference")
	public String getEntityReference() {
		return entityReference;
	}

	@Column(name = "process_id")
	public String getProcessId() {
		return processId;
	}
	
	@Column(name = "service_type")
	public String getServiceType() {
		return serviceType;
	}

	@Column(name = "sales_person")
	public String getSalesPerson() {
		return salesPerson;
	}

	@Column(name="ship_complete")
	public String getShipComplete() {
		return shipComplete;
	}

	@Transient
	public String getType() {
		return type;
	}
	
	@Transient
	public String getDBStatus() {
		return DBStatus;
	}

	
	@OneToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinColumn(name = "locale_id")
	public Locale getLocale() {
		return locale;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade= CascadeType.ALL)
	@JoinColumn(name="part_amount_id")
	public ServiceEntityAmount getPartAmount() {
		return partAmount;
	}
	
	@OneToOne(fetch=FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name="labor_amount_id")
	public ServiceEntityAmount getLaborAmount() {
		return laborAmount;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name="other_amount_id")
	public ServiceEntityAmount getOtherAmount() {
		return otherAmount;
	}

	@OneToOne(fetch=FetchType.LAZY ,cascade=CascadeType.ALL)
	@JoinColumn(name="total_amount_id")
	public ServiceEntityAmount getTotalAmount() {
		return totalAmount;
	}
	
	@Transient
	public ServiceEntityRelation getRelation() {
		return relation;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	public ServiceEntityProvider getProvider() {
		return provider;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	public ServiceEntityRequester getRequester() {
		return requester;
	}
	
	@Transient
	public User getUser() {
		return user;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity")
	public List<ServiceEntityRequest> getRequests() {
		return requests;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity")
	public List<ServiceEntityAttachment> getAttachments() {
		return attachments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity")
	public List<ServiceEntityAudit> getAudits() {
		return audits;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity")
	public List<ServiceEntityNotes> getNotes() {
		return notes;
	}
	
	@Column(name = "created_date",updatable = false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

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

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@JsonIgnore
	@Transient
	public ServiceEntityRequest getRequest() {
		if(requests != null && requests.size() > 0){
			return requests.get(0);
		}
		return null;
	}

	@JsonIgnore
	@Transient
	public void setRequest(ServiceEntityRequest request) {
		if(requests == null){
			requests = new ArrayList<ServiceEntityRequest>();
		}
		requests.add(request);
	}

	public void setPartAmount(ServiceEntityAmount partAmount) {
		this.partAmount = partAmount;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setAttachments(List<ServiceEntityAttachment> attachments) {
		this.attachments = attachments;
	}

	public void setAudits(List<ServiceEntityAudit> audit) {
		this.audits = audit;
	}

	public void setTotalAmount(ServiceEntityAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setRequester(ServiceEntityRequester requester) {
		this.requester = requester;
	}

	public void setRelation(ServiceEntityRelation relation) {
		this.relation = relation;
	}
	
	public void setProvider(ServiceEntityProvider provider) {
		this.provider = provider;
	}

	public void setNotes(List<ServiceEntityNotes> notes) {
		this.notes = notes;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	

	public void setEntityReference(String entityReference) {
		this.entityReference = entityReference;
	}
	
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public void setDBStatus(String DBStatus) {
		this.DBStatus = DBStatus;
	}
	
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setShipComplete(String shipComplete) {
		this.shipComplete = shipComplete;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	
	public void setOtherAmount(ServiceEntityAmount otherAmount) {
		this.otherAmount = otherAmount;
	}

	public void setRequests(List<ServiceEntityRequest> requests) {
		this.requests = requests;
	}

	public void setLaborAmount(ServiceEntityAmount laborAmount) {
		this.laborAmount = laborAmount;
	}
	
	@Override
	public int compareTo(ServiceEntity arg0) {
		return 0;
	}

	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();		
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((entityReference == null) ? 0 : entityReference.hashCode());
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result
				+ ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result
				+ ((provider == null) ? 0 : provider.hashCode());
		result = prime * result
				+ ((relation == null) ? 0 : relation.hashCode());
		result = prime * result
				+ ((requester == null) ? 0 : requester.hashCode());
		result = prime * result
				+ ((requests == null) ? 0 : requests.hashCode());
		result = prime * result
				+ ((salesPerson == null) ? 0 : salesPerson.hashCode());
		result = prime * result
				+ ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result
				+ ((shipComplete == null) ? 0 : shipComplete.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		ServiceEntity other = (ServiceEntity) obj;
		if (attachments == null) {
			if (other.attachments != null)
				return false;
		} else if (!attachments.equals(other.attachments))
			return false;	
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (entityReference == null) {
			if (other.entityReference != null)
				return false;
		} else if (!entityReference.equals(other.entityReference))
			return false;
		if (laborAmount == null) {
			if (other.laborAmount != null)
				return false;
		} else if (!laborAmount.equals(other.laborAmount))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (otherAmount == null) {
			if (other.otherAmount != null)
				return false;
		} else if (!otherAmount.equals(other.otherAmount))
			return false;
		if (partAmount == null) {
			if (other.partAmount != null)
				return false;
		} else if (!partAmount.equals(other.partAmount))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (relation == null) {
			if (other.relation != null)
				return false;
		} else if (!relation.equals(other.relation))
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (requests == null) {
			if (other.requests != null)
				return false;
		} else if (!requests.equals(other.requests))
			return false;
		if (salesPerson == null) {
			if (other.salesPerson != null)
				return false;
		} else if (!salesPerson.equals(other.salesPerson))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (shipComplete == null) {
			if (other.shipComplete != null)
				return false;
		} else if (!shipComplete.equals(other.shipComplete))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceEntity [code=" + code + ", status=" + status
				+ ", locale=" + locale + ", currencyCode=" + currencyCode
				+ ", entityReference=" + entityReference + ", partAmount="
				+ partAmount + ", laborAmount=" + laborAmount
				+ ", otherAmount=" + otherAmount + ", totalAmount="
				+ totalAmount + ", requests=" + requests + ", attachments="
				+ attachments + ", user=" + user + ", relation=" + relation + ", requester=" + requester
				+ ", provider=" + provider + ", notes=" + notes
				+ ", serviceType=" + serviceType + ", salesPerson="
				+ salesPerson + ", shipComplete=" + shipComplete + "]";
	}

}
