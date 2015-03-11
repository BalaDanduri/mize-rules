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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.datetime.DateTime;

@Entity(name = "se.ServiceEntityRelation")
@Table(name = "service_entity_rltn")
public class ServiceEntityRelation extends MizeSceEntity implements Comparable<ServiceEntityRelation> {

	private static final long serialVersionUID = 6821133638967617947L;
	@Transient
	private Long entityId;
	
	private ServiceEntity serviceEntity;
	private Long entityRelationId;
	
	public ServiceEntityRelation() {
		super();
	}
	
	public ServiceEntityRelation(Long id,Long entityId, Long entityRelationId) {
		super();
		this.id = id;
		this.entityId = entityId;
		this.entityRelationId = entityRelationId;
	}

	public Long getEntityId() {
		return entityId;
	}
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entity_id")
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}
	
	@Column(name="entity_rltn_id")
	public Long getEntityRelationId() {
		return entityRelationId;
	}
	
	
	public void setEntityRelationId(Long entityRelationId) {
		this.entityRelationId = entityRelationId;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
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
	
	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}	
	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityId == null) ? 0 : entityId.hashCode());
		result = prime
				* result
				+ ((entityRelationId == null) ? 0 : entityRelationId.hashCode());
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
		ServiceEntityRelation other = (ServiceEntityRelation) obj;
		if (entityId == null) {
			if (other.entityId != null)
				return false;
		} else if (!entityId.equals(other.entityId))
			return false;
		if (entityRelationId == null) {
			if (other.entityRelationId != null)
				return false;
		} else if (!entityRelationId.equals(other.entityRelationId))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ServiceEntityRelation arg0) {
		return 0;
	}

	

}
