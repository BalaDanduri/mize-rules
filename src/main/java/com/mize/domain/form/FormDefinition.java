package com.mize.domain.form;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeSceEntityAudit;
import com.mize.domain.datetime.Date;
import com.mize.domain.form.link.FormDefinitionLink;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.TenantSerializer;

@Entity
@Inheritance
@DiscriminatorColumn(name = "discriminator")
@DiscriminatorValue("FormDefinition")
@Table(name = "form_defn")
public class FormDefinition extends MizeSceEntityAudit implements Comparable<FormDefinition> {

	private static final long serialVersionUID = -6036421353518015224L;

	private FormTemplateDefinition formTemplateDefinition;
	private BusinessEntity tenant;
	private String formCode;
	private String versionNumber;
	private String statusCode;
	private String formDefinitionData;
	private String isActive;
	private Date startDate;
	private Date endDate;
	private String isNewVersion;
	private Form form;
	private Locale locale;
	private String source;
	private String reference;
	private List<FormDefinitionAudit> audits = new ArrayList<FormDefinitionAudit>();
	private List<FormDefinitionIntl> intls;
	private List<FormDefinitionLink> links;
	private List<FormDefinitionMessage> messages;
	private User user;

	public FormDefinition() {
		tenant = new BusinessEntity();
		form = new Form();
		formTemplateDefinition = new FormTemplateDefinition();
		intls = new ArrayList<FormDefinitionIntl>();
		links = new ArrayList<FormDefinitionLink>();
		messages = new ArrayList<FormDefinitionMessage>();
	}

	public FormDefinition(FormTemplateDefinition formTemplateDefinition, BusinessEntity tenant, String formCode, String versionNumber, String statusCode, String formDefinitionData, String isActive, Date startDate, Date endDate) {
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
		this.links = new ArrayList<FormDefinitionLink>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Override
	public Long getId() {
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	/*@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "template_defn_id", nullable = true)*/
	@Transient
	@JsonIgnore
	public FormTemplateDefinition getFormTemplateDefinition() {
		return formTemplateDefinition;
	}

	public void setFormTemplateDefinition(FormTemplateDefinition formTemplateDefinition) {
		this.formTemplateDefinition = formTemplateDefinition;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	@JsonSerialize(using = TenantSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "form_code")
	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	@Column(name = "version_number")
	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	@Column(name = "status_code")
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonIgnore
	@Column(name = "form_defn_data")
	public String getFormDefinitionData() {
		return formDefinitionData;
	}

	public void setFormDefinitionData(String formDefinitionData) {
		this.formDefinitionData = formDefinitionData;
	}

	@Column(name = "is_active")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	
	@Column(name = "start_date")
	@JsonInclude(Include.NON_DEFAULT)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	@JsonInclude(Include.NON_DEFAULT)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Transient
	public String getIsNewVersion() {
		return isNewVersion;
	}

	public void setIsNewVersion(String isNewVersion) {
		this.isNewVersion = isNewVersion;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "formDefinition", orphanRemoval = true)
	@JsonManagedReference(value = "form_def")
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
	
	@OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.LAZY, mappedBy = "formDefinition", orphanRemoval= true)
	@JsonSerialize(using = JPASerializer.class)
	@JsonManagedReference(value="form_defn_links")
	@JsonInclude(Include.NON_NULL)
	public List<FormDefinitionLink> getLinks() {
		return links;
	}
	
	public void setLinks(List<FormDefinitionLink> links) {
		this.links = links;
	}

	@Transient
	public Form getForm() {
		return form;
	}
	
	public void setForm(Form form) {
		this.form = form;
	}

	@Transient
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Column(name = "form_source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "form_reference")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "formDefinition", orphanRemoval = true)
	@JsonIgnore
	public List<FormDefinitionMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<FormDefinitionMessage> messages) {
		this.messages = messages;
	}

	@Transient
	@JsonIgnore
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((audits == null) ? 0 : audits.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + ((formCode == null) ? 0 : formCode.hashCode());
		result = prime * result + ((formTemplateDefinition == null) ? 0 : formTemplateDefinition.hashCode());
		result = prime * result + ((intls == null) ? 0 : intls.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((isNewVersion == null) ? 0 : isNewVersion.hashCode());
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((messages == null) ? 0 : messages.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((versionNumber == null) ? 0 : versionNumber.hashCode());
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
		if (audits == null) {
			if (other.audits != null)
				return false;
		} else if (!audits.equals(other.audits))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
			return false;
		if (formCode == null) {
			if (other.formCode != null)
				return false;
		} else if (!formCode.equals(other.formCode))
			return false;
		if (formTemplateDefinition == null) {
			if (other.formTemplateDefinition != null)
				return false;
		} else if (!formTemplateDefinition.equals(other.formTemplateDefinition))
			return false;
		if (intls == null) {
			if (other.intls != null)
				return false;
		} else if (!intls.equals(other.intls))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (isNewVersion == null) {
			if (other.isNewVersion != null)
				return false;
		} else if (!isNewVersion.equals(other.isNewVersion))
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (messages == null) {
			if (other.messages != null)
				return false;
		} else if (!messages.equals(other.messages))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
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
		} else if (!tenant.equals(other.tenant))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (versionNumber == null) {
			if (other.versionNumber != null)
				return false;
		} else if (!versionNumber.equals(other.versionNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormDefinition [formTemplateDefinition=" + formTemplateDefinition + ", tenant=" + tenant + ", formCode=" + formCode 
				+ ", versionNumber=" + versionNumber + ", statusCode=" + statusCode + ", isActive=" + isActive + ", startDate=" + startDate 
				+ ", endDate=" + endDate + ", isNewVersion=" + isNewVersion + ", form=" + form + ", locale=" + locale + ", source=" + source 
				+ ", reference=" + reference + ", audits=" + audits + ", intls=" + intls + ", links=" + links + ", messages=" + messages 
				+ ", user=" + user + "]";
	}
	
	@Override
	public int compareTo(FormDefinition formDefn) {
		if ( this == formDefn ) 
			return EQUAL;
		else if (this.id < formDefn.id) 
			return BEFORE;
		else if (formDefn.id == this.id) 
			return EQUAL;
		else if (this.id > formDefn.id)
			return AFTER;
		return EQUAL;
	}

}
