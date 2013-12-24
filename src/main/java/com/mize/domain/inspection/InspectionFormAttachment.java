package com.mize.domain.inspection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mize.domain.common.MizeEntity;

@Entity
@Table( name = "inspection_form_attach")
public class InspectionFormAttachment extends MizeEntity {	
	
	private static final long serialVersionUID = -6382930516529047484L;
	private InspectionForm inspectionForm;
	private String typeCode;
	private String attachmentName;
	private String attachmentUrl;
	
	public InspectionFormAttachment() {
		
	}	

	public InspectionFormAttachment(InspectionForm inspectionForm,
			String typeCode, String attachmentName, String attachmentUrl) {
		super();
		this.inspectionForm = inspectionForm;
		this.typeCode = typeCode;
		this.attachmentName = attachmentName;
		this.attachmentUrl = attachmentUrl;
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
	
	@ManyToOne
	@JoinColumn(name = "form_id", nullable = false)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}
	
	@Column(name = "type_code", nullable = true, length = 30)
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	@Column(name = "attach_name", nullable = true, length = 250)
	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
	@Column(name = "attach_url", nullable = true, length = 256)
	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((attachmentName == null) ? 0 : attachmentName.hashCode());
		result = prime * result
				+ ((attachmentUrl == null) ? 0 : attachmentUrl.hashCode());
		result = prime * result
				+ ((inspectionForm == null) ? 0 : inspectionForm.hashCode());
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
		InspectionFormAttachment other = (InspectionFormAttachment) obj;
		if (attachmentName == null) {
			if (other.attachmentName != null)
				return false;
		} else if (!attachmentName.equals(other.attachmentName))
			return false;
		if (attachmentUrl == null) {
			if (other.attachmentUrl != null)
				return false;
		} else if (!attachmentUrl.equals(other.attachmentUrl))
			return false;
		if (inspectionForm == null) {
			if (other.inspectionForm != null)
				return false;
		} else if (!inspectionForm.getId().equals(other.inspectionForm.getId()))
			return false;
		if (typeCode == null) {
			if (other.typeCode != null)
				return false;
		} else if (!typeCode.equals(other.typeCode))
			return false;
		return true;
	}
	

}
