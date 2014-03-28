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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.mize.domain.auth.User;
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.form.FormInstance;
import com.mize.domain.product.ProductRegistration;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "form_instance_link", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class FormInstanceLink extends MizeEntity {
	
	private static final long serialVersionUID = -7681217621881172130L;
	private String number;
	private FormInstance formInstance;
	private ProductSerial productSerial;
	private ProductRegistration productRegistration;
	private BusinessEntity linkBusinessEntity;
	private String linkType;
	private String linkDuration;
	private String statusCode;
	private List<FormInstanceLinkAudit> audits;
	private DateTime inspectionDate;
	private String inspectedBy;
	
	private User user;
	
	public FormInstanceLink() {
		super();
		formInstance = new FormInstance();
	}
	
	public enum Status{
		OPEN,COMPLETED,DELETED;
	}
	
	public FormInstanceLink(FormInstance formInstance, ProductRegistration productRegistration, 
			BusinessEntity linkBusinessEntity, String linkType, String linkDuration,
			String statusCode) {
		super();
		this.formInstance = formInstance;
		this.productRegistration = productRegistration;
		this.linkBusinessEntity = linkBusinessEntity;
		this.linkType = linkType;
		this.linkDuration = linkDuration;
		this.statusCode = statusCode;
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
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="form_instance_id", nullable = true)
	public FormInstance getFormInstance() {
		return formInstance;
	}
	
	public void setFormInstance(FormInstance formInstance) {
		this.formInstance = formInstance;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_regn_id")
	public ProductRegistration getProductRegistration() {
		return productRegistration;
	}
	
	public void setProductRegistration(ProductRegistration productRegistration) {
		this.productRegistration = productRegistration;
	}	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="link_be_id", nullable = true)
	public BusinessEntity getLinkBusinessEntity() {
		return linkBusinessEntity;
	}
	
	public void setLinkBusinessEntity(BusinessEntity linkBusinessEntity) {
		this.linkBusinessEntity = linkBusinessEntity;
	}
	
	@Column( name = "link_type", nullable = true, length = 50)
	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	
	@Column( name = "link_duration", nullable = true, length = 50)
	public String getLinkDuration() {
		return linkDuration;
	}

	public void setLinkDuration(String linkDuration) {
		this.linkDuration = linkDuration;
	}
	
	@Column( name = "status_code", nullable = true, length = 50)
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.EAGER, mappedBy = "formInstanceLink")
	@JsonManagedReference(value="form_instance_link")
	public List<FormInstanceLinkAudit> getAudits() {
		return audits;
	}
	
	public void setAudits(List<FormInstanceLinkAudit> audits) {
		this.audits = audits;
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
	@JsonInclude(Include.NON_NULL)
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
	@JsonInclude(Include.NON_NULL)
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

	@Column(name = "link_number")
	public String getNumber() {
		return String.valueOf(id);
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "inspection_date")
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateTimeSerializer.class, include = Inclusion.NON_NULL)
	public DateTime getInspectionDate() {
		return inspectionDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)
	public void setInspectionDate(DateTime inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Column(name = "inspected_by")
	public String getInspectedBy() {
		return inspectedBy;
	}

	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_serial_id")
	public ProductSerial getProductSerial() {
		return productSerial;
	}

	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((inspectedBy == null) ? 0 : inspectedBy.hashCode());
		result = prime * result
				+ ((inspectionDate == null) ? 0 : inspectionDate.hashCode());
		result = prime * result
				+ ((linkDuration == null) ? 0 : linkDuration.hashCode());
		result = prime * result
				+ ((linkType == null) ? 0 : linkType.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());		
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
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
		FormInstanceLink other = (FormInstanceLink) obj;
		if (inspectedBy == null) {
			if (other.inspectedBy != null)
				return false;
		} else if (!inspectedBy.equals(other.inspectedBy))
			return false;
		if (inspectionDate == null) {
			if (other.inspectionDate != null)
				return false;
		} else if (!inspectionDate.equals(other.inspectionDate))
			return false;
		if (linkDuration == null) {
			if (other.linkDuration != null)
				return false;
		} else if (!linkDuration.equals(other.linkDuration))
			return false;
		if (linkType == null) {
			if (other.linkType != null)
				return false;
		} else if (!linkType.equals(other.linkType))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;		
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormInstanceLink [number=" + number + ", linkType=" + linkType
				+ ", linkDuration=" + linkDuration + ", statusCode="
				+ statusCode + ",inspectionDate="
				+ inspectionDate + ", inspectedBy=" + inspectedBy + "]";
	}

	
}
