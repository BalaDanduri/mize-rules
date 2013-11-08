package com.mize.domain.common;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

public class WorkQueueResult extends MizeEntity {

	private static final long serialVersionUID = 3360189284913911659L;
	
	private String requester;
	private String provider;
	private String status;
	private String entityType;
	private String serviceType;
	private String serviceCode;
	private String ref;
	private String serviceProductName;
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	private DateTime serviceDate;
	
    public WorkQueueResult(){
    	super();
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
