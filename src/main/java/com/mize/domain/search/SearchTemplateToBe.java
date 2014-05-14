package com.mize.domain.search;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "search_template_to_be")
public class SearchTemplateToBe extends MizeEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3096913236977385350L;
	private Long id;
	private SearchTemplate searchTemplate;
	private BusinessEntity businessEntity;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true)
	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "search_template_id")
	@JsonBackReference(value="searchTemplateToBe")
	public SearchTemplate getSearchTemplate() {
		return searchTemplate;
	}
	public void setSearchTemplate(SearchTemplate searchTemplate) {
		this.searchTemplate = searchTemplate;
	}
	
	@ManyToOne(cascade={CascadeType.ALL},fetch = FetchType.LAZY)
	@JoinColumn(name="be_id")
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}
	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}

	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}

}
