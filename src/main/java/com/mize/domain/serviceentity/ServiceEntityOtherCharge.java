package com.mize.domain.serviceentity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.MizeDateTime;

@Entity
@Table(name = "service_entity_request_other")
public class ServiceEntityOtherCharge extends MizeSceEntity implements Comparable<ServiceEntityOtherCharge> {
	private static final long serialVersionUID = 68211336389676111L;
	
	private String type;
	private String code;
	private String description;
	@Transient
	private Long requestId;
	private ServiceEntityRequest request;
	
	private ServiceEntityAmount amount = new ServiceEntityAmount();
	
	public ServiceEntityOtherCharge() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	

	@Column(name="other_charge_type")
	public String getType() {
		return type;
	}

	@Column(name="other_charge_code")
	public String getCode() {
		return code;
	}

	@Column(name="other_charge_description")
	public String getDescription() {
		return description;
	}

	@Transient
	public Long getRequestId() {
		return requestId;
	}
	
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="amount_id")
	public ServiceEntityAmount getAmount() {
		return amount;
	}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="request_id")
	public ServiceEntityRequest getRequest() {
		return request;
	}

	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	

	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public void setAmount(ServiceEntityAmount amount) {
		this.amount = amount;
	}

	public void setRequest(ServiceEntityRequest request) {
		this.request = request;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value=false)*/
	@Column(name = "created_date",updatable = false)
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getCreatedDate() {
		return createdDate;
	}

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)*/
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.MizeDateTimeJPA")
	public MizeDateTime getUpdatedDate() {
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

/*	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)*/
	public void setCreatedDate(MizeDateTime createdDate) {
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

	/*@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)*/
	public void setUpdatedDate(MizeDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((requestId == null) ? 0 : requestId.hashCode());
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
		ServiceEntityOtherCharge other = (ServiceEntityOtherCharge) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
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
		return "SEOtherCharges [type=" + type + ", code=" + code
				+ ", description=" + description + ", requestId=" + requestId
				+ ", amount=" + amount + "]";
	}

	@Override
	public int compareTo(ServiceEntityOtherCharge arg0) {
		return 0;
	}	

}
