package com.mize.domain.form.link;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.form.FormDefinition;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("FormDefinitionLink")
@Table(name = "form_defn_link", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class FormDefinitionLink extends MizeEntity {

	private static final long serialVersionUID = -5813531097572778442L;
	
	private FormDefinition formDefinition;
	private String inspectionType;
	private String businessEntityType;
	private String model;
	private String brandName;
	private String categoryName;
	private User user;
	
	public FormDefinitionLink() {
		super();
		formDefinition = new FormDefinition();
	}
	
	public FormDefinitionLink(FormDefinition formDefinition) {
		super();
		this.formDefinition = formDefinition;
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_defn_id")
	@JsonBackReference(value="form_defn_links")
	@JsonSerialize(using=JPASerializer.class)
	public FormDefinition getFormDefinition() {
		return formDefinition;
	}
	
	public void setFormDefinition(FormDefinition formDefinition) {
		this.formDefinition = formDefinition;
	}

	@Column(name ="insp_type", length = 50)
	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	@Column(name ="be_type", length = 50)
	public String getBusinessEntityType() {
		return businessEntityType;
	}

	public void setBusinessEntityType(String businessEntityType) {
		this.businessEntityType = businessEntityType;
	}

	@Column(name ="model", length = 50)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name ="brand_name", length = 250)
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name ="category", length = 250)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
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
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
		result = prime * result + ((businessEntityType == null) ? 0 : businessEntityType.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((inspectionType == null) ? 0 : inspectionType.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		if (brandName == null) {
			if (other.brandName != null)
				return false;
		} else if (!brandName.equals(other.brandName))
			return false;
		if (businessEntityType == null) {
			if (other.businessEntityType != null)
				return false;
		} else if (!businessEntityType.equals(other.businessEntityType))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (inspectionType == null) {
			if (other.inspectionType != null)
				return false;
		} else if (!inspectionType.equals(other.inspectionType))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormDefinitionLink [inspectionType=" + inspectionType + ", businessEntityType=" + businessEntityType + ", model=" + model 
				+ ", brandName=" + brandName + ", categoryName=" + categoryName + "]";
	}

}
