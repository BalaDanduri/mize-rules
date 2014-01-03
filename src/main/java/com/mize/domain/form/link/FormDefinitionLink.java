package com.mize.domain.form.link;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.form.FormDefinition;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "form_defn_link", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class FormDefinitionLink extends MizeEntity {

	private static final long serialVersionUID = -5813531097572778442L;
	
	private FormDefinition formDefinition;
	private List<FormDefinitionLinkData> formDefnLinkData;
	private User user;
	
	public FormDefinitionLink() {
		super();
	}
	
	public FormDefinitionLink(List<FormDefinitionLinkData> formDefnLinkData) {
		super();
		this.formDefnLinkData = formDefnLinkData;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, length = 20)
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id=id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="form_defn_id", nullable = true)
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}
	
	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.EAGER, mappedBy = "formDefinitionLink", orphanRemoval= true)
	@JsonManagedReference(value="form_defn_link")
	@Fetch(FetchMode.SUBSELECT)
	public List<FormDefinitionLinkData> getFormDefnLinkData() {
		return formDefnLinkData;
	}
	
	public void setFormDefnLinkData(List<FormDefinitionLinkData> formDefnLinkData) {
		this.formDefnLinkData = formDefnLinkData;
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Column(name = "created_date", updatable = false)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)	
	@JsonIgnore(value=false)
	public DateTime getCreatedDate() {
		return createdDate;
	}
	
	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}
	
	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Column(name = "updated_date", nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateTimeSerializer.class,include=Inclusion.NON_DEFAULT)
	@JsonIgnore(value=false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}
	
	
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(value=false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}
	
	@Override	
	@Column(name = "created_by", nullable = true, length = 20, updatable = false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
	}
	
	@Override
	@JsonIgnore
	@Column(name = "updated_by", nullable = true, length = 20)
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}
	
	@Override
	@JsonIgnore
	public void setUpdatedBy(Long updatedBy) {		
		super.setUpdatedBy(updatedBy);
	}

	
	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((formDefinition == null) ? 0 : formDefinition.hashCode());
		result = prime
				* result
				+ ((formDefnLinkData == null) ? 0 : formDefnLinkData.hashCode());
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
		FormDefinitionLink other = (FormDefinitionLink) obj;
		if (formDefinition == null) {
			if (other.formDefinition != null)
				return false;
		} else if (!formDefinition.equals(other.formDefinition))
			return false;
		if (formDefnLinkData == null) {
			if (other.formDefnLinkData != null)
				return false;
		} else if (!formDefnLinkData.containsAll(other.formDefnLinkData))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormDefinitionLink [formDefinition=" + formDefinition
				+ ", formDefnLinkData=" + formDefnLinkData + "]";
	}

}