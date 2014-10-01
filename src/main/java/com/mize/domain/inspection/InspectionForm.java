package com.mize.domain.inspection;

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
import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.form.FormInstance;
import com.mize.domain.util.JPASerializer;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JodaDateTimeDeserializer;
import com.mize.domain.util.JsonDateSerializer;
import com.mize.domain.util.JsonDateTimeSerializer;

@Entity
@Table(name="insp_form")
public class InspectionForm extends MizeEntity {

	
	private static final long serialVersionUID = -666112603626187346L;
	
	private BusinessEntity tenant;
	private String inspectionCode;
	private String inspectionType;
	private String inspectionStatus;
	private String inspectionReference;
	private DateTime inspectionDate;
	private String inspectedBy;
	private Locale locale;
	private FormInstance formInstance;
	private InspectionFormRequestor requestor;
	private List<InspectionFormEquipment> inspectionEquipments = new ArrayList<InspectionFormEquipment>();
	private List<InspectionFormAudit> audits = new ArrayList<InspectionFormAudit>();
	private List<InspectionFormMessage> messages = new ArrayList<InspectionFormMessage>();
	private List<InspectionFormComment> comments = new ArrayList<InspectionFormComment>();

	private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public BusinessEntity getTenant() {
		return tenant;
	}

	public void setTenant(BusinessEntity tenant) {
		this.tenant = tenant;
	}

	@Column(name = "insp_code", length = 50)
	public String getInspectionCode() {
		return inspectionCode;
	}
	
	public void setInspectionCode(String inspectionCode) {
		this.inspectionCode = inspectionCode;
	}

	@Column(name = "insp_type", length = 50)
	public String getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(String inspectionType) {
		this.inspectionType = inspectionType;
	}

