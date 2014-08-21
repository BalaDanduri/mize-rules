package com.mize.domain.sce.serviceentity;

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

import org.hibernate.annotations.Type;
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
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;


/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty")
public class ServiceEntity extends MizeEntity {

	private static final long serialVersionUID = -1780679493288392673L;
	
	private String entityCode;
	private String entityType;
	private String entityStatus;
	private String entityReference;
	private BusinessEntity tenant;
	private Locale locale;
	private String currencyCode;
	private List<ServiceEntityRequest> serviceRequests;
	private ServiceEntityRequester requester;
	private ServiceEntityProvider provider;
	private ServiceEntityPayment payment;
	private ServiceEntityAmount partAmount;
	private ServiceEntityAmount laborAmount;
	private ServiceEntityAmount otherAmount;
	private ServiceEntityAmount totalAmount;
	private List<ServiceEntityAudit> audits = new ArrayList<ServiceEntityAudit>();
	private List<ServiceEntityRelation> entityRelations = new ArrayList<ServiceEntityRelation>();
	private List<ServiceEntityMessage> messages = new ArrayList<ServiceEntityMessage>();
	private List<ServiceEntityComment> comments = new ArrayList<ServiceEntityComment>();
	private List<ServiceEntityAttachment> attachments = new ArrayList<ServiceEntityAttachment>();
	private String source;	
	
	private User user;
	

	public ServiceEntity() {
		super();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@Column(name = "entity_code", length = 50)
	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
	
	@Column(name = "entity_type", length = 50)
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	
	@Column(name = "entity_status", length = 50)
	public String getEntityStatus() {
		return entityStatus;
	}

	public void setEntityStatus(String entityStatus) {
		this.entityStatus = entityStatus;
	}
	
	@Column(name = "entity_reference", length = 100)
	public String getEntityReference() {
		return entityReference;
	}

	public void setEntityReference(String entityReference) {
		this.entityReference = entityReference;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="locale_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	@Column(name = "currency_code", length = 50)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_entity_request")
	public List<ServiceEntityRequest> getServiceRequests() {
		return serviceRequests;
	}
	
	public void setServiceRequests(List<ServiceEntityRequest> serviceRequests) {
		this.serviceRequests = serviceRequests;
	}	
	
	@OneToOne(mappedBy = "serviceEntity",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "service_entity_requester")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityRequester getRequester() {
		return requester;
	}

	public void setRequester(ServiceEntityRequester requester) {
		this.requester = requester;
	}
	
	@OneToOne(mappedBy = "serviceEntity",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "service_entity_provider")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityProvider getProvider() {
		return provider;
	}

	public void setProvider(ServiceEntityProvider provider) {
		this.provider = provider;
	}
	
	@OneToOne(mappedBy = "serviceEntity",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "service_entity_payment")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntityPayment getPayment() {
		return payment;
	}

	public void setPayment(ServiceEntityPayment payment) {
		this.payment = payment;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="part_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(ServiceEntityAmount partAmount) {
		this.partAmount = partAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="labor_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(ServiceEntityAmount laborAmount) {
		this.laborAmount = laborAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="other_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(ServiceEntityAmount otherAmount) {
		this.otherAmount = otherAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="total_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceEntityAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(ServiceEntityAmount totalAmount) {
		this.totalAmount = totalAmount;
	}	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_entity_audits")
	public List<ServiceEntityAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<ServiceEntityAudit> audits) {
		this.audits = audits;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_entity_relations")
	public List<ServiceEntityRelation> getEntityRelations() {
		return entityRelations;
	}

	public void setEntityRelations(List<ServiceEntityRelation> entityRelations) {
		this.entityRelations = entityRelations;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_entity_messages")
	public List<ServiceEntityMessage> getMessages() {
		return messages;
	}
	
	public void setMessages(List<ServiceEntityMessage> messages) {
		this.messages = messages;
	}	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_entity_comments")
	public List<ServiceEntityComment> getComments() {
		return comments;
	}

	public void setComments(List<ServiceEntityComment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceEntity" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_entity_attachments")
	public List<ServiceEntityAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<ServiceEntityAttachment> attachments) {
		this.attachments = attachments;
	}
	
	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}	
	
	@Column(name = "entity_source", length = 100)
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}


	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}

	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((attachments == null) ? 0 : attachments.hashCode());
		result = prime * result + ((audits == null) ? 0 : audits.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((currencyCode == null) ? 0 : currencyCode.hashCode());
		result = prime * result
				+ ((entityCode == null) ? 0 : entityCode.hashCode());
		result = prime * result
				+ ((entityReference == null) ? 0 : entityReference.hashCode());
		result = prime * result
				+ ((entityRelations == null) ? 0 : entityRelations.hashCode());
		result = prime * result
				+ ((entityStatus == null) ? 0 : entityStatus.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((messages == null) ? 0 : messages.hashCode());
		result = prime * result
				+ ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result
				+ ((provider == null) ? 0 : provider.hashCode());
		result = prime * result
				+ ((requester == null) ? 0 : requester.hashCode());
		result = prime * result
				+ ((serviceRequests == null) ? 0 : serviceRequests.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		} else if (!attachments.containsAll(other.attachments))
			return false;
		if (audits == null) {
			if (other.audits != null)
				return false;
		} else if (!audits.equals(other.audits))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.containsAll(other.comments))
			return false;
		if (currencyCode == null) {
			if (other.currencyCode != null)
				return false;
		} else if (!currencyCode.equals(other.currencyCode))
			return false;
		if (entityCode == null) {
			if (other.entityCode != null)
				return false;
		} else if (!entityCode.equals(other.entityCode))
			return false;
		if (entityReference == null) {
			if (other.entityReference != null)
				return false;
		} else if (!entityReference.equals(other.entityReference))
			return false;
		if (entityRelations == null) {
			if (other.entityRelations != null)
				return false;
		} else if (!entityRelations.containsAll(other.entityRelations))
			return false;
		if (entityStatus == null) {
			if (other.entityStatus != null)
				return false;
		} else if (!entityStatus.equals(other.entityStatus))
			return false;
		if (entityType == null) {
			if (other.entityType != null)
				return false;
		} else if (!entityType.equals(other.entityType))
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
		if (messages == null) {
			if (other.messages != null)
				return false;
		} else if (!messages.containsAll(other.messages))
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
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (serviceRequests == null) {
			if (other.serviceRequests != null)
				return false;
		} else if (!serviceRequests.containsAll(other.serviceRequests))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}
	

}
