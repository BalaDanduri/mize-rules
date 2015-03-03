package com.mize.domain.entityparameter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.EntityReference;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.MizeDate;
import com.mize.domain.util.TenantSerializer;

@Entity
@Table(name = "entity_parameter")
public class EntityParameter extends MizeSceEntityAudit implements Comparable<EntityParameter>{
	private static final long serialVersionUID = 841149014756400338L;
	private BusinessEntity tenant;
	private String type;
	private String code;
	private Long beId;
	private MizeDate startDate;
	private MizeDate endDate;
	@Transient
	private User user;
	@Transient
	private EntityComment entityComment;
	@Transient
	private EntityReference entityReference;
	private List<EntityParameterAttribute> attributes = new ArrayList<EntityParameterAttribute>();
	private List<EntityParameterComment> comments = new ArrayList<EntityParameterComment>();
	
	public EntityParameter() {
	}

	@Id
	@Column(name="id",unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=TenantSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}
	

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column(name = "entity_type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name = "entity_code")
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "start_date")
	@Type(type = "com.mize.domain.util.MizeDateJPA")
	public MizeDate getStartDate() {
		return startDate;
	}

	public void setStartDate(MizeDate startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	@Type(type="com.mize.domain.util.MizeDateJPA")
	public MizeDate getEndDate() {
		return endDate;
	}

	public void setEndDate(MizeDate endDate) {
		this.endDate = endDate;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "entityParameter", orphanRemoval=true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<EntityParameterAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<EntityParameterAttribute> attributes) {
		this.attributes = attributes;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "entityParameter")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<EntityParameterComment> getComments() {
		return comments;
	}

	public void setComments(List<EntityParameterComment> comments) {
		this.comments = comments;
	}
	
	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}
	
	@JsonIgnore
	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public EntityReference getEntityReference() {
		return entityReference;
	}

	public void setEntityReference(EntityReference entityReference) {
		this.entityReference = entityReference;
	}

	public int compareTo(EntityParameter entityParameter) {
		if (this == entityParameter)
			return EQUAL;
		else if (this.id < entityParameter.id)
			return BEFORE;
		else if (entityParameter.id == this.id)
			return EQUAL;
		else if (this.id > entityParameter.id)
			return AFTER;
		return EQUAL;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((beId == null) ? 0 : beId.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		EntityParameter other = (EntityParameter) obj;
		if (beId == null) {
			if (other.beId != null)
				return false;
		} else if (!beId.equals(other.beId))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	

	@Column(name="entity_be_id")
	public Long getBeId() {
		return beId;
	}

	public void setBeId(Long beId) {
		this.beId = beId;
	}
	
}
