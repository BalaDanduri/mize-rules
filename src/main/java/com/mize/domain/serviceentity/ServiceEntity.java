package com.mize.domain.serviceentity;

import java.util.ArrayList;
import java.util.List;

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

public class ServiceEntity extends MizeEntity implements Comparable<ServiceEntity> {

	private static final long serialVersionUID = 6821133638967617947L;
	private String code;
	private String status;
	private Locale locale;
	private String currencyCode;
	private String entityReference;
	private SEAmount partAmount = new SEAmount();
	private SEAmount laborAmount = new SEAmount();
	private SEAmount otherAmount = new SEAmount();
	private SEAmount totalAmount = new SEAmount();
	private List<SERequest> requests = new ArrayList<SERequest>();
	private List<SEAttachment> attachments = new ArrayList<SEAttachment>();
	private User user;
	private SEAudit audit;
	private SERelation relation;
	private SERequester requester;
	private SEProvider provider;
	private List<SENote> notes = new ArrayList<SENote>();
	private String serviceType;
	private String salesPerson;
	private String shipComplete;
	
	
	public ServiceEntity() {
		super();
	}
	
	public enum Staus{
		Draft,Pending,Corrections_Needed,Approved,Deleted,Rejected
	}
	
	public enum Type{
		Warranty,Campaign,Extended_Warranty,PDI,Parts_Warranty,Support_Request,Service_Order;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	@Override
	public int compareTo(ServiceEntity arg0) {
		return 0;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getEntityReference() {
		return entityReference;
	}

	public void setEntityReference(String entityReference) {
		this.entityReference = entityReference;
	}

	public SEAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(SEAmount partAmount) {
		this.partAmount = partAmount;
	}

	public SEAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(SEAmount laborAmount) {
		this.laborAmount = laborAmount;
	}

	public SEAmount getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(SEAmount otherAmount) {
		this.otherAmount = otherAmount;
	}

	public SEAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(SEAmount totalAmount) {
		this.totalAmount = totalAmount;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
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
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore(value=false)
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore(value=false)
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	public Long getUpdatedBy() {
		return updatedBy;
	}

	@JsonIgnore(value=false)
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<SERequest> getRequests() {
		return requests;
	}

	public void setRequests(List<SERequest> requests) {
		this.requests = requests;
	}

	@JsonIgnore
	public SERequest getRequest() {
		if(requests != null && requests.size() > 0){
			return requests.get(0);
		}
		return null;
	}

	@JsonIgnore
	public void setRequest(SERequest request) {
		if(requests == null){
			requests = new ArrayList<SERequest>();
		}
		requests.add(request);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<SEAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<SEAttachment> attachments) {
		this.attachments = attachments;
	}

	public SEAudit getAudit() {
		return audit;
	}

	public void setAudit(SEAudit audit) {
		this.audit = audit;
	}

	public SERelation getRelation() {
		return relation;
	}

	public void setRelation(SERelation relation) {
		this.relation = relation;
	}

	public SERequester getRequester() {
		return requester;
	}

	public void setRequester(SERequester requester) {
		this.requester = requester;
	}

	public SEProvider getProvider() {
		return provider;
	}

	public void setProvider(SEProvider provider) {
		this.provider = provider;
	}

	public List<SENote> getNotes() {
		return notes;
	}

	public void setNotes(List<SENote> notes) {
		this.notes = notes;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getShipComplete() {
		return shipComplete;
	}

	public void setShipComplete(String shipComplete) {
		this.shipComplete = shipComplete;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result + ((audit == null) ? 0 : audit.hashCode());
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
		if (audit == null) {
			if (other.audit != null)
				return false;
		} else if (!audit.equals(other.audit))
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
				+ attachments + ", user=" + user + ", audit=" + audit
				+ ", relation=" + relation + ", requester=" + requester
				+ ", provider=" + provider + ", notes=" + notes
				+ ", serviceType=" + serviceType + ", salesPerson="
				+ salesPerson + ", shipComplete=" + shipComplete + "]";
	}

}
