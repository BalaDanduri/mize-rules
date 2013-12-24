package com.mize.domain.inspection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mize.domain.common.Locale;
import com.mize.domain.common.MizeEntity;

@Entity
@Table(name = "inspection_template_intl")
public class InspectionTemplateIntl extends MizeEntity {	
	
	private static final long serialVersionUID = -1087251016742382594L;
	
	private InspectionTemplate template;
	private Locale locale;
	private String templateName;
	private String templateDescription;

	public InspectionTemplateIntl() {
		locale = new Locale();
		template = new InspectionTemplate();
	}	
	

	public InspectionTemplateIntl(InspectionTemplate template, Locale locale,
			String templateName, String templateDescription) {
		super();
		this.template = template;
		this.locale = locale;
		this.templateName = templateName;
		this.templateDescription = templateDescription;
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
	@JoinColumn( name = "template_id", nullable = false)
	public InspectionTemplate getTemplate() {
		return template;
	}


	public void setTemplate(InspectionTemplate template) {
		this.template = template;
	}

	@ManyToOne
	@JoinColumn( name = "locale_id")
	public Locale getLocale() {
		return locale;
	}


	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Column( name = "template_name", nullable = true, length = 250)
	public String getTemplateName() {
		return templateName;
	}


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column( name = "template_desc", nullable = true, length = 500)
	public String getTemplateDescription() {
		return templateDescription;
	}


	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}


	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result
				+ ((template == null) ? 0 : template.hashCode());
		result = prime
				* result
				+ ((templateDescription == null) ? 0 : templateDescription
						.hashCode());
		result = prime * result
				+ ((templateName == null) ? 0 : templateName.hashCode());
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
		InspectionTemplateIntl other = (InspectionTemplateIntl) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.getId().equals(other.locale.getId()))
			return false;
		if (template == null) {
			if (other.template != null)
				return false;
		} else if (!template.getId().equals(other.template.getId()))
			return false;
		if (templateDescription == null) {
			if (other.templateDescription != null)
				return false;
		} else if (!templateDescription.equals(other.templateDescription))
			return false;
		if (templateName == null) {
			if (other.templateName != null)
				return false;
		} else if (!templateName.equals(other.templateName))
			return false;
		return true;
	}
	
	
	

}
