package com.mize.domain.form;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateSerializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "form_defn")
public class FormDefinition extends MizeEntity {

	private static final long serialVersionUID = -6036421353518015224L;

	private FormTemplateDefinition formTemplateDefinition;
	private BusinessEntity tenant;
	private String formCode;
	private String versionNumber;
	private String statusCode;
	private String formDefinitionData;
	private String isActive;
	private DateTime startDate;
	private DateTime endDate;
	private List<FormDefinitionAudit> audits = new ArrayList<FormDefinitionAudit>();
	private List<FormDefinitionIntl> intls;
	private User user;

	public FormDefinition() {
		tenant = new BusinessEntity();
		formTemplateDefinition = new FormTemplateDefinition();
		intls = new ArrayList<FormDefinitionIntl>();
	}

	public FormDefinition(FormTemplateDefinition formTemplateDefinition, BusinessEntity tenant, String formCode, String versionNumber, String statusCode, String formDefinitionData, String isActive, DateTime startDate, DateTime endDate) {
		super();
		this.formTemplateDefinition = formTemplateDefinition;
		this.tenant = tenant;
		this.formCode = formCode;
		this.versionNumber = versionNumber;
		this.statusCode = statusCode;
		this.formDefinitionData = formDefinitionData;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.intls = new ArrayList<FormDefinitionIntl>();
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
		super.id = id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "template_defn_id", nullable = true)
	public FormTemplateDefinition getFormTemplateDefinition() {
		return formTemplateDefinition;
	}

	public void setFormTemplateDefinition(FormTemplateDefinition formTemplateDefinition) {
		this.formTemplateDefinition = formTemplateDefinition;
	}

	@OneToOne()
	@JoinColumn(name = "tenant_id", nullable = true)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "form_code", nullable = true, length = 50)
	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	@Column(name = "version_number", nullable = true, length = 50)
	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Column(name = "status_code", nullable = true, length = 50)
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Column(name = "form_defn_data", nullable = true)
	public String getFormDefinitionData() {
		return formDefinitionData;
	}

	public void setFormDefinitionData(String formDefinitionData) {
		this.formDefinitionData = formDefinitionData;
	}

	@Column(name = "is_active", nullable = true, length = 1)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "start_date", nullable = true)
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonDeserialize(using = JodaDateDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "end_date", nullable = true)
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@JsonDeserialize(using = JodaDateDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "formDefinition", orphanRemoval = true)
	@JsonManagedReference(value = "form_def")
	@Fetch(FetchMode.SUBSELECT)
	@JsonSerialize(using = JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public List<FormDefinitionAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<FormDefinitionAudit> audits) {
		this.audits = audits;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "formDefinition", orphanRemoval = true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonManagedReference(value = "form_intls")
	public List<FormDefinitionIntl> getIntls() {
		return intls;
	}

	public void setIntls(List<FormDefinitionIntl> intls) {
		this.intls = intls;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	@Column(name = "created_date", updatable = false)
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value = false)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override
	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(value = false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	@Column(name = "updated_date", nullable = true)
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	@JsonIgnore(value = false)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using = JodaDateTimeDeserializer.class)
	@JsonIgnore(value = false)
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
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((formCode == null) ? 0 : formCode.hashCode());
		result = prime * result + ((formDefinitionData == null) ? 0 : formDefinitionData.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((formTemplateDefinition == null) ? 0 : formTemplateDefinition.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + ((versionNumber == null) ? 0 : versionNumber.hashCode());
		result = prime * result + ((intls == null) ? 0 : intls.hashCode());
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
		FormDefinition other = (FormDefinition) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (formCode == null) {
			if (other.formCode != null)
				return false;
		} else if (!formCode.equals(other.formCode))
			return false;
		if (formDefinitionData == null) {
			if (other.formDefinitionData != null)
				return false;
		} else if (!formDefinitionData.equals(other.formDefinitionData))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (formTemplateDefinition == null) {
			if (other.formTemplateDefinition != null)
				return false;
		} else if (!formTemplateDefinition.equals(other.formTemplateDefinition))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (tenant.getId() != null && !tenant.getId().equals(other.tenant.getId()))
			return false;
		if (versionNumber == null) {
			if (other.versionNumber != null)
				return false;
		} else if (versionNumber.compareTo(other.versionNumber) != 0)
			return false;
		if (intls == null) {
			if (other.intls != null)
				return false;
		} else if (!intls.equals(other.intls))
			return false;
		return true;
	}

}
