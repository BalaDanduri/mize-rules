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
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "entity_parameter", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class EntityParameter extends MizeEntity implements Comparable<EntityParameter>{

	private static final long serialVersionUID = 841149014756400338L;
	private BusinessEntity owner;
	private String type;
	private String code;
	private DateTime startDate;
	private DateTime endDate;
	
	private List<EntityParameterAttribute> attributes = new ArrayList<EntityParameterAttribute>();
	private List<EntityParameterComment> comments = new ArrayList<EntityParameterComment>();
	
	public EntityParameter() {
	}

	

	public EntityParameter(BusinessEntity owner, String type, String code,
			DateTime startDate, DateTime endDate,
			List<EntityParameterAttribute> attributes,
			List<EntityParameterComment> comments) {
		super();
		this.owner = owner;
		this.type = type;
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
		this.attributes = attributes;
		this.comments = comments;
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
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getOwner() {
		return owner;
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
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getStartDate() {
		return startDate;
	}

	@Column(name = "end_date", nullable = false)
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy h:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}
	
	public void setOwner(BusinessEntity owner) {
		this.owner = owner;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "entityParameter", orphanRemoval=true)
	public List<EntityParameterAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<EntityParameterAttribute> attributes) {
		this.attributes = attributes;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "entityParameter")
	/*@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)*/
	public List<EntityParameterComment> getComments() {
		return comments;
	}

	public void setComments(List<EntityParameterComment> comments) {
		this.comments = comments;
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
	public String toString() {
		return "EntityParameter [owner=" + owner + ", type=" + type + ", code="
				+ code + ", startDate=" + startDate + ", endDate=" + endDate
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());		
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
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
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;		
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

}
