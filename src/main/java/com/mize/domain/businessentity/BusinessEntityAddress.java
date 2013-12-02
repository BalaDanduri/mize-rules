package com.mize.domain.businessentity;

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

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity(name="com.mize.domain.businessentity.BusinessEntityAddress")
@Table(name="business_entity_address")
public class BusinessEntityAddress  extends MizeEntity  implements Comparable<BusinessEntityAddress>{

	private static final long serialVersionUID = 625412111910612584L;	
	private Long beId;
	private BusinessEntity businessEntity;
	private EntityAddress entityAddress;
	
	public BusinessEntityAddress() {
		super();
	}
	
	@Id
	@Column(name="id",nullable=false,unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Transient
	@Column(name="be_id",insertable=false,updatable=false)
	@JsonIgnore
	public long getBeId() {
		return beId;
	}
	public void setBeId(long beId) {
		this.beId = beId;
	}
	
	@OneToOne(fetch=FetchType.LAZY ,cascade= CascadeType.ALL)
	@JoinColumn(name="be_address_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public EntityAddress getEntityAddress() {
		return entityAddress;
	}
	
	public void setEntityAddress(EntityAddress entityAddress) {
		this.entityAddress = entityAddress;
	}
	
	@Override
	public int compareTo(BusinessEntityAddress o) {
		return(int)( this.getId() - o.getId());
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonBackReference
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((beId == null) ? 0 : beId.hashCode());
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime * result
				+ ((entityAddress == null) ? 0 : entityAddress.hashCode());
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
		BusinessEntityAddress other = (BusinessEntityAddress) obj;
		if (beId == null) {
			if (other.beId != null)
				return false;
		} else if (!beId.equals(other.beId))
			return false;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.equals(other.businessEntity))
			return false;
		if (entityAddress == null) {
			if (other.entityAddress != null)
				return false;
		} else if (!entityAddress.equals(other.entityAddress))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessEntityAddress [beId=");
		builder.append(beId);
		builder.append(", businessEntity=");
		builder.append(businessEntity);
		builder.append(", entityAddress=");
		builder.append(entityAddress);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}