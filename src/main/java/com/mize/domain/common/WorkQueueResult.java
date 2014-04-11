package com.mize.domain.common;

import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class WorkQueueResult extends MizeEntity {

	private static final long serialVersionUID = 3360189284913911659L;
	
	private String requester;
	private String provider;
	private String status;
	private Long   entityId;
	private String entityType;
	private String serviceType;
	private String serviceCode;
	private String orderType;
	private String ref;
	private String serviceProductName;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime serviceDate;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime serviceUpdatedDate;
	public BusinessEntity businessEntity;
	public ProductSerial productSerial;
	private String requesterCode;
	
    public WorkQueueResult(){
    	super();
    }

	public WorkQueueResult(Long id,Long entityId, String entityType,String status,String serviceType,String serviceCode,
			DateTime serviceDate,BusinessEntity businessEntity,ProductSerial productSerial) {
		super();
		this.id = id;
		this.entityId = entityId;
		this.entityType = entityType;
		this.status = status;
		this.serviceDate = serviceDate;
		this.serviceType = serviceType;
		this.serviceCode = serviceCode;
		this.businessEntity = businessEntity;
		this.productSerial = productSerial;
	}
	
	public WorkQueueResult(Long id,Long entityId, String entityType,String status,String serviceType,String serviceCode,String providerName,
			DateTime serviceDate,BusinessEntity businessEntity,ProductSerial productSerial) {
		super();
		this.id = id;
		this.entityId = entityId;
		this.entityType = entityType;
		this.status = status;
		this.serviceDate = serviceDate;
		this.serviceType = serviceType;
		this.serviceCode = serviceCode;
		this.businessEntity = businessEntity;
		this.productSerial = productSerial;
		this.provider = providerName;
	}
	

	public WorkQueueResult(Long id,Long entityId, String entityType,String entityCode,String status,String orderType,
			DateTime serviceDate,DateTime updatedDate,BusinessEntity businessEntity) {
		super();
		this.id = id;
		this.entityId = entityId;
		this.entityType = entityType;
		this.serviceCode = entityCode;
		this.status = status;
		this.orderType = orderType;
		this.serviceDate = serviceDate;
		this.serviceUpdatedDate = updatedDate;
		this.businessEntity = businessEntity;
	}
	

	public String getRequester() {
		return requester;
	}

	public String getProvider() {
		return provider;
	}

	public String getStatus() {
		return status;
	}

	public String getServiceType() {
		return serviceType;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public String getServiceProductName() {
		return serviceProductName;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getServiceDate() {
		return serviceDate;
	}
	
	public String getEntityType() {
		return entityType;
	}

	
	public String getRef() {
		return ref;
	}
	
	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void setServiceProductName(String serviceProductName) {
		this.serviceProductName = serviceProductName;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setServiceDate(DateTime serviceDate) {
		this.serviceDate = serviceDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getServiceUpdatedDate() {
		return serviceUpdatedDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setServiceUpdatedDate(DateTime serviceUpdatedDate) {
		this.serviceUpdatedDate = serviceUpdatedDate;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Transient
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	
	public String getRequesterCode() {
		return requesterCode;
	}

	public void setRequesterCode(String requesterCode) {
		this.requesterCode = requesterCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result
				+ ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result
				+ ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + ((ref == null) ? 0 : ref.hashCode());
		result = prime * result
				+ ((requester == null) ? 0 : requester.hashCode());
		result = prime * result
				+ ((serviceCode == null) ? 0 : serviceCode.hashCode());
		result = prime * result
				+ ((serviceDate == null) ? 0 : serviceDate.hashCode());
		result = prime
				* result
				+ ((serviceProductName == null) ? 0 : serviceProductName
						.hashCode());
		result = prime * result
				+ ((serviceType == null) ? 0 : serviceType.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		WorkQueueResult other = (WorkQueueResult) obj;
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
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (ref == null) {
			if (other.ref != null)
				return false;
		} else if (!ref.equals(other.ref))
			return false;
		if (requester == null) {
			if (other.requester != null)
				return false;
		} else if (!requester.equals(other.requester))
			return false;
		if (serviceCode == null) {
			if (other.serviceCode != null)
				return false;
		} else if (!serviceCode.equals(other.serviceCode))
			return false;
		if (serviceDate == null) {
			if (other.serviceDate != null)
				return false;
		} else if (!serviceDate.equals(other.serviceDate))
			return false;
		if (serviceProductName == null) {
			if (other.serviceProductName != null)
				return false;
		} else if (!serviceProductName.equals(other.serviceProductName))
			return false;
		if (serviceType == null) {
			if (other.serviceType != null)
				return false;
		} else if (!serviceType.equals(other.serviceType))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkQueueResult [id=");
		builder.append(id);
		builder.append(", entityId=");
		builder.append(entityId);
		builder.append(", entityType=");
		builder.append(entityType);
		builder.append(", provider=");
		builder.append(provider);
		builder.append(", ref=");
		builder.append(ref);
		builder.append(", requester=");
		builder.append(requester);
		builder.append(", serviceCode=");
		builder.append(serviceCode);
		builder.append(", serviceDate=");
		builder.append(serviceDate);
		builder.append(", serviceProductName=");
		builder.append(serviceProductName);
		builder.append(", serviceType=");
		builder.append(serviceType);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
