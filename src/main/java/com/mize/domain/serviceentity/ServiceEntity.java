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
	private String type;
	private String currencyCode;
	private String entityReference;
	private SEAmount partAmount = new SEAmount();
	private SEAmount laborAmount = new SEAmount();
	private SEAmount otherAmount = new SEAmount();
	private SEAmount totalAmount = new SEAmount();
	private List<SERequest> requests = new ArrayList<SERequest>();
	private List<SEAttachment> attachments = new ArrayList<SEAttachment>();
	private User user;
	private List<SEAudit> audits = new ArrayList<SEAudit>();
	private SERelation relation;
	private SERequester requester;
	private SEProvider provider;
	private List<SENote> notes = new ArrayList<SENote>();
	private String serviceType;
	private String salesPerson;
	private String shipComplete;
	private String processId;
	private String dDStatus;
	
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

	public List<SEAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<SEAudit> audit) {
		this.audits = audit;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getDBStatus() {
		return dDStatus;
	}

	public void setDBStatus(String dDStatus) {
		this.dDStatus = dDStatus;
	}
	
}
