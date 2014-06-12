package com.mize.domain.form;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JodaDateDeserializer;
import com.mize.domain.util.JsonDateSerializer;

@Entity
@Table(name = "form_template_defn")
public class FormTemplateDefinition extends MizeEntity {
	
	private static final long serialVersionUID = -153672496480024450L;	
	
	private String templateDefinitionData;
	private BigDecimal versionNumber;
	private DateTime startDate;
	private DateTime endDate;
	
	public FormTemplateDefinition() {
		
	}		

	public FormTemplateDefinition(String templateDefinitionData,
			BigDecimal versionNumber, DateTime startDate, DateTime endDate) {
		super();
		this.templateDefinitionData = templateDefinitionData;
		this.versionNumber = versionNumber;
		this.startDate = startDate;
		this.endDate = endDate;
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
	
	@Column(name = "template_defn_data",  nullable = true)
	public String getTemplateDefinitionData() {
		return templateDefinitionData;
	}
	
	public void setTemplateDefinitionData(String templateDefinitionData) {
		this.templateDefinitionData = templateDefinitionData;
	}
	
	@Column(name = "version_number",  nullable = true, precision = 20, scale = 6)
	public BigDecimal getVersionNumber() {
		return versionNumber;
	}
	
	public void setVersionNumber(BigDecimal versionNumber) {
		this.versionNumber = versionNumber;
	}

	@DateTimeFormat (pattern="MM-dd-yyyy")
	@Column(name = "start_date",  nullable = true)
	@Type(type="com.mize.domain.util.DateTimeJPA")
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
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
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonInclude(Include.NON_DEFAULT)
	public DateTime getEndDate() {
		return endDate;
	}
	
	@DateTimeFormat (pattern="MM-dd-yyyy")
	@JsonDeserialize(using=JodaDateDeserializer.class)
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime
				* result
				+ ((templateDefinitionData == null) ? 0
						: templateDefinitionData.hashCode());
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
		FormTemplateDefinition other = (FormTemplateDefinition) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (templateDefinitionData == null) {
			if (other.templateDefinitionData != null)
				return false;
		} else if (!templateDefinitionData.equals(other.templateDefinitionData))
			return false;
		if (versionNumber == null) {
			if (other.versionNumber != null)
				return false;
		} else if (!versionNumber.equals(other.versionNumber))
			return false;
		return true;
	}
	

}
