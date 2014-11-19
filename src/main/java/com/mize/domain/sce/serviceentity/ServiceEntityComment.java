package com.mize.domain.sce.serviceentity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_cmnt")
public class ServiceEntityComment extends MizeSceEntity implements Comparable<ServiceEntityComment> {

	
	private static final long serialVersionUID = -3606993641052519739L;
	
	private ServiceEntity serviceEntity;
	private EntityComment entityComment;

	public ServiceEntityComment() {
		
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
	@JsonBackReference(value="service_entity_comments")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "comment_id")
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((entityComment == null) ? 0 : entityComment.hashCode());
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
		ServiceEntityComment other = (ServiceEntityComment) obj;
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
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

	@Override
	public int compareTo(ServiceEntityComment o) {
		return 0;
	}	
	

}
