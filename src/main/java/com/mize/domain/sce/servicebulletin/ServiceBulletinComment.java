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
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

/**
 * @author SrinivasThodupunuri
 * @version 1.0
 */
@Entity
@Table(name = "srvc_blltn_cmnt")
public class ServiceBulletinComment extends MizeEntity {

	
	private static final long serialVersionUID = -3606993641052519739L;
	
	private ServiceBulletin serviceBulletin;
	private EntityComment entityComment;

	public ServiceBulletinComment() {
		
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
	@JsonBackReference(value="service_bulletin_comments")
	@JsonSerialize(using=JPASerializer.class)	
	public ServiceBulletin getServiceBulletin() {
		return serviceBulletin;
	}

	public void setServiceBulletin(ServiceBulletin serviceBulletin) {
		this.serviceBulletin = serviceBulletin;
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
				+ ((serviceBulletin == null) ? 0 : serviceBulletin.hashCode());
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
		ServiceBulletinComment other = (ServiceBulletinComment) obj;
		if (entityComment == null) {
			if (other.entityComment != null)
				return false;
		} else if (!entityComment.equals(other.entityComment))
			return false;
		if (serviceBulletin == null) {
			if (other.serviceBulletin != null)
				return false;
		} else {
			if(serviceBulletin.getId() == null) {
				if(other.serviceBulletin.getId() != null)
					return false;
			} else if(!serviceBulletin.getId().equals(other.serviceBulletin.getId()))
				return false;
		}
		return true;
	}

}
