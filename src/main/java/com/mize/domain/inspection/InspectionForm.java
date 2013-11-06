package com.mize.domain.inspection;

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

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.product.ProductRegister;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table( name = "inspection_form")
public class InspectionForm extends MizeEntity {
	
	private static final long serialVersionUID = -666112603626187346L;
	
	private InspectionTemplate template;
	private BusinessEntity businessEntity;
	private User user;
	private String inspectionCode;
	private String typeCode;
	private String statusCode;
	private String formDefinition;
	private DateTime inspectionDate;
	private String inspectedBy;
	private String businessEntityContact;
	private ProductRegister productRegistration;
	private List<InspectionFormAudit> formAudits;
	private List<InspectionFormAttachment> formAttachments;
	

	public InspectionForm() {
		template = new InspectionTemplate();
		businessEntity = new BusinessEntity();
		productRegistration = new ProductRegister();
	}

	public InspectionForm(InspectionTemplate template,
			BusinessEntity businessEntity, User user, String inspectionCode,
			String typeCode, String statusCode, String formDefinition,
			DateTime inspectionDate, String inspectedBy,
			String businessEntityContact, ProductRegister productRegistration,
			List<InspectionFormAudit> formAudits,
			List<InspectionFormAttachment> formAttachments) {
		super();
		this.template = template;
		this.businessEntity = businessEntity;
		this.user = user;
		this.inspectionCode = inspectionCode;
		this.typeCode = typeCode;
		this.statusCode = statusCode;
		this.formDefinition = formDefinition;
		this.inspectionDate = inspectionDate;
		this.inspectedBy = inspectedBy;
		this.businessEntityContact = businessEntityContact;
		this.productRegistration = productRegistration;
		this.formAudits = formAudits;
		this.formAttachments = formAttachments;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",unique=true,nullable=false,length=20)
	@Override
	public Long getId() {		
		return super.id;
	}

	@Override
	public void setId(Long id) {
		super.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "template_id", nullable = false)
	public InspectionTemplate getTemplate() {
		return template;
	}


	public void setTemplate(InspectionTemplate template) {
		this.template = template;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "be_id", nullable = false)
	public BusinessEntity getBusinessEntity() {
		return businessEntity;
	}


	public void setBusinessEntity(BusinessEntity businessEntity) {
		this.businessEntity = businessEntity;
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "inspection_code", nullable = true, length = 30)
	public String getInspectionCode() {
		return inspectionCode;
	}


	public void setInspectionCode(String inspectionCode) {
		this.inspectionCode = inspectionCode;
	}

	@Column(name = "type_code", nullable = true, length = 30)
	public String getTypeCode() {
		return typeCode;
	}


	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "status_code", nullable = true, length = 30)
	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Column(name = "form_definition", nullable = true)
	public String getFormDefinition() {
		return formDefinition;
	}


	public void setFormDefinition(String formDefinition) {
		this.formDefinition = formDefinition;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "inspection_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getInspectionDate() {
		return inspectionDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setInspectionDate(DateTime inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Column(name = "inspected_by",  nullable = true, length = 100)
	public String getInspectedBy() {
		return inspectedBy;
	}


	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}

	@Column(name = "be_contact",  nullable = true, length = 100)
	public String getBusinessEntityContact() {
		return businessEntityContact;
	}


	public void setBusinessEntityContact(String businessEntityContact) {
		this.businessEntityContact = businessEntityContact;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "prod_regn_id", nullable = true)
	public ProductRegister getProductRegistration() {
		return productRegistration;
	}

	public void setProductRegistration(ProductRegister productRegistration) {
		this.productRegistration = productRegistration;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="inspectionForm" )
	public List<InspectionFormAudit> getFormAudits() {
		return formAudits;
	}

	public void setFormAudits(List<InspectionFormAudit> formAudits) {
		this.formAudits = formAudits;
	}	
	
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="inspectionForm" )
	public List<InspectionFormAttachment> getFormAttachments() {
		return formAttachments;
	}

	public void setFormAttachments(List<InspectionFormAttachment> formAttachments) {
		this.formAttachments = formAttachments;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((businessEntity == null) ? 0 : businessEntity.hashCode());
		result = prime
				* result
				+ ((businessEntityContact == null) ? 0 : businessEntityContact
						.hashCode());
		result = prime * result
				+ ((formAttachments == null) ? 0 : formAttachments.hashCode());
		result = prime * result
				+ ((formAudits == null) ? 0 : formAudits.hashCode());
		result = prime * result
				+ ((formDefinition == null) ? 0 : formDefinition.hashCode());
		result = prime * result
				+ ((inspectedBy == null) ? 0 : inspectedBy.hashCode());
		result = prime * result
				+ ((inspectionCode == null) ? 0 : inspectionCode.hashCode());
		result = prime * result
				+ ((inspectionDate == null) ? 0 : inspectionDate.hashCode());
		result = prime
				* result
				+ ((productRegistration == null) ? 0 : productRegistration
						.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((template == null) ? 0 : template.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
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
		InspectionForm other = (InspectionForm) obj;
		if (businessEntity == null) {
			if (other.businessEntity != null)
				return false;
		} else if (!businessEntity.getId().equals(other.businessEntity.getId()))
			return false;
		if (businessEntityContact == null) {
			if (other.businessEntityContact != null)
				return false;
		} else if (!businessEntityContact.equals(other.businessEntityContact))
			return false;
		if (formAttachments == null) {
			if (other.formAttachments != null)
				return false;
		} else if (!formAttachments.equals(other.formAttachments))
			return false;
		if (formAudits == null) {
			if (other.formAudits != null)
				return false;
		} else if (!formAudits.equals(other.formAudits))
			return false;
		if (formDefinition == null) {
			if (other.formDefinition != null)
				return false;
		} else if (!formDefinition.equals(other.formDefinition))
			return false;
		if (inspectedBy == null) {
			if (other.inspectedBy != null)
				return false;
		} else if (!inspectedBy.equals(other.inspectedBy))
			return false;
		if (inspectionCode == null) {
			if (other.inspectionCode != null)
				return false;
		} else if (!inspectionCode.equals(other.inspectionCode))
			return false;
		if (inspectionDate == null) {
			if (other.inspectionDate != null)
				return false;
		} else if (!inspectionDate.equals(other.inspectionDate))
			return false;
		if (productRegistration == null) {
			if (other.productRegistration != null)
				return false;
		} else if (!productRegistration.getId().equals(other.productRegistration.getId()))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (template == null) {
			if (other.template != null)
				return false;
		} else if (!template.getId().equals(other.template.getId()))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		return true;
	}
	

}
