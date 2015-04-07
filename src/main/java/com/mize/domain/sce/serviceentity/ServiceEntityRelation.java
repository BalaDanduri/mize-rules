package com.mize.domain.sce.serviceentity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_rltn")
public class ServiceEntityRelation extends MizeSceEntity implements Comparable<ServiceEntityRelation> {
	
	private static final long serialVersionUID = 1131204751473949728L;
	
	private ServiceEntity serviceEntity;
	//private ServiceEntity relatedEntity;
	
	
	private Long entityCode;	
	private Long relatedEntityId;
	private String relationType;
	

	public ServiceEntityRelation() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
	
	/*@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "service_entity_rltn_id")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getRelatedEntity() {
		return relatedEntity;
	}
	
	public void setRelatedEntity(ServiceEntity relatedEntity) {
		this.relatedEntity = relatedEntity;
	}*/
	
	@Column(name = "srvc_enty_rltn_type")
	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	
	@Transient
	public Long getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(Long entityCode) {
		this.entityCode = entityCode;
	}
	
	@Column(name = "service_entity_rltn_id")
	public Long getRelatedEntityId() {
		return relatedEntityId;
	}

	public void setRelatedEntityId(Long relatedEntityId) {
		this.relatedEntityId = relatedEntityId;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((relationType == null) ? 0 : relationType.hashCode());
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
		if (relationType == null) {
			if (other.relationType != null)
				return false;
		} else if (!relationType.equals(other.relationType))
			return false;
		return true;
	}

	@Override
	public int compareTo(ServiceEntityRelation o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "ServiceEntityRelation [relationType=" + relationType + "]";
	}
	

}
