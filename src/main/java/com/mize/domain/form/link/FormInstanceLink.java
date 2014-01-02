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
import com.mize.domain.businessentity.BusinessEntity;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.form.FormInstance;
import com.mize.domain.product.ProductSerial;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateSerializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name = "form_instance_link", uniqueConstraints = {@UniqueConstraint (columnNames = {"id"})})
public class FormInstanceLink extends MizeEntity {
	
	private static final long serialVersionUID = -7681217621881172130L;
	
	private FormInstance formInstance;
	private ProductSerial productSerial;
	private BusinessEntity linkBusinessEntity;
	private String linkType;
	private String linkDuration;
	private String statusCode;
	private DateTime reviewedDate;
	private String reviewedBy;
	private List<FormInstanceLinkAudit> audits;
	
	private User user;
	
	public FormInstanceLink() {
		super();
	}
	
	public FormInstanceLink(FormInstance formInstance, ProductSerial productSerial, 
			BusinessEntity linkBusinessEntity, String linkType, String linkDuration,
			String statusCode, DateTime reviewedDate, String reviewedBy) {
		super();
		this.formInstance = formInstance;
		this.productSerial = productSerial;
		this.linkBusinessEntity = linkBusinessEntity;
		this.linkType = linkType;
		this.linkDuration = linkDuration;
		this.statusCode = statusCode;
		this.reviewedDate = reviewedDate;
		this.reviewedBy = reviewedBy;
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
	@JoinColumn(name="form_instance_id", nullable = true)
	public FormInstance getFormInstance() {
		return formInstance;
	}
	
	public void setFormInstance(FormInstance formInstance) {
		this.formInstance = formInstance;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prod_serial_id", nullable = true)
	public ProductSerial getProductSerial() {
		return productSerial;
	}
	
	public void setProductSerial(ProductSerial productSerial) {
		this.productSerial = productSerial;
	}	
	
	@ManyToOne(fetch=FetchType.EAGER)
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
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "reviewed_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class,include=Inclusion.NON_DEFAULT)
	public DateTime getReviewedDate() {
		return reviewedDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setReviewedDate(DateTime reviewedDate) {
		this.reviewedDate = reviewedDate;
	}
	
	@Column( name = "reviewed_by", nullable = true, length = 100)
	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	
	@OneToMany(cascade={CascadeType.ALL}, fetch= FetchType.EAGER, mappedBy = "formInstanceLink")
	@JsonManagedReference(value="form_instance_link")
	@Fetch(FetchMode.SUBSELECT)
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
				+ ((linkType == null) ? 0 : linkType.hashCode());
		result = prime * result
				+ ((linkDuration == null) ? 0 : linkDuration.hashCode());
		result = prime * result
				+ ((statusCode == null) ? 0 : statusCode.hashCode());
		result = prime * result
				+ ((reviewedDate == null) ? 0 : reviewedDate.hashCode());
		result = prime * result
				+ ((reviewedBy == null) ? 0 : reviewedBy.hashCode());
		result = prime
				* result
				+ ((formInstance == null) ? 0 : formInstance.hashCode());
		result = prime
				* result
				+ ((productSerial == null) ? 0 : productSerial.hashCode());
		result = prime
				* result
				+ ((linkBusinessEntity == null) ? 0 : linkBusinessEntity.hashCode());
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
		if (linkType == null) {
			if (other.linkType != null)
				return false;
		} else if (!linkType.equals(other.linkType))
			return false;		
		if (linkDuration == null) {
			if (other.linkDuration != null)
				return false;
		} else if (!linkDuration.equals(other.linkDuration))
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (reviewedDate == null) {
			if (other.reviewedDate != null)
				return false;
		} else if (!reviewedDate.equals(other.reviewedDate))
			return false;
		if (reviewedBy == null) {
			if (other.reviewedBy != null)
				return false;
		} else if (!reviewedBy.equals(other.reviewedBy))
			return false;
		if (formInstance == null) {
			if (other.formInstance != null)
				return false;
		} else if (!formInstance.equals(other.formInstance))
			return false;
		if (productSerial == null) {
			if (other.productSerial != null)
				return false;
		} else if (!productSerial.equals(other.productSerial))
			return false;
		if (linkBusinessEntity == null) {
			if (other.linkBusinessEntity != null)
				return false;
		} else if (!linkBusinessEntity.equals(other.linkBusinessEntity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FormInstanceLink [formInstance=" + formInstance
				+ ", productSerial=" + productSerial + ", linkBusinessEntity="
				+ linkBusinessEntity + ", linkType=" + linkType
				+ ", linkDuration=" + linkDuration + ", statusCode="
				+ statusCode + ", reviewedDate=" + reviewedDate
				+ ", reviewedBy=" + reviewedBy + "]";
	}
	
	

}
