package com.mize.domain.businessentity;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.EntityAddress;
import com.mize.domain.common.MizeSceEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "business_entity_rltn")
public class BusinessEntityRelation extends MizeSceEntity {
	
	private static final long serialVersionUID = 6120918610246685696L;
	private BusinessEntity businessEntity;
	private BusinessEntity relatedBusinessEntity;
	private String referenceNumber;
	private User user;
	private BusinessEntity tenant;
	private String source;
	private EntityAddress address;
	
	public BusinessEntityRelation() {
		super();
	}
	
	public BusinessEntityRelation(Long id, Long rebeId, String rebeCode, String rebeTypeCode, String rebeIntlName, String referenceNumber) {
		this.id = id;
		if(this.relatedBusinessEntity == null){
			setRelatedBusinessEntity(new BusinessEntity());
		}
		this.relatedBusinessEntity.setId(rebeId);
		this.relatedBusinessEntity.setCode(rebeCode);
		this.relatedBusinessEntity.setTypeCode(rebeTypeCode);
		BusinessEntityIntl beIntl = new BusinessEntityIntl();
		beIntl.setName(rebeIntlName);
		this.relatedBusinessEntity.getIntl().add(beIntl);
		this.referenceNumber = referenceNumber;
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
		this.id= id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonBackReference(value="be_relation")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}

	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rltn_be_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getRelatedBusinessEntity() {
		return relatedBusinessEntity;
	}

	public void setRelatedBusinessEntity(BusinessEntity relatedBusinessEntity) {
		this.relatedBusinessEntity = relatedBusinessEntity;
	}	
	
	@Column(name = "rltn_be_reference", length = 100, nullable = false)
	public String getReferenceNumber() {
		return referenceNumber;
	}
	
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Transient
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Transient
	public EntityAddress getAddress() {
		return address;
	}

	public void setAddress(EntityAddress address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((referenceNumber == null) ? 0 : referenceNumber.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		BusinessEntityRelation other = (BusinessEntityRelation) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (referenceNumber == null) {
			if (other.referenceNumber != null)
				return false;
		} else if (!referenceNumber.equals(other.referenceNumber))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusinessEntityRelation [referenceNumber=" + referenceNumber
				+ ", user=" + user + ", source=" + source + ", address="
				+ address + ", id=" + id + "]";
	}
}
