package com.mize.domain.sce.serviceentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity(name = "sce.ServiceEntityRelation")
@Table(name = "srvc_enty_rltn")
public class ServiceEntityRelation extends MizeEntity {
	
	private static final long serialVersionUID = 1131204751473949728L;
	
	private ServiceEntity serviceEntity;
	private Long relationId;
	private String relationType;

	public ServiceEntityRelation() {
		
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
	
	@ManyToOne
	@JoinColumn(name = "service_entity_id")
	@JsonBackReference(value="service_entity_relations")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	@Column(name = "service_entity_rltn_id")
	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}
	
	@Column(name = "service_entity_rltn_type")
	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((relationId == null) ? 0 : relationId.hashCode());
		result = prime * result
				+ ((relationType == null) ? 0 : relationType.hashCode());
		result = prime * result
				+ ((serviceEntity == null) ? 0 : serviceEntity.hashCode());
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
		if (relationId == null) {
			if (other.relationId != null)
				return false;
		} else if (!relationId.equals(other.relationId))
			return false;
		if (relationType == null) {
			if (other.relationType != null)
				return false;
		} else if (!relationType.equals(other.relationType))
			return false;
		if (serviceEntity == null) {
			if (other.serviceEntity != null)
				return false;
		} else {
			if(serviceEntity.getId() == null) {
				if(other.serviceEntity.getId() != null)
					return false;
			} else if(!serviceEntity.getId().equals(other.serviceEntity.getId()))
				return false;
		}
		return true;
	}
	

}
