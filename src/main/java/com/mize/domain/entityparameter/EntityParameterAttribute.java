package com.mize.domain.entityparameter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "entity_parameter_attribute", uniqueConstraints = { @UniqueConstraint(columnNames = {"id"}) })
public class EntityParameterAttribute extends MizeEntity implements Comparable<EntityParameterAttribute>{

	private static final long serialVersionUID = -4461151996428842735L;
	private EntityParameter entityParameter;
	private String code;
	private String value;
	Long parameterId;
	public EntityParameterAttribute() {
		super();
	}

	public EntityParameterAttribute(String code, String value) {
		super();
		this.code = code;
		this.value = value;
	}
	
	public EntityParameterAttribute(Long id ,Long parameterId ,String code, String value) {
		super();
		this.code = code;
		this.value = value;
		this.id = id;
		this.parameterId = parameterId;
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

	@Column(name = "attribute_code",length = 50)
	public String getCode() {
		return code;
	}

	@Column(name = "attribute_value",length = 50)
	public String getValue() {
		return value;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parameter_id")
	@JsonBackReference(value="entityParameter")
	public EntityParameter getEntityParameter() {
		return entityParameter;
	}

	public void setEntityParameter(EntityParameter entityParameter) {
		this.entityParameter = entityParameter;
	}

	@Transactional
	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public int compareTo(EntityParameterAttribute entityParameterAttribute) {
		if (this == entityParameterAttribute)
			return EQUAL;
		else if (this.id < entityParameterAttribute.id)
			return BEFORE;
		else if (entityParameterAttribute.id == this.id)
			return EQUAL;
		else if (this.id > entityParameterAttribute.id)
			return AFTER;
		return EQUAL;
	}

	

	@Override
	public String toString() {
		return "EntityParameterAttribute [code=" + code + ", value=" + value
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((value == null) ? 0 : value.hashCode());
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
		EntityParameterAttribute other = (EntityParameterAttribute) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;		
		return true;
	}

}