	@Column(name = "insp_status", length = 50)
	public String getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}
	
	@Column(name = "insp_reference", length = 100)
	public String getInspectionReference() {
		return inspectionReference;
	}
	
	public void setInspectionReference(String inspectionReference) {
		this.inspectionReference = inspectionReference;
	}

	@Column(name = "insp_date", nullable = true)
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Type(type = "com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using = JsonDateSerializer.class)
	@JsonInclude(Include.NON_NULL)
	public DateTime getInspectionDate() {
		return inspectionDate;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setInspectionDate(DateTime inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Column(name = "inspected_by", length = 100)
	public String getInspectedBy() {
		return inspectedBy;
	}

	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="locale_id")
	@JsonSerialize(using=JPASerializer.class)
	@JsonInclude(Include.NON_NULL)
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@OneToOne(fetch=FetchType.EAGER,cascade={CascadeType.ALL})
	@JoinColumn(name="form_instance_id", nullable = true)
	public FormInstance getFormInstance() {
		return formInstance;
	}

	public void setFormInstance(FormInstance formInstance) {
		this.formInstance = formInstance;
	}

	@OneToOne(mappedBy = "inspectionForm",cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "insp_form_requester")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionFormRequestor getRequestor() {
		return requestor;
	}

	public void setRequestor(InspectionFormRequestor requestor) {
		this.requestor = requestor;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "inspectionForm" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="insp_form_eqpmnt")
	public List<InspectionFormEquipment> getInspectionEquipments() {
		return inspectionEquipments;
	}
	
	public void setInspectionEquipments(List<InspectionFormEquipment> inspectionEquipments) {
		this.inspectionEquipments = inspectionEquipments;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "inspectionForm" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="insp_form_audits")
	public List<InspectionFormAudit> getAudits() {
		return audits;
	}

	public void setAudits(List<InspectionFormAudit> audits) {
		this.audits = audits;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "inspectionForm" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="insp_form_messages")
	public List<InspectionFormMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<InspectionFormMessage> messages) {
		this.messages = messages;
	}

	@OneToMany(cascade={CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "inspectionForm" , orphanRemoval = true)
	@JsonSerialize(using=JPASerializer.class)
	@JsonManagedReference(value="insp_form_comments")
	public List<InspectionFormComment> getComments() {
		return comments;
	}

	public void setComments(List<InspectionFormComment> comments) {
		this.comments = comments;
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
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "created_date",updatable=false)
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)
	public DateTime getCreatedDate() {
		return createdDate;
	}

	@Override	
	@DateTimeFormat(pattern="MM-dd-yyyy HH:mm:ss")
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@Column(name = "updated_date")
	@JsonIgnore(value = false)
	@JsonSerialize(using=JsonDateTimeSerializer.class)
    @JsonInclude(Include.NON_DEFAULT)
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	@Override
	@JsonIgnore
	@Column(name = "created_by",updatable=false)
	public Long getCreatedBy() {		
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	@Column(name = "updated_by")
	public Long getUpdatedBy() {		
		return super.getUpdatedBy();
	}


	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setCreatedDate(DateTime createdDate) {
		super.createdDate = createdDate;
	}

	@Override
	@DateTimeFormat (pattern="MM-dd-yyyy HH:mm:ss")
	@JsonDeserialize(using=JodaDateTimeDeserializer.class)	
	@JsonIgnore(false)
	public void setUpdatedDate(DateTime updatedDate) {
		super.updatedDate = updatedDate;
	}

	@Override
	@JsonIgnore
	public void setCreatedBy(Long createdBy) {		
		super.setCreatedBy(createdBy);
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
		result = prime * result + ((audits == null) ? 0 : audits.hashCode());
		result = prime * result + ((inspectionCode == null) ? 0 : inspectionCode.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((formInstance == null) ? 0 : formInstance.hashCode());
		result = prime * result
				+ ((inspectedBy == null) ? 0 : inspectedBy.hashCode());
		result = prime * result
				+ ((inspectionDate == null) ? 0 : inspectionDate.hashCode());
		result = prime * result + ((inspectionEquipments == null) ? 0 : inspectionEquipments.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((messages == null) ? 0 : messages.hashCode());
		result = prime * result
				+ ((inspectionReference == null) ? 0 : inspectionReference.hashCode());
		result = prime * result
				+ ((requestor == null) ? 0 : requestor.hashCode());
		result = prime * result + ((inspectionStatus == null) ? 0 : inspectionStatus.hashCode());
		result = prime * result + ((tenant == null) ? 0 : tenant.hashCode());
		result = prime * result + ((inspectionType == null) ? 0 : inspectionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof InspectionForm)) {
			return false;
		}
		InspectionForm other = (InspectionForm) obj;
		if (audits == null) {
			if (other.audits != null) {
				return false;
			}
		} else if (!audits.equals(other.audits)) {
			return false;
		}
		if (inspectionCode == null) {
			if (other.inspectionCode != null) {
				return false;
			}
		} else if (!inspectionCode.equals(other.inspectionCode)) {
			return false;
		}
		if (comments == null) {
			if (other.comments != null) {
				return false;
			}
		} else if (!comments.equals(other.comments)) {
			return false;
		}
		if (formInstance == null) {
			if (other.formInstance != null) {
				return false;
			}
		}else {
			if(formInstance.getId() == null) {
				if(other.formInstance.getId() != null)
					return false;
			} else if(!formInstance.getId().equals(other.formInstance.getId()))
				return false;
		} 
		if (inspectedBy == null) {
			if (other.inspectedBy != null) {
				return false;
			}
		} else if (!inspectedBy.equals(other.inspectedBy)) {
			return false;
		}
		if (inspectionDate == null) {
			if (other.inspectionDate != null) {
				return false;
			}
		} else if (inspectionDate.compareTo(other.inspectionDate) != 0) {
			return false;
		}
		if (inspectionEquipments == null) {
			if (other.inspectionEquipments != null) {
				return false;
			}
		} else if (!inspectionEquipments.equals(other.inspectionEquipments)) {
			return false;
		}
		if (locale == null) {
			if (other.locale != null) {
				return false;
			}
		}else{
			if(locale.getId() == null) {
				if(other.locale.getId() != null)
					return false;
			} else if(!locale.getId().equals(other.locale.getId()))
				return false;
		} 
		if (messages == null) {
			if (other.messages != null) {
				return false;
			}
		} else if (!messages.equals(other.messages)) {
			return false;
		}
		if (inspectionReference == null) {
			if (other.inspectionReference != null) {
				return false;
			}
		} else if (!inspectionReference.equals(other.inspectionReference)) {
			return false;
		}
		if (requestor == null) {
			if (other.requestor != null) {
				return false;
			}
		} else {
			if(requestor.getId() == null) {
				if(other.requestor.getId() != null)
					return false;
			} else if(!requestor.getId().equals(other.requestor.getId()))
				return false;
		} 
		if (inspectionStatus == null) {
			if (other.inspectionStatus != null) {
				return false;
			}
		} else if (!inspectionStatus.equals(other.inspectionStatus)) {
			return false;
		}
		if (tenant == null) {
			if (other.tenant != null) {
				return false;
			}
		} else if (!tenant.equals(other.tenant)) {
			return false;
		}
		if (inspectionType == null) {
			if (other.inspectionType != null) {
				return false;
			}
		} else if (!inspectionType.equals(other.inspectionType)) {
			return false;
		}
		return true;
	}

	
	
	
	
	
}