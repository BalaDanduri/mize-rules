package com.mize.domain.inspection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mize.domain.common.MizeEntity;
import com.mize.domain.util.JPASerializer;



@Entity
@Table(name = "insp_form_msg")
public class InspectionFormMessage extends MizeEntity {

	
	private static final long serialVersionUID = 8878621032671945424L;
	
	private InspectionForm inspectionForm;
	private Long messageId;
	private Integer messageSeverity;
	private String messageField;
	private String messageUiReference;
	private String messageValue;
	private String messageCode;
	private String shortDesc;
	private String longDesc;

	public InspectionFormMessage() {
		
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "insp_form_id")
	@JsonBackReference(value="insp_form_messages")
	@JsonSerialize(using=JPASerializer.class)
	public InspectionForm getInspectionForm() {
		return inspectionForm;
	}

	public void setInspectionForm(InspectionForm inspectionForm) {
		this.inspectionForm = inspectionForm;
	}
	
	@Column(name = "message_id")
	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	
	@Column(name = "message_severity")
	public Integer getMessageSeverity() {
		return messageSeverity;
	}
	
	public void setMessageSeverity(Integer messageSeverity) {
		this.messageSeverity = messageSeverity;
	}
	
	@Column(name = "message_field", length = 250)
	public String getMessageField() {
		return messageField;
	}

	public void setMessageField(String messageField) {
		this.messageField = messageField;
	}
	
	@Column(name = "message_ui_reference", length = 100)
	public String getMessageUiReference() {
		return messageUiReference;
	}

	public void setMessageUiReference(String messageUiReference) {
		this.messageUiReference = messageUiReference;
	}
	
	@Column(name = "message_value", length = 5000)
	public String getMessageValue() {
		return messageValue;
	}

	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}
	
	@Column(name = "message_code", nullable = true, length = 50)
	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	@Column(name = "short_description", nullable = true, length = 250)
	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	@Column(name = "long_description", nullable = true, length = 500)
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	@Override
	public int hashCode() {
		final int prime = PRIME;
		int result = super.hashCode();
		result = prime * result
				+ ((messageField == null) ? 0 : messageField.hashCode());
		result = prime * result
				+ ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result
				+ ((messageSeverity == null) ? 0 : messageSeverity.hashCode());
		result = prime
				* result
				+ ((messageUiReference == null) ? 0 : messageUiReference
						.hashCode());
		result = prime * result
				+ ((messageValue == null) ? 0 : messageValue.hashCode());
		result = prime * result
				+ ((inspectionForm == null) ? 0 : inspectionForm.hashCode());
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
		InspectionFormMessage other = (InspectionFormMessage) obj;
		if (messageField == null) {
			if (other.messageField != null)
				return false;
		} else if (!messageField.equals(other.messageField))
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (messageSeverity == null) {
			if (other.messageSeverity != null)
				return false;
		} else if (!messageSeverity.equals(other.messageSeverity))
			return false;
		if (messageUiReference == null) {
			if (other.messageUiReference != null)
				return false;
		} else if (!messageUiReference.equals(other.messageUiReference))
			return false;
		if (messageValue == null) {
			if (other.messageValue != null)
				return false;
		} else if (!messageValue.equals(other.messageValue))
			return false;
		if (shortDesc == null) {
			if (other.shortDesc != null)
				return false;
		} else if (!shortDesc.equals(other.shortDesc))
			return false;
		if (longDesc == null) {
			if (other.longDesc != null)
				return false;
		} else if (!longDesc.equals(other.longDesc)){
			return false;
		}
		return true;
	}
	

}
