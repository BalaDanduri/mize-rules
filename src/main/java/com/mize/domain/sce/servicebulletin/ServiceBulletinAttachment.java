package com.mize.domain.sce.servicebulletin;

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
 * @author SrinivasThodupunuri 
 * @version 1.0
 */
@Entity
@Table(name = "srvc_blltn_attach")
public class ServiceBulletinAttachment extends MizeSceEntity implements Comparable<ServiceBulletinAttachment> {

	
	private static final long serialVersionUID = -2371187334917831450L;
	
	private ServiceBulletin serviceBulletin;
	private EntityAttachment entityAttachment;

	public ServiceBulletinAttachment() {
		
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
	@JoinColumn(name = "blltn_id")
	@JsonBackReference(value="service_bulletin_attachments")
	@JsonSerialize(using=JPASerializer.class)
	public ServiceBulletin getServiceBulletin() {
		return serviceBulletin;
	}

	public void setServiceBulletin(ServiceBulletin serviceBulletin) {
		this.serviceBulletin = serviceBulletin;
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
		ServiceBulletinAttachment other = (ServiceBulletinAttachment) obj;
		if (entityAttachment == null) {
			if (other.entityAttachment != null)
				return false;
		} else if (!entityAttachment.equals(other.entityAttachment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceBulletinAttachment [entityAttachment="
				+ entityAttachment + "]";
	}

	@Override
	public int compareTo(ServiceBulletinAttachment o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
