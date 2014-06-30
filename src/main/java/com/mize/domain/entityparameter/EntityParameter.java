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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.EntityComment;
import com.mize.domain.common.EntityReference;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "entity_parameter", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class EntityParameter extends MizeEntity implements Comparable<EntityParameter>{

	private static final long serialVersionUID = 841149014756400338L;
	private BusinessEntity tenant;
	private String type;
	private String code;
	private Long beId;
	private DateTime startDate;
	private DateTime endDate;
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
	@Column(name="id",nullable=false,unique=true)
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
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}
	
	@Column(name = "entity_type",length = 50)
	public String getType() {
		return type;
	}
	
	@Column(name = "entity_code",length = 50)
	public String getCode() {
		return code;
	}
	
	@Column(name = "start_date", nullable = false)
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}

	@Column(name = "end_date", nullable = false)
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@JsonIgnore(false)
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore(false)
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore(false)
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore(false)
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public void setCode(String code) {
		this.code = code;
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
	
	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}
	
	@Transient
	public EntityComment getEntityComment() {
		return entityComment;
	}

	public void setEntityComment(EntityComment entityComment) {
		this.entityComment = entityComment;
	}
	
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
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((entityReference == null) ? 0 : entityReference.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((beId == null) ? 0 : beId.hashCode());
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
		if (entityReference == null) {
			if (other.entityReference != null)
				return false;
		} else if (!entityReference.equals(other.entityReference))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.equals(other.tenant))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (beId == null) {
			if (other.beId != null)
				return false;
		} else if (beId != other.beId)
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
