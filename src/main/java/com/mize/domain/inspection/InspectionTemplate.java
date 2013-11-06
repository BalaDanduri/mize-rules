package com.mize.domain.inspection;

import java.math.BigDecimal;
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
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "inspection_template")
public class InspectionTemplate extends MizeEntity {
	
	private static final long serialVersionUID = 2970815534756018496L;
	
	private BusinessEntity tenant;
	private String templateCode;
	private BigDecimal versionNumber;
	private String typeCode;
	private String statusCode;
	private String templateDefinition;
	private String isActive;
	private DateTime startDate;
	private DateTime endDate;
	private String model;	
	private User user;
	private List<InspectionTemplateIntl> templateIntls;
	private List<InspectionTemplateAudit> templateAudits;
	private List<InspectionTemplateAttachment> templateAttachments;
		

	public InspectionTemplate() {
		tenant = new BusinessEntity();
		user = new User();
	}

	public InspectionTemplate(BusinessEntity tenant, String templateCode,
			BigDecimal versionNumber, String typeCode, String statusCode,
			String templateDefinition, String isActive, DateTime startDate,
			DateTime endDate, String model, User user,
			List<InspectionTemplateIntl> templateIntls,
			List<InspectionTemplateAudit> templateAudits,
			List<InspectionTemplateAttachment> templateAttachments) {
		super();
		this.tenant = tenant;
		this.templateCode = templateCode;
		this.versionNumber = versionNumber;
		this.typeCode = typeCode;
		this.statusCode = statusCode;
		this.templateDefinition = templateDefinition;
		this.isActive = isActive;
		this.startDate = startDate;
		this.endDate = endDate;
		this.model = model;
		this.user = user;
		this.templateIntls = templateIntls;
		this.templateAudits = templateAudits;
		this.templateAttachments = templateAttachments;
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
	@JoinColumn(name = "tenant_id", nullable = true)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}
	
	@Column( name = "template_code", nullable = true, length = 30)
	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	
	@Column( name = "version_number", nullable = true, precision = 20, scale = 6)
	public BigDecimal getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(BigDecimal versionNumber) {
		this.versionNumber = versionNumber;
	}
	
	@Column( name = "type_code", nullable = true, length = 30)
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	@Column( name = "status_code", nullable = true, length = 30)
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@Column( name = "template_definition", nullable = true)
	public String getTemplateDefinition() {
		return templateDefinition;
	}

	public void setTemplateDefinition(String templateDefinition) {
		this.templateDefinition = templateDefinition;
	}
	
	@Column( name = "is_active", nullable = true, length = 1)
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "start_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getStartDate() {
		return startDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "end_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	
	@Column(name = "model", nullable = true, length = 50)
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	@Transient
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}, mappedBy="template" )
	public List<InspectionTemplateIntl> getTemplateIntls() {
		return templateIntls;
	}

	public void setTemplateIntls(List<InspectionTemplateIntl> templateIntls) {
		this.templateIntls = templateIntls;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="template" )
	public List<InspectionTemplateAudit> getTemplateAudits() {
		return templateAudits;
	}

	public void setTemplateAudits(List<InspectionTemplateAudit> templateAudits) {
		this.templateAudits = templateAudits;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL}, mappedBy="template" )
	public List<InspectionTemplateAttachment> getTemplateAttachments() {
		return templateAttachments;
	}

	public void setTemplateAttachments(
			List<InspectionTemplateAttachment> templateAttachments) {
		this.templateAttachments = templateAttachments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((isActive == null) ? 0 : isActive.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime
				* result
				+ ((templateAttachments == null) ? 0 : templateAttachments
						.hashCode());
		result = prime * result
				+ ((templateAudits == null) ? 0 : templateAudits.hashCode());
		result = prime * result
				+ ((templateCode == null) ? 0 : templateCode.hashCode());
		result = prime
				* result
				+ ((templateDefinition == null) ? 0 : templateDefinition
						.hashCode());
		result = prime * result
				+ ((templateIntls == null) ? 0 : templateIntls.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result
				+ ((typeCode == null) ? 0 : typeCode.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((versionNumber == null) ? 0 : versionNumber.hashCode());
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
		InspectionTemplate other = (InspectionTemplate) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
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
		if (templateAttachments == null) {
			if (other.templateAttachments != null)
				return false;
		} else if (!templateAttachments.equals(other.templateAttachments))
			return false;
		if (templateAudits == null) {
			if (other.templateAudits != null)
				return false;
		} else if (!templateAudits.equals(other.templateAudits))
			return false;
		if (templateCode == null) {
			if (other.templateCode != null)
				return false;
		} else if (!templateCode.equals(other.templateCode))
			return false;
		if (templateDefinition == null) {
			if (other.templateDefinition != null)
				return false;
		} else if (!templateDefinition.equals(other.templateDefinition))
			return false;
		if (templateIntls == null) {
			if (other.templateIntls != null)
				return false;
		} else if (!templateIntls.equals(other.templateIntls))
			return false;
		if (tenant == null) {
			if (other.tenant != null)
				return false;
		} else if (!tenant.getId().equals(other.tenant.getId()))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
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
	

}
