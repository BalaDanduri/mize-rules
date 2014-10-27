package com.mize.domain.sce.servicebulletin;

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
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;


/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */
@Entity
@Table(name = "srvc_blltn")
public class ServiceBulletin extends MizeEntity {

	private static final long serialVersionUID = -1780679493288392673L;
	
	private String bulletinCode;
	private String bulletinType;
	private String bulletinSubType;
	private String bulletinStatus;
	private String bulletinReference;
	private DateTime startDate;
	private DateTime endDate;
	private BusinessEntity tenant;
	private String currencyCode;
	private List<ServiceBulletinProcedure> procedures = new ArrayList<ServiceBulletinProcedure>();
	private ServiceBulletinAmount partAmount;
	private ServiceBulletinAmount laborAmount;
	private ServiceBulletinAmount otherAmount;
	private ServiceBulletinAmount totalAmount;
	private List<ServiceBulletinIntl> bulletinIntl = new ArrayList<ServiceBulletinIntl>();
	private List<ServiceBulletinAudit> audits = new ArrayList<ServiceBulletinAudit>();
	private List<ServiceBulletinMessage> messages = new ArrayList<ServiceBulletinMessage>();
	private List<ServiceBulletinComment> comments = new ArrayList<ServiceBulletinComment>();
	private List<ServiceBulletinAttachment> attachments = new ArrayList<ServiceBulletinAttachment>();
	private ServiceBulletinRespBusinessUnit respBusinessUnit;
	private User user;
	

	public ServiceBulletin() {
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
	
	@Column(name = "blltn_code", length = 50)
	public String getBulletinCode() {
		return bulletinCode;
	}

	public void setBulletinCode(String bulletinCode) {
		this.bulletinCode = bulletinCode;
	}

	@Column(name = "blltn_type", length = 50)
	public String getBulletinType() {
		return bulletinType;
	}

	public void setBulletinType(String bulletinType) {
		this.bulletinType = bulletinType;
	}
	
	@Column(name = "blltn_sub_type", length = 50)
	public String getBulletinSubType() {
		return bulletinSubType;
	}

	public void setBulletinSubType(String bulletinSubType) {
		this.bulletinSubType = bulletinSubType;
	}
	
	@Column(name = "blltn_status", length = 50)
	public String getBulletinStatus() {
		return bulletinStatus;
	}

	public void setBulletinStatus(String bulletinStatus) {
		this.bulletinStatus = bulletinStatus;
	}

	@Column(name = "blltn_reference", length = 100)
	public String getBulletinReference() {
		return bulletinReference;
	}

	public void setBulletinReference(String bulletinReference) {
		this.bulletinReference = bulletinReference;
	}
	
	@Column(name = "start_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_NULL)
	public DateTime getStartDate() {
		return startDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_NULL)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
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
	
	@Column(name = "currency_code", length = 50)
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletin" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_bulletin_procedures")
	public List<ServiceBulletinProcedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<ServiceBulletinProcedure> procedures) {
		this.procedures = procedures;
	}
	
	@OneToOne(mappedBy = "serviceBulletin",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "responsible_business_unit")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletinRespBusinessUnit getRespBusinessUnit() {
		return respBusinessUnit;
	}

	public void setRespBusinessUnit(ServiceBulletinRespBusinessUnit respBusinessUnit) {
		this.respBusinessUnit = respBusinessUnit;
	}

	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="part_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getPartAmount() {
		return partAmount;
	}

	public void setPartAmount(ServiceBulletinAmount partAmount) {
		this.partAmount = partAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="labor_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(ServiceBulletinAmount laborAmount) {
		this.laborAmount = laborAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="other_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(ServiceBulletinAmount otherAmount) {
		this.otherAmount = otherAmount;
	}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="total_amount_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public ServiceBulletinAmount getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(ServiceBulletinAmount totalAmount) {
		this.totalAmount = totalAmount;
	}	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletin" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_bulletin_audits")
	public List<ServiceBulletinAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<ServiceBulletinAudit> audits) {
		this.audits = audits;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletin" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_bulletin_messages")
	public List<ServiceBulletinMessage> getMessages() {
		return messages;
	}
	
	public void setMessages(List<ServiceBulletinMessage> messages) {
		this.messages = messages;
	}	
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletin" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_bulletin_comments")
	public List<ServiceBulletinComment> getComments() {
		return comments;
	}

	public void setComments(List<ServiceBulletinComment> comments) {
		this.comments = comments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "serviceBulletin" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="service_bulletin_attachments")
	public List<ServiceBulletinAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<ServiceBulletinAttachment> attachments) {
		this.attachments = attachments;
	}
	
	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.EAGER, mappedBy = "serviceBulletin" ,orphanRemoval= true)	
	@JsonManagedReference(value="bulletinIntl")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<ServiceBulletinIntl> getBulletinIntl() {
		return bulletinIntl;
	}

	public void setBulletinIntl(List<ServiceBulletinIntl> bulletinIntl) {
		this.bulletinIntl = bulletinIntl;
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
				+ ((bulletinCode == null) ? 0 : bulletinCode.hashCode());
		result = prime * result
				+ ((bulletinReference == null) ? 0 : bulletinReference.hashCode());
		result = prime * result
				+ ((bulletinStatus == null) ? 0 : bulletinStatus.hashCode());
		result = prime * result
				+ ((bulletinType == null) ? 0 : bulletinType.hashCode());
		result = prime * result
				+ ((bulletinSubType == null) ? 0 : bulletinSubType.hashCode());
		result = prime * result
				+ ((laborAmount == null) ? 0 : laborAmount.hashCode());
		result = prime * result
				+ ((messages == null) ? 0 : messages.hashCode());
		result = prime * result
				+ ((otherAmount == null) ? 0 : otherAmount.hashCode());
		result = prime * result
				+ ((partAmount == null) ? 0 : partAmount.hashCode());
		result = prime * result
				+ ((respBusinessUnit == null) ? 0 : respBusinessUnit.hashCode());
		result = prime * result
				+ ((procedures == null) ? 0 : procedures.hashCode());
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
		ServiceBulletin other = (ServiceBulletin) obj;
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
		if (bulletinCode == null) {
			if (other.bulletinCode != null)
				return false;
		} else if (!bulletinCode.equals(other.bulletinCode))
			return false;
		if (bulletinReference == null) {
			if (other.bulletinReference != null)
				return false;
		} else if (!bulletinReference.equals(other.bulletinReference))
			return false;
		if (bulletinSubType == null) {
			if (other.bulletinSubType != null)
				return false;
		} else if (!bulletinSubType.equals(other.bulletinSubType))
			return false;
		if (bulletinStatus == null) {
			if (other.bulletinStatus != null)
				return false;
		} else if (!bulletinStatus.equals(other.bulletinStatus))
			return false;
		if (bulletinType == null) {
			if (other.bulletinType != null)
				return false;
		} else if (!bulletinType.equals(other.bulletinType))
			return false;
		if (laborAmount == null) {
			if (other.laborAmount != null)
				return false;
		} else if (!laborAmount.equals(other.laborAmount))
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
		if (respBusinessUnit == null) {
			if (other.respBusinessUnit != null)
				return false;
		} else if (!respBusinessUnit.equals(other.respBusinessUnit))
			return false;
		if (procedures == null) {
			if (other.procedures != null)
				return false;
		} else if (!procedures.containsAll(other.procedures))
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
