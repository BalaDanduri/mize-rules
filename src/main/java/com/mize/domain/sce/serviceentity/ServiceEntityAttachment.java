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
import com.mize.domain.common.EntityAttachment;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;


/**
 * @author HarishBurra
 * @version 1.0
 */
@Entity
@Table(name = "srvc_enty_attach")
public class ServiceEntityAttachment extends MizeSceEntity implements Comparable<ServiceEntityAttachment> {

	
	private static final long serialVersionUID = -2371187334917831450L;
	
	private ServiceEntity serviceEntity;
	private EntityAttachment entityAttachment;

	public ServiceEntityAttachment() {
		
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
	@JsonBackReference(value="service_entity_attachments")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceEntity getServiceEntity() {
		return serviceEntity;
	}

	public void setServiceEntity(ServiceEntity serviceEntity) {
		this.serviceEntity = serviceEntity;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "attach_id")
	public EntityAttachment getEntityAttachment() {
		return entityAttachment;
	}

	public void setEntityAttachment(EntityAttachment entityAttachment) {
		this.entityAttachment = entityAttachment;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime
				* result
				+ ((entityAttachment == null) ? 0 : entityAttachment.hashCode());
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
		ServiceEntityAttachment other = (ServiceEntityAttachment) obj;
		if (entityAttachment == null) {
			if (other.entityAttachment != null)
				return false;
		} else if (!entityAttachment.equals(other.entityAttachment))
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
	public int compareTo(ServiceEntityAttachment arg0) {
		return 0;
	}
	

}
