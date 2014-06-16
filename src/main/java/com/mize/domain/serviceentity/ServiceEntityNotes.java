package com.mize.domain.serviceentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;


@Entity
@Table(name = "service_entity_notes")
public class ServiceEntityNotes extends MizeEntity implements Comparable<ServiceEntityNotes> {

	private static final long serialVersionUID = 6821133638967617947L;	
	@Transient
	private Long entityId;	
	private ServiceEntity serviceEntity;
	private String notes;
	private String type;
	
	public ServiceEntityNotes() {
		super();
	}
	
	public ServiceEntityNotes(Long id,Long entityId, String notes) {
		super();
		this.id = id;
		this.entityId = entityId;
		this.notes = notes;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@Transient
	public Long getEntityId() {
		return entityId;
	}
	
	@Column(name = "notes")
	public String getNotes() {
		return notes;
	}
	
	@Column(name = "note_type")
	public String getType() {
		return type;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity_id")
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@Column(name = "updated_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	@Transient
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@Column(name = "created_date")
	@org.hibernate.annotations.Type(type="com.mize.domain.util.DateTimeJPA")
	@Transient
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@JsonIgnore(value=false)
	@Transient
	public Long getCreatedBy() {
		return createdBy;
	}
	
	@JsonIgnore(value=false)
	@Transient
	public Long getUpdatedBy() {
		return updatedBy;
	}
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
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
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int compareTo(ServiceEntityNotes arg0) {
		return 0;
	}

	@Override
	public String toString() {
		return "SENote [entityId=" + entityId + ", notes=" + notes + ", type="
				+ type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
		ServiceEntityNotes other = (ServiceEntityNotes) obj;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}	

}
