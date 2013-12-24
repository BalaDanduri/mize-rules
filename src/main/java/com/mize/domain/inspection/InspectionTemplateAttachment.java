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
@Table(name = "inspection_template_attach")
public class InspectionTemplateAttachment extends MizeEntity {	
	
	private static final long serialVersionUID = 234803328097196621L;
	private InspectionTemplate template;
	private String typeCode;
	private String attachmentName;
	private String attachmentUrl;

	public InspectionTemplateAttachment() {
		template = new InspectionTemplate();
	}	
	

	public InspectionTemplateAttachment(InspectionTemplate template,
			String typeCode, String attachmentName, String attachmentUrl) {
		super();
		this.template = template;
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
	@JoinColumn(name = "template_id", nullable = false)
	public InspectionTemplate getTemplate() {
		return template;
	}


	public void setTemplate(InspectionTemplate template) {
		this.template = template;
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
		InspectionTemplateAttachment other = (InspectionTemplateAttachment) obj;
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
