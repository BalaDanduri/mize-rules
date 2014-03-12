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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "business_entity_rltn")
public class BusinessEntityRelation extends MizeEntity {
	
	private static final long serialVersionUID = 6120918610246685696L;
	
	private BusinessEntity businessEntity;
	private BusinessEntity relatedBusinessEntity;
	private String relatedReference;
	
	public BusinessEntityRelation() {
		
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
	public String getRelatedReference() {
		return relatedReference;
	}
	
	public void setRelatedReference(String relatedReference) {
		this.relatedReference = relatedReference;
	}

}
