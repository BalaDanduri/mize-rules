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

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.auth.User;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.servicelocator.BusinessEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "inspection_template")
public class InspectionTemplate extends MizeEntity implements Comparable<InspectionTemplate>{
	
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
	public int compareTo(InspectionTemplate o) {
		return 0;
	}
	
}
