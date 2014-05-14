package com.mize.domain.search;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;

@Entity
@Table(name = "search_template")
public class SearchTemplate extends MizeEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8770151975672845354L;
	private Long id;
	private Long searchEntityId;
	private String reportName;
	private String description;
	private List<SearchTemplateToBe> searchTemplateToBes;
	private List<SearchTemplateToUser> searchTemplateToUsers;
	
	@Transient
	private List<SearchEntityAttribute> criteriaAttributes;

	@Transient
	private List<SearchEntityAttribute> resultAttributes;

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
	@Column(name = "search_entity_id")
	public Long getSearchEntityId() {
		return searchEntityId;
	}
	public void setSearchEntityId(Long searchEntityId) {
		this.searchEntityId = searchEntityId;
	}
	
	@Column(name = "report_name", length = 100)
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	@Column(name = "description", length = 1000)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "searchTemplate",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="searchTemplateToBe")
	public List<SearchTemplateToBe> getSearchTemplateToBes() {
		return searchTemplateToBes;
	}
	public void setSearchTemplateToBes(List<SearchTemplateToBe> searchTemplateToBes) {
		this.searchTemplateToBes = searchTemplateToBes;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "searchTemplate",orphanRemoval= true)
	@JsonSerialize(using=JPASerializer.class,include=Inclusion.NON_NULL)
	@JsonManagedReference(value="searchTemplateToUser")
	public List<SearchTemplateToUser> getSearchTemplateToUsers() {
		return searchTemplateToUsers;
	}
	public void setSearchTemplateToUsers(
			List<SearchTemplateToUser> searchTemplateToUsers) {
		this.searchTemplateToUsers = searchTemplateToUsers;
	}
	
	@Transient
	public List<SearchEntityAttribute> getCriteriaAttributes() {
		return criteriaAttributes;
	}
	public void setCriteriaAttributes(List<SearchEntityAttribute> criteriaAttributes) {
		this.criteriaAttributes = criteriaAttributes;
	}
	
	@Transient
	public List<SearchEntityAttribute> getResultAttributes() {
		return resultAttributes;
	}
	public void setResultAttributes(List<SearchEntityAttribute> resultAttributes) {
		this.resultAttributes = resultAttributes;
	}
	@PrePersist
	@PreUpdate
	public void auditFields(){
		if(createdDate==null && id==null){
			setCreatedDate(DateTime.now());
		}
		setUpdatedDate(DateTime.now());		
	}

	@Override
	public String toString() {
		return "SearchTemplate [id=" + id + ", searchEntityId="
				+ searchEntityId + ", reportName=" + reportName
				+ ", description=" + description + "]";
	}

}
